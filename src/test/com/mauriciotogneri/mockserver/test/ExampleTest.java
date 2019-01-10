package com.mauriciotogneri.mockserver.test;

import com.mauriciotogneri.mockserver.EndPoint;
import com.mauriciotogneri.mockserver.MockServer;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import static org.junit.Assert.assertEquals;

public class ExampleTest
{
    @Test
    public void example() throws IOException
    {
        MockServer mockServer = new MockServer(8080, new ArrayList<EndPoint>());
        mockServer.start();

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://www.google.com")
                .build();

        Response response = client.newCall(request).execute();
        String body = response.body().string();

        assertEquals("aaa", body);
    }
}