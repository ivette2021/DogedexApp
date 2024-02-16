package com.ihiviko.dogedex.doglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call.Details
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ihiviko.dogedex.api.responses.ApiResponseStatus
import com.ihiviko.dogedex.databinding.ActivityDogListBinding
import com.ihiviko.dogedex.dogdetail.DogDetailActivity
import com.ihiviko.dogedex.dogdetail.DogDetailActivity.Companion.DOG_KEY

class DogListActivity : AppCompatActivity() {

    private val dogListViewModel: DogListViewModel by viewModels() //instaciamos el vm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loadingWheel = binding.loadingWheel

        val recycler = binding.dogRecycler
        recycler.layoutManager = LinearLayoutManager(this)
        val adapter = DogAdapter()

        adapter.setOnItemClickListener {
            //pasar el dog a DogDetailActivity el objeto debe ser parcelable para pasar entre activity
            val intent = Intent(this, DogDetailActivity::class.java)
            intent.putExtra(DOG_KEY, it)
            startActivity(intent)
        }

        recycler.adapter = adapter


        dogListViewModel.dogList.observe(this) { dogList ->
            adapter.submitList(dogList)
        }
        dogListViewModel.status.observe(this) { status ->
            when (status){
                is ApiResponseStatus.Error ->{
                    //ocultar el progressbar
                    loadingWheel.visibility = View.GONE
                    Toast.makeText(this, status.messageId, Toast.LENGTH_SHORT).show()
                }
                is ApiResponseStatus.Loading->loadingWheel.visibility = View.VISIBLE
                is ApiResponseStatus.Success ->{
                    //ocultar el progressbar
                    loadingWheel.visibility = View.GONE
                }
            }
        }
    }
}
