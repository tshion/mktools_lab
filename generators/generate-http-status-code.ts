import { CodeUtil } from 'models/code.util';
import { createGSheetsApiClient } from 'models/google-api.util';
import { HttpStatusCodeGSheetModel } from 'models/http-status-code-gsheet.model';
import { HttpStatusCodeTemplateDto } from 'models/http-status-code-template.dto';
import { WebLinkDto } from 'models/web-link.dto';
import { existsSync } from 'node:fs';
import { mkdir, writeFile } from 'node:fs/promises';
import { join } from 'node:path';
import { argv } from 'node:process';
import { render } from 'nunjucks';

/**
 * HTTP Status Code 関連のコード生成
 *
 * @example
 * ``` shell
 * node generate-http-status-code/index.js {{ gSheetId }} {{ pathJwtFile }} {{ pathOutputDir }}
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
    const gSheetData = await HttpStatusCodeGSheetModel.load(gSheetId, gSheetsApiClient);

    // データの加工
    const regex = /(?<rfc>rfc\d{4,})/;
    const mappedData = gSheetData.map(item => {
        let descriptions = [`${item.Code} ${item.Name}`];
        if (!!item.Note) {
            descriptions[0] = `${descriptions[0]}(${item.Note})`;
        }
        if (!!item.OldName) {
            descriptions.push(`(HTTP 1.0: ${item.OldName})`);
        }

        const links = new Array<WebLinkDto>();
        if (item.HasMDN) {
            links.push({
                title: 'MDN Web Docs',
                url: `https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/${item.Code}`,
            });
        }
        [
            item.Url1,
            item.Url2,
        ].forEach(url => {
            const found = url.match(regex)?.groups;
            if (found) {
                links.push({
                    title: found.rfc.toUpperCase(),
                    url: url,
                });
            }
        });

        const variableTokens = item.Name
            .replaceAll(`I'm`, 'I am')
            .split(' ')
            .flatMap(x => x.split('-'));

        const dto: HttpStatusCodeTemplateDto = {
            code: item.Code,
            descriptions: descriptions,
            links: links,
            variable: {
                camel: CodeUtil.formatCamelCase(variableTokens),
                pascal: CodeUtil.formatPascalCase(variableTokens),
                snake: CodeUtil.formatSnakeCase(variableTokens),
            },
            warning: item.Caution,
        };
        return dto;
    });

    // 書き出し
    if (!existsSync(pathOutputDir)) {
        await mkdir(pathOutputDir, { recursive: true });
    }
    const tasks = [
        'HttpStatusCode.cs',
        'HttpStatusCode.kt',
        'HttpStatusCode.swift',
        'http-status-code.ts',
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
