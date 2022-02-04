package com.github.tshion.mktools_android.constants

/**
 * HTTP Response Header
 */
enum class HttpResponseHeader(val value: String) {

    /**
     * Accept-CH
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-CH)
     */
    @Deprecated("This is an experimental technology")
    ACCEPT_CH("Accept-CH"),

    /**
     * Accept-CH-Lifetime
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-CH-Lifetime)
     */
    @Deprecated("This feature is no longer recommended.")
    ACCEPT_CH_LIFETIME("Accept-CH-Lifetime"),

    /**
     * Accept-Patch
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-Patch)
     * * [RFC5789](https://datatracker.ietf.org/doc/html/rfc5789#section-3.1)
     */
    ACCEPT_PATCH("Accept-Patch"),

    /**
     * Accept-Post
     *
     * * [https://www.w3.org/TR/ldp/#header-accept-post](https://www.w3.org/TR/ldp/#header-accept-post)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-Post)
     */
    ACCEPT_POST("Accept-Post"),

    /**
     * Accept-Ranges
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-Ranges)
     * * [RFC7233](https://datatracker.ietf.org/doc/html/rfc7233#section-2.3)
     */
    ACCEPT_RANGES("Accept-Ranges"),

    /**
     * Access-Control-Allow-Credentials
     *
     * * [https://fetch.spec.whatwg.org/#http-access-control-allow-credentials](https://fetch.spec.whatwg.org/#http-access-control-allow-credentials)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Credentials)
     */
    ACCESS_CONTROL_ALLOW_CREDENTIALS("Access-Control-Allow-Credentials"),

    /**
     * Access-Control-Allow-Headers
     *
     * * [https://fetch.spec.whatwg.org/#http-access-control-allow-headers](https://fetch.spec.whatwg.org/#http-access-control-allow-headers)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Headers)
     */
    ACCESS_CONTROL_ALLOW_HEADERS("Access-Control-Allow-Headers"),

    /**
     * Access-Control-Allow-Methods
     *
     * * [https://fetch.spec.whatwg.org/#http-access-control-allow-methods](https://fetch.spec.whatwg.org/#http-access-control-allow-methods)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Methods)
     */
    ACCESS_CONTROL_ALLOW_METHODS("Access-Control-Allow-Methods"),

    /**
     * Access-Control-Allow-Origin
     *
     * * [https://fetch.spec.whatwg.org/#http-access-control-allow-origin](https://fetch.spec.whatwg.org/#http-access-control-allow-origin)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Origin)
     */
    ACCESS_CONTROL_ALLOW_ORIGIN("Access-Control-Allow-Origin"),

    /**
     * Access-Control-Expose-Headers
     *
     * * [https://fetch.spec.whatwg.org/#http-access-control-expose-headers](https://fetch.spec.whatwg.org/#http-access-control-expose-headers)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Expose-Headers)
     */
    ACCESS_CONTROL_EXPOSE_HEADERS("Access-Control-Expose-Headers"),

    /**
     * Access-Control-Max-Age
     *
     * * [https://fetch.spec.whatwg.org/#http-access-control-max-age](https://fetch.spec.whatwg.org/#http-access-control-max-age)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Max-Age)
     */
    ACCESS_CONTROL_MAX_AGE("Access-Control-Max-Age"),

    /**
     * Age
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Age)
     * * [RFC7234](https://datatracker.ietf.org/doc/html/rfc7234#section-5.1)
     */
    AGE("Age"),

    /**
     * Allow
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Allow)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-7.4.1)
     */
    ALLOW("Allow"),

    /**
     * Alt-Svc
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Alt-Svc)
     * * [RFC7838](https://datatracker.ietf.org/doc/html/rfc7838)
     */
    ALT_SVC("Alt-Svc"),

    /**
     * Cache-Control
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Cache-Control)
     * * [RFC5861](https://datatracker.ietf.org/doc/html/rfc5861)
     * * [RFC7234](https://datatracker.ietf.org/doc/html/rfc7234)
     * * [RFC8246](https://datatracker.ietf.org/doc/html/rfc8246)
     */
    CACHE_CONTROL("Cache-Control"),

