package org.example.Builder;

public class HttpReqBuilder {
    HttpReq httpReq;
    public HttpReqBuilder() {
        httpReq = new HttpReq() {
            @Override
            public void executeAPI() {
                System.out.println("Executing the API");
            }
        }; // initialize object
    }


    public HttpReqBuilder withHeaders(String headers) {
        httpReq.headers = headers;
        return this;
    }

    public HttpReqBuilder withParams(String params)
    {
        httpReq.params = params;
        return this;
    }

    public HttpReqBuilder withBody(String body)
    {
        httpReq.body = body;
        return this;
    }

    public HttpReqBuilder withMethodType(String methodType)
    {
        httpReq.methodType = methodType;
        return this;
    }

    public HttpReqBuilder withUrl(String url)
    {
        httpReq.url = url;
        return this;
    }

    public HttpReq build()
    {
        if(httpReq.url==null)
        {
            throw new RuntimeException("URL is missing");
        }

        if(httpReq.methodType==null)
        {
            throw new RuntimeException("Method type is missing");
        }
        httpReq.executeAPI();
        return httpReq;
    }







}

