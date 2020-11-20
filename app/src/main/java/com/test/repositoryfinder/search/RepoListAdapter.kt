package com.test.repositoryfinder.search

import Items
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.repositoryfinder.R

class RepoListAdapter: RecyclerView.Adapter<RepoListAdapter.ItemViewHolder>() {

    private var items: ArrayList<Items> = ArrayList()

    fun setData(list: List<Items>){
        items.clear()
        items.addAll(list)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var repoNameTv: TextView? = null
        var starsCountTv: TextView? = null

        init {
            repoNameTv = itemView.findViewById(R.id.repoNameTv)
            starsCountTv = itemView.findViewById(R.id.starsCountTv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.repoNameTv?.text = items[position].name
        holder.starsCountTv?.text = items[position].stargazers_count.toString()
    }
}