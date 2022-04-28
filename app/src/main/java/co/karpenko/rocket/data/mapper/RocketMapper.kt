package co.karpenko.rocket.data.mapper

import co.karpenko.rocket.data.entity.LaunchedRocketDetail
import co.karpenko.rocket.data.entity.RocketModel

object RocketMapper {
    fun toRocket(rocketModel: RocketModel): Rocket =
        Rocket(
            id = rocketModel.id,
            name = rocketModel.rocketName,
            engines = rocketModel.engines?.number,
            description = rocketModel.description,
            country = rocketModel.country,
            mass = if (rocketModel.mass?.kg == 0.0) "-" else rocketModel.mass?.kg.toString(),
            activeRocket = rocketModel.active
        )

    fun toRocketDetail(rocketModel: LaunchedRocketDetail?): RocketDetail =
        RocketDetail(
            id = rocketModel?.rocket,
            name = rocketModel?.name,
            success = rocketModel?.success,
            date = rocketModel?.date,
        )

}