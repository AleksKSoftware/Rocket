@file:Suppress("unused")

package co.karpenko.rocket.presentation.widgets

import android.text.Editable
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

/**
 * Created by Alexander Karpenko on 25.04.22.
 * java.karpenko@gmail.com
 */

val EditText.afterTextChangedFlow: Flow<Editable?>
    get() = callbackFlow {
        val watcher = doAfterTextChanged { offer(it) }
        awaitClose { removeTextChangedListener(watcher) }
    }


