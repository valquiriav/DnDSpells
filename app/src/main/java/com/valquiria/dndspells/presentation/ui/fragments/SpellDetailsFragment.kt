package com.valquiria.dndspells.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.valquiria.dndspells.databinding.FragmentSpellDetailsBinding
import com.valquiria.dndspells.domain.model.SpellModel
import com.valquiria.dndspells.presentation.ui.viewModel.SpellDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpellDetailsFragment : Fragment() {

    private val navigationArgs: SpellDetailsFragmentArgs by navArgs()
    private lateinit var binding: FragmentSpellDetailsBinding
    private val viewModel: SpellDetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpellDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationArgs.spellIndex?.let { viewModel.getSpellDetails(it) }
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.observableStatus.observe(viewLifecycleOwner) {
            configureScreen(it)
        }

        viewModel.observableLoading.observe(viewLifecycleOwner) {
            with(binding) {
                if (it) {
                    spellDetailsShimmer.visibility = View.VISIBLE
                } else {
                    spellDetailsShimmer.visibility = View.GONE
                    spellDetailsView.visibility = View.VISIBLE
                }
            }

        }
    }

    private fun configureScreen(data: SpellModel) {
        with(binding) {
            spellNameLabel.text = data.spellName
            spellDescription.text = data.spellDescription
        }
    }
}