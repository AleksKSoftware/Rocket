package co.karpenko.rocket.presentation.rockets.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import co.karpenko.rocket.data.mapper.Rocket
import co.karpenko.rocket.presentation.widgets.simpleItemCallback

/**
 * Created by Alexander Karpenko on 26/4/22.
 * java.karpenko@gmail.com
 */
class RocketListAdapter(
    val clickListener: (rocket: Rocket) -> Unit,
) : ListAdapter<Rocket, RocketViewHolder>(
    simpleItemCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketViewHolder {
        return RocketViewHolder(parent).apply {
            itemView.setOnClickListener { clickListener(getItem(adapterPosition)) }
        }
    }

    override fun onBindViewHolder(holder: RocketViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}