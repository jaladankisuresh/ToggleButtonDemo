package com.imnotout.togglebuttondemo

import android.support.v7.widget.RecyclerView
import android.transition.ChangeBounds
import android.transition.Transition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.item_accordion_view.view.*

/**
 * Created by Suresh Jaladanki on 20-02-2018.
 */
class AccordionItemAdapter(val collection: List<String>): RecyclerView.Adapter<AccordionItemAdapter.AccordionItemViewHolder>() {
    private lateinit var mRecyclerView: RecyclerView
//    val transition: ChangeBounds = ChangeBounds()
//    init {
//        transition.setDuration(500)
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccordionItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_accordion_view, parent,false)
        return AccordionItemViewHolder(view)
    }
    override fun getItemCount(): Int = collection.size
    override fun onBindViewHolder(holder: AccordionItemViewHolder, position: Int) = holder.bind(position, collection[position])
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)

        mRecyclerView = recyclerView
    }

    inner class AccordionItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(position: Int, item: String) {
            view.tgle_section_header.run {
                text = item
                textOn = item
                textOff = item
                setCompoundDrawablesWithIntrinsicBounds( 0, 0, R.drawable.ic_expand_more_black_18dp, 0)
                setOnCheckedChangeListener { buttonView, isChecked ->
                    val viewHolder = this@AccordionItemViewHolder
                    if(isChecked) {
                        viewHolder.showExpandedView(buttonView, isChecked)
                        collapseOtherViews(position)
                    }
                    else viewHolder.showCollapsedView(buttonView, isChecked)

//                    TransitionManager.beginDelayedTransition(mRecyclerView as ViewGroup, transition)
                    TransitionManager.beginDelayedTransition(mRecyclerView as ViewGroup)
                }
            }
        }
        private fun collapseOtherViews(position: Int) {
            collection.indices.filter { it != position }.forEach {
                val accordionViewHolder = mRecyclerView.findViewHolderForAdapterPosition(it) as AccordionItemViewHolder
                accordionViewHolder.view.tgle_section_header.run {
                    if(isChecked) setChecked(false)
                }
            }
        }
        private fun showExpandedView(buttonView: CompoundButton, isChecked: Boolean) {
            view.lyt_section_body.visibility = View.VISIBLE
            buttonView.setCompoundDrawablesWithIntrinsicBounds( 0, 0, R.drawable.ic_expand_less_black_18dp, 0)
        }
        private fun showCollapsedView(buttonView: CompoundButton, isChecked: Boolean) {
            view.lyt_section_body.visibility = View.GONE
            buttonView.setCompoundDrawablesWithIntrinsicBounds( 0, 0, R.drawable.ic_expand_more_black_18dp, 0)
        }
    }
}