    /**
     * Clear-Site-Data
     *
     * * [https://w3c.github.io/webappsec-clear-site-data/](https://w3c.github.io/webappsec-clear-site-data/)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Clear-Site-Data)
     */
    CLEAR_SITE_DATA("Clear-Site-Data"),

    /**
     * Connection
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Connection)
     * * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#section-6.1)
     */
    CONNECTION("Connection"),

    /**
     * Content-Disposition
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Disposition)
     * * [RFC2183](https://datatracker.ietf.org/doc/html/rfc2183)
     * * [RFC6266](https://datatracker.ietf.org/doc/html/rfc6266)
     * * [RFC7578](https://datatracker.ietf.org/doc/html/rfc7578)
     */
    CONTENT_DISPOSITION("Content-Disposition"),

    /**
     * Content-DPR
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-DPR)
     */
    @Deprecated("This feature is no longer recommended.")
    CONTENT_DPR("Content-DPR"),

    /**
     * Content-Encoding
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Encoding)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-14.11)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-3.1.2.2)
     * * [RFC7932](https://datatracker.ietf.org/doc/html/rfc7932)
     */
    CONTENT_ENCODING("Content-Encoding"),

    /**
     * Content-Language
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Language)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-3.1.3.2)
     */
    CONTENT_LANGUAGE("Content-Language"),

    /**
     * Content-Length
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Length)
     * * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#section-3.3.2)
     */
    CONTENT_LENGTH("Content-Length"),

    /**
     * Content-Location
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Location)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-3.1.4.2)
     */
    CONTENT_LOCATION("Content-Location"),

    /**
     * Content-Range
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Range)
     * * [RFC7233](https://datatracker.ietf.org/doc/html/rfc7233#section-4.2)
     */
    CONTENT_RANGE("Content-Range"),

    /**
     * Content-Security-Policy
     *
     * * [https://w3c.github.io/webappsec-csp/#csp-header](https://w3c.github.io/webappsec-csp/#csp-header)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy)
     */
    CONTENT_SECURITY_POLICY("Content-Security-Policy"),

    /**
     * Content-Security-Policy-Report-Only
     *
     * * [https://w3c.github.io/webappsec-csp/#cspro-header](https://w3c.github.io/webappsec-csp/#cspro-header)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy-Report-Only)
     */
    CONTENT_SECURITY_POLICY_REPORT_ONLY("Content-Security-Policy-Report-Only"),

    /**
     * Content-Type
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Type)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-3.1.1.5)
     * * [RFC7233](https://datatracker.ietf.org/doc/html/rfc7233#section-4.1)
     */
    CONTENT_TYPE("Content-Type"),

    /**
     * Cross-Origin-Embedder-Policy
     *
     * * [https://html.spec.whatwg.org/multipage/origin.html#coep](https://html.spec.whatwg.org/multipage/origin.html#coep)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Cross-Origin-Embedder-Policy)
     */
    CROSS_ORIGIN_EMBEDDER_POLICY("Cross-Origin-Embedder-Policy"),

    /**
     * Cross-Origin-Opener-Policy
     *
     * * [https://html.spec.whatwg.org/multipage/origin.html#the-coop-headers](https://html.spec.whatwg.org/multipage/origin.html#the-coop-headers)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Cross-Origin-Opener-Policy)
     */
    CROSS_ORIGIN_OPENER_POLICY("Cross-Origin-Opener-Policy"),

    /**
     * Cross-Origin-Resource-Policy
     *
     * * [https://fetch.spec.whatwg.org/#cross-origin-resource-policy-header](https://fetch.spec.whatwg.org/#cross-origin-resource-policy-header)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Cross-Origin-Resource-Policy)
     */
    CROSS_ORIGIN_RESOURCE_POLICY("Cross-Origin-Resource-Policy"),

    /**
     * Date
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Date)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-7.1.1.2)
     */
    DATE("Date"),

    /**
     * Digest
     *
     * * [https://datatracker.ietf.org/doc/html/draft-ietf-httpbis-digest-headers-05#section-3](https://datatracker.ietf.org/doc/html/draft-ietf-httpbis-digest-headers-05#section-3)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Digest)
     */
    DIGEST("Digest"),

    /**
     * ETag
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/ETag)
     * * [RFC7232](https://datatracker.ietf.org/doc/html/rfc7232#section-2.3)
     */
    E_TAG("ETag"),

