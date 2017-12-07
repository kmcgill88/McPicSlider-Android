package com.mcgilldevtech.mcpicslider

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

/**
 * Created by kevinmcgill on 12/5/17.
 */
abstract class AbstractMcPicSliderAdapter(val context: Context, var images: List<String> = listOf()) : PagerAdapter() {

    protected val layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    var imageTappedListener: OnMcPicSliderImageTappedListener? = null

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        throw NotImplementedError("You must override override: 'fun instantiateItem(container: ViewGroup?, position: Int): Any'")
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}