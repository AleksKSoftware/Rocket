package co.karpenko.rocket.domain.repository

import co.karpenko.rocket.data.mapper.Rocket
import co.karpenko.rocket.data.mapper.RocketDetail
import co.karpenko.rocket.data.store.RocketStore
import javax.inject.Inject

/**
 * Created by Alexander Karpenko on 25.04.2022.
 * java.karpenko@gmail.com
 */

class RocketRepository @Inject constructor(
    private val rocketStore: RocketStore,
) {

    suspend fun getRockets(): List<Rocket> =
        requireNotNull(rocketStore.getRockets())

    suspend fun getLaunchedRockets(id: String): RocketDetail =
        requireNotNull(rocketStore.getRocketDetails(id))

}
