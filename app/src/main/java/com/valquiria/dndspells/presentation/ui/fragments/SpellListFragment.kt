package com.valquiria.dndspells.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.valquiria.dndspells.databinding.FragmentSpellListBinding
import com.valquiria.dndspells.presentation.ui.SpellAction
import com.valquiria.dndspells.presentation.ui.SpellFeedback
import com.valquiria.dndspells.presentation.ui.view.recycler.SpellListAdapter
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
        setupView()
        setupObserver()
        viewModel.getSpells()
    }

    private fun setupView() {
        with(binding) {
            spellListRecyclerView.adapter = adapter
        }
    }

    private fun setupObserver() {

        viewModel.observableAction.observe(viewLifecycleOwner) {
            when (it) {
                SpellAction.GenericError -> setFeedback(SpellFeedback.ERROR)
                SpellAction.NoInternet -> setFeedback(SpellFeedback.CONNECTION)
                SpellAction.NotFoundData -> setFeedback(SpellFeedback.NOT_FOUND)
            }
        }

        viewModel.observableStatus.observe(viewLifecycleOwner) {
            adapter.addItems(it)
        }

        viewModel.observableLoading.observe(viewLifecycleOwner) {
            with(binding) {
                if (it) {
                    shimmer.visibility = VISIBLE
                } else {
                    shimmer.visibility = GONE
                    spellListRecyclerView.visibility = VISIBLE
                }
            }

        }
    }

    private fun setFeedback(feedbackError: SpellFeedback) {
        with(binding) {
            customFeedback.visibility = VISIBLE
            customFeedback.setFeedback(feedbackError)
        }
    }

}