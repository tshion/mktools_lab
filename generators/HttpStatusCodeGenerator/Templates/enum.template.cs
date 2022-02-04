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
        %%PROPERTY_NAME%% = %%PROPERTY_VALUE%%,

        %%REPEAT_END%%
    }
}
