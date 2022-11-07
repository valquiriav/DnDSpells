package com.valquiria.dndspells.presentation.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.valquiria.dndspells.R
import com.valquiria.dndspells.presentation.ui.spellListScreen.SpellListAdapter
import com.valquiria.dndspells.presentation.ui.spellListScreen.SpellListViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel: SpellListViewModel by inject()

    private lateinit var spellListAdapter: SpellListAdapter

    private lateinit var spellListRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        setupObserver()
        viewModel.getSpells()
    }

    private fun setupRecyclerView() {

        spellListRecyclerView = findViewById(R.id.spellListRecyclerView)

        spellListRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        spellListAdapter = SpellListAdapter()
        spellListRecyclerView.adapter = spellListAdapter

        spellListAdapter.onItemClick = { item ->
            Log.d("TAG", "$item")
        }
    }

    private fun setupObserver() {
        viewModel.observableStatus
            .observe(this) {
                spellListAdapter.addItems(it)
            }
    }


}