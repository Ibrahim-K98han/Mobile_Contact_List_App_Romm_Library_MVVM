package com.ibrahim.contactapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ibrahim.contactapp.databinding.ContactRowBinding

class ContactAdapter(val callback:(ContactDB)->Unit):ListAdapter<ContactDB,ContactAdapter.ContactViewHolder>(ContactDiffUtil()) {

    class ContactViewHolder(val binding: ContactRowBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(contactDB: ContactDB){
            binding.contact = contactDB
        }
    }
    class ContactDiffUtil:DiffUtil.ItemCallback<ContactDB>(){
        override fun areItemsTheSame(oldItem: ContactDB, newItem: ContactDB): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ContactDB, newItem: ContactDB): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ContactRowBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = getItem(position)
        holder.bind(contact)
        holder.binding.detailsBtn.setOnClickListener {
            callback(contact)
        }
    }
}