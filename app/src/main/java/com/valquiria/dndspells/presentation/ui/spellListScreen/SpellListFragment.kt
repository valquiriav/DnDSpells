package com.valquiria.dndspells.presentation.ui.spellListScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.valquiria.dndspells.R

class SpellListFragment: Fragment() {

    //onde colocar o adapter?
    private lateinit var adapter: SpellListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_spell_list, container, false)
    }

}