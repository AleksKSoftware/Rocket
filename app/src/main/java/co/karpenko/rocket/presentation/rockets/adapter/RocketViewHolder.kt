package co.karpenko.rocket.presentation.rockets.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.karpenko.rocket.R
import co.karpenko.rocket.data.mapper.Rocket
import co.tiim.testkarpenkoalex.domain.base.inflate
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_holder_notification.view.*

/**
 * Created by Alexander Karpenko on 25.04.2022.
 * java.karpenko@gmail.com
 */

class RocketViewHolder(parent: ViewGroup) :
    RecyclerView.ViewHolder(
        parent.inflate(R.layout.view_holder_notification)
    ) {

    fun bind(rocket: Rocket) = with(itemView) {
        tvName.text = rocket.name
        tvBodyText.text = rocket.engines.toString()
        Glide.with(context)
            .load(R.drawable.rocket)
            .circleCrop()
            .into(ivAvatar)

    }
}
