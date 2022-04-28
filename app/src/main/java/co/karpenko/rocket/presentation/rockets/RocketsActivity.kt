package co.karpenko.rocket.presentation.rockets

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import co.karpenko.rocket.R
import co.karpenko.rocket.common.lifecycle.observe
import co.karpenko.rocket.data.mapper.Rocket
import co.karpenko.rocket.presentation.rocket_details.RocketDetailsActivity.Companion.launch
import co.karpenko.rocket.presentation.rockets.adapter.RocketListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_rocket.*


/**
 * Created by Alexander Karpenko on 25.04.22.
 * java.karpenko@gmail.com
 */
@AndroidEntryPoint
class RocketsActivity : AppCompatActivity() {

    private val viewModel: RocketsViewModel by viewModels()
    private lateinit var rocketListAdapter: RocketListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rocket)

        observe(viewModel.event) {
            when (it) {
                is Event.EmptyQuery -> Toast.makeText(this, R.string.empty_list, Toast.LENGTH_LONG).show()
                is Event.RocketList -> showRocketList(it.list)
                is Event.ShowDialog -> showDialog()
                else -> Unit
            }
        }

        listView.layoutManager = LinearLayoutManager(this)
        listView.setHasFixedSize(true)
        rocketListAdapter = RocketListAdapter(::onClick)
        listView.adapter = rocketListAdapter

        checkBox.setOnClickListener {
            viewModel.filterActive(checkBox.isChecked)
        }
        searchView.addListener(
            lifecycle = lifecycle,
            onQuery = { viewModel.search(it) },
            onCancel = { viewModel.onSearchClear() }
        )
    }

    private fun onClick(rocket: Rocket) {
        launch(rocket, this)
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.welcome)
        builder.setMessage(R.string.be_rocket)
        builder.setPositiveButton("OK", null)
        builder.show()
    }

    private fun showRocketList(list: List<Rocket>) {
        rocketListAdapter.submitList(list)
    }
}
