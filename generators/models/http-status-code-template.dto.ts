/**
 * テンプレート向けのHTTP Status Code 情報
 */
export interface HttpStatusCodeTemplateDto {
    /** HTTP Status Code */
    readonly code: string;

    /** HTTP Status Code の説明 */
    readonly description: string;

    /** 関連リンクの一覧 */
    readonly links: HttpStatusCodeLinkTemplateDto[];

    /** 生成コードの変数名 */
    readonly variable: {
        /** キャメルケース形式 */
        readonly camel: string;

        /** パスカルケース形式 */
        readonly pascal: string;

        /** スネークケース形式 */
        readonly snake: string;
    };
}

/**
 * テンプレート向けのHTTP Status Code の関連リンク情報
 */
export interface HttpStatusCodeLinkTemplateDto {
    /** リンクタイトル */
    readonly title: string;

    /** リンク先 */
    readonly url: string;
}
