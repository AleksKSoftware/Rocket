package co.karpenko.rocket.domain.usecases.rockets

import co.karpenko.rocket.data.store.PreferenceStorage
import co.karpenko.rocket.domain.repository.RocketRepository
import co.tiim.testkarpenkoalex.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by Alexander Karpenko on 25.04.2022.
 * java.karpenko@gmail.com
 */
class RocketsInteractor @Inject constructor(
    dispatcher: CoroutineDispatcher,
    private val repository: RocketRepository,
    private val prefStorage: PreferenceStorage,
) : BaseUseCase(dispatcher) {

    suspend fun fetchRockets() = wrapResult {
        repository.getRockets()
    }

    suspend fun fetchWelcomeMessage() = wrapResult {
        prefStorage.setStateWelcomeDialog(true)
        prefStorage.isNeedToShowWelcomeDialog()

    }
}