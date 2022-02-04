%%CLASS_DOCS%%
enum %%CLASS_NAME%%: %%CLASS_TYPE_BASE%% {

    /// Returns the element matching the given value.
    public static func parse(value: %%CLASS_TYPE_BASE%%) -> %%CLASS_NAME%% {
        return %%CLASS_NAME%%.init(rawValue: value)!
    }

    /// Returns the element matching the given value or null.
    public static func parseOrNull(value: %%CLASS_TYPE_BASE%%) -> %%CLASS_NAME%%? {
        return %%CLASS_NAME%%.init(rawValue: value)
    }


    %%REPEAT_BEGIN%%
    %%PROPERTY_DOCS%%
    case %%PROPERTY_NAME%% = %%PROPERTY_VALUE%%

    %%REPEAT_END%%
}
