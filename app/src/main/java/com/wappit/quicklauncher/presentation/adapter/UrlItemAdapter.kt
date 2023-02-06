package com.wappit.quicklauncher.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.wappit.quicklauncher.databinding.ListitemUrlBinding
import com.wappit.quicklauncher.presentation.model.UrlViewModel
import com.wappit.quicklauncher.presentation.viewholder.UrlItemViewHolder

class UrlItemAdapter(
    private val listener: MutableLiveData<UrlViewModel>
): Adapter<UrlItemViewHolder>(), BindableAdapter<List<UrlViewModel>> {
    private var urlList: MutableList<UrlViewModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UrlItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListitemUrlBinding.inflate(inflater, parent, false)
        return UrlItemViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: UrlItemViewHolder, position: Int) {
        holder.bind(urlList[position])
    }

    override fun getItemCount() = urlList.size

    override fun setData(data: List<UrlViewModel>) {
        val initialListSize = urlList.size
        urlList.clear()
        notifyItemRangeRemoved(0, initialListSize)
        urlList.addAll(data)
        notifyItemRangeInserted(0, data.count())
    }
}