package com.ex.lunchbox.ui.home

import android.app.LauncherActivity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ex.lunchbox.databinding.ListItemBinding
import com.ex.lunchbox.service.model.Item

class WorkListAdapter(private val lifecycleOwner: LifecycleOwner) :
    RecyclerView.Adapter<WorkListViewHolder>() {

    private var _workList: List<Item> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        binding.lifecycleOwner = lifecycleOwner
        return WorkListViewHolder(binding)
    }

    override fun getItemCount() = _workList.size

    override fun onBindViewHolder(holder: WorkListViewHolder, position: Int) {
        holder.setup(position, _workList[position])

    }

    fun setWorks(worklist: List<Item>) {
        this._workList = worklist
        notifyDataSetChanged()
    }

}


class WorkListViewHolder constructor(
    private val dataBinding: ListItemBinding
) : RecyclerView.ViewHolder(dataBinding.root) {
    fun setup(position: Int, item: Item) {
        dataBinding.position = position
        dataBinding.item = item
    }
}