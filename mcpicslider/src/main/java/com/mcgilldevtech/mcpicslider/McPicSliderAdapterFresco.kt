package com.mcgilldevtech.mcpicslider

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView


/**
 * Created by kevinmcgill on 12/5/17.
 */
class McPicSliderAdapterFresco(context: Context,
                               images: List<String> = listOf(),
                               private val onImageTapped: (position: Int, url: String) -> Unit = { pos, url -> }) : AbstractMcPicSliderAdapter(context, images) {

    init {
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(context)
            Fresco.getImagePipeline().clearCaches()
        }
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = layoutInflater.inflate(R.layout.fresco_item, container, false)
        container.addView(itemView)

        val simpleDraweeView = itemView.findViewById<SimpleDraweeView>(R.id.simpleDraweeView) as SimpleDraweeView

        val url = images[position]
        simpleDraweeView.setImageURI(Uri.parse(url), null)

        //listening to image click
        simpleDraweeView.setOnClickListener(View.OnClickListener {

            // Let the outside word know an image was tapped
            //
            onImageTapped(position, url)

            // Let McViewPager know an image was tapped
            //
            imageTappedListener?.onMcPicSliderImageTapped(position = position, url = url)
        })

        return itemView
    }
}