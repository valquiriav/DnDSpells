package com.valquiria.dndspells.presentation.ui.spellListScreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.valquiria.dndspells.R
import com.valquiria.dndspells.data.database.entity.SpellEntity

class SpellListAdapter(
    private val spellList: MutableList<SpellEntity>
) : RecyclerView.Adapter<SpellListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_spell_list, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = spellList[position]

        holder.bindView(item)
    }

    override fun getItemCount(): Int = spellList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewSpellName: TextView = itemView.findViewById(R.id.spellName)

        fun bindView(spell: SpellEntity) {
            textViewSpellName.text = spell.spellName
        }
    }
}