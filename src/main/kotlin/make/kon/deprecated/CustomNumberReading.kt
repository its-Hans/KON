package make.kon.deprecated

import make.kon.Context
import make.kon.Digiting
import make.kon.cur
import make.kon.d10
import make.kon.d16
import make.kon.d2
import make.kon.d8
import make.kon.processDigit
import make.kon.processNegative

fun Context<*>.readSigned(digiting: Digiting): Long {
    val negative = processNegative()
    val unsigned = readUnsigned(digiting)

    return if (negative)
        -unsigned
    else unsigned
}

fun Context<*>.readSigned(): Long = readSigned(processDigit())
fun Context<*>.readUnsigned(): Long = readUnsigned(processDigit())

fun Context<*>.readUnsigned(digiting: Digiting) = readUnsigned(digiting.digit, digiting.parse)

internal fun Context<*>.readUnsigned(digit: Int, parse: (Char) -> Int): Long {
    var res = 0L

    while (hasNext()) {
        val i = parse(cur)
        if (i == -1) break

        res = res * digit + i

        continu()
    }

    return res
}