package co.karpenko.rocket.data.store

import co.karpenko.rocket.data.api.Api
import co.karpenko.rocket.data.mapper.Rocket
import co.karpenko.rocket.data.mapper.RocketDetail
import co.karpenko.rocket.data.mapper.RocketMapper.toRocket
import co.karpenko.rocket.data.mapper.RocketMapper.toRocketDetail
import javax.inject.Inject

/**
 * Created by Alexander Karpenko on 25.04.2022.
 * java.karpenko@gmail.com
 */

class RocketStore @Inject constructor(
    private val api: Api
) {
    suspend fun getRockets(): List<Rocket> =
        api.getRockets().map { toRocket(it) }

    suspend fun getRocketDetails(id : String): RocketDetail {
        val rocket = api.getDetailsRocket().firstOrNull { it.rocket == id }
        return toRocketDetail(rocket)

    }
}