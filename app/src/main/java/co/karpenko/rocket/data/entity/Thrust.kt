package co.karpenko.rocket.data.entity

import com.google.gson.annotations.SerializedName

data class Thrust(
    @SerializedName("kN") var kN: Int?,
    @SerializedName("lbf") var lbf: Int?
)