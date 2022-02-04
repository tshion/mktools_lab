/// HTTP Response Header
public enum HttpResponseHeader: String {

    /// Returns the element matching the given value.
    public static func parse(value: String) -> HttpResponseHeader {
        return HttpResponseHeader.init(rawValue: value)!
    }

    /// Returns the element matching the given value or null.
    public static func parseOrNull(value: String) -> HttpResponseHeader? {
        return HttpResponseHeader.init(rawValue: value)
    }


    /// Accept-CH
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-CH)
    ///
    /// - Warning: This is an experimental technology
    case acceptCh = "Accept-CH"

    /// Accept-CH-Lifetime
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-CH-Lifetime)
    ///
    /// - Warning: This feature is no longer recommended.
    case acceptChLifetime = "Accept-CH-Lifetime"

    /// Accept-Patch
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-Patch)
    /// * [RFC5789](https://datatracker.ietf.org/doc/html/rfc5789#section-3.1)
    case acceptPatch = "Accept-Patch"

    /// Accept-Post
    ///
    /// * [https://www.w3.org/TR/ldp/#header-accept-post](https://www.w3.org/TR/ldp/#header-accept-post)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-Post)
    case acceptPost = "Accept-Post"

    /// Accept-Ranges
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-Ranges)
    /// * [RFC7233](https://datatracker.ietf.org/doc/html/rfc7233#section-2.3)
    case acceptRanges = "Accept-Ranges"

    /// Access-Control-Allow-Credentials
    ///
    /// * [https://fetch.spec.whatwg.org/#http-access-control-allow-credentials](https://fetch.spec.whatwg.org/#http-access-control-allow-credentials)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Credentials)
    case accessControlAllowCredentials = "Access-Control-Allow-Credentials"

    /// Access-Control-Allow-Headers
    ///
    /// * [https://fetch.spec.whatwg.org/#http-access-control-allow-headers](https://fetch.spec.whatwg.org/#http-access-control-allow-headers)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Headers)
    case accessControlAllowHeaders = "Access-Control-Allow-Headers"

    /// Access-Control-Allow-Methods
    ///
    /// * [https://fetch.spec.whatwg.org/#http-access-control-allow-methods](https://fetch.spec.whatwg.org/#http-access-control-allow-methods)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Methods)
    case accessControlAllowMethods = "Access-Control-Allow-Methods"

    /// Access-Control-Allow-Origin
    ///
    /// * [https://fetch.spec.whatwg.org/#http-access-control-allow-origin](https://fetch.spec.whatwg.org/#http-access-control-allow-origin)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Origin)
    case accessControlAllowOrigin = "Access-Control-Allow-Origin"

    /// Access-Control-Expose-Headers
    ///
    /// * [https://fetch.spec.whatwg.org/#http-access-control-expose-headers](https://fetch.spec.whatwg.org/#http-access-control-expose-headers)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Expose-Headers)
    case accessControlExposeHeaders = "Access-Control-Expose-Headers"

    /// Access-Control-Max-Age
    ///
    /// * [https://fetch.spec.whatwg.org/#http-access-control-max-age](https://fetch.spec.whatwg.org/#http-access-control-max-age)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Max-Age)
    case accessControlMaxAge = "Access-Control-Max-Age"

    /// Age
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Age)
    /// * [RFC7234](https://datatracker.ietf.org/doc/html/rfc7234#section-5.1)
    case age = "Age"

    /// Allow
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Allow)
    /// * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-7.4.1)
    case allow = "Allow"

    /// Alt-Svc
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Alt-Svc)
    /// * [RFC7838](https://datatracker.ietf.org/doc/html/rfc7838)
    case altSvc = "Alt-Svc"

    /// Cache-Control
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Cache-Control)
    /// * [RFC5861](https://datatracker.ietf.org/doc/html/rfc5861)
    /// * [RFC7234](https://datatracker.ietf.org/doc/html/rfc7234)
    /// * [RFC8246](https://datatracker.ietf.org/doc/html/rfc8246)
    case cacheControl = "Cache-Control"

    /// Clear-Site-Data
    ///
    /// * [https://w3c.github.io/webappsec-clear-site-data/](https://w3c.github.io/webappsec-clear-site-data/)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Clear-Site-Data)
    case clearSiteData = "Clear-Site-Data"

    /// Connection
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Connection)
    /// * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#section-6.1)
    case connection = "Connection"

    /// Content-Disposition
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Disposition)
    /// * [RFC2183](https://datatracker.ietf.org/doc/html/rfc2183)
    /// * [RFC6266](https://datatracker.ietf.org/doc/html/rfc6266)
    /// * [RFC7578](https://datatracker.ietf.org/doc/html/rfc7578)
    case contentDisposition = "Content-Disposition"

    /// Content-DPR
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-DPR)
    ///
    /// - Warning: This feature is no longer recommended.
    case contentDpr = "Content-DPR"

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

    /// Content-Range
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Range)
    /// * [RFC7233](https://datatracker.ietf.org/doc/html/rfc7233#section-4.2)
    case contentRange = "Content-Range"

    /// Content-Security-Policy
    ///
    /// * [https://w3c.github.io/webappsec-csp/#csp-header](https://w3c.github.io/webappsec-csp/#csp-header)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy)
    case contentSecurityPolicy = "Content-Security-Policy"

    /// Content-Security-Policy-Report-Only
    ///
    /// * [https://w3c.github.io/webappsec-csp/#cspro-header](https://w3c.github.io/webappsec-csp/#cspro-header)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Security-Policy-Report-Only)
    case contentSecurityPolicyReportOnly = "Content-Security-Policy-Report-Only"

    /// Content-Type
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Type)
    /// * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-3.1.1.5)
    /// * [RFC7233](https://datatracker.ietf.org/doc/html/rfc7233#section-4.1)
    case contentType = "Content-Type"

    /// Cross-Origin-Embedder-Policy
    ///
    /// * [https://html.spec.whatwg.org/multipage/origin.html#coep](https://html.spec.whatwg.org/multipage/origin.html#coep)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Cross-Origin-Embedder-Policy)
    case crossOriginEmbedderPolicy = "Cross-Origin-Embedder-Policy"

    /// Cross-Origin-Opener-Policy
    ///
    /// * [https://html.spec.whatwg.org/multipage/origin.html#the-coop-headers](https://html.spec.whatwg.org/multipage/origin.html#the-coop-headers)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Cross-Origin-Opener-Policy)
    case crossOriginOpenerPolicy = "Cross-Origin-Opener-Policy"

    /// Cross-Origin-Resource-Policy
    ///
    /// * [https://fetch.spec.whatwg.org/#cross-origin-resource-policy-header](https://fetch.spec.whatwg.org/#cross-origin-resource-policy-header)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Cross-Origin-Resource-Policy)
    case crossOriginResourcePolicy = "Cross-Origin-Resource-Policy"

    /// Date
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Date)
    /// * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-7.1.1.2)
    case date = "Date"

    /// Digest
    ///
    /// * [https://datatracker.ietf.org/doc/html/draft-ietf-httpbis-digest-headers-05#section-3](https://datatracker.ietf.org/doc/html/draft-ietf-httpbis-digest-headers-05#section-3)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Digest)
    case digest = "Digest"

    /// ETag
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/ETag)
    /// * [RFC7232](https://datatracker.ietf.org/doc/html/rfc7232#section-2.3)
    case eTag = "ETag"

    /// Expect-CT
    ///
    /// * [https://datatracker.ietf.org/doc/html/draft-ietf-httpbis-expect-ct-08](https://datatracker.ietf.org/doc/html/draft-ietf-httpbis-expect-ct-08)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Expect-CT)
    case expectCt = "Expect-CT"

    /// Expires
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Expires)
    /// * [RFC7234](https://datatracker.ietf.org/doc/html/rfc7234#section-5.3)
    case expires = "Expires"

    /// Feature-Policy
    ///
    /// * [https://w3c.github.io/webappsec-permissions-policy/#permissions-policy-http-header-field](https://w3c.github.io/webappsec-permissions-policy/#permissions-policy-http-header-field)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Feature-Policy)
    case featurePolicy = "Feature-Policy"

    /// Keep-Alive
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Keep-Alive)
    /// * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#appendix-A.1.2)
    case keepAlive = "Keep-Alive"

    /// Large-Allocation
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Large-Allocation)
    case largeAllocation = "Large-Allocation"

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

    /// Location
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Location)
    /// * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-7.1.2)
    case location = "Location"

    /// Max-Forwards
    ///
    /// - Warning: ?
    case maxForwards = "Max-Forwards"

    /// NEL
    ///
    /// * [https://w3c.github.io/network-error-logging/#nel-response-header](https://w3c.github.io/network-error-logging/#nel-response-header)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/NEL)
    ///
    /// - Warning: ?
    case nel = "NEL"

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

    /// Proxy-Authenticate
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Proxy-Authenticate)
    /// * [RFC7235](https://datatracker.ietf.org/doc/html/rfc7235#section-4.3)
    /// * [RFC7617](https://datatracker.ietf.org/doc/html/rfc7617)
    case proxyAuthenticate = "Proxy-Authenticate"

    /// Public-Key-Pins
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Public-Key-Pins)
    /// * [RFC7469](https://www.rfc-editor.org/rfc/rfc7469#section-2.1)
    ///
    /// - Warning: This feature is no longer recommended.
    case publicKeyPins = "Public-Key-Pins"

    /// Public-Key-Pins-Report-Only
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Public-Key-Pins-Report-Only)
    /// * [RFC7469](https://www.rfc-editor.org/rfc/rfc7469#section-2.1)
    ///
    /// - Warning: This feature is no longer recommended.
    case publicKeyPinsReportOnly = "Public-Key-Pins-Report-Only"

    /// Push-Policy
    ///
    /// * [https://datatracker.ietf.org/doc/html/draft-ruellan-http-accept-push-policy-00#section-3.2](https://datatracker.ietf.org/doc/html/draft-ruellan-http-accept-push-policy-00#section-3.2)
    ///
    /// - Warning: ?
    case pushPolicy = "Push-Policy"

    /// Referrer-Policy
    ///
    /// * [https://w3c.github.io/webappsec-referrer-policy/#referrer-policy-header](https://w3c.github.io/webappsec-referrer-policy/#referrer-policy-header)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Referrer-Policy)
    case referrerPolicy = "Referrer-Policy"

    /// Report-To
    ///
    /// - Warning: ?
    case reportTo = "Report-To"

    /// Retry-After
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Retry-After)
    /// * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-7.1.3)
    case retryAfter = "Retry-After"

    /// Sec-WebSocket-Accept
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Sec-WebSocket-Accept)
    case secWebsocketAccept = "Sec-WebSocket-Accept"

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

    /// Server
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Server)
    /// * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-7.4.2)
    case server = "Server"

    /// Server-Timing
    ///
    /// * [https://w3c.github.io/server-timing/#the-server-timing-header-field](https://w3c.github.io/server-timing/#the-server-timing-header-field)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Server-Timing)
    case serverTiming = "Server-Timing"

    /// Service-Worker-Allowed
    ///
    /// - Warning: ?
    case serviceWorkerAllowed = "Service-Worker-Allowed"

    /// Set-Cookie
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Set-Cookie)
    /// * [RFC6265](https://datatracker.ietf.org/doc/html/rfc6265#section-4.1)
    case setCookie = "Set-Cookie"

    /// Set-Cookie2
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Set-Cookie2)
    /// * [RFC2965](https://datatracker.ietf.org/doc/html/rfc2965)
    ///
    /// - Warning: This feature is no longer recommended
    case setCookie2 = "Set-Cookie2"

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

    /// SourceMap
    ///
    /// * [https://docs.google.com/document/d/1U1RGAehQwRypUTovF1KRlpiOFze0b-_2gc6fAH0KY0k/edit](https://docs.google.com/document/d/1U1RGAehQwRypUTovF1KRlpiOFze0b-_2gc6fAH0KY0k/edit)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/SourceMap)
    case sourcemap = "SourceMap"

    /// Strict-Transport-Security
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Strict-Transport-Security)
    /// * [RFC6797](https://datatracker.ietf.org/doc/html/rfc6797)
    case strictTransportSecurity = "Strict-Transport-Security"

    /// Timing-Allow-Origin
    ///
    /// * [https://w3c.github.io/resource-timing/#sec-timing-allow-origin](https://w3c.github.io/resource-timing/#sec-timing-allow-origin)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Timing-Allow-Origin)
    case timingAllowOrigin = "Timing-Allow-Origin"

    /// Tk
    ///
    /// * [https://www.w3.org/TR/tracking-dnt/#Tk-header-defn](https://www.w3.org/TR/tracking-dnt/#Tk-header-defn)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Tk)
    ///
    /// - Warning: This feature is no longer recommended.
    case tk = "Tk"

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

    /// Vary
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Vary)
    /// * [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-7.1.4)
    case vary = "Vary"

    /// Via
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Via)
    /// * [RFC7230](https://datatracker.ietf.org/doc/html/rfc7230#section-5.7.1)
    case via = "Via"

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

    /// WWW-Authenticate
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/WWW-Authenticate)
    /// * [RFC7235](https://datatracker.ietf.org/doc/html/rfc7235#section-4.1)
    case wwwAuthenticate = "WWW-Authenticate"

    /// X-Content-Type-Options
    ///
    /// * [https://fetch.spec.whatwg.org/#x-content-type-options-header](https://fetch.spec.whatwg.org/#x-content-type-options-header)
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Content-Type-Options)
    case xContentTypeOptions = "X-Content-Type-Options"

    /// X-DNS-Prefetch-Control
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-DNS-Prefetch-Control)
    case xDnsPrefetchControl = "X-DNS-Prefetch-Control"

    /// X-Download-Options
    ///
    /// - Warning: ?
    case xDownloadOptions = "X-Download-Options"

    /// X-Frame-Options
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Frame-Options)
    /// * [RFC7034](https://www.rfc-editor.org/rfc/rfc7034#section-2)
    case xFrameOptions = "X-Frame-Options"

    /// X-Firefox-Spdy
    ///
    /// - Warning: ?
    case xFirefoxSpdy = "X-Firefox-Spdy"

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

    /// X-XSS-Protection
    ///
    /// * [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-XSS-Protection)
    case xXssProtection = "X-XSS-Protection"
}
