/**
 * 入力欄の構造定義
 */
export interface InputSchemaDto {

    /** 複数入力できるかどうか */
    isArray: boolean;

    /** キー名 */
    key: string;

    /** 概要 */
    label: string;

    /** 選択肢 */
    options?: (number | string)[];

    /** 形式 */
    type: string;

    /** (デフォルトの)入力値 */
    value: (number | string)[];
}
