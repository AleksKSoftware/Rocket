package co.karpenko.rocket.data.entity

import com.google.gson.annotations.SerializedName


data class Mass(

    @SerializedName("kg") var kg: Double?,
    @SerializedName("lb") var lb: Double?

)