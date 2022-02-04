package your.package

%%CLASS_DOCS%%
internal enum class %%CLASS_NAME%%(val value: %%CLASS_TYPE_BASE%%) {

    %%REPEAT_BEGIN%%
    %%PROPERTY_DOCS%%
    %%PROPERTY_PREFIX%%
    %%PROPERTY_NAME%%(%%PROPERTY_VALUE%%),

    %%REPEAT_END%%
    ;


    companion object {

        /**
         * Returns the element matching the given value.
         */
        @JvmStatic
        fun parse(value: %%CLASS_TYPE_BASE%%) = values().single { it.value == value }

        /**
         * Returns the element matching the given value or null.
         */
        @JvmStatic
        fun parseOrNull(value: %%CLASS_TYPE_BASE%%) = values().singleOrNull { it.value == value }
    }
}
