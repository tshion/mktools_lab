namespace HttpStatusCodeGenerator
{
    /// <summary>
    /// リンクデータ
    /// </summary>
    internal class LinkEntity
    {
        /// <summary>
        /// タイトル
        /// </summary>
        public string Title { get; private set; }

        /// <summary>
        /// URL
        /// </summary>
        public string Url { get; private set; }


        public LinkEntity(
            string title,
            string url
        )
        {
            Title = title;
            Url = url;
        }
    }
}
