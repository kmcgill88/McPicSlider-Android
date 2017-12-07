package com.mcgilldevtech.mcpicslider

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat


/**
 * Created by kevinmcgill on 12/6/17.
 */
class McPicSliderFullScreenActivity : Activity() {

    object McPicSliderFullScreenKeys {
        val POSITION_KEY = "POSITION_KEY"
        val IMAGES_KEY = "IMAGES_KEY"
    }

    var position = 0
    var images = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt(McPicSliderFullScreenKeys.POSITION_KEY)
            images = savedInstanceState.getStringArrayList(McPicSliderFullScreenKeys.IMAGES_KEY)
        } else {
            position = intent.extras.getInt(McPicSliderFullScreenKeys.POSITION_KEY)
            images = intent.extras.getStringArrayList(McPicSliderFullScreenKeys.IMAGES_KEY)
        }

        setContentView(R.layout.mcpicslider_fullscreen_layout)

        val mcPicSlider = findViewById<McViewPager>(R.id.mcPicSliderFullScreenMcViewPager)
        mcPicSlider.setBackgroundColor(Color.BLACK)
        mcPicSlider.pageIndicatorTextView.setTextColor(Color.WHITE)
        mcPicSlider.isFullScreen = true
        mcPicSlider.adapter = McPicSliderAdapterFresco(
                context = this,
                onImageTapped = { _, _ ->
                    // Exit Full Screen
                    //
                    finish()
                },
                images = images
        )

        mcPicSlider.viewPager.setCurrentItem(position, true)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        if (outState != null) {
            outState.putInt(McPicSliderFullScreenKeys.POSITION_KEY, position)
            outState.putStringArrayList(McPicSliderFullScreenKeys.IMAGES_KEY, images)
        }
    }
}