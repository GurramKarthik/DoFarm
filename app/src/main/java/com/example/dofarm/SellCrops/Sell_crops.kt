package com.example.dofarm.SellCrops

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dofarm.DataClass.AddCrop
import com.example.dofarm.RecyclerViews.CropRecyclerView
import com.example.dofarm.DataClass.Crops_details
import com.example.dofarm.R
import com.example.dofarm.databinding.SellCropsBinding

class Sell_crops : AppCompatActivity() {

    private lateinit var binding: SellCropsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SellCropsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var sellCrop = Intent(this, Details_to_Sell::class.java)

        binding.addCropbtn.setOnClickListener {
            AddCrop.addCropFlag = true
            startActivity(sellCrop)

        }

        var cropsInHand = mutableListOf<Crops_details>(
            Crops_details("Sugar-cane", R.drawable.crop_img),
            Crops_details("Paddy", R.drawable.dofarm),
            Crops_details("Mirchi", R.drawable.profile_pic2),
            Crops_details("Peas", R.drawable.app_icon),

        )


        var CropsInHandAdaptor = CropRecyclerView(this,cropsInHand, Details_to_Sell::class.java)
        binding.CropsInHandRecycler.layoutManager = LinearLayoutManager(this)
        binding.CropsInHandRecycler.adapter = CropsInHandAdaptor



    }
}