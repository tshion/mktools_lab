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
        throw Error();
    }

    // 「シート2」の取得
    const sheet2 = await sheetApiClient.spreadsheets.values.get({
        spreadsheetId: sheetId,
        range: 'シート2!A2:H',
    });
    const sheet2Data = sheet2.data.values;
    if (sheet2Data === undefined || sheet2Data === null) {
        throw Error();
    }


    // 移行データの生成
    const mergeData = sheet1Data.map(item => {
        const values = Object.values(item);
        return 0 < Object.keys(item).length
            ? values
            : null;
    }).filter(list => list !== null);

    const cellCount = Math.max(...mergeData.map(x => x.length));
    const diffCount = sheet2Data.length - mergeData.length;
    for (let i = 0; i < diffCount; i++) {
        mergeData.push([...Array(cellCount)].map(_ => ''));
    }


    // 「シート2」へ書き込み
    const result = await sheetApiClient.spreadsheets.values.update({
        spreadsheetId: sheetId,
        range: 'シート2!A2:H',
        valueInputOption: 'USER_ENTERED',
        requestBody: {
            values: mergeData,
        },
    });
    console.log('%d cells updated.', result.data.updatedCells);
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
