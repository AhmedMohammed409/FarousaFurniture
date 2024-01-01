package com.example.farousa.fragments.show

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.farousa.databinding.RowBinding
import com.example.farousa.model.DataClassModel



class CutomerAdapter(private var listofData:MutableList<DataClassModel>,private var onItemClicked: (dataclick: DataClassModel) -> Unit) :
    Adapter<CutomerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listofData[position], onItemClicked)
    }


    override fun getItemCount(): Int {
        return listofData.size
    }

    inner class ViewHolder(private val binding: RowBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(item: DataClassModel, onItemClicked: (dataclick: DataClassModel) -> Unit) {
            binding.txtName.text = item.name
            binding.shapeableImageView.setImageResource(item.imageId)
            binding.root.setOnClickListener {
                onItemClicked(item)
            }

        }
    }


}

