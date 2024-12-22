/**
 * スプレッドシート「HttpStatusCode」の設定項目
 */
export const HttpStatusCodeGSheetKey = {
    CODE: 'Code',
    NAME: 'Name',
    OLD_NAME: 'OldName',
    NOTE: 'Note',
    CAUTION: 'Caution',
    HAS_MDN: 'HasMDN',
    URL1: 'Url1',
    URL2: 'Url2',
} as const;

/**
 * スプレッドシート「HttpStatusCode」の設定項目の型
 */
export type HttpStatusCodeGSheetKey = (typeof HttpStatusCodeGSheetKey)[keyof typeof HttpStatusCodeGSheetKey];


/**
 * スプレッドシート「HttpStatusCode」のデータ項目
 */
export interface HttpStatusCodeGSheetDto extends Record<HttpStatusCodeGSheetKey, string> { }
