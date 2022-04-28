@file:Suppress("unused")

package co.karpenko.rocket.common.lifecycle

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import org.front.common.lifecycle.NonNullObserver

/**
 * Created by Alexander Karpenko on 25.04.2022.
 * java.karpenko@gmail.com
 */


fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T) -> Unit) =
    liveData.observe(this, NonNullObserver(body))

fun <T : Any, L : LiveData<T>> Fragment.observe(liveData: L, body: (T) -> Unit) =
    liveData.observe(viewLifecycleOwner, NonNullObserver(body))

