package com.study.springboot.okhttp;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpTest {

    public static void main(String[] args) throws IOException {

//            placeOrder();
        queryWithdrawList();

    }

    public static void externRegisterGet() throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        RequestBody body = new FormBody.Builder().add("micComId","VIUKoAeyhszF").build();
        Request request = new Request.Builder().url("http://open.made-in-china.com/apis/com/externRegister/get")
                .header("appKey", "20201028771070396366585856")
                .header("signType","rsa2")
                .header("timestamp", "timestamp")
                .header("sign", "sign")
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    public static void placeOrder() throws IOException {
        String json = "{\"platformBusiId\":120020429,\"platformUserId\":120011173,\"bBusiId\":120020429,\"billingAddress\":{\"countryId\":121991,\"provinceId\":122001,\"city\":\"122061\",\"addr1\":\"few124\",\"addr2\":\"afsd32\",\"zipCode\":\"4234\",\"telephone\":\"2341432432432\"},\"goodsItems\":[{\"sBusiId\":614823684,\"deliveryType\":\"1\",\"goodsSkuId\":728823664,\"goodsId\":728823664,\"goodsName\":\"Car 029\",\"goodsSkuPicId\":0,\"goodsSkuPicUrl\":\"\",\"goodsSkuType\":\"1\",\"goodsQuantity\":500,\"goodsQuantityUnit\":\"0\",\"goodsPrice\":9000,\"goodsCost\":4500000.00,\"shippingAddress\":{\"countryId\":127961,\"provinceId\":150471,\"city\":\"Australia\",\"addr1\":\"few124\",\"addr2\":\"djakldnakmfnasmjkdlhakjf\",\"zipCode\":\"4234\",\"telephone\":\"2341432432432\"},\"receiveType\":\"0\",\"goodsCatId\":0},{\"sBusiId\":614823684,\"deliveryType\":\"1\",\"goodsSkuId\":728823644,\"goodsId\":728823644,\"goodsName\":\"Car 027\",\"goodsSkuPicId\":0,\"goodsSkuPicUrl\":\"\",\"goodsSkuType\":\"1\",\"goodsQuantity\":300,\"goodsQuantityUnit\":\"0\",\"goodsPrice\":5245,\"goodsCost\":1573500.00,\"shippingAddress\":{\"countryId\":127961,\"provinceId\":150471,\"city\":\"Australia\",\"addr1\":\"few124\",\"addr2\":\"djakldnakmfnasmjkdlhakjf\",\"zipCode\":\"4234\",\"telephone\":\"2341432432432\"},\"receiveType\":\"0\",\"goodsCatId\":0},{\"sBusiId\":614823684,\"deliveryType\":\"1\",\"goodsSkuId\":728692914,\"goodsId\":728692914,\"goodsName\":\"Qwert Ert Ewrt<Marquee> Adfadfmaklsdvasd</Marquee>Ss\",\"goodsSkuPicId\":674344364,\"goodsSkuPicUrl\":\"//image.made-in-china.com/3f2j00qAfGmtYjENlZ/Qwert-Ert-Ewrt-Marquee-Adfadfmaklsdvasd-Marquee-Ss.jpg\",\"goodsSkuType\":\"1\",\"goodsQuantity\":100,\"goodsQuantityUnit\":\"0\",\"goodsPrice\":500,\"goodsCost\":50000.00,\"shippingAddress\":{\"countryId\":127961,\"provinceId\":150471,\"city\":\"Australia\",\"addr1\":\"few124\",\"addr2\":\"djakldnakmfnasmjkdlhakjf\",\"zipCode\":\"4234\",\"telephone\":\"2341432432432\"},\"receiveType\":\"0\",\"goodsCatId\":0}],\"deliveryDeadLine\":\"2020-11-04 11:21:19\",\"totalTax\":0,\"totalFreight\":0}";
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        RequestBody body = RequestBody.create(MediaType.get("application/json; charset=utf-8"), json);
        Request request = new Request.Builder().url("http://openapi.innercrov.com/api/order/mic/placeOrder")
                .header("appKey", "20201016766612537612435456")
                .header("userId", "120011173")
                .header("comId", "120020429").post(body).build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    public static void queryWithdrawList() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url("http://192.168.23.225:8888/api/account/mic/withdraw/queryWithdrawList?pageSize=5&beginTime=2020-09-20 20:32:45&endTime=2020-10-22%2021:33:45&pageNum=1")
                .header("appKey", "20201016766612537612435456")
                .header("userId", "622186514")
                .header("comId", "614823684").build();
        Response response = client.newCall(request).execute();
        System.out.println(response.code() + "\t" + response.body().string());
    }
}
