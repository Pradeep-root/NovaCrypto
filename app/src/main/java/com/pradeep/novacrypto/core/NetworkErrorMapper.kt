package com.pradeep.novacrypto.core

import com.pradeep.novacrypto.core.common.ApiException
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class NetworkErrorMapper @Inject constructor() {

    fun map(throwable: Throwable): ApiException = when(throwable) {
        is HttpException -> ApiException.Server(code = throwable.code(), message = throwable.message)
        is UnknownHostException -> ApiException.Network(cause = throwable, message = "No internet connection.")
        is SocketTimeoutException -> ApiException.Network(cause = throwable, message = "Connection timed out.")
        is IOException -> ApiException.Network(cause = throwable)
        is ApiException -> throwable
        else -> ApiException.Unknown(cause = throwable)
    }

}