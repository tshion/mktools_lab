// 自動生成

/** 入力形式 */
export const InputType = {
    CHECKBOX: 'checkbox',
    COLOR: 'color',
    NUMBER: 'number',
    SELECT: 'select',
    TEXTBOX: 'textbox',
} as const;

/** 入力形式の型エイリアス */
export type InputType = typeof InputType[keyof typeof InputType];

/**
 * 入力欄の構造定義
 */
export interface InputSchemaDto {

    /** 入力グループ */
    group: string;

    /** 入力形式 */
    inputType: InputType;

    /** 複数入力できるかどうか */
    isArray: boolean;

    /** キー名 */
    key: string;

    /** 概要 */
    label: string;

    /** 数値入力できる最高値 */
    max?: number;

    /** 数値入力できる最低値 */
    min?: number;

    /** 選択肢 */
    options?: (number | string)[];

    /** 許可する入力パターンの正規表現 */
    pattern?: string;

    /** (デフォルトの)入力値 */
    value: (boolean | number | string)[];
}


/** 入力欄の構造データ */
export const inputSchemas: InputSchemaDto[] = [/** Data */];
