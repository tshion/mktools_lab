import { sheets_v4 } from 'googleapis';
import { CodePropertyTemplateDto } from './code-template.dto';
import { CodeUtil } from './code.util';
import { HttpHeaderGSheetDto, HttpHeaderGSheetKey } from './http-header-gsheet.dto';
import { HttpHeaderGSheet } from './http-header-gsheet.type';
import { WebLinkDto } from './web-link.dto';

/**
 * スプレッドシート「HttpHeader」の操作ロジック
 */
export class HttpHeaderGSheetModel {

    /**
     * データ取得
     *
     * @param gSheetId 操作対象のGoogle Spreadsheets ID
     * @param gSheetsApiClient Google Sheets API の操作クライアント
     * @param sheetName スプレッドシート「HttpHeader」のシート名
     */
    public static async load(
        gSheetId: string,
        gSheetsApiClient: sheets_v4.Sheets,
        sheetName: HttpHeaderGSheet,
    ) {
        const data = await gSheetsApiClient.spreadsheets.values.get({
            spreadsheetId: gSheetId,
            range: sheetName,
        }).then(sheet => sheet.data.values);
        if (!data) {
            throw Error(`ID: ${gSheetId} のシート「${sheetName}」を取得できません`);
        }


        const header = data.shift();
        if (!header) { return []; }

        const indexName = header.findIndex(x => x === HttpHeaderGSheetKey.NAME);
        if (indexName < 0) { return []; }

        const indexCaution = header.findIndex(x => x === HttpHeaderGSheetKey.CAUTION);
        if (indexCaution < 0) { return []; }

        const indexHasMDN = header.findIndex(x => x === HttpHeaderGSheetKey.HAS_MDN);
        if (indexHasMDN < 0) { return []; }

        const indexUrl1 = header.findIndex(x => x === HttpHeaderGSheetKey.URL1);
        if (indexUrl1 < 0) { return []; }

        const indexUrl2 = header.findIndex(x => x === HttpHeaderGSheetKey.URL2);
        if (indexUrl2 < 0) { return []; }

        const indexUrl3 = header.findIndex(x => x === HttpHeaderGSheetKey.URL3);
        if (indexUrl3 < 0) { return []; }


        return data.filter(item => 0 < Object.keys(item).length).map(item => {
            const dto: HttpHeaderGSheetDto = {
                Name: `${item[indexName] ?? ''}`.trim(),
                Caution: `${item[indexCaution] ?? ''}`.trim(),
                HasMDN: `${item[indexHasMDN] ?? ''}`.trim(),
                Url1: `${item[indexUrl1] ?? ''}`.trim(),
                Url2: `${item[indexUrl2] ?? ''}`.trim(),
                Url3: `${item[indexUrl3] ?? ''}`.trim(),
            };
            return dto;
        }).filter(dto => !!dto.HasMDN);
    }

    /**
     * Template 向けにデータ加工
     *
     * @param gSheetData スプレードシートデータ
     */
    public static mapToTemplate(gSheetData: HttpHeaderGSheetDto[]) {
        const regex = /(?<rfc>rfc\d{4,})/;
        return gSheetData.map(item => {
            let links = new Array<WebLinkDto>();
            if (item.HasMDN.toLowerCase() === 'true') {
                links.push({
                    title: 'MDN Web Docs',
                    url: `https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/${item.Name}`,
                });
            }
            [
                item.Url1,
                item.Url2,
                item.Url3,
            ].forEach(url => {
                const found = url.match(regex)?.groups;
                if (found) {
                    links.push({
                        title: found.rfc.toUpperCase(),
                        url: url,
                    });
                } else if (!!url && url != '?') {
                    links.push({ title: url, url: url });
                }
            });
            links = links.sort((a, b) => {
                const x = a.title.toUpperCase();
                const y = b.title.toUpperCase();
                if (x < y) { return -1; }
                if (x > y) { return 1; }
                return 0;
            });

            const variableTokens = item.Name
                .replaceAll('ETag', 'E Tag')
                .split(' ')
                .flatMap(x => x.split('-'));

            const dto: CodePropertyTemplateDto = {
                decorators: {
                    deprecated: item.Caution,
                },
                documentComment: {
                    descriptions: [item.Name],
                    links: links,
                },
                name: {
                    camel: CodeUtil.formatCamelCase(variableTokens),
                    pascal: CodeUtil.formatPascalCase(variableTokens),
                    snake: CodeUtil.formatSnakeCase(variableTokens),
                },
                value: item.Name,
            };
            return dto;
        });
    }
}
