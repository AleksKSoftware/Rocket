package co.karpenko.rocket.domain.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    val error = MutableLiveData<Error>()
}
