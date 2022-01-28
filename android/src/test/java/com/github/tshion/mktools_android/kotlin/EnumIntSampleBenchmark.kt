package com.github.tshion.mktools_android.kotlin

import org.junit.Test

import kotlin.system.measureNanoTime

/**
 * Int 型のプロパティを持ったEnum サンプルのベンチマークテスト
 */
class EnumIntSampleBenchmark {

    @Test
    fun test() {

        val testData = arrayOf(97, 105, 113, 122)
        val testRange = 0..1000

        measureNanoTime {
            for (count in testRange) {
                for (item in testData) {
                    EnumIntSample.parseCandidate1(item)
                }
            }
        }.also { println("candidate1: $it[ns]") }

        measureNanoTime {
            for (count in testRange) {
                for (item in testData) {
                    EnumIntSample.parseCandidate2(item)
                }
            }
        }.also { println("candidate2: $it[ns]") }

        measureNanoTime {
            for (count in testRange) {
                for (item in testData) {
                    EnumIntSample.parseCandidate3(item)
                }
            }
        }.also { println("candidate3: $it[ns]") }

        measureNanoTime {
            for (count in testRange) {
                for (item in testData) {
                    EnumIntSample.parseCandidate4(item)
                }
            }
        }.also { println("candidate4: $it[ns]") }
    }
}
