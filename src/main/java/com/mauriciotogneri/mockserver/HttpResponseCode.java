package com.mauriciotogneri.mockserver;

public class HttpResponseCode
{
    private final int code;
    private final String message;

    // 1xx Informational
    public static final HttpResponseCode CONTINUE = new HttpResponseCode(100, "Continue");
    public static final HttpResponseCode SWITCHING_PROTOCOLS = new HttpResponseCode(101, "Switching Protocols");
    public static final HttpResponseCode PROCESSING = new HttpResponseCode(102, "Processing");

    // 2xx Success
    public static final HttpResponseCode OK = new HttpResponseCode(200, "OK");
    public static final HttpResponseCode CREATED = new HttpResponseCode(201, "Created");
    public static final HttpResponseCode ACCEPTED = new HttpResponseCode(202, "Accepted");
    public static final HttpResponseCode NON_AUTHORITATIVE_INFORMATION = new HttpResponseCode(203, "Non-Authoritative Information");
    public static final HttpResponseCode NO_CONTENT = new HttpResponseCode(204, "No Content");
    public static final HttpResponseCode RESET_CONTENT = new HttpResponseCode(205, "Reset Content");
    public static final HttpResponseCode PARTIAL_CONTENT = new HttpResponseCode(206, "Partial Content");
    public static final HttpResponseCode MULTI_STATUS = new HttpResponseCode(207, "Multi-Status");
    public static final HttpResponseCode ALREADY_REPORTED = new HttpResponseCode(208, "Already Reported");
    public static final HttpResponseCode IM_USED = new HttpResponseCode(226, "IM Used");

    // 3xx Redirection
    public static final HttpResponseCode MULTIPLE_CHOICES = new HttpResponseCode(300, "Multiple Choices");
    public static final HttpResponseCode MOVED_PERMANENTLY = new HttpResponseCode(301, "Moved Permanently");
    public static final HttpResponseCode FOUND = new HttpResponseCode(302, "Found");
    public static final HttpResponseCode SEE_OTHER = new HttpResponseCode(303, "See Other");
    public static final HttpResponseCode NOT_MODIFIED = new HttpResponseCode(304, "Not Modified");
    public static final HttpResponseCode USE_PROXY = new HttpResponseCode(305, "Use Proxy");
    public static final HttpResponseCode TEMPORARY_REDIRECT = new HttpResponseCode(307, "Temporary Redirect");
    public static final HttpResponseCode PERMANENT_REDIRECT = new HttpResponseCode(308, "Permanent Redirect");

