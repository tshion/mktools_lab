package your.package

/**
 * HTTP Response Header
 */
enum class HttpResponseHeader(val value: String) {

%%ITEMS%%
    ;


    companion object {

        /**
         * Returns the element matching the given value.
         */
        @JvmStatic
        fun parse(value: String): HttpResponseHeader {
            return values().single { it.value == value }
        }

        /**
         * Returns the element matching the given value or null.
         */
        @JvmStatic
        fun parseOrNull(value: String): HttpResponseHeader? {
            return values().singleOrNull { it.value == value }
        }
    }
}
