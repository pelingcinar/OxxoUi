package com.pelingulcinar.oxxoui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.pelingulcinar.oxxoui.CustomGridView
import com.pelingulcinar.oxxoui.R
import kotlinx.android.synthetic.main.custom_gridview_layout.view.*
import java.util.*

class MainGridViewAdapter(val context: Context, val kombinList: ArrayList<CustomGridView>) : BaseAdapter() {

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {

        val kombin = kombinList[position]
        val inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        return with(inflator.inflate(R.layout.custom_gridview_layout, null)) {

            imgKombin1.setImageResource(kombin.image)
            txtKombinDetay.text = kombin.descp
            txtKombinFiyat.text = kombin.cost

            this
        }
    }

    override fun getItem(position: Int): Any = kombinList[position]
    override fun getItemId(position: Int): Long = position.toLong()
    override fun getCount(): Int = kombinList.size
}