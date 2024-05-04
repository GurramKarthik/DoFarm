package com.example.dofarm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dofarm.DOFarm.Implementation
import com.example.dofarm.DataClass.Crops_details
import com.example.dofarm.RecyclerViews.CropRecyclerView
import com.example.dofarm.SellCrops.Sell_crops
import com.example.dofarm.databinding.ActivityMyPlantsBinding

class My_Plants : AppCompatActivity() {

    private lateinit var binding: ActivityMyPlantsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyPlantsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var cropsList = mutableListOf<Crops_details>(
            Crops_details("Crop1", R.drawable.dofarm , ),
            Crops_details("Crop2" , R.drawable.sellcrop),
            Crops_details("Crop3", R.drawable.cart),
            Crops_details("Crop4" , R.drawable.profile_pic2),
            Crops_details("Crop5" , R.drawable.profile_pic2),
            Crops_details("Crop6" , R.drawable.profile_pic2),
            Crops_details("Crop3", R.drawable.cart),
            Crops_details("Crop4" , R.drawable.profile_pic2),
            Crops_details("Crop5" , R.drawable.profile_pic2),
        )




        var Current_Planting = CropRecyclerView(this, cropsList , Implementation::class.java)

        binding.myPlantsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.myPlantsRecyclerView.adapter = Current_Planting
        binding.sellCropsbtn.setOnClickListener {
            var sellcrops = Intent(this, Sell_crops::class.java)
            startActivity(sellcrops)
        }


    }


}