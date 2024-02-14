package com.ihiviko.dogedex.doglist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ihiviko.dogedex.Dog
import com.ihiviko.dogedex.databinding.DogListItemBinding


class DogAdapter : ListAdapter<Dog, DogAdapter.DogViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Dog>(){

        //comparar elementos en la lista y determinar si han cambiado-----------
        override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean {
                return oldItem.id == newItem.id
            }
        //-----------------------------------------------------------------------
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val binding = DogListItemBinding.inflate(LayoutInflater.from(parent.context)) //inflamos la vista
       return DogViewHolder(binding)
    }

    override fun onBindViewHolder(dogViewHolder: DogViewHolder, position: Int) { //pintando el viewholder
        val dog = getItem(position)
        dogViewHolder.bind(dog)
    }

    //crear viewholder
    inner class DogViewHolder(private val binding: DogListItemBinding): RecyclerView.ViewHolder(binding.root){

        //pintamos la vista
        fun bind(dog: Dog){
            binding.dogName.text = dog.name //texto seteado xml no esta texto asociado
        }
    }
}