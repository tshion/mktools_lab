/** RGB カラーコード */
scalar rgbHex extends string;

/** 色 */
model Color {
    /** 名前 */
    name: string;

    /** カラーコード */
    code: rgbHex;
}
