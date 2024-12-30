import { WebLinkDto } from './web-link.dto';

/**
 * テンプレートに流し込むコード情報
 */
export interface CodeTemplateDto {

    /** ドキュメントコメント */
    readonly documentComment: DocumentCommentTemplateDto;

    /** モデルの継承元 */
    readonly extends?: string;

    /** モデル名 */
    readonly name: string;

    /** プロパティ */
    readonly properties: CodePropertyTemplateDto[];
}

/**
 * テンプレートに流し込むコードのプロパティ情報
 */
export interface CodePropertyTemplateDto {

    /** コードメタデータ */
    readonly decorators: {
        /** 廃止 */
        readonly deprecated: string;
    };

    /** ドキュメントコメント */
    readonly documentComment: DocumentCommentTemplateDto;

    /** プロパティ名 */
    readonly name: {
        /** キャメルケース形式 */
        readonly camel: string;

        /** パスカルケース形式 */
        readonly pascal: string;

        /** スネークケース形式 */
        readonly snake: string;
    };

    /** プロパティ値 */
    readonly value?: string;
}

/**
 * テンプレートに流し込むドキュメントコメント情報
 */
export interface DocumentCommentTemplateDto {

    /** 説明文 */
    readonly descriptions: string[];

    /** 関連リンクの一覧 */
    readonly links: WebLinkDto[];
}
