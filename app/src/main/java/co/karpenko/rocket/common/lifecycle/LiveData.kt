package org.front.common.lifecycle

import androidx.lifecycle.MutableLiveData

fun <T> mutableLiveData(callback: (T?) -> Unit) =
    object : MutableLiveData<T?>() {
        override fun setValue(value: T?) {
            super.setValue(value)
            callback(value)
        }
    }

fun <T> mutableLiveData(value: T, callback: (T) -> Unit) =
    object : MutableLiveData<T>(value) {
        override fun setValue(value: T) {
            super.setValue(value)
            callback(value)
        }
    }
