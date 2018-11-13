package com.pelingulcinar.oxxoui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.pelingulcinar.oxxoui.R

class MainViewPagerAdapter(private val context: Context) : PagerAdapter() {

    private val images = arrayOf(R.drawable.hmgo, R.drawable.hmgoepprod)

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view === `object`
    override fun getCount(): Int = images.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return with(layoutInflater.inflate(R.layout.custom_layout, null)){

            val image = findViewById<ImageView>(R.id.imageView)
            image.setImageResource(images[position])

            container.addView(this,0)

            this
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(`object` as View)
        super.destroyItem(container, position, `object`)
    }
}