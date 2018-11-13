package com.pelingulcinar.oxxoui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.GridView


class ExpandableHeightGridView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttrs: Int = 0) : GridView(context, attrs, defStyleAttrs) {

    var isExpanded = false

    public override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (isExpanded) {

            val expandSpec = View.MeasureSpec.makeMeasureSpec(View.MEASURED_SIZE_MASK, View.MeasureSpec.AT_MOST)
            super.onMeasure(widthMeasureSpec, expandSpec)

            val params = layoutParams
            params.height = measuredHeight

        } else {

            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }
}