package co.karpenko.rocket.presentation.rockets

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.karpenko.rocket.data.mapper.Rocket
import co.karpenko.rocket.domain.usecases.rockets.RocketsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.front.common.coroutines.ClosableMainScope
import javax.inject.Inject

/**
 * Created by Alexander Karpenko on 25/4/22.
 * java.karpenko@gmail.com
 */

@HiltViewModel
class RocketsViewModel @Inject constructor(
    private val rocketsInteractor: RocketsInteractor,
) : ViewModel() {

    val event = MutableLiveData<Event>()
    private val list = ArrayList<Rocket>()
    private val searchScope = ClosableMainScope()

    init {
        welcomeDialog()
        getRockets()
    }

    private fun welcomeDialog() {
        searchScope.launch {
            rocketsInteractor.fetchWelcomeMessage().fold(
                onSuccess = {
                    if (!it) {
                        event.value = Event.ShowDialog
                    }
                },
                onFailure = ::error
            )
        }
    }

    private fun getRockets() {
        searchScope.launch {
            rocketsInteractor.fetchRockets().fold(
                onSuccess = {
                    event.value = Event.RocketList(it)
                    updateList(it)
                },
                onFailure = ::error
            )
        }
    }

    private fun updateList(list: List<Rocket>) {
        this.list.clear()
        this.list.addAll(list)
    }

    override fun onCleared() {
        searchScope.close()
        super.onCleared()
    }

    fun search(query: String, checked: Boolean) {
        searchScope.cancelChildren()
        if (query.isNotEmpty() || checked) {
            searchScope.launch {
                list.filter { it.name?.contains(query) == true && it.activeRocket == checked }.let {
                    event.value = Event.RocketList(it)
                }
            }
        } else {
            event.value = Event.RocketList(list)

        }

    }

    fun onSearchClear() {
        event.value = Event.EmptyQuery
    }
}
