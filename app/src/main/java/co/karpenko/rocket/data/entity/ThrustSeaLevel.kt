package co.karpenko.rocket.data.entity

import com.google.gson.annotations.SerializedName


data class ThrustSeaLevel (
  @SerializedName("kN"  ) var kN  : Int?,
  @SerializedName("lbf" ) var lbf : Int?
)