package com.pelingulcinar.oxxoui.activities

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pelingulcinar.oxxoui.CustomGridView
import com.pelingulcinar.oxxoui.R
import com.pelingulcinar.oxxoui.adapters.MainGridViewAdapter
import com.pelingulcinar.oxxoui.adapters.MainRecyclerViewAdapter
import com.pelingulcinar.oxxoui.adapters.MainViewPagerAdapter
import com.pelingulcinar.oxxoui.model.ItemDescriptionDTO
import com.pelingulcinar.oxxoui.model.ItemsDTO
import com.pelingulcinar.oxxoui.model.RvListDTO
import iammert.com.expandablelib.ExpandCollapseListener
import iammert.com.expandablelib.ExpandableLayout
import iammert.com.expandablelib.Section
import kotlinx.android.synthetic.main.activity_main.*
import me.relex.circleindicator.CircleIndicator


class MainActivity : AppCompatActivity() {

    val mainViewPagerAdapter by lazy { MainViewPagerAdapter(this) }
    val kombinList by lazy { ArrayList<CustomGridView>() }
    val gridViewAdapter by lazy { MainGridViewAdapter(this, kombinList) }
    val rvList by lazy { ArrayList<String>()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager_main.adapter = mainViewPagerAdapter
        val indicator = findViewById<CircleIndicator>(R.id.indicator)
        indicator.setViewPager(viewPager_main)

        kombinList.add(CustomGridView(R.drawable.siyahcanta, "Bağlama Çanta", "53,00TL"))
        kombinList.add(CustomGridView(R.drawable.boncukluayakkabi, "Boncuk Detaylı Ayakkabı", "48,00TL"))
        kombinList.add(CustomGridView(R.drawable.siyahcantao, "Bağlama Çanta", "53,00TL"))
        kombinList.add(CustomGridView(R.drawable.ayakkabi, "Boncuk Detaylı Ayakkabı", "48,00TL"))

        with(gridView) {
            adapter = gridViewAdapter
            isExpanded = true

        }

        with(el) {

            setRenderer(object : ExpandableLayout.Renderer<ItemsDTO, ItemDescriptionDTO> {
                override fun renderChild(view: View?, description: ItemDescriptionDTO?, parentPosition: Int, childPosition: Int) {

                    view?.findViewById<TextView>(R.id.tvChild)?.setText(description?.description)

                }

                override fun renderParent(view: View?, items: ItemsDTO?, isExpanded: Boolean, parentPosition: Int) {

                    view?.findViewById<TextView>(R.id.tvParent)?.setText(items?.name)
                    view?.findViewById<ImageView>(R.id.arrow)?.setImageResource(R.drawable.ic_baseline_keyboard_arrow_right_24px)

                }
            })

            addSection(getSection("Ürün Bilgisi", "Ürün Bilgisi Desc"))
            addSection(getSection("Ürün Açıklaması", "Ürün Açıklaması Desc"))
            addSection(getSection("İade ve Değişim", "İade ve Değişim Desc"))
            addSection(getSection("Beden Tablosu", "Beden Tablosu Desc"))

            setExpandListener(object : ExpandCollapseListener.ExpandListener<ItemsDTO> {
                override fun onExpanded(parentIndex: Int, parent: ItemsDTO?, view: View?) {
                    view?.findViewById<ImageView>(R.id.arrow)?.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24px)
                }
            })

            setCollapseListener(object : ExpandCollapseListener.CollapseListener<ItemsDTO> {
                override fun onCollapsed(parentIndex: Int, parent: ItemsDTO?, view: View?) {
                    view?.findViewById<ImageView>(R.id.arrow)?.setImageResource(R.drawable.ic_baseline_keyboard_arrow_right_24px)
                }
            })
        }

        txtXS.setOnClickListener{

            checkStateTextImage(it as TextView)
        }

        txtS.setOnClickListener{

            checkStateTextImage(it as TextView)
        }

        txtM.setOnClickListener{

            checkStateTextImage(it as TextView)
        }

        txtL.setOnClickListener{

            checkStateTextImage(it as TextView)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)

        val feed = ArrayList<RvListDTO>()

        feed.add(RvListDTO("Askılı Bağlamalı Çanta","53,00TL", R.drawable.ayakkabi))
        feed.add(RvListDTO("Boncuk Detaylı Ayakkabı","48,00TL", R.drawable.siyahcantao))
        feed.add(RvListDTO("Askılı Bağlamalı Çanta","53,00TL", R.drawable.boncukluayakkabi))
        feed.add(RvListDTO("Boncuk Detaylı Ayakkabı","48,00TL", R.drawable.ayakkabi))


        val adapter = MainRecyclerViewAdapter(feed)
        recyclerView.adapter = adapter
    }

    private fun checkStateTextImage(textView : TextView){

        defaultText(txtXS)
        defaultText(txtS)
        defaultText(txtM)
        defaultText(txtL)

        if(textView.currentTextColor == Color.BLACK){

            textView.setBackgroundColor(Color.BLACK)
            textView.setTextColor(Color.WHITE)
        }
    }

    private fun defaultText(textView : TextView){

        textView.setBackgroundColor(Color.WHITE)
        textView.setTextColor(Color.BLACK)
    }

    fun getSection(name: String, description: String): Section<ItemsDTO, ItemDescriptionDTO> {

        return with(Section<ItemsDTO, ItemDescriptionDTO>()) {

            parent = ItemsDTO(name)
            children.add(ItemDescriptionDTO(description))
            this
        }
    }
}






