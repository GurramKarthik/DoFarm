package com.example.dofarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dofarm.DataClass.Market_data
import com.example.dofarm.RecyclerViews.MarketRecyclerView

class MarketPrice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market_price)

        var marketRecy = findViewById<RecyclerView>(R.id.marketRecyclerView)
        marketRecy.layoutManager = LinearLayoutManager(this)

        var marketArray = mutableListOf<Market_data>(
            Market_data(R.drawable.crop_img, "Crop Name", "20", "/Kg"),
            Market_data(R.drawable.crop_img, "Crop Name", "20","/dozen"),
            Market_data(R.drawable.crop_img, "Crop Name", "20", "/Kg"),
            Market_data(R.drawable.crop_img, "Crop Name", "20", "/Kg"),
            Market_data(R.drawable.crop_img, "Crop Name", "20", "/Kg"),
            Market_data(R.drawable.crop_img, "Crop Name", "20", "/Kg"),
        )

        var adaptor = MarketRecyclerView(this, marketArray)
        marketRecy.adapter = adaptor




    }
}