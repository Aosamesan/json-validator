package parser.datafinder

import parser.IDataFinder

class RecursiveDataFinder: IDataFinder {
    override fun find(root: Any?, path: String): Any? {
        return findRecursive(root, *path.split(".").toTypedArray())
    }

    private fun findRecursive(data: Any?, vararg paths: String): Any? {
        if (paths.isEmpty()) {
            return data
        }
        // first path
        var first = paths.first()
        val rest = paths.drop(1).toTypedArray()
        val isList = first.endsWith("[]")

        when (data) {
            is Map<*, *> -> {
                return if (isList) {
                    first = first.replace(Regex("\\[]$"), "")
                    if (data[first] is List<*>) {
                        (data[first] as List<*>).map { findRecursive(it, *rest) }
                    } else {
                        throw Exception("path $first is not list")
                    }
                } else {
                    findRecursive(data[first], *rest)
                }
            }

            is List<*> -> {
                return data.map { findRecursive(it, *rest) }
            }

            else -> {
                throw Exception("Unreachable")
            }
        }
    }
}