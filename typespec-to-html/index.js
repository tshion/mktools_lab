const fs = require('fs');
const path = require('path');

+function (
    /**
     * JSON 形式で出力されたTypeSpec の配置パス
     * @type{string}
     */
    specPath,
) {
    /** プロジェクトルートのパス*/
    const pathRoot = path.join(__dirname, '..');

    // 型定義の加工
    const file = fs.readFileSync(path.join(pathRoot, specPath)).toString();
    const schema = JSON.parse(file);

    const doms = [];
    for (const [key, value] of Object.entries(schema['properties'])) {
        const type = value['type'];
        const description = value['description'];
        switch (type) {
            case 'integer':
                const min = value['minimum'];
                const max = value['maximum'];
                doms.push(`<label for="${key}">${description}</label>`);
                doms.push(`<input type="number" id="${key}" min="${min}" max="${max}" />`);
                break;
            case 'string':
                doms.push(`<label for="${key}">${description}</label>`);
                doms.push(`<input type="text" id="${key}" />`);
                break;
            default:
                continue;
        }
    }
    const template = fs.readFileSync(path.join(__dirname, 'index.template.html')).toString();
    const html = template.replace('%%PLACEHOLDER%%', doms.join('\n'));

    // 出力
    const pathDist = path.join(__dirname, 'dist');
    fs.mkdirSync(pathDist, { recursive: true });
    fs.writeFileSync(path.join(pathDist, 'index.html'), html, { encoding: 'utf-8' });
}(
    'typespec/dist/@typespec/json-schema/HttpStatusCode.json',
);
