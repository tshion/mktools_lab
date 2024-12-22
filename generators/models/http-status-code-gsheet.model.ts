import { sheets_v4 } from 'googleapis';
import { HttpStatusCodeGSheetDto, HttpStatusCodeGSheetKey } from './http-status-code-gsheet.dto';

/**
 * スプレッドシート「HttpStatusCode」の操作ロジック
 */
export class HttpStatusCodeGSheetModel {

    /**
     * データ取得
     *
     * @param gSheetId 操作対象のGoogle Spreadsheets ID
     * @param gSheetsApiClient Google Sheets API の操作クライアント
     */
    public static async load(
        gSheetId: string,
        gSheetsApiClient: sheets_v4.Sheets,
    ) {
        const sheetName = 'シート1';

        const data = await gSheetsApiClient.spreadsheets.values.get({
            spreadsheetId: gSheetId,
            range: sheetName,
        }).then(sheet => sheet.data.values);
        if (!data) {
            throw Error(`ID: ${gSheetId} のシート「${sheetName}」を取得できません`);
        }


        const header = data.shift();
        if (!header) { return []; }

        const indexCode = header.findIndex(x => x === HttpStatusCodeGSheetKey.CODE);
        if (indexCode < 0) { return []; }

        const indexName = header.findIndex(x => x === HttpStatusCodeGSheetKey.NAME);
        if (indexName < 0) { return []; }

        const indexOldName = header.findIndex(x => x === HttpStatusCodeGSheetKey.OLD_NAME);
        if (indexOldName < 0) { return []; }

        const indexNote = header.findIndex(x => x === HttpStatusCodeGSheetKey.NOTE);
        if (indexNote < 0) { return []; }

        const indexCaution = header.findIndex(x => x === HttpStatusCodeGSheetKey.CAUTION);
        if (indexCaution < 0) { return []; }

        const indexHasMDN = header.findIndex(x => x === HttpStatusCodeGSheetKey.HAS_MDN);
        if (indexHasMDN < 0) { return []; }

        const indexUrl1 = header.findIndex(x => x === HttpStatusCodeGSheetKey.URL1);
        if (indexUrl1 < 0) { return []; }

        const indexUrl2 = header.findIndex(x => x === HttpStatusCodeGSheetKey.URL2);
        if (indexUrl2 < 0) { return []; }


        return data.filter(item => 0 < Object.keys(item).length).map(item => {
            const dto: HttpStatusCodeGSheetDto = {
                Code: item[indexCode] ?? '',
                Name: item[indexName] ?? '',
                OldName: item[indexOldName] ?? '',
                Note: item[indexNote] ?? '',
                Caution: item[indexCaution] ?? '',
                HasMDN: item[indexHasMDN] ?? '',
                Url1: item[indexUrl1] ?? '',
                Url2: item[indexUrl2] ?? '',
            };
            return dto;
        });
    }
}
