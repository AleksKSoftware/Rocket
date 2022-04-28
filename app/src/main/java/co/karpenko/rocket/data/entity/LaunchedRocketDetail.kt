package co.karpenko.rocket.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by Alexander Karpenko on 26/4/22.
 * java.karpenko@gmail.com
 */
class LaunchedRocketDetail constructor(
    @SerializedName("rocket") val rocket: String?,
    @SerializedName("success") val success: Boolean?,
    @SerializedName("static_fire_date_utc") val date: String?,
    @SerializedName("name") val name: String?
)
