package com.example.workshoptest

import com.example.workshoptest.coroutine.CoroutineProvider
import kotlinx.coroutines.Dispatchers.Unconfined
import kotlin.coroutines.CoroutineContext

class CoroutineProviderTest :  CoroutineProvider() {
    override var mainCoroutine: CoroutineContext = Unconfined

}