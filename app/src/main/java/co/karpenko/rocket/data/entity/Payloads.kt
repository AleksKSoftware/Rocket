package co.karpenko.rocket.data.entity

import co.karpenko.rocket.data.entity.CompositeFairing
import com.google.gson.annotations.SerializedName


data class Payloads(

    @SerializedName("option_1") var option1: String?,
    @SerializedName("option_2") var option2: String?,
    @SerializedName("composite_fairing") var compositeFairing: CompositeFairing?

)