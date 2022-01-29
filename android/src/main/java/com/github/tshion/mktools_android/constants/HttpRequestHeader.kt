package com.github.tshion.mktools_android.constants

/**
 * HTTP Request Header
 */
enum class HttpRequestHeader(val value: String) {

    /**
     * Accept
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-5.3.2)
     */
    ACCEPT("Accept"),

    /**
     * Accept-Charset
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-Charset)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-5.3.3)
     */
    ACCEPT_CHARSET("Accept-Charset"),

    /**
     * Accept-Encoding
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-Encoding)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-5.3.4)
     */
    ACCEPT_ENCODING("Accept-Encoding"),

    /**
     * Accept-Language
     *
     * * [https://www.rfc-editor.org/info/bcp47](https://www.rfc-editor.org/info/bcp47)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-Language)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-5.3.5)
     */
    ACCEPT_LANGUAGE("Accept-Language"),

    /**
     * Accept-Push-Policy
     *
     * * [https://datatracker.ietf.org/doc/html/draft-ruellan-http-accept-push-policy-00#section-3.1](https://datatracker.ietf.org/doc/html/draft-ruellan-http-accept-push-policy-00#section-3.1)
     */
    @Deprecated("?")
    ACCEPT_PUSH_POLICY("Accept-Push-Policy"),

    /**
     * Accept-Signature
     *
     * * [https://wicg.github.io/webpackage/draft-yasskin-http-origin-signed-responses.html#rfc.section.3.7](https://wicg.github.io/webpackage/draft-yasskin-http-origin-signed-responses.html#rfc.section.3.7)
     */
    @Deprecated("?")
    ACCEPT_SIGNATURE("Accept-Signature"),

    /**
     * Access-Control-Request-Headers
     *
     * * [https://fetch.spec.whatwg.org/#http-access-control-request-headers](https://fetch.spec.whatwg.org/#http-access-control-request-headers)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Request-Headers)
     */
    ACCESS_CONTROL_REQUEST_HEADERS("Access-Control-Request-Headers"),

    /**
     * Access-Control-Request-Method
     *
     * * [https://fetch.spec.whatwg.org/#http-access-control-request-method](https://fetch.spec.whatwg.org/#http-access-control-request-method)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Request-Method)
     */
    ACCESS_CONTROL_REQUEST_METHOD("Access-Control-Request-Method"),

    /**
     * Allow
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Allow)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-7.4.1)
     */
    ALLOW("Allow"),

