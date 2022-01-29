package com.github.tshion.mktools_android.grammar

import org.junit.Assert.assertNull
import org.junit.Test

import kotlin.system.measureNanoTime

/**
 * Int 型のプロパティを持ったEnum サンプルの挙動確認
 */
class EnumIntSamplePlayground {

    private fun benchmark(name: String, target: (num: Int) -> Unit) {
        measureNanoTime {
            for (count in 0..1000) {
                for (item in arrayOf(97, 105, 113, 122)) {
                    target.invoke(item)
                }
            }
        }.also { println("$name: $it[ns]") }
    }


    @Test
    fun test_benchmark_parseByCacheArray() = benchmark("parseByCacheArray") {
        EnumIntSample.parseByCacheArray(it)
    }

    @Test
    fun test_benchmark_parseByCacheMap() = benchmark("parseByCacheMap") {
        EnumIntSample.parseByCacheMap(it)
    }

//    @Test
//    fun test_benchmark_parseByCacheSparseArray() = benchmark("parseByCacheSparseArray") {
//        EnumIntSample.parseByCacheSparseArray(it)
//    }

    @Test
    fun test_benchmark_parseByValuesAndSingle() = benchmark("parseByValuesAndSingle") {
        EnumIntSample.parseByValuesAndSingle(it)
    }

    @Test
    fun test_benchmark_parseByWhen() = benchmark("parseByWhen") {
        EnumIntSample.parseByWhen(it)
    }

    @Test
    fun test_default_value_java() {
        val javaClass = EnumHadClass()
        assertNull(javaClass.typeInt)
    }
}
