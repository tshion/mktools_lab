/**
 Http Status Code
 */
public enum HttpStatusCode : Int {

    /**
     100 Continue

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/100)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.1.1)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.2.1)
     */
    case `continue` = 100

    /**
     101 Switching Protocols

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/101)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.1.2)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.2.2)
     */
    case switchingProtocols = 101

    /**
     102 Processing(WebDAV)

     - SeeAlso:
      - [RFC2518](https://datatracker.ietf.org/doc/html/rfc2518#section-10.1)
     */
    case processing = 102

    /**
     103 Early Hints

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/103)
      - [RFC8297](https://datatracker.ietf.org/doc/html/rfc8297#section-2)
     */
    case earlyHints = 103

    /**
     200 OK

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/200)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.2.1)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.3.1)
     */
    case ok = 200

    /**
     201 Created

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/201)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.2.2)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.3.2)
     */
    case created = 201

    /**
     202 Accepted

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/202)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.2.3)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.3.3)
     */
    case accepted = 202

    /**
     203 Non-Authoritative Information

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/203)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.2.4)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.3.4)
     */
    case nonAuthoritativeInformation = 203

    /**
     204 No Content

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/204)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.2.5)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.3.5)
     */
    case noContent = 204

    /**
     205 Reset Content

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/205)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.2.6)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.3.6)
     */
    case resetContent = 205

    /**
     206 Partial Content

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/206)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.2.7)
      - [RFC7233](https://datatracker.ietf.org/doc/html/rfc7233#section-4.1)
     */
    case partialContent = 206

    /**
     207 Multi-Status(WebDAV)

     - SeeAlso:
      - [RFC2518](https://datatracker.ietf.org/doc/html/rfc2518#section-10.2)
      - [RFC4918](https://datatracker.ietf.org/doc/html/rfc4918#section-11.1)
     */
    case multiStatus = 207

    /**
     208 Already Reported(WebDAV)

     - SeeAlso:
      - [RFC5842](https://datatracker.ietf.org/doc/html/rfc5842#section-7.1)
     */
    case alreadyReported = 208

    /**
     226 IM Used(HTTP Delta encoding)

     - SeeAlso:
      - [RFC3229](https://datatracker.ietf.org/doc/html/rfc3229#section-10.4.1)
     */
    case imUsed = 226

    /**
     300 Multiple Choice

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/300)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.3.1)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.4.1)
     */
    case multipleChoice = 300

    /**
     301 Moved Permanently

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/301)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.3.2)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.4.2)
     */
    case movedPermanently = 301

    /**
     302 Found
     (HTTP 1.0: Moved Temporarily)

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/302)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.3.3)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.4.3)
     */
    case found = 302

    /**
     303 See Other

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/303)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.3.4)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.4.4)
     */
    case seeOther = 303

    /**
     304 Not Modified

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/304)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.3.5)
      - [RFC7232](https://datatracker.ietf.org/doc/html/rfc7232#section-4.1)
     */
    case notModified = 304

    /**
     305 Use Proxy

     - SeeAlso:
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.3.6)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.4.5)

     - Warning: It has been deprecated due to security concerns regarding in-band configuration of a proxy.
     */
    case useProxy = 305

    /**
     306 unused

     - SeeAlso:
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.3.7)

     - Warning: This response code is no longer used; it is just reserved.
     */
    case unused = 306

    /**
     307 Temporary Redirect

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/307)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.3.8)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.4.7)
     */
    case temporaryRedirect = 307

    /**
     308 Permanent Redirect

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/308)
      - [RFC7238](https://datatracker.ietf.org/doc/html/rfc7238)
      - [RFC7538](https://datatracker.ietf.org/doc/html/rfc7538#section-3)
     */
    case permanentRedirect = 308

    /**
     400 Bad Request

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/400)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.1)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.1)
     */
    case badRequest = 400

    /**
     401 Unauthorized

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/401)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.2)
      - [RFC7235](https://datatracker.ietf.org/doc/html/rfc7235#section-3.1)
     */
    case unauthorized = 401

    /**
     402 Payment Required

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/402)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.3)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.2)

     - Warning: This response code is reserved for future use.
     */
    case paymentRequired = 402

    /**
     403 Forbidden

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/403)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.4)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.3)
     */
    case forbidden = 403

    /**
     404 Not Found

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/404)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.5)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.4)
     */
    case notFound = 404

    /**
     405 Method Not Allowed

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/405)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.6)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.5)
     */
    case methodNotAllowed = 405

    /**
     406 Not Acceptable

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/406)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.7)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.6)
     */
    case notAcceptable = 406

    /**
     407 Proxy Authentication Required

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/407)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.8)
      - [RFC7235](https://datatracker.ietf.org/doc/html/rfc7235#section-3.2)
     */
    case proxyAuthenticationRequired = 407

    /**
     408 Request Timeout

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/408)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.9)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.7)
     */
    case requestTimeout = 408

    /**
     409 Conflict

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/409)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.10)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.8)
     */
    case conflict = 409

    /**
     410 Gone

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/410)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.11)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.9)
     */
    case gone = 410

    /**
     411 Length Required

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/411)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.12)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.10)
     */
    case lengthRequired = 411

    /**
     412 Precondition Failed

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/412)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.13)
      - [RFC7232](https://datatracker.ietf.org/doc/html/rfc7232#section-4.2)
     */
    case preconditionFailed = 412

