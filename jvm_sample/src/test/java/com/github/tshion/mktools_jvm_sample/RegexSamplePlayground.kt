package com.github.tshion.mktools_jvm_sample

import org.junit.jupiter.api.Test
import kotlin.system.measureNanoTime

/**
 * 正規表現の実装サンプル
 */
class RegexSamplePlayground {

    private object Sample {
        private val regex = "[a-z]{2,3}".toRegex()


        fun isValid1(value: String): Boolean {
            val regex = "[a-z]{2,3}".toRegex()
            return Sample.regex.matches(value)
        }

        fun isValid2(value: String): Boolean {
            return regex.matches(value)
        }
    }


    private fun benchmark(name: String, target: (value: String) -> Unit) {
        measureNanoTime {
            for (count in 0..1000) {
                for (item in arrayOf("a", "ab", "abc", "abcd", "0da")) {
                    target.invoke(item)
                }
            }
        }.also { println("$name: $it[ns]") }
    }


    @Test
    fun test_benchmark_isValid1() = benchmark("isValid1") {
        Sample.isValid1(it)
    }

    @Test
    fun test_benchmark_isValid2() = benchmark("isValid2") {
        Sample.isValid2(it)
    }
}
