package parser

interface IDataFinder {
    fun find(root: Any?, path: String): Any?
}