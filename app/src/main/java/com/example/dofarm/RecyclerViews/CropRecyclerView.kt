package com.example.dofarm.RecyclerViews

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.dofarm.DataClass.AddCrop
import com.example.dofarm.DataClass.Crops_details
import com.example.dofarm.R

class CropRecyclerView(
    var context: Context,
    var cropsList: List<Crops_details>,
    var cls : Class<*>
    ): RecyclerView.Adapter<CropRecyclerView.CropViewHolder>() {

    inner class CropViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CropViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.display_crops, parent , false)
        return CropViewHolder(view)


    }

    override fun getItemCount(): Int {
        return  cropsList.size
    }

    override fun onBindViewHolder(holder: CropViewHolder, position: Int) {

        holder.itemView.apply {

            var cropName = findViewById<TextView>(R.id.cropNameTxt)
            var cropImg = findViewById<ImageView>(R.id.cropImgView)
            var recyclerCardView = findViewById<CardView>(R.id.RecyclerCardView)

            cropName.text = cropsList[position].CropName
            cropImg.setImageResource(  cropsList[position].CropImg )


            var intent = Intent(context, cls)

            recyclerCardView.setOnClickListener{
                AddCrop.addCropFlag = false
                context.startActivity(intent)

            }

        }

    }
}