    /**
     * Expect-CT
     *
     * * [https://datatracker.ietf.org/doc/html/draft-ietf-httpbis-expect-ct-08](https://datatracker.ietf.org/doc/html/draft-ietf-httpbis-expect-ct-08)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Expect-CT)
     */
    EXPECT_CT("Expect-CT"),

    /**
     * Expires
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Expires)
     * * [RFC7234](https://datatracker.ietf.org/doc/html/rfc7234#section-5.3)
     */
    EXPIRES("Expires"),

    /**
     * Feature-Policy
     *
     * * [https://w3c.github.io/webappsec-permissions-policy/#permissions-policy-http-header-field](https://w3c.github.io/webappsec-permissions-policy/#permissions-policy-http-header-field)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Feature-Policy)
     */
    FEATURE_POLICY("Feature-Policy"),

    /**
     * Keep-Alive
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Keep-Alive)
     * * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#appendix-A.1.2)
     */
    KEEP_ALIVE("Keep-Alive"),

    /**
     * Large-Allocation
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Large-Allocation)
     */
    LARGE_ALLOCATION("Large-Allocation"),

    /**
     * Last-Event-ID
     */
    @Deprecated("?")
    LAST_EVENT_ID("Last-Event-ID"),

    /**
     * Last-Modified
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Last-Modified)
     * * [RFC7232](https://datatracker.ietf.org/doc/html/rfc7232#section-2.2)
     */
    LAST_MODIFIED("Last-Modified"),

    /**
     * Link
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Link)
     * * [RFC5988](https://datatracker.ietf.org/doc/html/rfc5988#section-5)
     */
    LINK("Link"),

    /**
     * Location
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Location)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-7.1.2)
     */
    LOCATION("Location"),

    /**
     * Max-Forwards
     */
    @Deprecated("?")
    MAX_FORWARDS("Max-Forwards"),

    /**
     * NEL
     *
     * * [https://w3c.github.io/network-error-logging/#nel-response-header](https://w3c.github.io/network-error-logging/#nel-response-header)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/NEL)
     */
    @Deprecated("?")
    NEL("NEL"),

    /**
     * Origin-Isolation
     */
    @Deprecated("?")
    ORIGIN_ISOLATION("Origin-Isolation"),

    /**
     * Ping-From
     */
    @Deprecated("?")
    PING_FROM("Ping-From"),

    /**
     * Ping-To
     */
    @Deprecated("?")
    PING_TO("Ping-To"),

    /**
     * Pragma
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Pragma)
     * * [RFC7234](https://datatracker.ietf.org/doc/html/rfc7234#section-5.4)
     */
    PRAGMA("Pragma"),

    /**
     * Proxy-Authenticate
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Proxy-Authenticate)
     * * [RFC7235](https://datatracker.ietf.org/doc/html/rfc7235#section-4.3)
     * * [RFC7617](https://datatracker.ietf.org/doc/html/rfc7617)
     */
    PROXY_AUTHENTICATE("Proxy-Authenticate"),

    /**
     * Public-Key-Pins
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Public-Key-Pins)
     * * [RFC7469](https://www.rfc-editor.org/rfc/rfc7469#section-2.1)
     */
    @Deprecated("This feature is no longer recommended.")
    PUBLIC_KEY_PINS("Public-Key-Pins"),

    /**
     * Public-Key-Pins-Report-Only
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Public-Key-Pins-Report-Only)
     * * [RFC7469](https://www.rfc-editor.org/rfc/rfc7469#section-2.1)
     */
    @Deprecated("This feature is no longer recommended.")
    PUBLIC_KEY_PINS_REPORT_ONLY("Public-Key-Pins-Report-Only"),

    /**
     * Push-Policy
     *
     * * [https://datatracker.ietf.org/doc/html/draft-ruellan-http-accept-push-policy-00#section-3.2](https://datatracker.ietf.org/doc/html/draft-ruellan-http-accept-push-policy-00#section-3.2)
     */
    @Deprecated("?")
    PUSH_POLICY("Push-Policy"),

    /**
     * Referrer-Policy
     *
     * * [https://w3c.github.io/webappsec-referrer-policy/#referrer-policy-header](https://w3c.github.io/webappsec-referrer-policy/#referrer-policy-header)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Referrer-Policy)
     */
    REFERRER_POLICY("Referrer-Policy"),

