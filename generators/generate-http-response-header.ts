import { createGSheetsApiClient } from 'models/google-api.util';
import { HttpHeaderGSheetModel } from 'models/http-header-gsheet.model';
import { existsSync } from 'node:fs';
import { mkdir, writeFile } from 'node:fs/promises';
import { join } from 'node:path';
import { argv } from 'node:process';
import { render } from 'nunjucks';

/**
 * HTTP Response Header 関連のコード生成
 *
 * @example
 * ``` shell
 * node generate-http-response-header/index.js {{ gSheetId }} {{ pathJwtFile }} {{ pathOutputDir }}
 * ```
 */
+async function (
    /** 操作対象のGoogle Spreadsheets ID */
    gSheetId: string,

    /** Google サービスアカウント認証情報(JSON 形式) のファイルパス */
    pathJwtFile: string,

    /** 結果の出力先 */
    pathOutputDir: string,
) {
    if (!gSheetId) {
        throw Error('gSheetId が指定されていません。');
    }
    if (!pathOutputDir) {
        throw Error('pathOutputDir が指定されていません。');
    }

    // データの取得
    const gSheetsApiClient = await createGSheetsApiClient(pathJwtFile);
    const gSheetData = await HttpHeaderGSheetModel.load(gSheetId, gSheetsApiClient, 'Response');

    // データの加工
    const mappedData = HttpHeaderGSheetModel.mapToTemplate(gSheetData);

    // 書き出し
    if (!existsSync(pathOutputDir)) {
        await mkdir(pathOutputDir, { recursive: true });
    }
    const tasks = [
        'HttpResponseHeader.cs',
        'HttpResponseHeader.kt',
        'HttpResponseHeader.swift',
        'http-response-header.ts',
    ].map(async fileName => writeFile(
        join(pathOutputDir, fileName),
        render(
            join(__dirname, '..', '..', 'assets', `${fileName}.txt`),
            { list: mappedData },
        ),
        { encoding: 'utf-8' },
    ));
    await Promise.all(tasks);
}(
    argv[2],
    argv[3],
    argv[4],
);
