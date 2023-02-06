package com.wappit.quicklauncher.presentation.viewholder

import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.wappit.quicklauncher.databinding.ListitemUrlBinding
import com.wappit.quicklauncher.presentation.model.UrlViewModel

class UrlItemViewHolder(
    private val binding: ListitemUrlBinding,
    private val listener: MutableLiveData<UrlViewModel>
): ViewHolder(binding.root) {

    fun bind (url: UrlViewModel) {
        binding.viewModel = url
        binding.root.setOnClickListener {
            listener.postValue(url)
        }
    }
}