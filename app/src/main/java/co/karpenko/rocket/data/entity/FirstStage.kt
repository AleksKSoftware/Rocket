package co.karpenko.rocket.data.entity

import com.google.gson.annotations.SerializedName


data class FirstStage(

    @SerializedName("reusable") var reusable: Boolean?,
    @SerializedName("engines") var engines: Int?,
    @SerializedName("fuel_amount_tons") var fuelAmountTons: Double?,
    @SerializedName("cores") var cores: Int?,
    @SerializedName("burn_time_sec") var burnTimeSec: Int?,
    @SerializedName("thrust_sea_level") var thrustSeaLevel: ThrustSeaLevel?,
    @SerializedName("thrust_vacuum") var thrustVacuum: ThrustVacuum?

)