    /**
     * Report-To
     */
    @Deprecated("?")
    REPORT_TO("Report-To"),

    /**
     * Retry-After
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Retry-After)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-7.1.3)
     */
    RETRY_AFTER("Retry-After"),

    /**
     * Sec-WebSocket-Accept
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-WebSocket-Accept)
     */
    SEC_WEBSOCKET_ACCEPT("Sec-WebSocket-Accept"),

    /**
     * Sec-WebSocket-Extensions
     */
    @Deprecated("?")
    SEC_WEBSOCKET_EXTENSIONS("Sec-WebSocket-Extensions"),

    /**
     * Sec-WebSocket-Key
     */
    @Deprecated("?")
    SEC_WEBSOCKET_KEY("Sec-WebSocket-Key"),

    /**
     * Sec-WebSocket-Protocol
     */
    @Deprecated("?")
    SEC_WEBSOCKET_PROTOCOL("Sec-WebSocket-Protocol"),

    /**
     * Sec-WebSocket-Version
     */
    @Deprecated("?")
    SEC_WEBSOCKET_VERSION("Sec-WebSocket-Version"),

    /**
     * Server
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Server)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-7.4.2)
     */
    SERVER("Server"),

    /**
     * Server-Timing
     *
     * * [https://w3c.github.io/server-timing/#the-server-timing-header-field](https://w3c.github.io/server-timing/#the-server-timing-header-field)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Server-Timing)
     */
    SERVER_TIMING("Server-Timing"),

    /**
     * Service-Worker-Allowed
     */
    @Deprecated("?")
    SERVICE_WORKER_ALLOWED("Service-Worker-Allowed"),

    /**
     * Set-Cookie
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Set-Cookie)
     * * [RFC6265](https://datatracker.ietf.org/doc/html/rfc6265#section-4.1)
     */
    SET_COOKIE("Set-Cookie"),

    /**
     * Set-Cookie2
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Set-Cookie2)
     * * [RFC2965](https://datatracker.ietf.org/doc/html/rfc2965)
     */
    @Deprecated("This feature is no longer recommended")
    SET_COOKIE2("Set-Cookie2"),

    /**
     * Signature
     *
     * * [https://wicg.github.io/webpackage/draft-yasskin-http-origin-signed-responses.html#rfc.section.3.1](https://wicg.github.io/webpackage/draft-yasskin-http-origin-signed-responses.html#rfc.section.3.1)
     */
    @Deprecated("?")
    SIGNATURE("Signature"),

    /**
     * Signed-Headers
     *
     * * [https://wicg.github.io/webpackage/draft-yasskin-http-origin-signed-responses.html#rfc.section.5.1.2](https://wicg.github.io/webpackage/draft-yasskin-http-origin-signed-responses.html#rfc.section.5.1.2)
     */
    @Deprecated("?")
    SIGNED_HEADERS("Signed-Headers"),

    /**
     * SourceMap
     *
     * * [https://docs.google.com/document/d/1U1RGAehQwRypUTovF1KRlpiOFze0b-_2gc6fAH0KY0k/edit](https://docs.google.com/document/d/1U1RGAehQwRypUTovF1KRlpiOFze0b-_2gc6fAH0KY0k/edit)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/SourceMap)
     */
    SOURCEMAP("SourceMap"),

    /**
     * Strict-Transport-Security
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Strict-Transport-Security)
     * * [RFC6797](https://datatracker.ietf.org/doc/html/rfc6797)
     */
    STRICT_TRANSPORT_SECURITY("Strict-Transport-Security"),

    /**
     * Timing-Allow-Origin
     *
     * * [https://w3c.github.io/resource-timing/#sec-timing-allow-origin](https://w3c.github.io/resource-timing/#sec-timing-allow-origin)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Timing-Allow-Origin)
     */
    TIMING_ALLOW_ORIGIN("Timing-Allow-Origin"),

    /**
     * Tk
     *
     * * [https://www.w3.org/TR/tracking-dnt/#Tk-header-defn](https://www.w3.org/TR/tracking-dnt/#Tk-header-defn)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Tk)
     */
    @Deprecated("This feature is no longer recommended.")
    TK("Tk"),

