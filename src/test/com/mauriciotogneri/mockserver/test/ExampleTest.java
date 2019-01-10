package com.mauriciotogneri.mockserver.test;

import com.mauriciotogneri.javautils.Randomized;
import com.mauriciotogneri.mockserver.EndPoint;
import com.mauriciotogneri.mockserver.MockServer;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import static org.junit.Assert.assertEquals;

public class ExampleTest
{
    @Test
    public void example() throws IOException
    {
        List<EndPoint> endPoints = new ArrayList<>();
        endPoints.add(new ExampleEndpoint());

        int port = Randomized.of(1024, 9999);

        MockServer mockServer = new MockServer(port, endPoints);
        mockServer.start();

        OkHttpClient client = new OkHttpClient();

        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        String json = "{foo:bar}";
        RequestBody requestBody = RequestBody.create(JSON, json);

        Request request = new Request.Builder()
                .url("http://localhost:" + port + "/path/endpoint?foo=bar")
                .header("Cookie", "FOO=BAR")
                .header("Content-Type", "application/json")
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();
        String body = response.body().string();

        assertEquals("{\"foo\":\"bar\"}", body);
    }
}