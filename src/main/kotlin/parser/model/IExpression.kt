package parser.model

interface IExpression : IExecutable<Operation.Result> {
    operator fun plus(other: IExpression): IExpression
    operator fun times(other: IExpression): IExpression
}