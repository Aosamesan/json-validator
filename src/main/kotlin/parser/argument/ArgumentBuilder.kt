package parser.argument

import java.util.*
import kotlin.collections.ArrayList

class ArgumentBuilder {
    private val queue: Queue<Any?> = LinkedList()

    fun register(operand: Any?) {
        queue.add(operand)
    }

    fun getNumber(): Double {
        val result = queue.poll()
        if (result !is Double) {
            throw Exception("Top is not Double")
        }
        return result
    }

    fun getString(): String {
        val result = queue.poll()
        if (result !is String) {
            throw Exception("Top is not String")
        }
        return result.replace(Regex("^\"|\"$"), "")
    }

    fun getBoolean(): Boolean {
        val result = queue.poll()
        if (result !is Boolean) {
            throw Exception("Top is not Boolean")
        }
        return result
    }

    fun getAsList(): List<Any?> {
        val result = ArrayList(queue)
        queue.clear()
        return result
    }
}