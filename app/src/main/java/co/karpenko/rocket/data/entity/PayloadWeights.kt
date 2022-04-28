package co.karpenko.rocket.data.entity

import com.google.gson.annotations.SerializedName


data class PayloadWeights(

    @SerializedName("id") var id: String?,
    @SerializedName("name") var name: String?,
    @SerializedName("kg") var kg: Int?,
    @SerializedName("lb") var lb: Int?

)