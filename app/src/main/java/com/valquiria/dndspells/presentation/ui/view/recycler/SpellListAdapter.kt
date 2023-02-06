package com.valquiria.dndspells.presentation.ui.view.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.valquiria.dndspells.databinding.RecyclerViewItemSpellBinding
import com.valquiria.dndspells.domain.model.SpellModel
import com.valquiria.dndspells.presentation.ui.fragments.SpellListFragmentDirections

class SpellListAdapter : RecyclerView.Adapter<SpellListAdapter.SpellListViewHolder>() {

    private val listOfItems = arrayListOf<SpellModel>()

    fun addItems(list: List<SpellModel>): List<SpellModel> {
        listOfItems.clear()
        listOfItems.addAll(list)
        notifyDataSetChanged()

        return list
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SpellListViewHolder {
        return SpellListViewHolder(
            RecyclerViewItemSpellBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: SpellListViewHolder,
        position: Int
    ) {
        val item = listOfItems[position]
        with(holder.binding) {
            spellName.text = item.spellName
            root.setOnClickListener {
                it.findNavController().navigate(
                    SpellListFragmentDirections
                        .actionSpellListFragmentToSpellDetailsFragment(item.spellIndex)
                )
            }
        }
    }

    override fun getItemCount(): Int = listOfItems.size

    inner class SpellListViewHolder(val binding: RecyclerViewItemSpellBinding) :
        RecyclerView.ViewHolder(binding.root)
}