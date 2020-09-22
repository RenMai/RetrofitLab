package com.example.w1_d4_retrofitlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private val changeObserver =
        Observer<String> { value ->
            value?.let { updateHitCount(value) }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.hitCount.observe(this, changeObserver)

        presidentList.adapter = PresidentListAdapter(this, GlobalModel.presidents)
        presidentList.setOnItemClickListener { _, _, position, _ ->
            val selectedPresident = GlobalModel.presidents[position]

            viewModel.queryName(selectedPresident.name)

            presidentName.text = selectedPresident.name
            presidentStart.text = selectedPresident.startDuty.toString()
            presidentEnd.text = selectedPresident.endDuty.toString()
            presidentDescription.text = selectedPresident.description
        }
    }

    private fun updateHitCount(hitCount: String) {
        presidentHitCount.text = hitCount
    }
}