package fr.davinhdot.fizzbuzz.util

fun Int.getFizzBuzzResult(
    firstMultiple: Int,
    secondMultiple: Int,
    fizz: String,
    buzz: String
): String {
    return when {
        (this) % firstMultiple == 0 && (this) % secondMultiple == 0 -> "$fizz$buzz"
        (this) % secondMultiple == 0 -> buzz
        (this) % firstMultiple == 0 -> fizz
        else -> this.toString()
    }
}