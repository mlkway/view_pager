package com.raywenderlich.view_pager

import android.content.Context
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter

class CustomPagerAdapter(
    private val context: Context,
     private val  itemListener: ItemListener):PagerAdapter() {


    override fun getCount()= Images.values().size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`

    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, container,false)

        val img = view.findViewById<ImageView>(R.id.imgView)
        img.setImageResource(Images.values()[position].imgID)
        container.addView(view, 0)


        img.setOnClickListener {
            itemListener.imageListener(position)
        }
        return view

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(`object` as View)
    }

}