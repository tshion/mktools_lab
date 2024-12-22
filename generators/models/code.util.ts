/**
 * コード生成に関するユーティリティ
 */
export class CodeUtil {

    /**
     * キャメルケースに変換
     */
    public static formatCamelCase(words: string[]) {
        const list = words.filter(word => word !== '');
        if (list.length < 1) {
            return '';
        }

        return [
            list[0].toLowerCase(),
            this.formatPascalCase(list.slice(1)),
        ].join('');
    }

    /**
     * パスカルケースに変換
     */
    public static formatPascalCase(words: string[]) {
        return words.filter(word => word !== '').map(word => {
            const chars = word.toLowerCase().split('');
            chars[0] = chars[0].toUpperCase();
            return chars.join('');
        }).join('');
    }

    /**
     * スネークケースに変換
     */
    public static formatSnakeCase(words: string[]) {
        return words.map(word => word.toUpperCase()).join('_');
    }
}
