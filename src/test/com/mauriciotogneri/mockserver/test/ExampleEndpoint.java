package com.mauriciotogneri.mockserver.test;

import com.mauriciotogneri.mockserver.EndPoint;
import com.mauriciotogneri.mockserver.HttpRequest;
import com.mauriciotogneri.mockserver.HttpResponse;

public class ExampleEndpoint extends EndPoint
{
    protected ExampleEndpoint()
    {
        super(POST, "/path/endpoint");
    }

    @Override
    public HttpResponse process(HttpRequest httpRequest)
    {
        return json(new ExampleResponse("bar"));
    }

    public static class ExampleResponse
    {
        public final String foo;

        public ExampleResponse(String foo)
        {
            this.foo = foo;
        }
    }
}