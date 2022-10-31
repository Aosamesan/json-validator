package parser.model

import parser.IDataFinder

interface IExecutable<TResult> {
    fun execute(root: Any?, dataFinder: IDataFinder): TResult
}