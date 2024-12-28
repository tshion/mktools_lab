const { google } = require('googleapis');
const path = require('node:path');
const { argv } = require('node:process');

/**
 * HTTP Status Code データをGoogle Spreadsheet から取得し、別シートに転記する
 *
 * @example
 * generators 配下に `credentials.json` というファイルを作成し、
 * [サービスアカウント認証情報](https://cloud.google.com/iam/docs/service-account-creds) の内容を保存した上で下記コマンドを実行してください。
 *
 * ``` shell
 * node generators/transfer-status-code.js 'sheetId'
 * ```
 */
+async function (
    /** @type{string} sheetId データがあるSpreadsheet のID */
    sheetId,
) {
    if (!sheetId) {
        throw Error();
    }

    const sheetApiClient = await getSheetsApi();

    // 「シート1」の取得
    const sheet1 = await sheetApiClient.spreadsheets.values.get({
        spreadsheetId: sheetId,
        range: 'シート1!A2:H',
    });
    const sheet1Data = sheet1.data.values;
    if (sheet1Data === undefined || sheet1Data === null) {
        throw Error('転送元にデータがありません');
    }

    // 更新データの候補生成
    const updateData = sheet1Data.map(item => {
        const values = Object.values(item);
        return 0 < Object.keys(item).length
            ? values
            : null;
    }).filter(list => list !== null);


    // 「シート2」の取得
    const sheet2 = await sheetApiClient.spreadsheets.values.get({
        spreadsheetId: sheetId,
        range: 'シート2!A2:H',
    });
    const sheet2Data = sheet2.data.values;

    // (差分を考慮した) 更新データの生成
    const maxRowCount = Math.max(
        updateData.length,
        sheet2Data?.length ?? 0,
    );

    const mergedData = [];
    for (let rowIndex = 0; rowIndex < maxRowCount; rowIndex++) {
        const rowDataFrom = updateData.at(rowIndex);
        const rowDataTo = sheet2Data?.at(rowIndex);
        if (!rowDataFrom) {
            const cellCount = Object.keys(rowDataTo ?? {}).length;
            mergedData.push([...Array(cellCount)].map(_ => ''));
        } else if (!rowDataTo) {
            mergedData.push(rowDataFrom);
        } else {
            const maxColumnCount = Math.max(rowDataFrom.length, rowDataTo.length);
            const rowData = [...Array(maxColumnCount)].map(_ => '');
            rowDataFrom.forEach((from, i) => {
                rowData[i] = from !== rowDataTo[i] ? from : null;
            });
            mergedData.push(rowData);
        }
    }


    // 「シート2」へ書き込み
    const result = await sheetApiClient.spreadsheets.values.update({
        spreadsheetId: sheetId,
        range: 'シート2!A2:H',
        valueInputOption: 'USER_ENTERED',
        requestBody: {
            values: mergedData,
        },
    });
    console.log('%d cells updated.', result.data.updatedCells ?? 0);
}(
    argv[2],
);



/**
 * Google Sheets API の操作クライアントの取得
 */
async function getSheetsApi() {
    // 参考: https://github.com/googleapis/google-api-nodejs-client/issues/1699#issuecomment-1770598231
    const jwt = new google.auth.JWT({
        keyFile: path.join(__dirname, 'credentials.json'),
        scopes: [
            'https://www.googleapis.com/auth/spreadsheets',
        ]
    });
    await jwt.authorize();

    return google.sheets({ version: 'v4', auth: jwt });
}
