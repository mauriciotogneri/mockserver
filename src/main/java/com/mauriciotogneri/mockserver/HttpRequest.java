package com.mauriciotogneri.mockserver;

import com.mauriciotogneri.javautils.Encoding;
import com.mauriciotogneri.javautils.Json;
import com.mauriciotogneri.javautils.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpRequest
{
    private final String method;
    private final String route;
    private final String path;
    private final List<String> cookies;
    private final Map<String, String> headers;
    private final String body;

    public HttpRequest(String method, String route, List<String> cookies, Map<String, String> headers, String body)
    {
        this.method = method;
        this.route = route;
        this.path = pathRoute(route);
        this.cookies = cookies;
        this.headers = headers;
        this.body = body;
    }

    private String pathRoute(String route)
    {
        int paramsStart = route.indexOf("?");

        return (paramsStart == -1) ? route : route.substring(0, paramsStart);
    }

    public boolean matches(String method, String pattern)
    {
        return this.method.equals(method) && path.matches(pattern);
    }

    public List<String> cookies()
    {
        return cookies;
    }

    public Map<String, String> headers()
    {
        return headers;
    }

    public boolean hasHeader(String name)
    {
        return headers.containsKey(name);
    }

    public String header(String name)
    {
        return headers.get(name);
    }

    public String body()
    {
        return body;
    }

    public <T> T body(Class<T> clazz)
    {
        return Json.object(body, clazz);
    }

    public List<String> path(String regex)
    {
        List<String> result = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(route);

        while (matcher.find())
        {
            result.add(matcher.group(1).trim());
        }

        return result;
    }

    public String path(String regex, int index)
    {
        List<String> parameters = path(regex);

        return parameters.get(index);
    }

    public Map<String, String> query()
    {
        Map<String, String> result = new HashMap<>();

        try
        {
            String[] parts = route.split("\\?")[1].split("&");

            for (String part : parts)
            {
                String[] param = part.split("=");
                String name = param[0].trim();
                String value = (param.length > 1) ? Encoding.urlDecode(param[1]).trim() : "";

                result.put(name, value);
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        return result;
    }

    public String query(String name)
    {
        Map<String, String> map = query();

        return map.get(name);
    }

    public <T> T query(Class<T> clazz)
    {
        return Json.object(query(), clazz);
    }

    public Map<String, String> form()
    {
        Map<String, String> result = new HashMap<>();

        try
        {
            String[] parts = body.split("&");

            for (String part : parts)
            {
                String[] param = part.split("=");
                String name = param[0].trim();
                String value = (param.length > 1) ? Encoding.urlDecode(param[1]).trim() : "";

                result.put(name, value);
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        return result;
    }

    public String form(String name)
    {
        Map<String, String> map = form();

        return map.get(name);
    }

    public <T> T form(Class<T> clazz)
    {
        return Json.object(form(), clazz);
    }

    public static HttpRequest fromInputStream(InputStream inputStream) throws IOException
    {
        String method = null;
        String route = null;
        List<String> cookies = new ArrayList<>();
        Map<String, String> headers = new HashMap<>();
        String body = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        int contentLength = 0;

        while (Strings.isNotEmpty(line = reader.readLine()))
        {
            if ((method == null) || (route == null))
            {
                String[] parts = line.split(" ");
                method = parts[0];
                route = parts[1];
            }
            else
            {
                if (line.startsWith("Content-Length:"))
                {
                    contentLength = Integer.parseInt(line.replace("Content-Length:", "").trim());
                }

                String[] parts = line.split(":");
                String name = parts[0];
                String value = parts[1];

                if (name.equals("Cookie"))
                {
                    cookies.add(value);
                }
                else
                {
                    headers.put(name.trim(), value.trim());
                }
            }
        }

        if (contentLength != 0)
        {
            char[] buffer = new char[contentLength];
            reader.read(buffer);
            body = new String(buffer);
        }

        return new HttpRequest(method, route, cookies, headers, body);
    }
}