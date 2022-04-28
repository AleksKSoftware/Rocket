package co.karpenko.rocket.data.store

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


/**
 * Created by Alexander Karpenko on 25/4/22.
 * java.karpenko@gmail.com
 */

class PreferenceStorage @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(ROCKET_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)


    fun isNeedToShowWelcomeDialog(): Boolean = sharedPreferences.getBoolean(IS_SHOW_WELCOME_DIALOG, true)

    fun setStateWelcomeDialog(show: Boolean): Boolean = sharedPreferences.edit()
        .putBoolean(ROCKET_PREFERENCES_FILE_NAME, show)
        .commit()


    companion object {

        const val ROCKET_PREFERENCES_FILE_NAME = "rocket"

        const val IS_SHOW_WELCOME_DIALOG = "rocket"

    }

}