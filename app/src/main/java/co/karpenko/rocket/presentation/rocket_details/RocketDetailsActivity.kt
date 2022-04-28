package co.karpenko.rocket.presentation.rocket_details

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import co.karpenko.rocket.R
import co.karpenko.rocket.common.lifecycle.observe
import co.karpenko.rocket.data.mapper.Rocket
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_rocket_details.*

@AndroidEntryPoint
class RocketDetailsActivity : AppCompatActivity() {

    private val viewModel: RocketDetailsViewModel by viewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rocket_details)

        val rocket = intent.getParcelableExtra<Rocket>(rocketModel)
        viewModel.getRocketDetails(rocket?.id)
        tvName.text = getString(R.string.name) + ": " + rocket?.name
        tvDescription.text = rocket?.description
        tvCountry.text = getString(R.string.country) + ": " + rocket?.country
        tvHeight.text = getString(R.string.height) + ": " + rocket?.height.toString()
        tvMass.text = getString(R.string.mass) + ": " + rocket?.mass
        tvDate.text = getString(R.string.date) + ": " + rocket?.name

        observe(viewModel.rocketDetailsEvent) {
            showRocket()
            tvNameRocket.text = getString(R.string.rocketName) + it?.let { it.name }
            tvDate.text = it.date
            it.success?.let { it ->
                tvSuccess.text = getString(R.string.status) + ": " + if (it)
                    getString(R.string.success)
                else
                    getString(R.string.fail)
            } ?: getString(R.string.noData)

        }
        toolbar.setNavigationOnClickListener { finish() }
    }

    private fun showRocket() {
        Glide.with(this)
            .load(R.drawable.rocket)
            .circleCrop()
            .into(imRocket)
    }


    companion object {
        private const val rocketModel = "rocketModel"

        fun launch(rocket: Rocket, context: Context) {
            return context.startActivity(
                Intent(context, RocketDetailsActivity::class.java).also {
                    it.putExtra(rocketModel, rocket)
                }
            )
        }
    }
}