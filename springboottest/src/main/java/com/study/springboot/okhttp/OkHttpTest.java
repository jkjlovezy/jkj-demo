package com.study.springboot.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpTest {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url("http://192.168.23.225:8888/api/account/mic/withdraw/queryWithdrawList?pageSize=5&beginTime=2020-09-20 20:32:45&endTime=2020-10-22%2021:33:45&pageNum=1")
                .header("appKey","20201016766612537612435456")
                .header("userId","622186514")
                .header("comId","614823684").build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
