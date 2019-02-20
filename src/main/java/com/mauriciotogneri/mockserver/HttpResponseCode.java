package com.mauriciotogneri.mockserver;

public class HttpResponseCode
{
    private final int code;
    private final String message;

    public static final HttpResponseCode CONTINUE = new HttpResponseCode(100, "Continue");
    public static final HttpResponseCode SWITCHING_PROTOCOLS = new HttpResponseCode(101, "Switching Protocols");
    public static final HttpResponseCode PROCESSING = new HttpResponseCode(102, "Processing");

    public static final HttpResponseCode OK = new HttpResponseCode(200, "OK");
    public static final HttpResponseCode CREATED = new HttpResponseCode(201, "Created");
    public static final HttpResponseCode NO_CONTENT = new HttpResponseCode(204, "No Content");

    public static final HttpResponseCode BAD_REQUEST = new HttpResponseCode(400, "Bad Request");
    public static final HttpResponseCode UNAUTHORIZED = new HttpResponseCode(401, "Unauthorized");
    public static final HttpResponseCode FORBIDDEN = new HttpResponseCode(403, "Forbidden");
    public static final HttpResponseCode NOT_FOUND = new HttpResponseCode(404, "Not Found");
    public static final HttpResponseCode METHOD_NOT_ALLOWED = new HttpResponseCode(405, "Method Not Allowed");
    public static final HttpResponseCode CONFLICT = new HttpResponseCode(409, "Conflict");
    public static final HttpResponseCode PRECONDITION_FAILED = new HttpResponseCode(412, "Precondition Failed");

    public static final HttpResponseCode INTERNAL_SERVER_ERROR = new HttpResponseCode(500, "Internal Server Error");
    public static final HttpResponseCode SERVICE_UNAVAILABLE = new HttpResponseCode(503, "Service Unavailable");

    public HttpResponseCode(int code, String message)
    {
        this.code = code;
        this.message = message;
    }

    public int code()
    {
        return code;
    }

    public String message()
    {
        return message;
    }

    @Override
    public String toString()
    {
        return String.format("%s %s", code, message);
    }
}