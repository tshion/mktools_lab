import { FormType } from '../types/form.type';

/**
 * 入力データの基礎実装
 */
export abstract class QuestionBaseEntity<T> {

    /** 入力欄の形式 */
    abstract formType: FormType;

    /** 入力欄の識別キー名 */
    public key: string;

    /** 入力欄の説明 */
    public label: string;

    /** 入力値 */
    public value: T | undefined;

    /** (デフォルトの)入力値 */
    public valueDefault: T;


    public constructor(
        key: string,
        label: string,
        valueDefault: T,
        options: {
            value?: T;
        } = {},
    ) {
        this.key = key;
        this.label = label;
        this.value = options.value;
        this.valueDefault = valueDefault;
    }
}
