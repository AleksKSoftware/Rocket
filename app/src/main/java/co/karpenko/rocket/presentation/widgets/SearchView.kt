@file:Suppress("SetterBackingFieldAssignment")

package co.karpenko.rocket.presentation.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.res.use
import androidx.core.view.isGone
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.coroutineScope
import co.karpenko.rocket.R
import kotlinx.android.synthetic.main.widget_search.view.*
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * Created by Alexander Karpenko on 25.04.22.
 * java.karpenko@gmail.com
 */

class SearchView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? ,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var requestFocus: Boolean = false
    lateinit var searchHint: CharSequence
     var searchText: String = ""

    init {
        View.inflate(context, R.layout.widget_search, this)

        context.obtainStyledAttributes(attrs, R.styleable.SearchView).use {
            requestFocus = it.getBoolean(R.styleable.SearchView_svRequestFocus, false)
            searchHint = it.getString(R.styleable.SearchView_android_hint)!!
        }

        etSearchInput.hint = searchHint
    }

    fun text() = etSearchInput.text.toString()


    fun addListener(lifecycle: Lifecycle, onQuery: (String) -> Unit, onCancel: () -> Unit) {
        if (requestFocus) {
            etSearchInput.requestFocus()
        }

        etSearchInput.afterTextChangedFlow
            .debounce(DELAY)
            .onEach { query ->
                ivClearInput.isGone = query.toString().isEmpty()
                onQuery(query.toString())
                searchText = query.toString()
            }
            .launchIn(lifecycle.coroutineScope)

        ivClearInput.setOnClickListener {
            etSearchInput.text
            onCancel()
        }
    }

    companion object {
        private const val DELAY = 250L
    }
}
