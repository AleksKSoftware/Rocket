package co.karpenko.rocket.domain.usecases.rocket_details

import co.karpenko.rocket.domain.repository.RocketRepository
import co.tiim.testkarpenkoalex.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by Alexander Karpenko on 25.04.2022.
 * java.karpenko@gmail.com
 */
class RocketDetailsInteractor @Inject constructor(
    dispatcher: CoroutineDispatcher,
    private val repository: RocketRepository,
) : BaseUseCase(dispatcher) {

    suspend fun fetchRocketDetails(id: String) = wrapResult {
        repository.getLaunchedRockets(id)
    }
}