import "@typespec/json-schema";

using TypeSpec.JsonSchema;

@jsonSchema
namespace Schemas;

/**
 * 数値関連の定義のサンプル
 */
model NumberSample {
    /** 空を飛べるか？ */
    canFly: boolean = false;

    /** サイコロの目 */
    dice: 1 | 2 | 3 | 4 | 5 | 6 = 3;

    /** サイコロの目の一覧 */
    dices: (1 | 2 | 3 | 4 | 5 | 6)[] = #[3];

    /** ステータスコード */
    @maxValue(599)
    httpStatusCode: uint16 = 200;

    /** ステータスコードの一覧 */
    httpStatusCodeList: uint16[] = #[200];

    /** 消費税率 */
    tax: float64 = 0.10;

    /** 消費税率の一覧 */
    taxList: float64[] = #[0.08, 0.10];
}