    /**
     413 Payload Too Large
     (HTTP 1.0: Request Entity Too Large)

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/413)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.11)
     */
    case payloadTooLarge = 413

    /**
     414 URI Too Long
     (HTTP 1.0: Request-URI Too Long)

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/414)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.12)
     */
    case uriTooLong = 414

    /**
     415 Unsupported Media Type

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/415)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.16)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.13)
     */
    case unsupportedMediaType = 415

    /**
     416 Range Not Satisfiable

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/416)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.17)
      - [RFC7233](https://datatracker.ietf.org/doc/html/rfc7233#section-4.4)
     */
    case rangeNotSatisfiable = 416

    /**
     417 Expectation Failed

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/417)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.4.18)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.14)
     */
    case expectationFailed = 417

    /**
     418 I'm a teapot

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/418)
      - [RFC2324](https://datatracker.ietf.org/doc/html/rfc2324#section-2.3.2)
      - [RFC7168](https://datatracker.ietf.org/doc/html/rfc7168#section-2.3.3)
     */
    case iAmATeapot = 418

    /**
     421 Misdirected Request

     - SeeAlso:
      - [RFC7540](https://datatracker.ietf.org/doc/html/rfc7540#section-9.1.2)
      - [RFC7838](https://datatracker.ietf.org/doc/html/rfc7838#section-6)
     */
    case misdirectedRequest = 421

    /**
     422 Unprocessable Entity(WebDAV)

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/422)
      - [RFC2518](https://datatracker.ietf.org/doc/html/rfc2518#section-10.3)
      - [RFC4918](https://datatracker.ietf.org/doc/html/rfc4918#section-11.2)
     */
    case unprocessableEntity = 422

    /**
     423 Locked(WebDAV)

     - SeeAlso:
      - [RFC2518](https://datatracker.ietf.org/doc/html/rfc2518#section-10.4)
      - [RFC4918](https://datatracker.ietf.org/doc/html/rfc4918#section-11.3)
     */
    case locked = 423

    /**
     424 Failed Dependency(WebDAV)

     - SeeAlso:
      - [RFC2518](https://datatracker.ietf.org/doc/html/rfc2518#section-10.5)
      - [RFC4918](https://datatracker.ietf.org/doc/html/rfc4918#section-11.4)
     */
    case failedDependency = 424

    /**
     425 Too Early

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/425)
      - [RFC8470](https://datatracker.ietf.org/doc/html/rfc8470#section-5.2)

     - Warning: This is an experimental technology.
     */
    case tooEarly = 425

    /**
     426 Upgrade Required

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/426)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.15)
     */
    case upgradeRequired = 426

    /**
     428 Precondition Required

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/428)
      - [RFC6585](https://datatracker.ietf.org/doc/html/rfc6585#section-3)
     */
    case preconditionRequired = 428

    /**
     429 Too Many Requests

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/429)
      - [RFC6585](https://datatracker.ietf.org/doc/html/rfc6585#section-4)
     */
    case tooManyRequests = 429

    /**
     431 Request Header Fields Too Large

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/431)
      - [RFC6585](https://datatracker.ietf.org/doc/html/rfc6585#section-5)
     */
    case requestHeaderFieldsTooLarge = 431

    /**
     451 Unavailable For Legal Reasons

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/451)
      - [RFC7725](https://datatracker.ietf.org/doc/html/rfc7725#section-3)
     */
    case unavailableForLegalReasons = 451

    /**
     500 Internal Server Error

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/500)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.5.1)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.6.1)
     */
    case internalServerError = 500

    /**
     501 Not Implemented

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/501)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.5.2)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.6.2)
     */
    case notImplemented = 501

    /**
     502 Bad Gateway

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/502)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.5.3)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.6.3)
     */
    case badGateway = 502

    /**
     503 Service Unavailable

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/503)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.5.4)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.6.4)
     */
    case serviceUnavailable = 503

    /**
     504 Gateway Timeout

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/504)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.5.5)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.6.5)
     */
    case gatewayTimeout = 504

    /**
     505 HTTP Version Not Supported

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/505)
      - [RFC2616](https://datatracker.ietf.org/doc/html/rfc2616#section-10.5.6)
      - [RFC7231](https://datatracker.ietf.org/doc/html/rfc7231#section-6.6.6)
     */
    case httpVersionNotSupported = 505

    /**
     506 Variant Also Negotiates

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/506)
      - [RFC2295](https://datatracker.ietf.org/doc/html/rfc2295#section-8.1)
     */
    case variantAlsoNegotiates = 506

    /**
     507 Insufficient Storage(WebDAV)

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/507)
      - [RFC4918](https://datatracker.ietf.org/doc/html/rfc4918#section-11.5)
     */
    case insufficientStorage = 507

    /**
     508 Loop Detected(WebDAV)

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/508)
      - [RFC5842](https://datatracker.ietf.org/doc/html/rfc5842#section-7.2)
     */
    case loopDetected = 508

    /**
     510 Not Extended

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/510)
      - [RFC2774](https://datatracker.ietf.org/doc/html/rfc2774#section-7)
     */
    case notExtended = 510

    /**
     511 Network Authentication Required

     - SeeAlso:
      - [MDN Web Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/511)
      - [RFC6585](https://datatracker.ietf.org/doc/html/rfc6585#section-6)
     */
    case networkAuthenticationRequired = 511
}
