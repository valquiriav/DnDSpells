package com.valquiria.dndspells.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.valquiria.dndspells.R
import com.valquiria.dndspells.presentation.ui.spellListScreen.SpellListAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: SpellListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //TODO

}