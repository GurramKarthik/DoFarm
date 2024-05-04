package com.example.dofarm.RecyclerViews

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dofarm.DataClass.Cart_Data
import com.example.dofarm.R
import com.example.dofarm.SoldDetails

class CartRecyclerView(
   var context: Context,
    var list : List<Cart_Data>
) :RecyclerView.Adapter<CartRecyclerView.CartViewHandler>()
{

    inner class CartViewHandler(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHandler {
        var layout = LayoutInflater.from(context).inflate(R.layout.cart_recycler_layout,parent,false)
        return CartViewHandler(layout)

    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: CartViewHandler, position: Int) {
        holder.itemView.apply{
            var CropName = findViewById<TextView>(R.id.soldCropName)
            var status = findViewById<TextView>(R.id.cropStatus)
            var amount = findViewById<TextView>(R.id.cropAmount)
            var date = findViewById<TextView>(R.id.dateSold)

            CropName.text = list[position].cropName
            amount.text = list[position].amount.toString()
            date.text = list[position].date

            var detail = findViewById<Button>(R.id.cartViewDetails)

            detail.setOnClickListener{

                var soldDetails = Intent(context, SoldDetails::class.java)
                context.startActivity(soldDetails)

            }



        }
    }
}