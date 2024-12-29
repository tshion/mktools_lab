import { createGSheetsApiClient, makeDiffRowValues } from 'models/google-api.util';
import { HttpStatusCodeGSheetModel } from 'models/http-status-code-gsheet.model';
import { argv } from 'node:process';

/**
 * HTTP Status Code 情報を別シートに転記する
 *
 * @example
 * ``` shell
 * node transfer-status-code/index.js {{ gSheetId }} {{ pathJwtFile }}
 * ```
 */
+async function (
    /** 操作対象のGoogle Spreadsheets ID */
    gSheetId: string,

    /** Google サービスアカウント認証情報(JSON 形式) のファイルパス */
    pathJwtFile: string,
) {
    if (!gSheetId) {
        throw Error('gSheetId が指定されていません。');
    }

    // データの取得
    const gSheetsApiClient = await createGSheetsApiClient(pathJwtFile, true);
    const gSheetData = await HttpStatusCodeGSheetModel.load(gSheetId, gSheetsApiClient);

    // 更新データの候補生成
    const updateData = gSheetData.filter(dto => !!dto.Code);


    // 「シート2」の取得
    const sheet2 = await gSheetsApiClient.spreadsheets.values.get({
        spreadsheetId: gSheetId,
        range: 'シート2!A2:H',
    });
    const sheet2Data = sheet2.data.values;

    // (差分を考慮した) 更新データの生成
    const maxRowCount = Math.max(
        updateData.length,
        sheet2Data?.length ?? 0,
    );

    const mergedData = [];
    for (let i = 0; i < maxRowCount; i++) {
        const diff = makeDiffRowValues(
            sheet2Data?.at(i),
            Object.values(updateData.at(i) ?? {}),
        );
        mergedData.push(diff);
    }


    // 「シート2」へ書き込み
    const result = await gSheetsApiClient.spreadsheets.values.update({
        spreadsheetId: gSheetId,
        range: 'シート2!A2:H',
        valueInputOption: 'USER_ENTERED',
        requestBody: {
            values: mergedData,
        },
    });
    console.log('%d cells updated.', result.data.updatedCells ?? 0);
}(
    argv[2],
    argv[3],
);
