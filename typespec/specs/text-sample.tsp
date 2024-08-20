import "@typespec/json-schema";

using TypeSpec.JsonSchema;

@jsonSchema
namespace Schemas;

/** RGB + alpha カラーコード */
scalar argb extends string;

/** RGB カラーコード */
scalar rgb extends string;

/**
 * 文字列関連の定義のサンプル
 */
model TextSample {
    /** 好きな色 */
    color: rgb = "#FF0000";

    /** 好きな色(透過付き) */
    colorAlpha: argb = "#FFFF0000";

    /** フリーダイヤル */
    freeDial: "0120" | "0800" = "0120";

    /** フリーダイヤルの一覧 */
    freeDialList: ("0120" | "0800")[] = #["0120"];

    /** メッセージ */
    message: string = "Hello World!";

    /** メッセージの一覧 */
    messageList: string[] = #["Hello World!", "Good night!"];
}
