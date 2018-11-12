package com.pelingulcinar.oxxoui.activities

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.pelingulcinar.oxxoui.CustomGridView
import com.pelingulcinar.oxxoui.ExpandableHeightGridView
import com.pelingulcinar.oxxoui.R
import com.pelingulcinar.oxxoui.adapters.MainGridViewAdapter
import com.pelingulcinar.oxxoui.adapters.MainViewPagerAdapter
import com.pelingulcinar.oxxoui.model.ItemDescriptionDTO
import com.pelingulcinar.oxxoui.model.ItemsDTO
import iammert.com.expandablelib.ExpandCollapseListener
import iammert.com.expandablelib.ExpandableLayout
import iammert.com.expandablelib.Section
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager
    var gridViewAdapter : MainGridViewAdapter? = null
    var kombinList = ArrayList<CustomGridView>()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById<ViewPager>(R.id.viewPager_main) as ViewPager
        val adapter = MainViewPagerAdapter(this)
        viewPager.adapter = adapter

        kombinList.add(CustomGridView(R.drawable.siyahcanta,"Bağlama Çanta","53,00TL"))
        kombinList.add(CustomGridView(R.drawable.boncukluayakkabi,"Boncuk Detaylı Ayakkabı","48,00TL"))
        kombinList.add(CustomGridView(R.drawable.siyahcantao,"Bağlama Çanta","53,00TL"))
        kombinList.add(CustomGridView(R.drawable.ayakkabi,"Boncuk Detaylı Ayakkabı","48,00TL"))

        gridViewAdapter = MainGridViewAdapter(this, kombinList)
        gridView.adapter = gridViewAdapter

        val mgridView  = findViewById<ExpandableHeightGridView>(R.id.gridView)
        mgridView.setAdapter(gridViewAdapter)
        mgridView.isExpanded = true


        val expandableLayout = findViewById<ExpandableLayout>(R.id.el)
        expandableLayout.setRenderer(object : ExpandableLayout.Renderer<ItemsDTO, ItemDescriptionDTO>{
            override fun renderChild(view: View?, description: ItemDescriptionDTO?, parentPosition: Int, childPosition: Int) {

                view?.findViewById<TextView>(R.id.tvChild)?.setText(description?.description)

            }

            override fun renderParent(view: View?, items: ItemsDTO?, isExpanded: Boolean, parentPosition: Int) {

                view?.findViewById<TextView>(R.id.tvParent)?.setText(items?.name)
                view?.findViewById<ImageView>(R.id.arrow)?.setImageResource(R.drawable.ic_baseline_keyboard_arrow_right_24px)

            }
        })

        expandableLayout.addSection(getSection())
        expandableLayout.addSection(getSection1())
        expandableLayout.addSection(getSection2())
        expandableLayout.addSection(getSection3())

        for(i in 0..3){
            val linearLayout = expandableLayout.getChildAt(i) as LinearLayout
            linearLayout.showDividers = LinearLayout.SHOW_DIVIDER_END
            val drawablee = GradientDrawable()
            drawablee.setColor(Color.GRAY)
            drawablee.setSize(4,2)
            linearLayout.dividerPadding = 22
            linearLayout.dividerDrawable = drawablee
        }

        expandableLayout.setExpandListener(object : ExpandCollapseListener.ExpandListener<ItemsDTO>{
            override fun onExpanded(parentIndex: Int, parent: ItemsDTO?, view: View?) {
                view?.findViewById<ImageView>(R.id.arrow)?.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24px)
            }
        })

        expandableLayout.setCollapseListener(object : ExpandCollapseListener.CollapseListener<ItemsDTO>{
            override fun onCollapsed(parentIndex: Int, parent: ItemsDTO?, view: View?) {
                view?.findViewById<ImageView>(R.id.arrow)?.setImageResource(R.drawable.ic_baseline_keyboard_arrow_right_24px)
            }
        })
    }

    fun getSection():Section<ItemsDTO,ItemDescriptionDTO>{

        val section = Section<ItemsDTO,ItemDescriptionDTO>()
        val title = ItemsDTO("Ürün Bilgisi")
        val desc1 = ItemDescriptionDTO("Desc 1")

        section.parent = title
        section.children.add(desc1)

        return section
    }

    fun getSection1(): Section<ItemsDTO,ItemDescriptionDTO> {

        val section = Section<ItemsDTO,ItemDescriptionDTO>()
        val title = ItemsDTO("Ürün Açıklaması")
        val desc1 = ItemDescriptionDTO("Desc 2")

        section.parent = title
        section.children.add(desc1)

        return section

    }

    fun getSection2(): Section<ItemsDTO,ItemDescriptionDTO> {

        val section = Section<ItemsDTO,ItemDescriptionDTO>()
        val title = ItemsDTO("İade ve Değişim")
        val desc2 = ItemDescriptionDTO("Desc 3")

        section.parent = title
        section.children.add(desc2)

        return section

    }

    fun getSection3(): Section<ItemsDTO,ItemDescriptionDTO> {

        val section = Section<ItemsDTO,ItemDescriptionDTO>()
        val title = ItemsDTO("Beden Tablosu")

        val desc3 = ItemDescriptionDTO("Desc 4")

        section.parent = title
        section.children.add(desc3)

        return section

    }
}






