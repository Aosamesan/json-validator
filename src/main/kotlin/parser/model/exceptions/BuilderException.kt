package parser.model.exceptions

class BuilderException(builderName: String, message: String) : Exception("[$builderName] $message")