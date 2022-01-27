package com.github.tshion.mktools_android.constants

/**
 * HTTP Status Code
 */
enum class HttpStatusCode(val value: Int) {

    /**
     * 100 Continue
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/100)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.1.1)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.2.1)
     */
    CONTINUE(100),

    /**
     * 101 Switching Protocols
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/101)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.1.2)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.2.2)
     */
    SWITCHING_PROTOCOLS(101),

    /**
     * 102 Processing(WebDAV)
     *
     * * [RFC2518](https://datatracker.ietf.org/doc/html/rfc2518#section-10.1)
     */
    PROCESSING(102),

    /**
     * 103 Early Hints
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/103)
     * * [RFC8297](https://datatracker.ietf.org/doc/html/rfc8297#section-2)
     */
    EARLY_HINTS(103),

    /**
     * 200 OK
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/200)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.2.1)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.3.1)
     */
    OK(200),

    /**
     * 201 Created
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/201)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.2.2)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.3.2)
     */
    CREATED(201),

    /**
     * 202 Accepted
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/202)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.2.3)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.3.3)
     */
    ACCEPTED(202),

    /**
     * 203 Non-Authoritative Information
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/203)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.2.4)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.3.4)
     */
    NON_AUTHORITATIVE_INFORMATION(203),

    /**
     * 204 No Content
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/204)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.2.5)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.3.5)
     */
    NO_CONTENT(204),

    /**
     * 205 Reset Content
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/205)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.2.6)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.3.6)
     */
    RESET_CONTENT(205),

    /**
     * 206 Partial Content
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/206)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.2.7)
     * * [RFC7233](https://datatracker.ietf.org/doc/html/rfc7233#section-4.1)
     */
    PARTIAL_CONTENT(206),

    /**
     * 207 Multi-Status(WebDAV)
     *
     * * [RFC2518](https://datatracker.ietf.org/doc/html/rfc2518#section-10.2)
     * * [RFC4918](https://datatracker.ietf.org/doc/html/rfc4918#section-11.1)
     */
    MULTI_STATUS(207),

    /**
     * 208 Already Reported(WebDAV)
     *
     * * [RFC5842](https://datatracker.ietf.org/doc/html/rfc5842#section-7.1)
     */
    ALREADY_REPORTED(208),

    /**
     * 226 IM Used(HTTP Delta encoding)
     *
     * * [RFC3229](https://datatracker.ietf.org/doc/html/rfc3229#section-10.4.1)
     */
    IM_USED(226),

    /**
     * 300 Multiple Choice
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/300)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.3.1)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.4.1)
     */
    MULTIPLE_CHOICE(300),

    /**
     * 301 Moved Permanently
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/301)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.3.2)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.4.2)
     */
    MOVED_PERMANENTLY(301),

    /**
     * 302 Found
     * (HTTP 1.0: Moved Temporarily)
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/302)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.3.3)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.4.3)
     */
    FOUND(302),

    /**
     * 303 See Other
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/303)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.3.4)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.4.4)
     */
    SEE_OTHER(303),

    /**
     * 304 Not Modified
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/304)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.3.5)
     * * [RFC7232](https://datatracker.ietf.org/doc/html/rfc7232#section-4.1)
     */
    NOT_MODIFIED(304),

    /**
     * 305 Use Proxy
     *
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.3.6)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.4.5)
     */
    @Deprecated("It has been deprecated due to security concerns regarding in-band configuration of a proxy.")
    USE_PROXY(305),

    /**
     * 306 unused
     *
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.3.7)
     */
    @Deprecated("This response code is no longer used; it is just reserved.")
    UNUSED(306),

    /**
     * 307 Temporary Redirect
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/307)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.3.8)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.4.7)
     */
    TEMPORARY_REDIRECT(307),

