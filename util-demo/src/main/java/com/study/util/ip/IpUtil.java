package com.study.util.ip;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.core.io.Resource;

import com.focustech.silk.sian.component.constans.Constants;

@Slf4j
public class IpUtil {
    private Resource resource;
    private int offset;
    private int[] index = new int[65536];
    private ByteBuffer dataBuffer;
    private ByteBuffer indexBuffer;
    private ReentrantLock lock = new ReentrantLock();

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public String[] getLocationInfo(String ip) throws Exception {
        String[] ips = ip.split(Constants.SEP_SLASH_POINT);
        int prefix_value = (Integer.valueOf(ips[0]) * 256 + Integer.valueOf(ips[1]));
        long ip2long_value = ip2long(ip);
        int start = index[prefix_value];
        int max_comp_len = offset - 262144 - 4;
        long tmpInt;
        long index_offset = -1;
        int index_length = -1;
        byte b = 0;
        for (start = start * 9 + 262144; start < max_comp_len; start += 9) {
            tmpInt = int2long(indexBuffer.getInt(start));
            if (tmpInt >= ip2long_value) {
                index_offset = bytesToLong(b, indexBuffer.get(start + 6), indexBuffer.get(start + 5),
                        indexBuffer.get(start + 4));
                index_length = (0xFF & indexBuffer.get(start + 7) << 8) + (0xFF & indexBuffer.get(start + 8));
                break;
            }
        }

        byte[] areaBytes;

        lock.lock();
        try {
            dataBuffer.position(offset + (int) index_offset - 262144);
            areaBytes = new byte[index_length];
            dataBuffer.get(areaBytes, 0, index_length);
        }
        finally {
            lock.unlock();
        }

        return new String(areaBytes, "UTF-8").split(Constants.SEP_TABS);
    }

    public void initialize() throws IOException {
        lock.lock();
        try {
            dataBuffer = ByteBuffer.wrap(getBytesByStream(getResource()));
            dataBuffer.position(0);
            offset = dataBuffer.getInt(); // indexLength
            byte[] indexBytes = new byte[offset];
            dataBuffer.get(indexBytes, 0, offset - 4);
            indexBuffer = ByteBuffer.wrap(indexBytes);
            indexBuffer.order(ByteOrder.LITTLE_ENDIAN);

            for (int i = 0; i < 256; i++) {
                for (int j = 0; j < 256; j++) {
                    index[i * 256 + j] = indexBuffer.getInt();
                }
            }
            indexBuffer.order(ByteOrder.BIG_ENDIAN);
        }
        finally {
            lock.unlock();
        }
    }

    @Deprecated
    private byte[] getBytesByFile(File file) {
        FileInputStream fin = null;
        byte[] bs = new byte[new Long(file.length()).intValue()];
        try {
            fin = new FileInputStream(file);
            int readBytesLength = 0;
            int i;
            while ((i = fin.available()) > 0) {
                fin.read(bs, readBytesLength, i);
                readBytesLength += i;
            }
        }
        catch (IOException ioe) {
            log.error("IpComponentServiceImpl::getBytesByFile()::", ioe);
        }
        finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            }
            catch (IOException e) {
                log.error("IpComponentServiceImpl::getBytesByFile()::", e);
            }
        }

        return bs;
    }

    private byte[] getBytesByStream(Resource resource) throws IOException {
        byte[] input2Bytes = null;
        try {
            InputStream in = resource.getInputStream();
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[100];
            int rc = 0;
            while ((rc = in.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            input2Bytes = swapStream.toByteArray();
        }
        catch (Exception e) {
            log.error("IpComponentServiceImpl::getBytesByStream()::", e);
        }
        return input2Bytes;

    }

    private long bytesToLong(byte a, byte b, byte c, byte d) {
        return int2long((((a & 0xff) << 24) | ((b & 0xff) << 16) | ((c & 0xff) << 8) | (d & 0xff)));
    }

    private int str2Ip(String ip) {
        String[] ss = ip.split(Constants.SEP_SLASH_POINT);
        int a, b, c, d;
        a = Integer.parseInt(ss[0]);
        b = Integer.parseInt(ss[1]);
        c = Integer.parseInt(ss[2]);
        d = Integer.parseInt(ss[3]);
        return (a << 24) | (b << 16) | (c << 8) | d;
    }

    public long ip2long(String ip) {
        long int2long = int2long(str2Ip(ip));
        return int2long;
    }

    private long int2long(int value) {
        long result = value & 0x7fffffffL;
        if (value < 0) {
            result |= 0x080000000L;
        }
        return result;
    }
}
