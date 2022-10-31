import org.junit.jupiter.api.Test
import parser.createValidator
import parser.datafinder.RecursiveDataFinder
import java.math.BigDecimal
import java.util.LinkedList
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ValidatorTests {
    private val testDefinition = """
        validator {
            step "foo": (get("foo") == 1) -> "Invalid!";
        }
    """.trimIndent()

    private val testObject = mapOf(
        Pair("foo", 1),
        Pair("bar", 2),
        Pair("baz", null)
    )

    @Test
    fun validatorTest() {
        val validator = createValidator(testDefinition)
        println(validator)

        val dataFinder = RecursiveDataFinder()

        val result = validator.execute(testObject, dataFinder)

        println(result)
    }

    @Test
    fun finderTest() {
        val dataFinder = RecursiveDataFinder()
        assertEquals(dataFinder.find(testObject, "foo"), 1)
    }

    @Test
    fun equality() {
        val n = 3
        val f = BigDecimal(3)

        assertTrue { (f.minus(BigDecimal(n))) == BigDecimal.ZERO }
    }
}