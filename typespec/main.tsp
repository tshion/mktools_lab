import "@typespec/json-schema";

using TypeSpec.JsonSchema;

@jsonSchema
namespace Schemas;

/**
 * HTTP レスポンスステータスコード
 */
model HttpStatusCode {

    /** ステータスコード */
    @maxValue(599)
    code: uint16;

    /** メッセージ */
    message: string
}
