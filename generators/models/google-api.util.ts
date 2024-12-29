import { google } from 'googleapis';
import { existsSync } from 'node:fs';
import { extname } from 'node:path';

/**
 * [Google Sheets API](https://developers.google.com/sheets) の操作クライアント生成
 *
 * @param pathJwtFile Google サービスアカウント認証情報(JSON 形式) のファイルパス
 * @param canWrite 書き込み権限を要求するかどうか
 */
export async function createGSheetsApiClient(
    pathJwtFile: string,
    canWrite: boolean = false,
) {
    if (!existsSync(pathJwtFile) || extname(pathJwtFile) !== '.json') {
        throw Error(`サービスアカウント認証情報(JSON 形式) が見当たりません: ${pathJwtFile}`);
    }

    // 参考: https://github.com/googleapis/google-api-nodejs-client/issues/1699#issuecomment-1770598231
    const scopeSuffix = canWrite ? '' : '.readonly';
    const jwt = new google.auth.JWT({
        keyFile: pathJwtFile,
        scopes: [
            `https://www.googleapis.com/auth/spreadsheets${scopeSuffix}`,
        ]
    });
    await jwt.authorize();
    return google.sheets({ version: 'v4', auth: jwt });
}

/**
 * 行の差分データ生成
 *
 * @param baseValues 元データ
 * @param overrideValues 上書きデータ
 */
export function makeDiffRowValues(
    baseValues: unknown[] | undefined,
    overrideValues: unknown[] | undefined,
) {
    if (!overrideValues) {
        const cellCount = baseValues?.length ?? 0;
        return [...Array(cellCount)].map(_ => '');
    }

    if (!baseValues) {
        return overrideValues;
    }

    const maxValueCount = Math.max(baseValues.length, overrideValues.length);
    const newValues: unknown[] = [...Array(maxValueCount)].map(_ => '');
    overrideValues.forEach((value, i) => {
        const baseValue = baseValues[i] ?? '';
        // TODO: Float の桁数の考慮(例: 0 と 0.0)
        newValues[i] = value !== baseValue ? value : null;
    });
    return newValues.every(value => value === null) ? [] : newValues;
}
