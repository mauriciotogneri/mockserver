package com.mauriciotogneri.mockserver;

import com.mauriciotogneri.javautils.Json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import okhttp3.mockwebserver.MockResponse;
import okio.Buffer;

public class HttpResponse
{
    private final HttpResponseCode code;
    private final Map<String, String> headers;
    private final byte[] body;

    public HttpResponse(HttpResponseCode code, Map<String, String> headers, byte[] body)
    {
        this.code = code;
        this.headers = headers;
        this.body = body;
    }

    public MockResponse response()
    {
        MockResponse response = new MockResponse();
        response.setResponseCode(code.code);

        for (Entry<String, String> entry : headers.entrySet())
        {
            response.setHeader(entry.getKey(), entry.getValue());
        }

        if (body != null)
        {
            response.setBody(new Buffer().write(body));
        }

        return response;
    }

    public static class Builder
    {
        private final HttpResponseCode code;
        private final Map<String, String> headers;
        private byte[] body;

        public Builder(HttpResponseCode code)
        {
            this.code = code;
            this.headers = new HashMap<>();
        }

        public Builder header(String name, String value)
        {
            headers.put(name, value);

            return this;
        }

        public Builder string(String body)
        {
            this.body = body.getBytes();

            return this;
        }

        public Builder bytes(byte[] body)
        {
            this.body = body;

            return this;
        }

        public Builder json(Object object)
        {
            this.body = Json.json(object).getBytes();

            return this;
        }

        public Builder array(Object... object)
        {
            this.body = Json.json(object).getBytes();

            return this;
        }

        public Builder list(List<?> object)
        {
            this.body = Json.json(object).getBytes();

            return this;
        }

        public HttpResponse build()
        {
            return new HttpResponse(code, headers, body);
        }
    }
}