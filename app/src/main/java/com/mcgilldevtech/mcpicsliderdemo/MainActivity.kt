package com.mcgilldevtech.mcpicsliderdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import com.mcgilldevtech.mcpicslider.McPicSliderAdapterFresco
import com.mcgilldevtech.mcpicslider.McViewPager

class MainActivity : AppCompatActivity() {

    lateinit var adpater1: McPicSliderAdapterFresco
    lateinit var adapter2: McPicSliderAdapterFresco

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adpater1 = McPicSliderAdapterFresco(
                context = this,
                onImageTapped = { position, url ->
                    Toast.makeText(this, "You clicked image " + (position + 1), Toast.LENGTH_SHORT).show()
                },
                images = listOf(
                    "http://www.petmd.com/sites/default/files/scared-kitten-shutterstock_191443322.jpg",
                    "http://www.petmd.com/sites/default/files/hypoallergenic-cat-breeds.jpg",
                    "https://d4n5pyzr6ibrc.cloudfront.net/media/27FB7F0C-9885-42A6-9E0C19C35242B5AC/4785B1C2-8734-405D-96DC23A6A32F256B/thul-90efb785-97af-5e51-94cf-503fc81b6940.jpg?response-content-disposition=inline"
                )
        )

        adapter2 = McPicSliderAdapterFresco(
                context = this,
                onImageTapped = { position, url ->
                    Toast.makeText(this, "You clicked image " + (position + 1), Toast.LENGTH_SHORT).show()
                },
                images = listOf(
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Cat_eating_a_rabbit.jpeg/220px-Cat_eating_a_rabbit.jpeg",
                    "http://sites.psu.edu/siowfa15/wp-content/uploads/sites/29639/2015/10/cat.jpg",
                    "https://i.ytimg.com/vi/72NfSwCzFVE/hqdefault.jpg"
                )
        )

        val mcPicSlider = findViewById<McViewPager>(R.id.mcViewPager)
        mcPicSlider.useFullScreen = true // Default: False. If true, you must declare McPicSliderFullScreenActivity in your manifest
        mcPicSlider.adapter = adpater1


        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            mcPicSlider.adapter = if (mcPicSlider.adapter == adpater1) adapter2 else adpater1
        }
    }
}
