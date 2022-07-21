package com.valquiria.dndspells.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.valquiria.dndspells.R
import com.valquiria.dndspells.data.database.entity.SpellEntity
import com.valquiria.dndspells.presentation.ui.spellListScreen.SpellListAdapter
import com.valquiria.dndspells.presentation.ui.spellListScreen.SpellListViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel: SpellListViewModel by inject()

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getSpells()

        recyclerView = findViewById(R.id.spellListRecyclerView)
    }

}