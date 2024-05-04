package com.example.dofarm.DOFarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dofarm.RecyclerViews.CropRecyclerView
import com.example.dofarm.DataClass.Crops_details
import com.example.dofarm.R

class DoFarm : AppCompatActivity()  {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_do_farm)

        val seasonsSpinner = findViewById<Spinner>(R.id.seasonsSpinner)
        val seasonsAdopter = ArrayAdapter(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            arrayOf("</Seasons/>", "Summer", "Rainy", "Winter")
        )
        seasonsSpinner.adapter = seasonsAdopter



        val landsSpinner = findViewById<Spinner>(R.id.landSpinner)
        val landsAdopter = ArrayAdapter(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            arrayOf("</Land/>", "Red Fertile Soil", "Black Fiertle Soil")
        )
        landsSpinner.adapter = landsAdopter



        val seecropsbtn = findViewById<Button>(R.id.seecropbtn)
        var recyclerView = findViewById<RecyclerView>(R.id.CropsRecyclerView)


        seecropsbtn.setOnClickListener {
            if (seasonsSpinner.selectedItem is String && !seasonsSpinner.selectedItem.toString()
                    .equals("</Seasons/>") &&
                landsSpinner.selectedItem is String && !landsSpinner.selectedItem.toString()
                    .equals("</Land/>")
            ) {


                recyclerView.isVisible = true

//                Toast.makeText(
//                    this,
//                    "${seasonsSpinner.selectedItem}  ${landsSpinner.selectedItem}",
//                    Toast.LENGTH_SHORT
//                ).show()

            } else {
                Toast.makeText(this, "Select correct items", Toast.LENGTH_SHORT).show()

            }
        }




        recyclerView.layoutManager = LinearLayoutManager(this)


         var cropsList = mutableListOf<Crops_details>(

             Crops_details("Crop1", R.drawable.dofarm, ),
             Crops_details("Crop2" , R.drawable.sellcrop),
             Crops_details("Crop3", R.drawable.cart),
             Crops_details("Crop4" , R.drawable.profile_pic2),
             Crops_details("Crop5" , R.drawable.profile_pic2),
            Crops_details("Crop6" , R.drawable.profile_pic2)

             )




        val cropRecylerView = CropRecyclerView(this, cropsList, Details_of_Crop::class.java )
        recyclerView.adapter = cropRecylerView


    }
}