package your.package

/**
 * HTTP Request Header
 */
enum class HttpRequestHeader(val value: String) {

%%ITEMS%%
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
