package com.study.network.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AccessRandomFileTest {
    static String fileName = "G:\\acessRandomFile.txt";

    public static void main(String[] args) throws Exception {
        //m1();
        m2();
    }

    private static void m2() throws IOException {
        File file = new File(fileName);
        if(file.exists())
            file.delete();
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        raf.setLength(2 * 1024);

        MappedByteBuffer mappedByteBuffer = raf.getChannel().map(FileChannel.MapMode.READ_WRITE,8,1024);
        mappedByteBuffer.load().put((byte)3).put((byte)1);

    }

    private static void m1() throws IOException {
        File file = new File(fileName);
        file.deleteOnExit();
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        raf.setLength(2 * 1024);

        for(long i=0,len = raf.length();i<len;i++){
            System.out.println(i+"\t"+raf.read());
        }
        System.out.println(raf.read());

        raf.seek(0);
        raf.writeInt(16);
        System.out.println(raf.getFilePointer()); //return 4.
        System.out.println( raf.readInt()); // return 0.  因为0-3个字节保存的是integer:16.  此时读取的是4-7个字节，所以返回0。

        raf.seek(0);
        System.out.println(raf.getFilePointer());//return 0.
        System.out.println( raf.readInt()); // return 16.

        readFile(fileName);
    }

    public static void readFile(String fileName) throws IOException {
        Paths.get(fileName);
        System.out.println("readFile:\t[" + new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8) + "]");
    }

    public static byte[] readBytes(RandomAccessFile raf, int length) throws IOException {
        byte[] bytes = new byte[length];
        raf.read(bytes);
        return bytes;
    }
}
