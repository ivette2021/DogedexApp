package com.ihiviko.dogedex.dogdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ihiviko.dogedex.R
import com.ihiviko.dogedex.databinding.ActivityDogDetailBinding

class DogDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}