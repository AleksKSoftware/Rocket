package co.karpenko.rocket.presentation.widgets

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Alexander Karpenko on 25.04.22.
 * java.karpenko@gmail.com
 */

inline fun <reified T> simpleItemCallback() = object : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }
}

fun getViewType(
    parent: RecyclerView,
    position: Int
): Int = parent.run {
    requireNotNull(adapter).getItemViewType(position)
}

fun <T> ListAdapter<T, *>.forceSubmit(items: List<T>, callback: Runnable? ) {
    submitList(null) { submitList(items, callback) }
}
