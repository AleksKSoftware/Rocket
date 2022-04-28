package org.front.common.coroutines

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine
import kotlin.experimental.ExperimentalTypeInference

/**
 * Created by Alexander Karpenko on 25.04.2022.
 * java.karpenko@gmail.com
 */

fun <T> CoroutineScope.bufferedChannel(
    channel: ReceiveChannel<T>,
    millis: Long,
    unit: suspend (List<T>) -> Unit
) = launch {
    val items = mutableListOf<T>()
    for (item in channel) {
        items.add(item)
        coroutineContext.cancelChildren()
        launch {
            delay(millis)
            unit(items.toList())
            items.clear()
        }
    }
}

@OptIn(ExperimentalTypeInference::class)
fun <T> repeatFlow(
    delay: Long,
    startDelay: Long = delay,
    until: () -> Boolean = { true },
    @BuilderInference block: suspend FlowCollector<T>.() -> Unit,
) = flow<T> {
    delay(startDelay)
    while (until()) {
        block()
        delay(delay)
    }
}

suspend inline fun <T> suspendCatchable(crossinline block: () -> T): T = suspendCoroutine {
    try {
        it.resume(block())
    } catch (expected: Exception) {
        it.resumeWithException(expected)
    }
}

suspend fun <T> Flow<T>.collect(liveData: MutableLiveData<T>) {
    collect { liveData.value = it }
}

@Suppress("unused")
val Dispatchers.Single
    get() = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
