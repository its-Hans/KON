package make.kon.serializers

import com.google.common.primitives.Ints
import make.common.result.Err
import make.common.result.Ok
import make.common.result.Result
import make.kon.Context
import make.kon.Failure
import make.kon.LiteralSize
import make.kon.Serializer
import make.kon.processDigit
import make.kon.processNegative

/**
 * @author MakeCat
 */
class IntSerializer : Serializer<Int> {
    override val size = LiteralSize(4)

    override fun <C> Context<C>.from(): Result<Int, Failure> {
    }

    override fun from(array: ByteArray): Result<Int, Nothing> {
        return Ok(Ints.fromByteArray(array))
    }

    override fun serialize(input: Int): Result<ByteArray, Nothing> {
        return Ok(Ints.toByteArray(input))
    }
}