    /**
     * Authorization
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Authorization)
     * * [RFC7235](https://datatracker.ietf.org/doc/html/rfc7235#section-4.2)
     * * [RFC7617](https://datatracker.ietf.org/doc/html/rfc7617)
     */
    AUTHORIZATION("Authorization"),

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
     * Connection
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Connection)
     * * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#section-6.1)
     */
    CONNECTION("Connection"),

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
     * Content-Type
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Type)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-3.1.1.5)
     * * [RFC7233](https://datatracker.ietf.org/doc/html/rfc7233#section-4.1)
     */
    CONTENT_TYPE("Content-Type"),

    /**
     * Cookie
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Cookie)
     * * [RFC6265](https://datatracker.ietf.org/doc/html/rfc6265#section-5.4)
     */
    COOKIE("Cookie"),

    /**
     * Cookie2
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Cookie2)
     * * [RFC2965](https://datatracker.ietf.org/doc/html/rfc2965)
     */
    @Deprecated("This feature is no longer recommended.")
    COOKIE2("Cookie2"),

    /**
     * Date
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Date)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-7.1.1.2)
     */
    DATE("Date"),

    /**
     * Device-Memory
     *
     * * [https://w3c.github.io/device-memory/#sec-device-memory-client-hint-header](https://w3c.github.io/device-memory/#sec-device-memory-client-hint-header)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Device-Memory)
     */
    @Deprecated("This is an experimental technology")
    DEVICE_MEMORY("Device-Memory"),

    /**
     * DNT
     *
     * * [https://www.w3.org/TR/tracking-dnt/#dnt-header-field](https://www.w3.org/TR/tracking-dnt/#dnt-header-field)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/DNT)
     */
    @Deprecated("This feature is no longer recommended.")
    DNT("DNT"),

    /**
     * Downlink
     *
     * * [https://wicg.github.io/netinfo/#downlink-request-header-field](https://wicg.github.io/netinfo/#downlink-request-header-field)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Downlink)
     */
    @Deprecated("This is an experimental technology")
    DOWNLINK("Downlink"),

    /**
     * DPR
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/DPR)
     */
    @Deprecated("This feature is no longer recommended.")
    DPR("DPR"),

    /**
     * Early-Data
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Early-Data)
     * * [RFC8470](https://datatracker.ietf.org/doc/html/rfc8470#section-5.1)
     */
    @Deprecated("This is an experimental technology")
    EARLY_DATA("Early-Data"),

    /**
     * ECT
     *
     * * [https://wicg.github.io/netinfo/#ect-request-header-field](https://wicg.github.io/netinfo/#ect-request-header-field)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/ECT)
     */
    @Deprecated("This is an experimental technology")
    ECT("ECT"),

    /**
     * Expect
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Expect)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-5.1.1)
     */
    EXPECT("Expect"),

    /**
     * Forwarded
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Forwarded)
     * * [RFC7239](https://www.rfc-editor.org/rfc/rfc7239#section-4)
     */
    FORWARDED("Forwarded"),

    /**
     * From
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/From)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-5.5.1)
     */
    FROM("From"),

    /**
     * Host
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Host)
     * * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#section-5.4)
     */
    HOST("Host"),

    /**
     * If-Match
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/If-Match)
     * * [RFC7232](https://datatracker.ietf.org/doc/html/rfc7232#section-3.1)
     */
    IF_MATCH("If-Match"),

    /**
     * If-Modified-Since
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/If-Modified-Since)
     * * [RFC7232](https://datatracker.ietf.org/doc/html/rfc7232#section-3.3)
     */
    IF_MODIFIED_SINCE("If-Modified-Since"),

    /**
     * If-None-Match
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/If-None-Match)
     * * [RFC7232](https://datatracker.ietf.org/doc/html/rfc7232#section-3.2)
     */
    IF_NONE_MATCH("If-None-Match"),

    /**
     * If-Range
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/If-Range)
     * * [RFC7233](https://datatracker.ietf.org/doc/html/rfc7233#section-3.2)
     */
    IF_RANGE("If-Range"),

    /**
     * If-Unmodified-Since
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/If-Unmodified-Since)
     * * [RFC7232](https://datatracker.ietf.org/doc/html/rfc7232#section-3.4)
     */
    IF_UNMODIFIED_SINCE("If-Unmodified-Since"),

    /**
     * Keep-Alive
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Keep-Alive)
     * * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#appendix-A.1.2)
     */
    KEEP_ALIVE("Keep-Alive"),

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
     * Max-Forwards
     */
    @Deprecated("?")
    MAX_FORWARDS("Max-Forwards"),

    /**
     * Origin
     *
     * * [https://fetch.spec.whatwg.org/#origin-header](https://fetch.spec.whatwg.org/#origin-header)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Origin)
     * * [RFC6454](https://datatracker.ietf.org/doc/html/rfc6454#section-7)
     */
    ORIGIN("Origin"),

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
     * Proxy-Authorization
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Proxy-Authorization)
     * * [RFC7235](https://datatracker.ietf.org/doc/html/rfc7235#section-4.4)
     * * [RFC7617](https://datatracker.ietf.org/doc/html/rfc7617)
     */
    PROXY_AUTHORIZATION("Proxy-Authorization"),

    /**
     * Push-Policy
     *
     * * [https://datatracker.ietf.org/doc/html/draft-ruellan-http-accept-push-policy-00#section-3.2](https://datatracker.ietf.org/doc/html/draft-ruellan-http-accept-push-policy-00#section-3.2)
     */
    @Deprecated("?")
    PUSH_POLICY("Push-Policy"),

    /**
     * Range
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Range)
     * * [RFC7233](https://datatracker.ietf.org/doc/html/rfc7233#section-3.1)
     */
    RANGE("Range"),

    /**
     * Referer
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Referer)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-5.5.2)
     */
    REFERER("Referer"),

    /**
     * Report-To
     */
    @Deprecated("?")
    REPORT_TO("Report-To"),

    /**
     * RTT
     *
     * * [https://wicg.github.io/netinfo/#rtt-request-header-field](https://wicg.github.io/netinfo/#rtt-request-header-field)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/RTT)
     */
    @Deprecated("This is an experimental technology")
    RTT("RTT"),

    /**
     * Save-Data
     *
     * * [https://wicg.github.io/savedata/#save-data-request-header-field](https://wicg.github.io/savedata/#save-data-request-header-field)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Save-Data)
     */
    @Deprecated("This is an experimental technology")
    SAVE_DATA("Save-Data"),

    /**
     * Sec-CH-UA
     *
     * * [https://wicg.github.io/ua-client-hints/#sec-ch-ua](https://wicg.github.io/ua-client-hints/#sec-ch-ua)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-CH-UA)
     */
    @Deprecated("This is an experimental technology")
    SEC_CH_UA("Sec-CH-UA"),

    /**
     * Sec-CH-UA-Arch
     *
     * * [https://wicg.github.io/ua-client-hints/#sec-ch-ua-arch](https://wicg.github.io/ua-client-hints/#sec-ch-ua-arch)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-CH-UA-Arch)
     */
    @Deprecated("This is an experimental technology")
    SEC_CH_UA_ARCH("Sec-CH-UA-Arch"),

    /**
     * Sec-CH-UA-Bitness
     *
     * * [https://wicg.github.io/ua-client-hints/#sec-ch-ua-bitness](https://wicg.github.io/ua-client-hints/#sec-ch-ua-bitness)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-CH-UA-Bitness)
     */
    @Deprecated("This is an experimental technology")
    SEC_CH_UA_BITNESS("Sec-CH-UA-Bitness"),

    /**
     * Sec-CH-UA-Full-Version
     *
     * * [https://wicg.github.io/ua-client-hints/#sec-ch-ua-full-version](https://wicg.github.io/ua-client-hints/#sec-ch-ua-full-version)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-CH-UA-Full-Version)
     */
    @Deprecated("This feature is no longer recommended.")
    SEC_CH_UA_FULL_VERSION("Sec-CH-UA-Full-Version"),

    /**
     * Sec-CH-UA-Full-Version-List
     *
     * * [https://wicg.github.io/ua-client-hints/#sec-ch-ua-full-version-list](https://wicg.github.io/ua-client-hints/#sec-ch-ua-full-version-list)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-CH-UA-Full-Version-List)
     */
    @Deprecated("This is an experimental technology")
    SEC_CH_UA_FULL_VERSION_LIST("Sec-CH-UA-Full-Version-List"),

    /**
     * Sec-CH-UA-Mobile
     *
     * * [https://wicg.github.io/ua-client-hints/#sec-ch-ua-mobile](https://wicg.github.io/ua-client-hints/#sec-ch-ua-mobile)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-CH-UA-Mobile)
     */
    @Deprecated("This is an experimental technology")
    SEC_CH_UA_MOBILE("Sec-CH-UA-Mobile"),

    /**
     * Sec-CH-UA-Model
     *
     * * [https://wicg.github.io/ua-client-hints/#sec-ch-ua-model](https://wicg.github.io/ua-client-hints/#sec-ch-ua-model)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-CH-UA-Model)
     */
    @Deprecated("This is an experimental technology")
    SEC_CH_UA_MODEL("Sec-CH-UA-Model"),

    /**
     * Sec-CH-UA-Platform
     *
     * * [https://wicg.github.io/ua-client-hints/#sec-ch-ua-platform](https://wicg.github.io/ua-client-hints/#sec-ch-ua-platform)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-CH-UA-Platform)
     */
    @Deprecated("This is an experimental technology")
    SEC_CH_UA_PLATFORM("Sec-CH-UA-Platform"),

    /**
     * Sec-CH-UA-Platform-Version
     *
     * * [https://wicg.github.io/ua-client-hints/#sec-ch-ua-platform-version](https://wicg.github.io/ua-client-hints/#sec-ch-ua-platform-version)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-CH-UA-Platform-Version)
     */
    @Deprecated("This is an experimental technology")
    SEC_CH_UA_PLATFORM_VERSION("Sec-CH-UA-Platform-Version"),

    /**
     * Sec-Fetch-Dest
     *
     * * [https://w3c.github.io/webappsec-fetch-metadata/#sec-fetch-dest-header](https://w3c.github.io/webappsec-fetch-metadata/#sec-fetch-dest-header)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-Fetch-Dest)
     */
    SEC_FETCH_DEST("Sec-Fetch-Dest"),

    /**
     * Sec-Fetch-Mode
     *
     * * [https://w3c.github.io/webappsec-fetch-metadata/#sec-fetch-mode-header](https://w3c.github.io/webappsec-fetch-metadata/#sec-fetch-mode-header)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-Fetch-Mode)
     */
    SEC_FETCH_MODE("Sec-Fetch-Mode"),

    /**
     * Sec-Fetch-Site
     *
     * * [https://w3c.github.io/webappsec-fetch-metadata/#sec-fetch-site-header](https://w3c.github.io/webappsec-fetch-metadata/#sec-fetch-site-header)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-Fetch-Site)
     */
    SEC_FETCH_SITE("Sec-Fetch-Site"),

    /**
     * Sec-Fetch-User
     *
     * * [https://w3c.github.io/webappsec-fetch-metadata/#sec-fetch-user-header](https://w3c.github.io/webappsec-fetch-metadata/#sec-fetch-user-header)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-Fetch-User)
     */
    SEC_FETCH_USER("Sec-Fetch-User"),

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
     * Service-Worker-Allowed
     */
    @Deprecated("?")
    SERVICE_WORKER_ALLOWED("Service-Worker-Allowed"),

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
     * TE
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/TE)
     * * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#section-4.3)
     */
    TE("TE"),

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
     * Upgrade-Insecure-Requests
     *
     * * [https://w3c.github.io/webappsec-upgrade-insecure-requests/#preference](https://w3c.github.io/webappsec-upgrade-insecure-requests/#preference)
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Upgrade-Insecure-Requests)
     */
    UPGRADE_INSECURE_REQUESTS("Upgrade-Insecure-Requests"),

    /**
     * User-Agent
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/User-Agent)
     * * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-14.43)
     * * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-5.5.3)
     */
    USER_AGENT("User-Agent"),

    /**
     * Via
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Via)
     * * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#section-5.7.1)
     */
    VIA("Via"),

    /**
     * Viewport-Width
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Viewport-Width)
     */
    @Deprecated("This feature is no longer recommended.")
    VIEWPORT_WIDTH("Viewport-Width"),

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
     * Width
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Width)
     */
    @Deprecated("This feature is no longer recommended.")
    WIDTH("Width"),

    /**
     * X-Download-Options
     */
    @Deprecated("?")
    X_DOWNLOAD_OPTIONS("X-Download-Options"),

    /**
     * X-Firefox-Spdy
     */
    @Deprecated("?")
    X_FIREFOX_SPDY("X-Firefox-Spdy"),

    /**
     * X-Forwarded-For
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Forwarded-For)
     */
    @Deprecated("Not part of any current specification. The standardized version of this header is Forwarded.")
    X_FORWARDED_FOR("X-Forwarded-For"),

    /**
     * X-Forwarded-Host
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Forwarded-Host)
     */
    @Deprecated("Not part of any current specification. The standardized version of this header is Forwarded.")
    X_FORWARDED_HOST("X-Forwarded-Host"),

    /**
     * X-Forwarded-Proto
     *
     * * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Forwarded-Proto)
     */
    @Deprecated("Not part of any current specification. The standardized version of this header is Forwarded.")
    X_FORWARDED_PROTO("X-Forwarded-Proto"),

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
    ;


    companion object {

        /**
         * Returns the element matching the given value.
         */
        @JvmStatic
        fun parse(value: String): HttpRequestHeader {
            return values().single { it.value == value }
        }

        /**
         * Returns the element matching the given value or null.
         */
        @JvmStatic
        fun parseOrNull(value: String): HttpRequestHeader? {
            return values().singleOrNull { it.value == value }
        }
    }
}
