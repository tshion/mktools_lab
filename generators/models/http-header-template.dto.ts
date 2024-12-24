import { WebLinkDto } from './web-link.dto';

/**
 * テンプレート向けのHTTP Header 情報
 */
export interface HttpHeaderTemplateDto {

    /** 説明 */
    readonly description: string;

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

    /** 値 */
    readonly variableValue: string;

    /** コード警告 */
    readonly warning: string;
}
