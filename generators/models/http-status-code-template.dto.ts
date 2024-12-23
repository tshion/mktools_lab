import { WebLinkDto } from './web-link.dto';

/**
 * テンプレート向けのHTTP Status Code 情報
 */
export interface HttpStatusCodeTemplateDto {
    /** HTTP Status Code */
    readonly code: string;

    /** HTTP Status Code の説明 */
    readonly descriptions: string[];

    /** 関連リンクの一覧 */
    readonly links: WebLinkDto[];

    /** 生成コードの変数名 */
    readonly variable: {
        /** キャメルケース形式 */
        readonly camel: string;

        /** パスカルケース形式 */
        readonly pascal: string;

        /** スネークケース形式 */
        readonly snake: string;
    };

    /** コード警告 */
    readonly warning: string;
}
