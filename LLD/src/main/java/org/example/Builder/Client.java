package org.example.Builder;

public class Client {
    public static void main(String[] args) {
        HttpReq request = new HttpReqBuilder()
                .withUrl("https://api.example.com/users")
                .withMethodType("POST")
                .withHeaders("Authorization: Bearer token")
                .withParams("id=101")
                .withBody("{\"name\":\"Vikas\"}")
                .build();

        System.out.println("Done executing");
    }



}
