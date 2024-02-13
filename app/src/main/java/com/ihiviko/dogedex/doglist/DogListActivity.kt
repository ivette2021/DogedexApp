package com.ihiviko.dogedex.doglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ihiviko.dogedex.Dog
import com.ihiviko.dogedex.DogAdapter
import com.ihiviko.dogedex.DogListViewModel
import com.ihiviko.dogedex.R
import com.ihiviko.dogedex.databinding.ActivityDogListBinding

class DogListActivity : AppCompatActivity() {

    private val dogListViewModel: DogListViewModel by viewModels() //instaciamos el vm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler = binding.dogRecycler
        val adapter = DogAdapter()
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)

        dogListViewModel.dogList.observe(this){
            dogList ->
            adapter.submitList(dogList)
        }
    }
}
