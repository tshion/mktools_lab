package com.github.tshion.mktools_android.kotlin

import org.junit.Test

import kotlin.system.measureNanoTime

/**
 * Int 型のプロパティを持ったEnum サンプルのベンチマークテスト
 */
class EnumIntSampleBenchmark {

    private val testData = arrayOf(97, 105, 113, 122)
    private val testRange = 0..1000


    private fun test(name: String, target: (num: Int) -> Unit) {
        measureNanoTime {
            for (count in testRange) {
                for (item in testData) {
                    target.invoke(item)
                }
            }
        }.also { println("$name: $it[ns]") }
    }


    @Test
    fun test_parseByCacheArray() = test("parseByCacheArray") {
        EnumIntSample.parseByCacheArray(it)
    }

    @Test
    fun test_parseByCacheMap() = test("parseByCacheMap") {
        EnumIntSample.parseByCacheMap(it)
    }

//    @Test
//    fun test_parseByCacheSparseArray() = test("parseByCacheSparseArray") {
//        EnumIntSample.parseByCacheSparseArray(it)
//    }

    @Test
    fun test_parseByValuesAndSingle() = test("parseByValuesAndSingle") {
        EnumIntSample.parseByValuesAndSingle(it)
    }

    @Test
    fun test_parseByWhen() = test("parseByWhen") {
        EnumIntSample.parseByWhen(it)
    }
}
