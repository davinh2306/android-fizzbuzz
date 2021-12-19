package fr.davinhdot.fizzbuzz

import fr.davinhdot.fizzbuzz.entity.FizzBuzz
import fr.davinhdot.fizzbuzz.entity.FizzBuzz.Companion.DEFAULT_BUZZ
import fr.davinhdot.fizzbuzz.entity.FizzBuzz.Companion.DEFAULT_FIRST_MULTIPLE
import fr.davinhdot.fizzbuzz.entity.FizzBuzz.Companion.DEFAULT_FIZZ
import fr.davinhdot.fizzbuzz.entity.FizzBuzz.Companion.DEFAULT_SECOND_MULTIPLE
import org.junit.Assert.assertNull
import org.junit.Test

class FizzBuzzUnitTest {

    private val start = 1
    private val limit = 100

    private val fizzBuzz = FizzBuzz(
        DEFAULT_FIRST_MULTIPLE,
        DEFAULT_SECOND_MULTIPLE,
        DEFAULT_FIZZ,
        DEFAULT_BUZZ
    )


    @Test
    fun multiplesOfFirstMultipleOnlyReturnsFizz() {
        val divisibleByFirstMultipleOnly = (start..limit)
            .filter {
                it % DEFAULT_FIRST_MULTIPLE == 0 && it % DEFAULT_SECOND_MULTIPLE != 0
            }

        val result = divisibleByFirstMultipleOnly
            .firstOrNull {
                fizzBuzz.getResult(it) != DEFAULT_FIZZ
            }

        assertNull(result)
    }

    @Test
    fun multiplesOfSecondMultipleOnlyReturnsBuzz() {
        val divisibleBySecondMultipleOnly = (start..limit)
            .filter {
                it % DEFAULT_FIRST_MULTIPLE != 0 && it % DEFAULT_SECOND_MULTIPLE == 0
            }

        val result = divisibleBySecondMultipleOnly
            .firstOrNull {
                fizzBuzz.getResult(it) != DEFAULT_BUZZ
            }

        assertNull(result)
    }

    @Test
    fun multiplesOfFirstAndSecondMultipleReturnsFizzBuzz() {
        val divisibleByFirstAndSecondMultiple = (start..limit)
            .filter {
                it % DEFAULT_FIRST_MULTIPLE == 0 && it % DEFAULT_SECOND_MULTIPLE == 0
            }

        val result = divisibleByFirstAndSecondMultiple
            .firstOrNull {
                fizzBuzz.getResult(it) != "$DEFAULT_FIZZ$DEFAULT_BUZZ"
            }

        assertNull(result)
    }

    @Test
    fun notMultiplesOfFirstAndSecondMultipleReturnsNumber() {
        val notDivisibleByFirstAndSecondMultiple = (start..limit)
            .filter {
                it % DEFAULT_FIRST_MULTIPLE != 0 && it % DEFAULT_SECOND_MULTIPLE != 0
            }

        val result = notDivisibleByFirstAndSecondMultiple
            .firstOrNull {
                fizzBuzz.getResult(it) != it.toString()
            }

        assertNull(result)
    }
}