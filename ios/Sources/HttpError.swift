import Foundation

/// Exception for an unexpected, non-2xx HTTP response.
///
/// * [square/retrofit](https://github.com/square/retrofit/blob/master/retrofit/src/main/java/retrofit2/HttpException.java)
public struct HttpError: LocalizedError {

    public let code: Int
    public let message: String
    public let response: HTTPURLResponse?


    public var errorDescription: String? {
        return "HTTP \(code) \(message)"
    }


    private init(
        code: Int,
        message: String,
        response: HTTPURLResponse?
    ) {
        self.code = code
        self.message = message
        self.response = response
    }
}


extension HttpError {

    public static func create(
        response: HTTPURLResponse
    ) -> HttpError {
        return HttpError(
            code: response.statusCode,
            message: response.description,
            response: response
        )
    }
}
