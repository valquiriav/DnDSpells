package com.valquiria.dndspells.presentation.ui.spellListScreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.valquiria.dndspells.R
import com.valquiria.dndspells.data.remote.response.Spell

class SpellListAdapter : RecyclerView.Adapter<SpellListAdapter.ViewHolder>() {

    var onItemClick: ((Spell) -> Unit)? = null
    private val listOfItems = arrayListOf<Spell>()

    fun addItems(list: List<Spell>): List<Spell> {
        listOfItems.clear()
        listOfItems.addAll(list)
        notifyDataSetChanged()

        return list
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item_spell, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listOfItems[position]

        holder.bind(item)
    }


    override fun getItemCount(): Int = listOfItems.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewSpellName: TextView? = itemView.findViewById(R.id.spellName)

        fun bind(spell: Spell) {
            textViewSpellName?.text = spell.name
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(listOfItems[adapterPosition])
            }
        }
    }
}