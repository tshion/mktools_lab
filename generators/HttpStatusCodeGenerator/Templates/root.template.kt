package your.package

/**
 * HTTP Status Code
 */
enum class HttpStatusCode(val value: Int) {

%%ITEMS%%
    ;


    companion object {

        /**
         * Returns the element matching the given value.
         */
        @JvmStatic
        fun parse(value: Int): HttpStatusCode {
            return values().single { it.value == value }
        }

        /**
         * Returns the element matching the given value or null.
         */
        @JvmStatic
        fun parseOrNull(value: Int): HttpStatusCode? {
            return values().singleOrNull { it.value == value }
        }
    }
}
