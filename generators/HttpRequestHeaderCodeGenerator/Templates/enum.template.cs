namespace YourNamespace
{
    %%CLASS_DOCS%%
    internal enum %%CLASS_NAME%%
    {
        /// <summary>
        /// This is default value.
        /// </summary>
        [Obsolete("Please use another.")]
        Undefined = 0,

        %%REPEAT_BEGIN%%
        %%PROPERTY_DOCS%%
        %%PROPERTY_PREFIX%%
        %%PROPERTY_NAME%%,

        %%REPEAT_END%%
    }


    internal static class %%CLASS_NAME%%Extensions
    {
        private static readonly Dictionary<%%CLASS_TYPE_BASE%%, %%CLASS_NAME%%> _store = new()
        {
            %%REPEAT_BEGIN%%
            [%%PROPERTY_VALUE%%] = %%CLASS_NAME%%.%%PROPERTY_NAME%%,
            %%REPEAT_END%%
        };


        /// <summary>
        /// Converts the string representation of a HttpRequestHeader
        /// </summary>
        /// <exception cref="ArgumentException">No such member.</exception>
        public static %%CLASS_NAME%% Parse(%%CLASS_TYPE_BASE%% value)
        {
            var isSuccess = TryParse(value, out var result);
            if (isSuccess)
            {
                return result;
            }
            else
            {
                throw new ArgumentException("No such member.");
            }
        }

        /// <summary>
        /// Converts the string representation of a HttpRequestHeader
        /// </summary>
        public static bool TryParse(%%CLASS_TYPE_BASE%% value, out %%CLASS_NAME%% result)
        {
            result = _store
                .SingleOrDefault(pair => pair.Key.Equals(value, StringComparison.OrdinalIgnoreCase))
                .Value;
            return result != default;
        }
    }
}
