/**
 * スプレッドシート「HttpHeader」のシート一覧
 */
export const HttpHeaderGSheet = {
    REQUEST: 'Request',
    RESPONSE: 'Response',
} as const;

/**
 * スプレッドシート「HttpHeader」のシート一覧
 */
export type HttpHeaderGSheet = (typeof HttpHeaderGSheet)[keyof typeof HttpHeaderGSheet];
