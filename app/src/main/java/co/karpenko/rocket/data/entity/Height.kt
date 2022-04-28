package co.karpenko.rocket.data.entity

import com.google.gson.annotations.SerializedName


data class Height(
    @SerializedName("meters") var meters: Double?,
    @SerializedName("feet") var feet: Double?
)