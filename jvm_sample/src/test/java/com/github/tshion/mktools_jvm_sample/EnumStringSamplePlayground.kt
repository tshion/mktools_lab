package com.github.tshion.mktools_jvm_sample

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

import kotlin.system.measureNanoTime

/**
 * String 型のプロパティを持ったEnum サンプルの挙動確認
 */
class EnumStringSamplePlayground {

    private fun benchmark(name: String, target: (num: String) -> Unit) {
        measureNanoTime {
            for (count in 0..1000) {
                for (item in arrayOf("97", "105", "113", "122")) {
                    target.invoke(item)
                }
            }
        }.also { println("$name: $it[ns]") }
    }


    @Test
    fun test_benchmark_parseByCacheArray() = benchmark("parseByCacheArray") {
        EnumStringSample.parseByCacheArray(it)
    }

    @Test
    fun test_benchmark_parseByCacheMap() = benchmark("parseByCacheMap") {
        EnumStringSample.parseByCacheMap(it)
    }

//    @Test
//    fun test_benchmark_parseByCacheSparseArray() = benchmark("parseByCacheSparseArray") {
//        EnumStringSample.parseByCacheSparseArray(it)
//    }

    @Test
    fun test_benchmark_parseByCacheValues() = benchmark("parseByCacheValues") {
        EnumStringSample.parseByCacheValues(it)
    }

    @Test
    fun test_benchmark_parseByCacheValuesToMap() = benchmark("parseByCacheValuesToMap") {
        EnumStringSample.parseByCacheValuesToMap(it)
    }

    @Test
    fun test_benchmark_parseByValuesAndSingle() = benchmark("parseByValuesAndSingle") {
        EnumStringSample.parseByValuesAndSingle(it)
    }

    @Test
    fun test_benchmark_parseByWhen() = benchmark("parseByWhen") {
        EnumStringSample.parseByWhen(it)
    }

    @Test
    fun test_default_value_java() {
        assertThat(EnumHadClass().typeString).isNull()
    }
}
