package org.example.Builder;

public abstract class HttpReq {
    String url;
    String body;
    String params;
    String methodType;
    String headers;

     HttpReq()
    {

    }
    public abstract void executeAPI();


}
