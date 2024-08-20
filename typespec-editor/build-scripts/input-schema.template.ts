// 自動生成

/** 入力形式 */
export const InputType = {
} as const;

/** 入力形式の型エイリアス */
export type InputType = typeof InputType[keyof typeof InputType];

/**
 * 入力欄の構造定義
 */
export interface InputSchemaDto {

    /** 入力形式 */
    inputType: InputType;

    /** 複数入力できるかどうか */
    isArray: boolean;

    /** キー名 */
    key: string;

    /** 概要 */
    label: string;

    /** 選択肢 */
    options?: (number | string)[];

    /** (デフォルトの)入力値 */
    value: (number | string)[];
}


/** 入力欄の構造データ */
export const inputSchemas: InputSchemaDto[] = [
    /** Data */
];
