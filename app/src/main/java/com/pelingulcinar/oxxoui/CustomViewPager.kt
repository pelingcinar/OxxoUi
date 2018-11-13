package com.pelingulcinar.oxxoui

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager


class CustomViewPager @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : ViewPager(context, attrs) {

    private var isPagingEnabled = true

    override fun onTouchEvent(event: MotionEvent): Boolean = this.isPagingEnabled && super.onTouchEvent(event)

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean = this.isPagingEnabled && super.onInterceptTouchEvent(event)

    fun setPagingEnabled(b: Boolean) = with(this) { isPagingEnabled = b }
}