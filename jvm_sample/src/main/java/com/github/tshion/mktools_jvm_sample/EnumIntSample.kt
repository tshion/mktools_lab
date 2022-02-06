package com.github.tshion.mktools_jvm_sample

/**
 * Int 型のプロパティを持ったEnum サンプル
 */
enum class EnumIntSample(val value: Int) {

    A(97),
    B(98),
    C(99),
    D(100),
    E(101),
    F(102),
    G(103),
    H(104),
    I(105),
    J(106),
    K(107),
    L(108),
    M(109),
    N(110),
    O(111),
    P(112),
    Q(113),
    R(114),
    S(115),
    T(116),
    U(117),
    V(118),
    W(119),
    X(120),
    Y(121),
    Z(122),
    ;


    companion object {

        private val cacheArray = arrayOf(
            A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z
        )

        @JvmStatic
        fun parseByCacheArray(value: Int): EnumIntSample {
            return cacheArray.single { it.value == value }
        }


        private val cacheMap = mapOf(
            97 to A,
            98 to B,
            99 to C,
            100 to D,
            101 to E,
            102 to F,
            103 to G,
            104 to H,
            105 to I,
            106 to J,
            107 to K,
            108 to L,
            109 to M,
            110 to N,
            111 to O,
            112 to P,
            113 to Q,
            114 to R,
            115 to S,
            116 to T,
            117 to U,
            118 to V,
            119 to W,
            120 to X,
            121 to Y,
            122 to Z,
        )

        @JvmStatic
        fun parseByCacheMap(value: Int): EnumIntSample {
            return cacheMap[value]!!
        }


//        private val cacheSparseArray = SparseArray<EnumIntSample>().apply {
//            append(97, A)
//            append(98, B)
//            append(99, C)
//            append(100, D)
//            append(101, E)
//            append(102, F)
//            append(103, G)
//            append(104, H)
//            append(105, I)
//            append(106, J)
//            append(107, K)
//            append(108, L)
//            append(109, M)
//            append(110, N)
//            append(111, O)
//            append(112, P)
//            append(113, Q)
//            append(114, R)
//            append(115, S)
//            append(116, T)
//            append(117, U)
//            append(118, V)
//            append(119, W)
//            append(120, X)
//            append(121, Y)
//            append(122, Z)
//        }
//
//        @JvmStatic
//        fun parseByCacheSparseArray(value: Int): EnumIntSample {
//            return cacheSparseArray[value]!!
//        }


        private val cacheValues = values()

        @JvmStatic
        fun parseByCacheValues(value: Int): EnumIntSample {
            return cacheValues.single { it.value == value }
        }


        private val cacheValuesToMap = values().associateBy { it.value }

        @JvmStatic
        fun parseByCacheValuesToMap(value: Int): EnumIntSample {
            return cacheValuesToMap[value]!!
        }


        @JvmStatic
        fun parseByValuesAndSingle(value: Int): EnumIntSample {
            return values().single { it.value == value }
        }


        @JvmStatic
        fun parseByWhen(value: Int): EnumIntSample {
            return when (value) {
                97 -> A
                98 -> B
                99 -> C
                100 -> D
                101 -> E
                102 -> F
                103 -> G
                104 -> H
                105 -> I
                106 -> J
                107 -> K
                108 -> L
                109 -> M
                110 -> N
                111 -> O
                112 -> P
                113 -> Q
                114 -> R
                115 -> S
                116 -> T
                117 -> U
                118 -> V
                119 -> W
                120 -> X
                121 -> Y
                122 -> Z
                else -> throw NoSuchElementException()
            }
        }
    }
}
