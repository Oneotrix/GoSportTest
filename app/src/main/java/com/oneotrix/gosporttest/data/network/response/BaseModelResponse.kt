package com.oneotrix.gosporttest.data.network.response

sealed class BaseModelResponse<T>(
    val  data: T? = null,
    val message: String? = null
) {

    class Success<T>(data: T) : BaseModelResponse<T>(data)

    class Error<T>(message: String?, data: T? = null) : BaseModelResponse<T>(data, message)


}