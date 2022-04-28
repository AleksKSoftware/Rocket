package co.karpenko.rocket.data.mapper

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Rocket(
    val id: String?,
    val name: String?,
    val engines: Int? = 0,
    val description: String? = "",
    val height: Int? = 0,
    val country: String?,
    val mass: String?,
    val activeRocket: Boolean? = false
) : Parcelable