package com.example.dofarm.SellCrops

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ScrollView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.dofarm.DataClass.AddCrop
import com.example.dofarm.R
import com.example.dofarm.databinding.ActivityDetailsToSellBinding

class Details_to_Sell : AppCompatActivity() {

    lateinit var binding : ActivityDetailsToSellBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsToSellBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if(AddCrop.addCropFlag){
            //if add crop is clicked then edit text will appear and text will disapppear
            //else reverse.

            binding.CropNameEdt.isVisible = true
            binding.CropNametxt.isVisible = false
        }else{
            binding.CropNameEdt.isVisible = false
            binding.CropNametxt.isVisible = true
        }


    }
}