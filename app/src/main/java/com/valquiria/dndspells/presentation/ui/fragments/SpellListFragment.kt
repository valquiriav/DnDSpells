package com.valquiria.dndspells.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.valquiria.dndspells.databinding.FragmentSpellListBinding
import com.valquiria.dndspells.presentation.ui.view.adapter.SpellListAdapter
import com.valquiria.dndspells.presentation.ui.viewModel.SpellListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpellListFragment : Fragment() {

    private val adapter by lazy { SpellListAdapter() }

    private lateinit var binding: FragmentSpellListBinding

    private val viewModel: SpellListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpellListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservables()
        setupView()
        viewModel.getSpells()
    }

    private fun setupView() {
        with(binding) {
            spellListRecyclerView.adapter = adapter
        }
    }

    private fun setupObservables() {
        viewModel.observableStatus
            .observe(viewLifecycleOwner) {
                adapter.addItems(it)
            }
    }

}