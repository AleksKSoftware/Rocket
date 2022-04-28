package co.karpenko.rocket.data.api

import co.karpenko.rocket.data.entity.LaunchedRocketDetail
import co.karpenko.rocket.data.entity.RocketModel
import retrofit2.http.GET

/**
 * Created by Alexander Karpenko on 25.04.2022.
 * java.karpenko@gmail.com
 */

interface Api {

    @GET("/v4/rockets")
    suspend fun getRockets(): List<RocketModel>

    @GET("/v4/launches")
    suspend fun getDetailsRocket(): List<LaunchedRocketDetail>

}
