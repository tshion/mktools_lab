const fs = require('fs');
const path = require('path');

/**
 * ビルドの後処理
 *
 * ※配列型のデフォルト値の抽出
 */
+function () {
    /** プロジェクトルートのパス*/
    const rootPath = path.join(__dirname);


    // 対象データの抽出
    const keyList = (dirPath => {
        const pathList = fs.readdirSync(dirPath)
            .filter(filename => filename.endsWith('.json'))
            .map(filename => path.join(dirPath, filename));

        const result = [];
        pathList.forEach(filePath => {
            const file = fs.readFileSync(filePath).toString();
            if (file.includes('"properties": {')) {
                const obj = JSON.parse(file);
                const keys = Object.entries(obj['properties'])
                    .filter(([_, v]) => v['type'] === 'array')
                    .map(([k, _]) => k);
                result.push(...keys);
            }
        });
        return result;
    })(path.join(rootPath, 'dist', '@typespec', 'json-schema'));


    // 配列型のデフォルト値の抽出
    const data = ((dirPath, keys) => {
        const pathList = fs.readdirSync(dirPath)
            .filter(filename => filename.endsWith('.tsp'))
            .map(filename => path.join(dirPath, filename));

        const result = {};
        pathList.forEach(filePath => {
            const file = fs.readFileSync(filePath).toString();
            const targetLines = file
                .replaceAll('\n', '')
                .replaceAll(' ', '')
                .split(';')
                .filter(line => line.includes('#['));

            targetLines.forEach(line => {
                const targetKeys = keys.filter(k => !Object.keys(result).includes(k));
                for (const k of targetKeys) {
                    const regex = new RegExp(`${k}.+#(\\[.*\\])`);
                    const match = regex.exec(line);
                    if (match) {
                        result[k] = JSON.parse(match[1]);
                        break;
                    }
                }
            });
        });
        return result;
    })(
        path.join(rootPath, 'specs'),
        keyList,
    );


    // 出力
    fs.writeFileSync(
        path.join(rootPath, 'dist', 'defaults.json'),
        JSON.stringify(data),
        { encoding: 'utf-8' },
    )
}();
