const { google } = require('googleapis');
const { writeFile } = require('node:fs/promises');
const path = require('node:path');
const { argv } = require('node:process');



/**
 * HTTP Status Code データをGoogle Spreadsheet から取得し、CSV 出力する
 *
 * @example
 * generators 配下に `credentials.json` というファイルを作成し、
 * [サービスアカウント認証情報](https://cloud.google.com/iam/docs/service-account-creds) の内容を保存した上で下記コマンドを実行してください。
 *
 * ``` shell
 * node generators/create-status-code-csv.js 'sheetId'
 * ```
 *
 * @param {string} sheetId データがあるSpreadsheet のID
 */
+async function (
    sheetId,
) {
    if (!sheetId) {
        throw Error();
    }

    const sheetApiClient = await getSheetsApi();
    const targetSheet = await sheetApiClient.spreadsheets.values.get({
        spreadsheetId: sheetId,
        range: 'シート1',
    });

    const csv = toCSV(targetSheet.data.values);
    if (!csv) {
        throw Error();
    }

    await writeFile(
        path.join(__dirname, 'HttpStatusCodeGenerator', 'Data', 'HttpStatusCode2.csv'),
        csv,
        { encoding: 'utf-8' },
    );
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
            'https://www.googleapis.com/auth/spreadsheets.readonly',
        ]
    });
    await jwt.authorize();

    return google.sheets({ version: 'v4', auth: jwt });
}

/**
 * Sheet データをCSV 形式に変換
 *
 * @param {any[][]|null|undefined} values
 */
function toCSV(values) {
    if (!values) { return; }

    const list = values;
    const header = list.shift();
    if (!header) { return; }

    const indexCode = header.findIndex(x => x === 'Code');
    if (indexCode < 0) { return; }

    const indexName = header.findIndex(x => x === 'Name');
    if (indexName < 0) { return; }

    const indexOldName = header.findIndex(x => x === 'OldName');
    if (indexOldName < 0) { return; }

    const indexNote = header.findIndex(x => x === 'Note');
    if (indexNote < 0) { return; }

    const indexCaution = header.findIndex(x => x === 'Caution');
    if (indexCaution < 0) { return; }

    const indexHasMDN = header.findIndex(x => x === 'HasMDN');
    if (indexHasMDN < 0) { return; }

    const indexUrl1 = header.findIndex(x => x === 'Url1');
    if (indexUrl1 < 0) { return; }

    const indexUrl2 = header.findIndex(x => x === 'Url2');
    if (indexUrl2 < 0) { return; }


    const lines = [
        [
            header[indexCode],
            header[indexName],
            header[indexOldName],
            header[indexNote],
            header[indexCaution],
            header[indexHasMDN],
            header[indexUrl1],
            header[indexUrl2],
        ].join(','),
    ];
    list.map(item => [
        item[indexCode],
        item[indexName],
        item[indexOldName],
        item[indexNote],
        item[indexCaution],
        item[indexHasMDN],
        item[indexUrl1],
        item[indexUrl2],
    ]).forEach(array => {
        const separator = ',';
        const line = array.join(separator);

        const regex = new RegExp(`^${separator}+$`);
        if (!regex.test(line)) {
            lines.push(line);
        }
    });
    return lines.join('\n');
}
