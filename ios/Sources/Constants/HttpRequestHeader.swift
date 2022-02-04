/// HTTP Request Header
public enum HttpRequestHeader: String {

    /// Returns the element matching the given value.
    public static func parse(value: String) -> HttpRequestHeader {
        return HttpRequestHeader.init(rawValue: value)!
    }

    /// Returns the element matching the given value or null.
    public static func parseOrNull(value: String) -> HttpRequestHeader? {
        return HttpRequestHeader.init(rawValue: value)
    }


    /// Accept
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept)
    /// * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-5.3.2)
    case accept = "Accept"

    /// Accept-Charset
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-Charset)
    /// * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-5.3.3)
    case acceptCharset = "Accept-Charset"

    /// Accept-Encoding
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-Encoding)
    /// * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-5.3.4)
    case acceptEncoding = "Accept-Encoding"

    /// Accept-Language
    ///
    /// * [https://www.rfc-editor.org/info/bcp47](https://www.rfc-editor.org/info/bcp47)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-Language)
    /// * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-5.3.5)
    case acceptLanguage = "Accept-Language"

    /// Accept-Push-Policy
    ///
    /// * [https://datatracker.ietf.org/doc/html/draft-ruellan-http-accept-push-policy-00#section-3.1](https://datatracker.ietf.org/doc/html/draft-ruellan-http-accept-push-policy-00#section-3.1)
    ///
    /// - Warning: ?
    case acceptPushPolicy = "Accept-Push-Policy"

    /// Accept-Signature
    ///
    /// * [https://wicg.github.io/webpackage/draft-yasskin-http-origin-signed-responses.html#rfc.section.3.7](https://wicg.github.io/webpackage/draft-yasskin-http-origin-signed-responses.html#rfc.section.3.7)
    ///
    /// - Warning: ?
    case acceptSignature = "Accept-Signature"

    /// Access-Control-Request-Headers
    ///
    /// * [https://fetch.spec.whatwg.org/#http-access-control-request-headers](https://fetch.spec.whatwg.org/#http-access-control-request-headers)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Request-Headers)
    case accessControlRequestHeaders = "Access-Control-Request-Headers"

    /// Access-Control-Request-Method
    ///
    /// * [https://fetch.spec.whatwg.org/#http-access-control-request-method](https://fetch.spec.whatwg.org/#http-access-control-request-method)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Request-Method)
    case accessControlRequestMethod = "Access-Control-Request-Method"

    /// Allow
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Allow)
    /// * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-7.4.1)
    case allow = "Allow"

    /// Authorization
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Authorization)
    /// * [RFC7235](https://datatracker.ietf.org/doc/html/rfc7235#section-4.2)
    /// * [RFC7617](https://datatracker.ietf.org/doc/html/rfc7617)
    case authorization = "Authorization"

    /// Cache-Control
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Cache-Control)
    /// * [RFC5861](https://datatracker.ietf.org/doc/html/rfc5861)
    /// * [RFC7234](https://datatracker.ietf.org/doc/html/rfc7234)
    /// * [RFC8246](https://datatracker.ietf.org/doc/html/rfc8246)
    case cacheControl = "Cache-Control"

    /// Connection
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Connection)
    /// * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#section-6.1)
    case connection = "Connection"

    /// Content-Encoding
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Encoding)
    /// * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-14.11)
    /// * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-3.1.2.2)
    /// * [RFC7932](https://datatracker.ietf.org/doc/html/rfc7932)
    case contentEncoding = "Content-Encoding"

    /// Content-Language
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Language)
    /// * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-3.1.3.2)
    case contentLanguage = "Content-Language"

    /// Content-Length
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Length)
    /// * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#section-3.3.2)
    case contentLength = "Content-Length"

    /// Content-Location
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Location)
    /// * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-3.1.4.2)
    case contentLocation = "Content-Location"

    /// Content-Type
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Type)
    /// * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-3.1.1.5)
    /// * [RFC7233](https://datatracker.ietf.org/doc/html/rfc7233#section-4.1)
    case contentType = "Content-Type"

    /// Cookie
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Cookie)
    /// * [RFC6265](https://datatracker.ietf.org/doc/html/rfc6265#section-5.4)
    case cookie = "Cookie"

    /// Cookie2
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Cookie2)
    /// * [RFC2965](https://datatracker.ietf.org/doc/html/rfc2965)
    ///
    /// - Warning: This feature is no longer recommended.
    case cookie2 = "Cookie2"

    /// Date
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Date)
    /// * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-7.1.1.2)
    case date = "Date"

    /// Device-Memory
    ///
    /// * [https://w3c.github.io/device-memory/#sec-device-memory-client-hint-header](https://w3c.github.io/device-memory/#sec-device-memory-client-hint-header)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Device-Memory)
    ///
    /// - Warning: This is an experimental technology
    case deviceMemory = "Device-Memory"

    /// DNT
    ///
    /// * [https://www.w3.org/TR/tracking-dnt/#dnt-header-field](https://www.w3.org/TR/tracking-dnt/#dnt-header-field)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/DNT)
    ///
    /// - Warning: This feature is no longer recommended.
    case dnt = "DNT"

    /// Downlink
    ///
    /// * [https://wicg.github.io/netinfo/#downlink-request-header-field](https://wicg.github.io/netinfo/#downlink-request-header-field)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Downlink)
    ///
    /// - Warning: This is an experimental technology
    case downlink = "Downlink"

    /// DPR
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/DPR)
    ///
    /// - Warning: This feature is no longer recommended.
    case dpr = "DPR"

    /// Early-Data
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Early-Data)
    /// * [RFC8470](https://datatracker.ietf.org/doc/html/rfc8470#section-5.1)
    ///
    /// - Warning: This is an experimental technology
    case earlyData = "Early-Data"

    /// ECT
    ///
    /// * [https://wicg.github.io/netinfo/#ect-request-header-field](https://wicg.github.io/netinfo/#ect-request-header-field)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/ECT)
    ///
    /// - Warning: This is an experimental technology
    case ect = "ECT"

    /// Expect
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Expect)
    /// * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-5.1.1)
    case expect = "Expect"

    /// Forwarded
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Forwarded)
    /// * [RFC7239](https://www.rfc-editor.org/rfc/rfc7239#section-4)
    case forwarded = "Forwarded"

    /// From
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/From)
    /// * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-5.5.1)
    case from = "From"

    /// Host
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Host)
    /// * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#section-5.4)
    case host = "Host"

    /// If-Match
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/If-Match)
    /// * [RFC7232](https://datatracker.ietf.org/doc/html/rfc7232#section-3.1)
    case ifMatch = "If-Match"

    /// If-Modified-Since
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/If-Modified-Since)
    /// * [RFC7232](https://datatracker.ietf.org/doc/html/rfc7232#section-3.3)
    case ifModifiedSince = "If-Modified-Since"

    /// If-None-Match
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/If-None-Match)
    /// * [RFC7232](https://datatracker.ietf.org/doc/html/rfc7232#section-3.2)
    case ifNoneMatch = "If-None-Match"

    /// If-Range
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/If-Range)
    /// * [RFC7233](https://datatracker.ietf.org/doc/html/rfc7233#section-3.2)
    case ifRange = "If-Range"

    /// If-Unmodified-Since
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/If-Unmodified-Since)
    /// * [RFC7232](https://datatracker.ietf.org/doc/html/rfc7232#section-3.4)
    case ifUnmodifiedSince = "If-Unmodified-Since"

    /// Keep-Alive
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Keep-Alive)
    /// * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#appendix-A.1.2)
    case keepAlive = "Keep-Alive"

    /// Last-Event-ID
    ///
    /// - Warning: ?
    case lastEventId = "Last-Event-ID"

    /// Last-Modified
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Last-Modified)
    /// * [RFC7232](https://datatracker.ietf.org/doc/html/rfc7232#section-2.2)
    case lastModified = "Last-Modified"

    /// Link
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Link)
    /// * [RFC5988](https://datatracker.ietf.org/doc/html/rfc5988#section-5)
    case link = "Link"

    /// Max-Forwards
    ///
    /// - Warning: ?
    case maxForwards = "Max-Forwards"

    /// Origin
    ///
    /// * [https://fetch.spec.whatwg.org/#origin-header](https://fetch.spec.whatwg.org/#origin-header)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Origin)
    /// * [RFC6454](https://datatracker.ietf.org/doc/html/rfc6454#section-7)
    case origin = "Origin"

    /// Origin-Isolation
    ///
    /// - Warning: ?
    case originIsolation = "Origin-Isolation"

    /// Ping-From
    ///
    /// - Warning: ?
    case pingFrom = "Ping-From"

    /// Ping-To
    ///
    /// - Warning: ?
    case pingTo = "Ping-To"

    /// Pragma
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Pragma)
    /// * [RFC7234](https://datatracker.ietf.org/doc/html/rfc7234#section-5.4)
    case pragma = "Pragma"

    /// Proxy-Authorization
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Proxy-Authorization)
    /// * [RFC7235](https://datatracker.ietf.org/doc/html/rfc7235#section-4.4)
    /// * [RFC7617](https://datatracker.ietf.org/doc/html/rfc7617)
    case proxyAuthorization = "Proxy-Authorization"

    /// Push-Policy
    ///
    /// * [https://datatracker.ietf.org/doc/html/draft-ruellan-http-accept-push-policy-00#section-3.2](https://datatracker.ietf.org/doc/html/draft-ruellan-http-accept-push-policy-00#section-3.2)
    ///
    /// - Warning: ?
    case pushPolicy = "Push-Policy"

    /// Range
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Range)
    /// * [RFC7233](https://datatracker.ietf.org/doc/html/rfc7233#section-3.1)
    case range = "Range"

    /// Referer
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Referer)
    /// * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-5.5.2)
    case referer = "Referer"

    /// Report-To
    ///
    /// - Warning: ?
    case reportTo = "Report-To"

    /// RTT
    ///
    /// * [https://wicg.github.io/netinfo/#rtt-request-header-field](https://wicg.github.io/netinfo/#rtt-request-header-field)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/RTT)
    ///
    /// - Warning: This is an experimental technology
    case rtt = "RTT"

    /// Save-Data
    ///
    /// * [https://wicg.github.io/savedata/#save-data-request-header-field](https://wicg.github.io/savedata/#save-data-request-header-field)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Save-Data)
    ///
    /// - Warning: This is an experimental technology
    case saveData = "Save-Data"

    /// Sec-CH-UA
    ///
    /// * [https://wicg.github.io/ua-client-hints/#sec-ch-ua](https://wicg.github.io/ua-client-hints/#sec-ch-ua)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-CH-UA)
    ///
    /// - Warning: This is an experimental technology
    case secChUa = "Sec-CH-UA"

    /// Sec-CH-UA-Arch
    ///
    /// * [https://wicg.github.io/ua-client-hints/#sec-ch-ua-arch](https://wicg.github.io/ua-client-hints/#sec-ch-ua-arch)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-CH-UA-Arch)
    ///
    /// - Warning: This is an experimental technology
    case secChUaArch = "Sec-CH-UA-Arch"

    /// Sec-CH-UA-Bitness
    ///
    /// * [https://wicg.github.io/ua-client-hints/#sec-ch-ua-bitness](https://wicg.github.io/ua-client-hints/#sec-ch-ua-bitness)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-CH-UA-Bitness)
    ///
    /// - Warning: This is an experimental technology
    case secChUaBitness = "Sec-CH-UA-Bitness"

    /// Sec-CH-UA-Full-Version
    ///
    /// * [https://wicg.github.io/ua-client-hints/#sec-ch-ua-full-version](https://wicg.github.io/ua-client-hints/#sec-ch-ua-full-version)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-CH-UA-Full-Version)
    ///
    /// - Warning: This feature is no longer recommended.
    case secChUaFullVersion = "Sec-CH-UA-Full-Version"

    /// Sec-CH-UA-Full-Version-List
    ///
    /// * [https://wicg.github.io/ua-client-hints/#sec-ch-ua-full-version-list](https://wicg.github.io/ua-client-hints/#sec-ch-ua-full-version-list)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-CH-UA-Full-Version-List)
    ///
    /// - Warning: This is an experimental technology
    case secChUaFullVersionList = "Sec-CH-UA-Full-Version-List"

    /// Sec-CH-UA-Mobile
    ///
    /// * [https://wicg.github.io/ua-client-hints/#sec-ch-ua-mobile](https://wicg.github.io/ua-client-hints/#sec-ch-ua-mobile)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-CH-UA-Mobile)
    ///
    /// - Warning: This is an experimental technology
    case secChUaMobile = "Sec-CH-UA-Mobile"

    /// Sec-CH-UA-Model
    ///
    /// * [https://wicg.github.io/ua-client-hints/#sec-ch-ua-model](https://wicg.github.io/ua-client-hints/#sec-ch-ua-model)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-CH-UA-Model)
    ///
    /// - Warning: This is an experimental technology
    case secChUaModel = "Sec-CH-UA-Model"

    /// Sec-CH-UA-Platform
    ///
    /// * [https://wicg.github.io/ua-client-hints/#sec-ch-ua-platform](https://wicg.github.io/ua-client-hints/#sec-ch-ua-platform)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-CH-UA-Platform)
    ///
    /// - Warning: This is an experimental technology
    case secChUaPlatform = "Sec-CH-UA-Platform"

    /// Sec-CH-UA-Platform-Version
    ///
    /// * [https://wicg.github.io/ua-client-hints/#sec-ch-ua-platform-version](https://wicg.github.io/ua-client-hints/#sec-ch-ua-platform-version)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-CH-UA-Platform-Version)
    ///
    /// - Warning: This is an experimental technology
    case secChUaPlatformVersion = "Sec-CH-UA-Platform-Version"

    /// Sec-Fetch-Dest
    ///
    /// * [https://w3c.github.io/webappsec-fetch-metadata/#sec-fetch-dest-header](https://w3c.github.io/webappsec-fetch-metadata/#sec-fetch-dest-header)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-Fetch-Dest)
    case secFetchDest = "Sec-Fetch-Dest"

    /// Sec-Fetch-Mode
    ///
    /// * [https://w3c.github.io/webappsec-fetch-metadata/#sec-fetch-mode-header](https://w3c.github.io/webappsec-fetch-metadata/#sec-fetch-mode-header)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-Fetch-Mode)
    case secFetchMode = "Sec-Fetch-Mode"

    /// Sec-Fetch-Site
    ///
    /// * [https://w3c.github.io/webappsec-fetch-metadata/#sec-fetch-site-header](https://w3c.github.io/webappsec-fetch-metadata/#sec-fetch-site-header)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-Fetch-Site)
    case secFetchSite = "Sec-Fetch-Site"

    /// Sec-Fetch-User
    ///
    /// * [https://w3c.github.io/webappsec-fetch-metadata/#sec-fetch-user-header](https://w3c.github.io/webappsec-fetch-metadata/#sec-fetch-user-header)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-Fetch-User)
    case secFetchUser = "Sec-Fetch-User"

    /// Sec-WebSocket-Extensions
    ///
    /// - Warning: ?
    case secWebsocketExtensions = "Sec-WebSocket-Extensions"

    /// Sec-WebSocket-Key
    ///
    /// - Warning: ?
    case secWebsocketKey = "Sec-WebSocket-Key"

    /// Sec-WebSocket-Protocol
    ///
    /// - Warning: ?
    case secWebsocketProtocol = "Sec-WebSocket-Protocol"

    /// Sec-WebSocket-Version
    ///
    /// - Warning: ?
    case secWebsocketVersion = "Sec-WebSocket-Version"

    /// Service-Worker-Allowed
    ///
    /// - Warning: ?
    case serviceWorkerAllowed = "Service-Worker-Allowed"

    /// Signature
    ///
    /// * [https://wicg.github.io/webpackage/draft-yasskin-http-origin-signed-responses.html#rfc.section.3.1](https://wicg.github.io/webpackage/draft-yasskin-http-origin-signed-responses.html#rfc.section.3.1)
    ///
    /// - Warning: ?
    case signature = "Signature"

    /// Signed-Headers
    ///
    /// * [https://wicg.github.io/webpackage/draft-yasskin-http-origin-signed-responses.html#rfc.section.5.1.2](https://wicg.github.io/webpackage/draft-yasskin-http-origin-signed-responses.html#rfc.section.5.1.2)
    ///
    /// - Warning: ?
    case signedHeaders = "Signed-Headers"

    /// TE
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/TE)
    /// * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#section-4.3)
    case te = "TE"

    /// Trailer
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Trailer)
    /// * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#section-4.1.2)
    /// * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#section-4.4)
    case trailer = "Trailer"

    /// Transfer-Encoding
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Transfer-Encoding)
    /// * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#section-3.3.1)
    case transferEncoding = "Transfer-Encoding"

    /// Upgrade
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Upgrade)
    /// * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#section-6.7)
    /// * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.15)
    /// * [RFC7540](https://datatracker.ietf.org/doc/html/rfc7540#section-8.1.1)
    case upgrade = "Upgrade"

    /// Upgrade-Insecure-Requests
    ///
    /// * [https://w3c.github.io/webappsec-upgrade-insecure-requests/#preference](https://w3c.github.io/webappsec-upgrade-insecure-requests/#preference)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Upgrade-Insecure-Requests)
    case upgradeInsecureRequests = "Upgrade-Insecure-Requests"

    /// User-Agent
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/User-Agent)
    /// * [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-14.43)
    /// * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-5.5.3)
    case userAgent = "User-Agent"

    /// Via
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Via)
    /// * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#section-5.7.1)
    case via = "Via"

    /// Viewport-Width
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Viewport-Width)
    ///
    /// - Warning: This feature is no longer recommended.
    case viewportWidth = "Viewport-Width"

    /// Want-Digest
    ///
    /// * [https://datatracker.ietf.org/doc/html/draft-ietf-httpbis-digest-headers-05#section-4](https://datatracker.ietf.org/doc/html/draft-ietf-httpbis-digest-headers-05#section-4)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Want-Digest)
    case wantDigest = "Want-Digest"

    /// Warning
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Warning)
    /// * [RFC7234](https://datatracker.ietf.org/doc/html/rfc7234#section-5.5)
    ///
    /// - Warning: This feature is no longer recommended.
    case warning = "Warning"

    /// Width
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Width)
    ///
    /// - Warning: This feature is no longer recommended.
    case width = "Width"

    /// X-Download-Options
    ///
    /// - Warning: ?
    case xDownloadOptions = "X-Download-Options"

    /// X-Firefox-Spdy
    ///
    /// - Warning: ?
    case xFirefoxSpdy = "X-Firefox-Spdy"

    /// X-Forwarded-For
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Forwarded-For)
    ///
    /// - Warning: Not part of any current specification. The standardized version of this header is Forwarded.
    case xForwardedFor = "X-Forwarded-For"

    /// X-Forwarded-Host
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Forwarded-Host)
    ///
    /// - Warning: Not part of any current specification. The standardized version of this header is Forwarded.
    case xForwardedHost = "X-Forwarded-Host"

    /// X-Forwarded-Proto
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Forwarded-Proto)
    ///
    /// - Warning: Not part of any current specification. The standardized version of this header is Forwarded.
    case xForwardedProto = "X-Forwarded-Proto"

    /// X-Permitted-Cross-Domain-Policies
    ///
    /// - Warning: ?
    case xPermittedCrossDomainPolicies = "X-Permitted-Cross-Domain-Policies"

    /// X-Pingback
    ///
    /// - Warning: ?
    case xPingback = "X-Pingback"

    /// X-Powered-By
    ///
    /// - Warning: ?
    case xPoweredBy = "X-Powered-By"

    /// X-Requested-With
    ///
    /// - Warning: ?
    case xRequestedWith = "X-Requested-With"

    /// X-Robots-Tag
    ///
    /// * [https://developers.google.com/search/reference/robots_meta_tag#xrobotstag](https://developers.google.com/search/reference/robots_meta_tag#xrobotstag)
    ///
    /// - Warning: ?
    case xRobotsTag = "X-Robots-Tag"

    /// X-UA-Compatible
    ///
    /// - Warning: ?
    case xUaCompatible = "X-UA-Compatible"
}
