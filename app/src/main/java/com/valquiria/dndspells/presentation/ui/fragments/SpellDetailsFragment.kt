package com.valquiria.dndspells.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.valquiria.dndspells.databinding.FragmentSpellDetailsBinding
import com.valquiria.dndspells.domain.model.SpellInfoModel
import com.valquiria.dndspells.presentation.ui.extension.onObserver
import com.valquiria.dndspells.presentation.ui.viewModel.SpellDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpellDetailsFragment : Fragment() {

    private lateinit var binding: FragmentSpellDetailsBinding

    private val viewModel: SpellDetailsViewModel by viewModel()

    //TODO private val args: SpellDetailsFragmentArgs by navArgs()

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
        setupObservables()
    }

    private fun setupObservables() {
        onObserver(viewModel.observableStatus) {
            configureScreen(it)
        }
    }

    private fun configureScreen(data: SpellInfoModel) {
        with(binding) {
            spellNameLabel.text = data.spellName
            spellDescription.text = data.spellDescription
        }
    }


}