package co.karpenko.rocket.presentation.rocket_details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.karpenko.rocket.data.mapper.RocketDetail
import co.karpenko.rocket.domain.usecases.rocket_details.RocketDetailsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Alexander Karpenko on 25/4/22.
 * java.karpenko@gmail.com
 */

@HiltViewModel
class RocketDetailsViewModel @Inject constructor(
    private val rocketDetailsInteractor: RocketDetailsInteractor,
) : ViewModel() {

    val rocketDetailsEvent = MutableLiveData<RocketDetail>()


    fun getRocketDetails(id: String?) {
        id?.let {
            viewModelScope.launch {
                rocketDetailsInteractor.fetchRocketDetails(id).fold(
                    onSuccess = {
                        rocketDetailsEvent.value = it
                    },
                    onFailure = ::error
                )
            }
        }
    }
}
