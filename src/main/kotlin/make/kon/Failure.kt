package make.kon

/**
 * @author MakeCat
 */
enum class Failure {
    UNSUPPORTED_NUMERICAL_REPRESENTATION,
    UNSUPPORTED_BYTEARRAY_SIZE
}

enum class RecoveryStrategy {
    END,
    SKIP
}