    // 4xx Client Error
    public static final HttpResponseCode BAD_REQUEST = new HttpResponseCode(400, "Bad Request");
    public static final HttpResponseCode UNAUTHORIZED = new HttpResponseCode(401, "Unauthorized");
    public static final HttpResponseCode PAYMENT_REQUIRED = new HttpResponseCode(402, "Payment Required");
    public static final HttpResponseCode FORBIDDEN = new HttpResponseCode(403, "Forbidden");
    public static final HttpResponseCode NOT_FOUND = new HttpResponseCode(404, "Not Found");
    public static final HttpResponseCode METHOD_NOT_ALLOWED = new HttpResponseCode(405, "Method Not Allowed");
    public static final HttpResponseCode NOT_ACCEPTABLE = new HttpResponseCode(406, "Not Acceptable");
    public static final HttpResponseCode PROXY_AUTHENTICATION_REQUIRED = new HttpResponseCode(407, "Proxy Authentication Required");
    public static final HttpResponseCode REQUEST_TIMEOUT = new HttpResponseCode(408, "Request Timeout");
    public static final HttpResponseCode CONFLICT = new HttpResponseCode(409, "Conflict");
    public static final HttpResponseCode GONE = new HttpResponseCode(410, "Gone");
    public static final HttpResponseCode LENGTH_REQUIRED = new HttpResponseCode(411, "Length Required");
    public static final HttpResponseCode PRECONDITION_FAILED = new HttpResponseCode(412, "Precondition Failed");
    public static final HttpResponseCode REQUEST_ENTITY_TOO_LARGE = new HttpResponseCode(413, "Request Entity Too Large");
    public static final HttpResponseCode REQUEST_URI_TOO_LONG = new HttpResponseCode(414, "Request-URI Too Long");
    public static final HttpResponseCode UNSUPPORTED_MEDIA_TYPE = new HttpResponseCode(415, "Unsupported Media Type");
    public static final HttpResponseCode REQUESTED_RANGE_NOT_SATISFIABLE = new HttpResponseCode(416, "Requested Range Not Satisfiable");
    public static final HttpResponseCode EXPECTATION_FAILED = new HttpResponseCode(417, "Expectation Failed");
    public static final HttpResponseCode IAM_A_TEAPOT = new HttpResponseCode(418, "I'm a teapot");
    public static final HttpResponseCode ENHANCE_YOUR_CALM = new HttpResponseCode(420, "Enhance Your Calm");
    public static final HttpResponseCode UNPROCESSABLE_ENTITY = new HttpResponseCode(422, "Unprocessable Entity");
    public static final HttpResponseCode LOCKED = new HttpResponseCode(423, "Locked");
    public static final HttpResponseCode FAILED_DEPENDENCY = new HttpResponseCode(424, "Failed Dependency");
    public static final HttpResponseCode UPGRADE_REQUIRED = new HttpResponseCode(426, "Upgrade Required");
    public static final HttpResponseCode PRECONDITION_REQUIRED = new HttpResponseCode(428, "Precondition Required");
    public static final HttpResponseCode TOO_MANY_REQUESTS = new HttpResponseCode(429, "Too Many Requests");
    public static final HttpResponseCode REQUEST_HEADER_FIELDS_TOO_LARGE = new HttpResponseCode(431, "Request Header Fields Too Large");
    public static final HttpResponseCode NO_RESPONSE = new HttpResponseCode(444, "No Response");
    public static final HttpResponseCode RETRY_WITH = new HttpResponseCode(449, "Retry With");
    public static final HttpResponseCode UNAVAILABLE_FOR_LEGAL_REASONS = new HttpResponseCode(451, "Unavailable For Legal Reasons");
    public static final HttpResponseCode CLIENT_CLOSED_REQUEST = new HttpResponseCode(499, "Client Closed Request");

    // 5xx Server Error
    public static final HttpResponseCode INTERNAL_SERVER_ERROR = new HttpResponseCode(500, "Internal Server Error");
    public static final HttpResponseCode NOT_IMPLEMENTED_ = new HttpResponseCode(501, "Not Implemented");
    public static final HttpResponseCode BAD_GETAWAT = new HttpResponseCode(502, "Bad Gateway");
    public static final HttpResponseCode SERVICE_UNAVAILABLE = new HttpResponseCode(503, "Service Unavailable");
    public static final HttpResponseCode GATEWAY_TIMEOUT = new HttpResponseCode(504, "Gateway Timeout");
    public static final HttpResponseCode HTTP_VERSION_NOT_SUPPORTED = new HttpResponseCode(505, "HTTP Version Not Supported");
    public static final HttpResponseCode VARIANT_ALSO_NEGOTIATES = new HttpResponseCode(506, "Variant Also Negotiates");
    public static final HttpResponseCode INSUFFICIENT_STORAGE = new HttpResponseCode(507, "Insufficient Storage");
    public static final HttpResponseCode LOOP_DETECTED = new HttpResponseCode(508, "Loop Detected");
    public static final HttpResponseCode BANDWIDTH_LIMIT_EXCEEDED = new HttpResponseCode(509, "Bandwidth Limit Exceeded");
    public static final HttpResponseCode NOT_EXTENDED = new HttpResponseCode(510, "Not Extended");
    public static final HttpResponseCode NETWORK_AUTHENTICATION_REQUIRED = new HttpResponseCode(511, "Network Authentication Required");
    public static final HttpResponseCode NETWORK_READ_TIMEOUT_ERROR = new HttpResponseCode(598, "Network read timeout error");
    public static final HttpResponseCode NETWORK_CONNECT_TIMEOUT_ERROR = new HttpResponseCode(599, "Network connect timeout error");

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