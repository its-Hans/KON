package make.kon

inline operator fun Context.plusAssign(step: Int) {
    this.continu(step)
}

inline val Context.cur get() = peek()