    /**
     * 308 Permanent Redirect
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/308)
     * * [RFC7238](https://datatracker.ietf.org/doc/html/rfc7238)
     * * [RFC7538](https://datatracker.ietf.org/doc/html/rfc7538#section-3)
     */
    PERMANENT_REDIRECT(308),

    /**
     * 400 Bad Request
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/400)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.1)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.1)
     */
    BAD_REQUEST(400),

    /**
     * 401 Unauthorized
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/401)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.2)
     * * [RFC7235](https://datatracker.ietf.org/doc/html/rfc7235#section-3.1)
     */
    UNAUTHORIZED(401),

    /**
     * 402 Payment Required
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/402)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.3)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.2)
     */
    @Deprecated("This response code is reserved for future use.")
    PAYMENT_REQUIRED(402),

    /**
     * 403 Forbidden
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/403)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.4)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.3)
     */
    FORBIDDEN(403),

    /**
     * 404 Not Found
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/404)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.5)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.4)
     */
    NOT_FOUND(404),

    /**
     * 405 Method Not Allowed
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/405)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.6)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.5)
     */
    METHOD_NOT_ALLOWED(405),

    /**
     * 406 Not Acceptable
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/406)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.7)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.6)
     */
    NOT_ACCEPTABLE(406),

    /**
     * 407 Proxy Authentication Required
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/407)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.8)
     * * [RFC7235](https://datatracker.ietf.org/doc/html/rfc7235#section-3.2)
     */
    PROXY_AUTHENTICATION_REQUIRED(407),

    /**
     * 408 Request Timeout
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/408)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.9)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.7)
     */
    REQUEST_TIMEOUT(408),

    /**
     * 409 Conflict
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/409)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.10)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.8)
     */
    CONFLICT(409),

    /**
     * 410 Gone
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/410)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.11)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.9)
     */
    GONE(410),

    /**
     * 411 Length Required
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/411)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.12)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.10)
     */
    LENGTH_REQUIRED(411),

    /**
     * 412 Precondition Failed
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/412)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.13)
     * * [RFC7232](https://datatracker.ietf.org/doc/html/rfc7232#section-4.2)
     */
    PRECONDITION_FAILED(412),

    /**
     * 413 Payload Too Large
     * (HTTP 1.0: Request Entity Too Large)
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/413)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.11)
     */
    PAYLOAD_TOO_LARGE(413),

    /**
     * 414 URI Too Long
     * (HTTP 1.0: Request-URI Too Long)
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/414)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.12)
     */
    URI_TOO_LONG(414),

    /**
     * 415 Unsupported Media Type
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/415)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.16)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.13)
     */
    UNSUPPORTED_MEDIA_TYPE(415),

    /**
     * 416 Range Not Satisfiable
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/416)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.17)
     * * [RFC7233](https://datatracker.ietf.org/doc/html/rfc7233#section-4.4)
     */
    RANGE_NOT_SATISFIABLE(416),

    /**
     * 417 Expectation Failed
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/417)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.18)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.14)
     */
    EXPECTATION_FAILED(417),

    /**
     * 418 I'm a teapot
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/418)
     * * [RFC2324](https://datatracker.ietf.org/doc/html/rfc2324#section-2.3.2)
     * * [RFC7168](https://datatracker.ietf.org/doc/html/rfc7168#section-2.3.3)
     */
    I_AM_A_TEAPOT(418),

    /**
     * 421 Misdirected Request
     *
     * * [RFC7540](https://datatracker.ietf.org/doc/html/rfc7540#section-9.1.2)
     * * [RFC7838](https://datatracker.ietf.org/doc/html/rfc7838#section-6)
     */
    MISDIRECTED_REQUEST(421),

    /**
     * 422 Unprocessable Entity(WebDAV)
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/422)
     * * [RFC2518](https://datatracker.ietf.org/doc/html/rfc2518#section-10.3)
     * * [RFC4918](https://datatracker.ietf.org/doc/html/rfc4918#section-11.2)
     */
    UNPROCESSABLE_ENTITY(422),

