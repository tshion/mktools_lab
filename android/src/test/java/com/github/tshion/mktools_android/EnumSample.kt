package com.github.tshion.mktools_android

enum class EnumSample(val value: Int) {

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

//        @JvmStatic
//        fun parseCandidate(value: Int): EnumSample {
//            return
//        }

        @JvmStatic
        fun parseCandidate1(value: Int): EnumSample {
            return values().single { it.value == value }
        }

        @JvmStatic
        fun parseCandidate2(value: Int): EnumSample {
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
                else -> throw IllegalArgumentException()
            }
        }


        private val tmp1 = arrayOf(
            A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z
        )

        @JvmStatic
        fun parseCandidate3(value: Int): EnumSample {
            return tmp1.single { it.value == value }
        }

        private val tmp2 = mapOf(
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
        fun parseCandidate4(value: Int): EnumSample {
            return tmp2[value]!!
        }
    }
}
