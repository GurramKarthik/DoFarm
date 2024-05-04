package com.example.dofarm.Cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dofarm.DataClass.Cart_Data
import com.example.dofarm.R
import com.example.dofarm.RecyclerViews.CartRecyclerView


class Sold : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var layout = inflater.inflate(R.layout.fragment_sold, container, false)

        var  recyclerView = layout.findViewById<RecyclerView>(R.id.cartRecyclerView)

        recyclerView.layoutManager = LinearLayoutManager(requireActivity())

        var cartList = mutableListOf<Cart_Data>(
            Cart_Data("Tomota", 400000,"23-04-2024"),
            Cart_Data("potato", 500000,"23-04-2024"),
            Cart_Data("weate", 600000,"23-04-2024"),
            Cart_Data("Paddy", 700000,"23-04-2024")

        )

        var adaptor = CartRecyclerView(requireActivity(), cartList)
        recyclerView.adapter = adaptor


        return layout
    }


}