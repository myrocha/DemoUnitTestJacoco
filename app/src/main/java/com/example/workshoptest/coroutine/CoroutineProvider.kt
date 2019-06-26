package com.example.workshoptest.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

open class CoroutineProvider {

    open val mainCoroutine: CoroutineContext =  Dispatchers.Main
    open val ioCoroutine: CoroutineScope = CoroutineScope(Dispatchers.IO)
   // open val IO: CoroutineContext by lazy { CommonPool }
    //open val IO: CoroutineContext by lazy { IO }
}