'use strict';

const fs = require('fs');
const path = require('path');

/**
 * TypeSpec のJSON Schema から入力データの変換
 */
+function (
    /** 入力元のディレクトリーパス @type{string} */
    inputDirPath,

    /** 出力先のディレクトリーパス @type{string} */
    outputDirPath,
) {
    /** プロジェクトルートのパス*/
    const rootPath = path.join(__dirname, '..', '..');


    // 対象データの読み込み
    const inputData = (dirPath => {
        const pathList = fs.readdirSync(dirPath)
            .filter(filename => filename.endsWith('.json'))
            .map(filename => path.join(dirPath, filename));

        const result = [];
        pathList.forEach(filePath => {
            const file = fs.readFileSync(filePath).toString();
            if (file.includes('"properties": {')) {
                const obj = JSON.parse(file);
                result.push({
                    name: path.basename(filePath).replace('.json', ''),
                    schema: obj['properties'],
                });
            }
        });
        return result;
    })(path.join(rootPath, inputDirPath));


    // 型定義の加工
    const dic = inputData.flatMap(x => Object.entries(x.schema));
    const list = [];
    for (const [key, v] of dic) {
        const description = v['description'];
        const valueDefault = v['default'];

        switch (v['type']) {
            case 'boolean':
                list.push({
                    inputType: 'checkbox',
                    isArray: false,
                    key: key,
                    label: description,
                    value: [valueDefault],
                });
                continue;
        }

        switch (v['$ref']) {
        }
    }



    // 出力
    const templatePath = path.join(rootPath, 'typespec-editor', 'build-scripts', 'input-schema.template.ts');
    const template = fs.readFileSync(templatePath).toString()
        .replace('[/** Data */]', JSON.stringify(list));
    fs.writeFileSync(
        path.join(rootPath, outputDirPath, path.basename(templatePath).replace('.template', '')),
        template,
        { encoding: 'utf-8' },
    );
}(
    'typespec/dist/@typespec/json-schema',
    'typespec-editor/src',
);