    /**
     * Trailer
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Trailer)
     * * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#section-4.1.2)
     * * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#section-4.4)
     */
    TRAILER("Trailer"),

    /**
     * Transfer-Encoding
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Transfer-Encoding)
     * * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#section-3.3.1)
     */
    TRANSFER_ENCODING("Transfer-Encoding"),

    /**
     * Upgrade
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Upgrade)
     * * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#section-6.7)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.15)
     * * [RFC7540](https://datatracker.ietf.org/doc/html/rfc7540#section-8.1.1)
     */
    UPGRADE("Upgrade"),

    /**
     * Vary
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Vary)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-7.1.4)
     */
    VARY("Vary"),

    /**
     * Via
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Via)
     * * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#section-5.7.1)
     */
    VIA("Via"),

    /**
     * Want-Digest
     *
     * * [https://datatracker.ietf.org/doc/html/draft-ietf-httpbis-digest-headers-05#section-4](https://datatracker.ietf.org/doc/html/draft-ietf-httpbis-digest-headers-05#section-4)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Want-Digest)
     */
    WANT_DIGEST("Want-Digest"),

    /**
     * Warning
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Warning)
     * * [RFC7234](https://datatracker.ietf.org/doc/html/rfc7234#section-5.5)
     */
    @Deprecated("This feature is no longer recommended.")
    WARNING("Warning"),

    /**
     * WWW-Authenticate
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/WWW-Authenticate)
     * * [RFC7235](https://datatracker.ietf.org/doc/html/rfc7235#section-4.1)
     */
    WWW_AUTHENTICATE("WWW-Authenticate"),

    /**
     * X-Content-Type-Options
     *
     * * [https://fetch.spec.whatwg.org/#x-content-type-options-header](https://fetch.spec.whatwg.org/#x-content-type-options-header)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Content-Type-Options)
     */
    X_CONTENT_TYPE_OPTIONS("X-Content-Type-Options"),

    /**
     * X-DNS-Prefetch-Control
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-DNS-Prefetch-Control)
     */
    X_DNS_PREFETCH_CONTROL("X-DNS-Prefetch-Control"),

    /**
     * X-Download-Options
     */
    @Deprecated("?")
    X_DOWNLOAD_OPTIONS("X-Download-Options"),

    /**
     * X-Frame-Options
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Frame-Options)
     * * [RFC7034](https://www.rfc-editor.org/rfc/rfc7034#section-2)
     */
    X_FRAME_OPTIONS("X-Frame-Options"),

    /**
     * X-Firefox-Spdy
     */
    @Deprecated("?")
    X_FIREFOX_SPDY("X-Firefox-Spdy"),

    /**
     * X-Permitted-Cross-Domain-Policies
     */
    @Deprecated("?")
    X_PERMITTED_CROSS_DOMAIN_POLICIES("X-Permitted-Cross-Domain-Policies"),

    /**
     * X-Pingback
     */
    @Deprecated("?")
    X_PINGBACK("X-Pingback"),

    /**
     * X-Powered-By
     */
    @Deprecated("?")
    X_POWERED_BY("X-Powered-By"),

    /**
     * X-Requested-With
     */
    @Deprecated("?")
    X_REQUESTED_WITH("X-Requested-With"),

    /**
     * X-Robots-Tag
     *
     * * [https://developers.google.com/search/reference/robots_meta_tag#xrobotstag](https://developers.google.com/search/reference/robots_meta_tag#xrobotstag)
     */
    @Deprecated("?")
    X_ROBOTS_TAG("X-Robots-Tag"),

    /**
     * X-UA-Compatible
     */
    @Deprecated("?")
    X_UA_COMPATIBLE("X-UA-Compatible"),

    /**
     * X-XSS-Protection
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-XSS-Protection)
     */
    X_XSS_PROTECTION("X-XSS-Protection"),
    ;


    companion object {

        /**
         * Returns the element matching the given value.
         */
        @JvmStatic
        fun parse(value: String) = values().single { it.value == value }

        /**
         * Returns the element matching the given value or null.
         */
        @JvmStatic
        fun parseOrNull(value: String) = values().singleOrNull { it.value == value }
    }
}
