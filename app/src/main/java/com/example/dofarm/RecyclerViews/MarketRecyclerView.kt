package com.example.dofarm.RecyclerViews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dofarm.DataClass.Market_data
import com.example.dofarm.R

class MarketRecyclerView (
    var context : Context,
    var list : List<Market_data>

):RecyclerView.Adapter<MarketRecyclerView.MarketViewHolder>(){

    inner class MarketViewHolder(itemVIew: View) : RecyclerView.ViewHolder(itemVIew)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketViewHolder {
        var layout = LayoutInflater.from(context).inflate(R.layout.market_layout, parent, false)
        return MarketViewHolder(layout)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MarketViewHolder, position: Int) {
        holder.itemView.apply {
            var cropimag = findViewById<ImageView>(R.id.img)
            var crpName = findViewById<TextView>(R.id.crpName)
            var amount  = findViewById<TextView>(R.id.amount)
            var type = findViewById<TextView>(R.id.type)

            cropimag.setImageResource(list[position].img)
            crpName.text = list[position].cropname
            amount.text = list[position].amount
            type.text = list[position].quntityType

        }
    }


}