package com.example.workshoptest.view.activity

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{
    async {
        delay(200L)
        println("Tarefa numero 1")
    }
    println("Esperando a tarefa numero 1 terminar")// essa linha so é executada qdo a coroutine é finalizada
}