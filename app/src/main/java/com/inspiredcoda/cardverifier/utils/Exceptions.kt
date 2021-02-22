package com.inspiredcoda.cardverifier.utils

import java.io.IOException

class NoInternetException(message: String): IOException(message)

class ApiException(message: String): IOException(message)