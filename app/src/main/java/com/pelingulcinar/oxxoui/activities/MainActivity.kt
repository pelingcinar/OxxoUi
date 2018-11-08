package com.pelingulcinar.oxxoui.activities

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.pelingulcinar.oxxoui.R
import com.pelingulcinar.oxxoui.adapters.MainViewPagerAdapter

class MainActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById<ViewPager>(R.id.viewPager_main) as ViewPager
        val adapter = MainViewPagerAdapter(this)
        viewPager.adapter = adapter
        

    }
    
}




