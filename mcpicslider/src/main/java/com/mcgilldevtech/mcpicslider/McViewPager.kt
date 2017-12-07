package com.mcgilldevtech.mcpicslider

import android.content.Context
import android.content.Intent
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.widget.RelativeLayout
import android.widget.TextView


/**
 * Created by kevinmcgill on 12/5/17.
 */
class McViewPager : RelativeLayout, OnMcPicSliderImageTappedListener {

    lateinit var viewPager: ViewPager
    lateinit var pageIndicatorTextView: TextView

    var isFullScreen = false
    var useFullScreen = false

    var adapter: AbstractMcPicSliderAdapter
        set(value) {
            value.imageTappedListener = this
            viewPager.adapter = value
            notifyDataSetChanged()
        }
        get() = viewPager.adapter as AbstractMcPicSliderAdapter

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs){
        initView(context, attrs)
    }

    constructor(context: Context) : super(context) {
        initView(context)
    }

    private fun initView(context: Context, attrs: AttributeSet? = null) {
        if (attrs != null) {
            //TODO: Pass options via XML
        }

        inflate(context, R.layout.mcpicslider_layout, this) as RelativeLayout
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        pageIndicatorTextView = findViewById(R.id.textView)
        viewPager = findViewById(R.id.viewPager)
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                setPageIndicatorText(position)
            }
        })
    }

    fun notifyDataSetChanged() {
        setPageIndicatorText(viewPager.currentItem)
        viewPager.adapter?.notifyDataSetChanged()
    }

    fun setPageIndicatorText(position: Int) {
        val imagesCount = adapter.images.size
        val text = if (imagesCount > 0) "${position + 1}/${imagesCount}" else "0/0"
        pageIndicatorTextView.text = text
    }

    override fun onMcPicSliderImageTapped(position: Int, url: String) {
        if (!isFullScreen && useFullScreen) {
            val fullScreenMcPicSliderIntent = Intent(context, McPicSliderFullScreenActivity::class.java)
            fullScreenMcPicSliderIntent.putExtra(McPicSliderFullScreenActivity.McPicSliderFullScreenKeys.POSITION_KEY, position)
            fullScreenMcPicSliderIntent.putStringArrayListExtra(McPicSliderFullScreenActivity.McPicSliderFullScreenKeys.IMAGES_KEY, ArrayList<String>(adapter.images))
            context.startActivity(fullScreenMcPicSliderIntent)
        }
    }
}