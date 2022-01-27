package com.github.tshion.mktools_android

import org.junit.Test

import kotlin.system.measureNanoTime

/**
 * Enum の変換テスト
 */
class EnumSampleUnitTest {

    @Test
    fun test() {

        val testData = arrayOf(97, 105, 113, 122)
        val testRange = 0..1000

        measureNanoTime {
            for (count in testRange) {
                for (item in testData) {
                    EnumSample.parseCandidate1(item)
                }
            }
        }.also { println("candidate1: $it[ns]") }

        measureNanoTime {
            for (count in testRange) {
                for (item in testData) {
                    EnumSample.parseCandidate2(item)
                }
            }
        }.also { println("candidate2: $it[ns]") }

        measureNanoTime {
            for (count in testRange) {
                for (item in testData) {
                    EnumSample.parseCandidate3(item)
                }
            }
        }.also { println("candidate3: $it[ns]") }

        measureNanoTime {
            for (count in testRange) {
                for (item in testData) {
                    EnumSample.parseCandidate4(item)
                }
            }
        }.also { println("candidate4: $it[ns]") }
    }
}
