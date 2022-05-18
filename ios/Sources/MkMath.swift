/// 数学関連処理
public class MkMath {

    /// 剰余計算
    public static func mod(_ x: Int, _ n: Int) -> Int {
        var candidate = x % n
        if candidate < 0 {
            candidate = candidate + n
        }
        return candidate
    }
}
