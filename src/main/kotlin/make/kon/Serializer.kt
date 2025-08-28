package make.kon

import make.common.result.Result

/**
 * @author MakeCat
 */
interface Serializer<T> {
    val size: Size

    fun <C> Context<C>.from(): Result<T, Failure>
    fun from(array: ByteArray): Result<T, Failure>
    fun serialize(input: T): Result<ByteArray, Failure>
}

interface Size {
    fun match(size: Int): Boolean
}

class LiteralSize(val size: Int): Size {
    override fun match(size: Int) = this.size == size
}

class RangedSize(val range: ClosedRange<Int>): Size {
    override fun match(size: Int) = size in range
}

object DynamicSize: Size {
    override fun match(size: Int) = true
}