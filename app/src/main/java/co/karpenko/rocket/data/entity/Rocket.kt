package co.karpenko.rocket.data.entity

import com.google.gson.annotations.SerializedName


data class RocketModel(
    @SerializedName("id") var id: String?,
    @SerializedName("active") var active: Boolean?,
    @SerializedName("stages") var stages: Int?,
    @SerializedName("boosters") var boosters: Int?,
    @SerializedName("cost_per_launch") var costPerLaunch: Int?,
    @SerializedName("success_rate_pct") var successRatePct: Int?,
    @SerializedName("first_flight") var firstFlight: String?,
    @SerializedName("country") var country: String?,
    @SerializedName("company") var company: String?,
    @SerializedName("height") var height: Height?,
    @SerializedName("diameter") var diameter: Diameter?,
    @SerializedName("mass") var mass: Mass?,
    @SerializedName("payload_weights") var payloadWeights: ArrayList<PayloadWeights>,
    @SerializedName("first_stage") var firstStage: FirstStage?,
    @SerializedName("second_stage") var secondStage: SecondStage?,
    @SerializedName("engines") var engines: Engines?,
    @SerializedName("landing_legs") var landingLegs: LandingLegs?,
    @SerializedName("wikipedia") var wikipedia: String?,
    @SerializedName("description") var description: String?,
    @SerializedName("rocket_id") var rocketId: String?,
    @SerializedName("name") var rocketName: String?,
    @SerializedName("rocket_type") var rocketType: String?
)