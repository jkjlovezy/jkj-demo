package com.study.network;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ApiTest {
    public static void main(String[] args) throws Exception {
        String appKey = "20200818745328791810736128";
        String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCKfJXTXS3DZmfixjNaPDGnqthe+mEhDLF9imEyk/uNnhtZfBKNVXCGzEp/H8npjPb+Utm2wF0En1yE6tGdvexerA3ufWhdMhzKY60ZHZ2J3Dx3Qg+aDGpxmWElDDN3/bcNZkFl6ee8qrnLyymiJ9t2ZOIdsL6yg7kPInrTg1dP0nb8xwdre0erokS0MGOe9tDlEjotTcH3DDzmGDBJRlR1KloF3kIvwJjODq2LuHZ3c4GauDy/JKQdwRrwq7pLdal6guRmm9BZdmdycByidtNILSAqptWiRkMglpONVRDaIsLW9kaY3hGsts43TRH2J+NpTtbeCT+M2jZlC6DECskvAgMBAAECggEAdDbqsG4QWlrUsSysqXu8G702SDYLTmXNiNGYkY432nck8mo5U1uwy54ioh22HoUKPRCf3Un+hUOKq4w3Dg30jtoJ8upQq2zDVmBhQaNlsewc3eOVHixvIxeYuzNK+dXzSI5YMUMiEmSe+FNsg8S42dj9G/dXgI0jvnyr4FXm7ncvBzGN4u/5EdyY6XoizwFzi/XBezvv4ERvS5TfqPJ+HtwE9X8zsS5TEhOau3V7jYEuSMaq6GRk8W+MWTUFtU2jMjPGbhLbbSFjGjZXVbL84d4fyddEHMlAlbkLTkraPzFOj81clc89Tl3rhCOKyqXBTPQd8texV4DvsRE2wZt4oQKBgQDAMyJidudHT5LDPsY2JPxrx3Lz1ztnVAuI/g15poa+kYOWP3cnz00e0nZnuXXeUJmtkH6lNZ30Yey77WfZy1FNhabiHe/dXEGyAME1RhxOG5HwsRK72NyGe7MGD42+8ldng2ehw1UVGpPFQW2ia4PauOAbth5V2r7jo5eVyZ6z8QKBgQC4dPz9+LLCohH/P+X3TtOwELx8eLmH2QxVHbJqWCshMksp7nYRPNPsOnM4r2idXExs/zF9Sdxr8ScVUbEvnd2wDjR2DKfwZqzaSxfGGh5ztJibuPGtJx8rgL7/mPY+EjYCNuN+kiTL0XzUzsuk0cvPN72vrWjdwVhiTq4rDiXvHwKBgQCz3ub+CVMW3LR3/saXI3QMFeNRqosQf4owEbpgr+UIcbwZH5oO6qW9A7AGEH3rqbi4wzKSwKPrcr2PfnWjUPDswPjWQrgZjN56jNREXDHfM1QYUk8695AiV5/KO0IngjskR8jzjY+RqYbDoyDMURxb1Ir/xCeNp6Lf/Vi+uKrKsQKBgQC0w6ketvdwN+XNL/CMsMpRM8WTcbfYAoPMcgLjpq31pVT1rcQ01liUmx9JgNTTyZz4AAqezqBdhAGaKemrUVjsbK9KtNJrjCN+9bJBqF0JZQVdLhxhZQJt3ojO8Tb3017sQqAk7NF0kEJ2RoZZamQCGY0huZ4YG58jEBotBXt1XwKBgDTnYvgIwTUnngVZRl851uaSNMM5+z6vgHNz5ghItpg6kqHyny3g42SzOT580NKZDQmFk36l3eUiMuAe4ag3Lny3n4bA8Js0PSGVSjCgfr+Y7QcQ5Owr1Cstnukhg4z1Kr8xr9ZSI0TkZIQFjY8LRfJwbBlbB2uBfoJ15x5a2u1o";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "application/json");
        requestHeaders.add("appKey", appKey);
        requestHeaders.add("signType", "rsa2");
        long timestamp = System.currentTimeMillis();
        requestHeaders.add("timestamp", String.valueOf(timestamp));
        requestHeaders.add("sign", RsaUtil.sign(appKey,privateKey,timestamp));
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> requestEntity = new HttpEntity<String>("{\n" +
                "    \"beginTime\": \"2020-08-11\",\n" +
                "    \"endTime\": \"2020-08-20\",\n" +
                "    \"pageNo\": 0,\n" +
                "    \"pageSize\": 50\n" +
                "}", requestHeaders);
        RestTemplate template = new RestTemplate();
//        ResponseEntity<String> response = template.exchange("http://openapi.crov.com/api/seller/queryOrderDetail", HttpMethod.POST, requestEntity, String.class);
//        ResponseEntity<String> response = template.exchange("https://sandbox-openapi.crov.com/api/seller/queryOrderDetail", HttpMethod.POST, requestEntity, String.class);

        ResponseEntity<String> response = template.exchange("https://sandbox-openapi.crov.com/api/seller/queryOrderDetail", HttpMethod.POST, requestEntity, String.class);
//        ResponseEntity<String> response = template.exchange("https://sandbox-openapi.crov.com/api/goods/spu/list", HttpMethod.GET, requestEntity, String.class);
        String body = response.getBody();
        System.out.println(body);
        HttpHeaders responseHeaders = response.getHeaders();
                for(Map.Entry<String, List<String>> entry:responseHeaders.entrySet()){
                    System.out.println(entry.getKey()+":\t"+entry.getValue());
                }
    }
}
