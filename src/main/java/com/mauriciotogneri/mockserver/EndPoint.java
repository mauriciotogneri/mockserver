package com.mauriciotogneri.mockserver;

import com.mauriciotogneri.javautils.Encoding;

import java.util.List;

public abstract class EndPoint
{
    private final String method;
    private final String pattern;

    protected static final String GET = "GET";
    protected static final String PUT = "PUT";
    protected static final String POST = "POST";
    protected static final String PATCH = "PATCH";
    protected static final String DELETE = "DELETE";

    protected EndPoint(String method, String pattern)
    {
        this.method = method;
        this.pattern = pattern;
    }

    protected String pattern()
    {
        return pattern;
    }

    public boolean matches(HttpRequest httpRequest)
    {
        return httpRequest.matches(method, pattern);
    }

    public abstract HttpResponse process(HttpRequest httpRequest);

    protected void wait(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    protected String decode(String text)
    {
        try
        {
            return Encoding.urlDecode(text);
        }
        catch (Exception e)
        {
            return text;
        }
    }

    protected HttpResponse response(HttpResponseCode code)
    {
        return new HttpResponse.Builder(code).build();
    }

    protected HttpResponse json(Object object)
    {
        return new HttpResponse.Builder(HttpResponseCode.OK).json(object).build();
    }

    protected HttpResponse.Builder json(HttpResponseCode code, Object object)
    {
        return new HttpResponse.Builder(code).json(object);
    }

    protected HttpResponse.Builder string(HttpResponseCode code, String string)
    {
        return new HttpResponse.Builder(code).string(string);
    }

    protected HttpResponse.Builder list(HttpResponseCode code, List<?> object)
    {
        return new HttpResponse.Builder(code).list(object);
    }

    protected HttpResponse ok()
    {
        return new HttpResponse.Builder(HttpResponseCode.OK).build();
    }

    protected HttpResponse created()
    {
        return new HttpResponse.Builder(HttpResponseCode.CREATED).build();
    }

    protected HttpResponse noContent()
    {
        return new HttpResponse.Builder(HttpResponseCode.NO_CONTENT).build();
    }

    protected HttpResponse badRequest()
    {
        return new HttpResponse.Builder(HttpResponseCode.BAD_REQUEST).build();
    }

    protected HttpResponse unauthorized()
    {
        return new HttpResponse.Builder(HttpResponseCode.UNAUTHORIZED).build();
    }

    protected HttpResponse forbidden()
    {
        return new HttpResponse.Builder(HttpResponseCode.FORBIDDEN).build();
    }

    protected HttpResponse notFound()
    {
        return new HttpResponse.Builder(HttpResponseCode.NOT_FOUND).build();
    }

    protected HttpResponse methodNotAllowed()
    {
        return new HttpResponse.Builder(HttpResponseCode.METHOD_NOT_ALLOWED).build();
    }

    protected HttpResponse conflict()
    {
        return new HttpResponse.Builder(HttpResponseCode.CONFLICT).build();
    }

    protected HttpResponse preconditionFailed()
    {
        return new HttpResponse.Builder(HttpResponseCode.PRECONDITION_FAILED).build();
    }

    protected HttpResponse internalServerError()
    {
        return new HttpResponse.Builder(HttpResponseCode.INTERNAL_SERVER_ERROR).build();
    }

    protected HttpResponse serviceUnavailable()
    {
        return new HttpResponse.Builder(HttpResponseCode.SERVICE_UNAVAILABLE).build();
    }

    protected HttpResponse.Builder empty(HttpResponseCode code)
    {
        return new HttpResponse.Builder(code);
    }
}