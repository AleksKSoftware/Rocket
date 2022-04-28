package co.karpenko.rocket.data.entity

import com.google.gson.annotations.SerializedName


data class Engines(

    @SerializedName("number") var number: Int?,
    @SerializedName("type") var type: String?,
    @SerializedName("version") var version: String?,
    @SerializedName("layout") var layout: String?,
    @SerializedName("engine_loss_max") var engineLossMax: Int?,
    @SerializedName("propellant_1") var propellant1: String?,
    @SerializedName("propellant_2") var propellant2: String?,
    @SerializedName("thrust_sea_level") var thrustSeaLevel: ThrustSeaLevel?,
    @SerializedName("thrust_vacuum") var thrustVacuum: ThrustVacuum?,
    @SerializedName("thrust_to_weight") var thrustToWeight: Double?

)