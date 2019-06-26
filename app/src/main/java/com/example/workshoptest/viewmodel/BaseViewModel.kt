package com.example.workshoptest.viewmodel

import android.arch.lifecycle.ViewModel
import com.example.workshoptest.coroutine.CoroutineProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren

open class BaseViewModel constructor(courtineProvider: CoroutineProvider) : ViewModel(), CoroutineScope {


    val job = SupervisorJob()
    override val coroutineContext = courtineProvider.mainCoroutine + job

    override fun onCleared() {
        super.onCleared()
        job.cancelChildren()
    }

}