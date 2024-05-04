package com.example.dofarm.Cart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dofarm.DataClass.Cart_Data
import com.example.dofarm.R
import com.example.dofarm.RecyclerViews.CartRecyclerView
import com.example.dofarm.databinding.ActivityCartBinding

class MyCart_Host : AppCompatActivity() {

    lateinit var binding: ActivityCartBinding
    lateinit var fragmentManager : FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var viewPager = binding.tabviewpager
        var tabLayout = binding.tabs

        var viewPagerAdapter = TabViewPage(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter

        // It is used to join TabLayout with ViewPager.
        tabLayout.setupWithViewPager(viewPager)


        fragmentManager = supportFragmentManager




    }
}