    /**
     * 423 Locked(WebDAV)
     *
     * * [RFC2518](https://datatracker.ietf.org/doc/html/rfc2518#section-10.4)
     * * [RFC4918](https://datatracker.ietf.org/doc/html/rfc4918#section-11.3)
     */
    LOCKED(423),

    /**
     * 424 Failed Dependency(WebDAV)
     *
     * * [RFC2518](https://datatracker.ietf.org/doc/html/rfc2518#section-10.5)
     * * [RFC4918](https://datatracker.ietf.org/doc/html/rfc4918#section-11.4)
     */
    FAILED_DEPENDENCY(424),

    /**
     * 425 Too Early
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/425)
     * * [RFC8470](https://datatracker.ietf.org/doc/html/rfc8470#section-5.2)
     */
    @Deprecated("This is an experimental technology.")
    TOO_EARLY(425),

    /**
     * 426 Upgrade Required
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/426)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.15)
     */
    UPGRADE_REQUIRED(426),

    /**
     * 428 Precondition Required
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/428)
     * * [RFC6585](https://datatracker.ietf.org/doc/html/rfc6585#section-3)
     */
    PRECONDITION_REQUIRED(428),

    /**
     * 429 Too Many Requests
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/429)
     * * [RFC6585](https://datatracker.ietf.org/doc/html/rfc6585#section-4)
     */
    TOO_MANY_REQUESTS(429),

    /**
     * 431 Request Header Fields Too Large
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/431)
     * * [RFC6585](https://datatracker.ietf.org/doc/html/rfc6585#section-5)
     */
    REQUEST_HEADER_FIELDS_TOO_LARGE(431),

    /**
     * 451 Unavailable For Legal Reasons
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/451)
     * * [RFC7725](https://datatracker.ietf.org/doc/html/rfc7725#section-3)
     */
    UNAVAILABLE_FOR_LEGAL_REASONS(451),

    /**
     * 500 Internal Server Error
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/500)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.5.1)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.6.1)
     */
    INTERNAL_SERVER_ERROR(500),

    /**
     * 501 Not Implemented
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/501)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.5.2)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.6.2)
     */
    NOT_IMPLEMENTED(501),

    /**
     * 502 Bad Gateway
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/502)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.5.3)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.6.3)
     */
    BAD_GATEWAY(502),

    /**
     * 503 Service Unavailable
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/503)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.5.4)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.6.4)
     */
    SERVICE_UNAVAILABLE(503),

    /**
     * 504 Gateway Timeout
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/504)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.5.5)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.6.5)
     */
    GATEWAY_TIMEOUT(504),

    /**
     * 505 HTTP Version Not Supported
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/505)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.5.6)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.6.6)
     */
    HTTP_VERSION_NOT_SUPPORTED(505),

    /**
     * 506 Variant Also Negotiates
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/506)
     * * [RFC2295](https://datatracker.ietf.org/doc/html/rfc2295#section-8.1)
     */
    VARIANT_ALSO_NEGOTIATES(506),

    /**
     * 507 Insufficient Storage(WebDAV)
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/507)
     * * [RFC4918](https://datatracker.ietf.org/doc/html/rfc4918#section-11.5)
     */
    INSUFFICIENT_STORAGE(507),

    /**
     * 508 Loop Detected(WebDAV)
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/508)
     * * [RFC5842](https://datatracker.ietf.org/doc/html/rfc5842#section-7.2)
     */
    LOOP_DETECTED(508),

    /**
     * 510 Not Extended
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/510)
     * * [RFC2774](https://datatracker.ietf.org/doc/html/rfc2774#section-7)
     */
    NOT_EXTENDED(510),

    /**
     * 511 Network Authentication Required
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/511)
     * * [RFC6585](https://datatracker.ietf.org/doc/html/rfc6585#section-6)
     */
    NETWORK_AUTHENTICATION_REQUIRED(511),
    ;
}
