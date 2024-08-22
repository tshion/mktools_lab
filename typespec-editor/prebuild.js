const fs = require('fs');
const path = require('path');

/**
 * TypeSpec のJSON Schema から入力データの変換
 */
+function (
    /** 入力元のディレクトリーパス @type{string} */
    inputDirPath,
) {
    /** プロジェクトルートのパス*/
    const rootPath = path.join(__dirname, '..');


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
    })(path.join(rootPath, inputDirPath, '@typespec', 'json-schema'));


    // 配列型のデフォルト値の読み込み
    const arrayDefaults = (filePath => {
        const file = fs.readFileSync(filePath).toString();
        return file ? JSON.parse(file) : {};
    })(path.join(rootPath, inputDirPath, 'defaults.json'));


    // 型定義の加工
    const dic = inputData.flatMap(x => Object.entries(x.schema));
    const list = [];
    const fxType = (prop) => {
        return prop['type']
            ?? prop['$ref']
            ?? prop['anyOf']?.[0]?.['type']
            ?? prop['anyOf']?.[0]?.['$ref'];
    };
    for (const [k, v] of dic) {
        const isArray = v['type'] === 'array';
        const type = isArray ? fxType(v['items']) : fxType(v);
        // console.log(`${type} ${isArray}`);

        const obj = {
            // group: ,
            isArray: isArray,
            key: k,
            label: v['description'],
            value: isArray ? arrayDefaults[k] : [v['default']],
        };
        // console.log(`${type} ${isArray}: ${obj.value}`);

        switch (type) {
            case 'argb.json':
                break;
            case 'boolean':
                obj['inputType'] = 'checkbox';
                break;
            case 'integer':
                break;
            case 'number':
                break;
            case 'rgb.json':
                break;
            case 'string':
                obj['inputType'] = 'textbox';
                // TODO: pattern
                break;
            default:
                // $ref
                // anyOf
                break;
        }

        // TODO: 選択肢

        if (obj.inputType) {
            list.push(obj);
        }
    }


    // 出力
    const templatePath = path.join(rootPath, 'typespec-editor', 'input-schema.template.ts');
    const template = fs.readFileSync(templatePath).toString()
        .replace('[/** Data */]', JSON.stringify(list, null, 4));
    fs.writeFileSync(
        path.join(rootPath, 'typespec-editor', 'src', path.basename(templatePath).replace('.template', '')),
        template,
        { encoding: 'utf-8' },
    );
}(
    'typespec/dist',
);
