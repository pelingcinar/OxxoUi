package com.pelingulcinar.oxxoui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pelingulcinar.oxxoui.R
import com.pelingulcinar.oxxoui.model.RvListDTO

class MainRecyclerViewAdapter (val RvList : ArrayList<RvListDTO>) : RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> () {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent?.context).inflate(R.layout.items_recyclerview, parent, false)

        return MainRecyclerViewAdapter.ViewHolder(v)

    }

    override fun getItemCount(): Int {

        return RvList.size

    }

    override fun onBindViewHolder(holder: MainRecyclerViewAdapter.ViewHolder, position: Int) {

        val kombin = holder.itemView.findViewById<TextView>(R.id.txtRecyclerKombin)
        val kombinCost = holder.itemView.findViewById<TextView>(R.id.txtKombinRecyclerFiyat)
        val imgLink = holder.itemView.findViewById<ImageView>(R.id.imgRecycler)


        /*imgLink.setImageResource(R.drawable.ayakkabi)
        imgLink.setImageResource(R.drawable.ayakkabi)
        imgLink.setImageResource(R.drawable.ayakkabi)
        imgLink.setImageResource(R.drawable.ayakkabi)*/


        kombin.text = RvList[position].desc
        kombinCost.text = RvList[position].cost
        //imgLink.text = RvList[position].imgLink
        Glide.with(holder.itemView)
                .load(RvList[position].imgLink)
                .into(imgLink)

    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        val kombin = view.findViewById<TextView>(R.id.txtRecyclerKombin)
        val kombinCost = view.findViewById<TextView>(R.id.txtKombinRecyclerFiyat)
        val imgLink = view.findViewById<ImageView>(R.id.imgRecycler)



    }

}