/// Int ベースのEnum サンプル
enum EnumIntSample: Int {

    static func parse(value: Int) -> EnumIntSample {
        return EnumIntSample.init(rawValue: value)!
    }


    private static let cacheArray = [
        A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z,
    ]

    static func parseByCacheArray(value: Int) -> EnumIntSample {
        return cacheArray.first { item in item.rawValue == value }!
    }


    private static let cacheDictionary = [
        97: A,
        98: B,
        99: C,
        100: D,
        101: E,
        102: F,
        103: G,
        104: H,
        105: I,
        106: J,
        107: K,
        108: L,
        109: M,
        110: N,
        111: O,
        112: P,
        113: Q,
        114: R,
        115: S,
        116: T,
        117: U,
        118: V,
        119: W,
        120: X,
        121: Y,
        122: Z,
    ]

    static func parseByCacheDictionary(value: Int) -> EnumIntSample {
        return cacheDictionary[value]!
    }


    static func parseBySwitch(value: Int) -> EnumIntSample {
        switch value {
        case 97: return A
        case 98: return B
        case 99: return C
        case 100: return D
        case 101: return E
        case 102: return F
        case 103: return G
        case 104: return H
        case 105: return I
        case 106: return J
        case 107: return K
        case 108: return L
        case 109: return M
        case 110: return N
        case 111: return O
        case 112: return P
        case 113: return Q
        case 114: return R
        case 115: return S
        case 116: return T
        case 117: return U
        case 118: return V
        case 119: return W
        case 120: return X
        case 121: return Y
        case 122: return Z
        default: return A
        }
    }


    case A = 97
    case B = 98
    case C = 99
    case D = 100
    case E = 101
    case F = 102
    case G = 103
    case H = 104
    case I = 105
    case J = 106
    case K = 107
    case L = 108
    case M = 109
    case N = 110
    case O = 111
    case P = 112
    case Q = 113
    case R = 114
    case S = 115
    case T = 116
    case U = 117
    case V = 118
    case W = 119
    case X = 120
    case Y = 121
    case Z = 122
}
