package fr.davinhdot.fizzbuzz.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class FizzBuzz(
    private val firstMultiple: Int,
    private val secondMultiple: Int,
    private val fizz: String,
    private val buzz: String
) : Parcelable {

    companion object {
        const val DEFAULT_LIMIT = 100

        const val DEFAULT_FIRST_MULTIPLE = 3
        const val DEFAULT_SECOND_MULTIPLE = 5

        const val DEFAULT_FIZZ = "fizz"
        const val DEFAULT_BUZZ = "buzz"
    }

    fun getResult(number: Int) = when {
        isDivisibleByFirstAndSecondMultiple(number) -> "$fizz$buzz"
        isDivisibleByFirstMultiple(number) -> fizz
        isDivisibleBySecondMultiple(number) -> buzz
        else -> number.toString()
    }

    private fun isDivisibleByFirstMultiple(number: Int) = number % firstMultiple == 0

    private fun isDivisibleBySecondMultiple(number: Int) = number % secondMultiple == 0

    private fun isDivisibleByFirstAndSecondMultiple(number: Int) =
        isDivisibleByFirstMultiple(number) && isDivisibleBySecondMultiple(number)
}