package co.karpenko.rocket.data.entity

import com.google.gson.annotations.SerializedName


data class CompositeFairing(

    @SerializedName("height") var height: Height?,
    @SerializedName("diameter") var diameter: Diameter?

)