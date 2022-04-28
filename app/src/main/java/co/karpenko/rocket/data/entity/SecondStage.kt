package co.karpenko.rocket.data.entity

import com.google.gson.annotations.SerializedName


data class SecondStage(

  @SerializedName("engines") var engines: Int?,
  @SerializedName("burn_time_sec") var burnTimeSec: Int?,
  @SerializedName("thrust") var thrust: Thrust?,
  @SerializedName("payloads") var payloads: Payloads?

)