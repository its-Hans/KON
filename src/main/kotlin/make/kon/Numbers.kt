package make.kon

fun Context<*>.processNegative(): Boolean {
    val negative = cur == '-'

    if (negative || cur == '+') continu()

    return negative
}

fun Context<*>.processDigit(): Digiting {
    if (cur != '0')
        return d10

    continu()
    return when (read()) {
        'x' -> d16
        'b' -> d2
        else -> d8
    }
}

class Digiting(val digit: Int, val parse: (Char) -> Int)

val d16 = Digiting(16) {
    when (it) {
        in '0'..'9' -> it - '0'
        in 'a'..'f' -> it - 'a' + 10
        in 'A'..'F' -> it - 'A' + 10

        else -> -1
    }
}

val d10 = Digiting(10) {
    if (it in '0'..'9')
        it - '0'
    else -1
}

val d8 = Digiting(8) {
    if (it in '0'..'7')
        it - '0'
    else -1
}

val d2 = Digiting(2) {
    when (it) {
        '0' -> 0
        '1' -> 1

        else -> -1
    }
}