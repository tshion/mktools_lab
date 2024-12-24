/**
 * スプレッドシート「HttpHeader」の設定項目
 */
export const HttpHeaderGSheetKey = {
    NAME: 'Name',
    CAUTION: 'Caution',
    HAS_MDN: 'HasMDN',
    URL1: 'Url1',
    URL2: 'Url2',
    URL3: 'Url3',
} as const;

/**
 * スプレッドシート「HttpHeader」の設定項目の型
 */
export type HttpHeaderGSheetKey = (typeof HttpHeaderGSheetKey)[keyof typeof HttpHeaderGSheetKey];


/**
 * スプレッドシート「HttpHeader」のデータ項目
 */
export interface HttpHeaderGSheetDto extends Record<HttpHeaderGSheetKey, string> { }
