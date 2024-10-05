const { google } = require('googleapis');
const { writeFile } = require('node:fs/promises');
const path = require('node:path');
const { argv } = require('node:process');
const nunjucks = require('nunjucks');



/**
 * HTTP Status Code データをGoogle Spreadsheet から取得し、TypeScript 実装を出力する
 *
 * @example
 * generators 配下に `credentials.json` というファイルを作成し、
 * [サービスアカウント認証情報](https://cloud.google.com/iam/docs/service-account-creds) の内容を保存した上で下記コマンドを実行してください。
 *
 * ``` shell
 * node generators/create-status-code-ts.js 'sheetId'
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

    const data = parseSheet(targetSheet.data.values);
    if (!data) {
        throw Error();
    }

    const replaced = nunjucks.render(
        path.join(__dirname, 'HttpStatusCodeGenerator', 'Templates', 'http-status-code.ts.template'),
        { list: data },
    );
    await writeFile(
        path.join(__dirname, 'http-status-code.ts'),
        replaced,
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
 * Sheet データの解析
 *
 * @param {any[][]|null|undefined} values
 */
function parseSheet(values) {
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


    const regex = /(?<rfc>rfc\d{4,})/;
    return list
        .filter(item => 0 < parseInt(item[indexCode]))
        .map(item => {
            const code = item[indexCode];

            const links = [];
            if (item[indexHasMDN]) {
                links.push({
                    title: 'MDN Web Docs',
                    url: `https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/${code}`,
                });
            }
            [
                item[indexUrl1],
                item[indexUrl2],
            ].map(url => `${url}`).forEach(url => {
                const found = url.match(regex)?.groups;
                if (found) {
                    links.push({
                        title: found.rfc.toUpperCase(),
                        url,
                    })
                }
            });

            const name = `${item[indexName]}`;
            return {
                code,
                key: name.replaceAll(`I'm`, 'I am').split(' ').flatMap(x => x.split('-')).join(''),
                links,
                name,
            };
        });
}
