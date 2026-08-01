package com.pradeep.novacrypto.core.common

sealed class ApiException(
    message: String? = null,
    cause: Throwable? = null
): Exception(message, cause) {

    class Network(cause: Throwable? = null, message: String? = null) : ApiException(message, cause)
    class Server(val code: Int, message: String? = null): ApiException(message)
    class Unknown(cause: Throwable? = null): ApiException(cause?.message, cause)
}

fun ApiException.toUserMessage(): String = when (this) {
    is ApiException.Network -> message?.takeIf { it.isNotBlank() } ?: "No network connection."
    is ApiException.Server -> "Server returns with error $code"
    is ApiException.Unknown -> message?.takeIf { it.isNotBlank() }?: "Something went wrong."
}