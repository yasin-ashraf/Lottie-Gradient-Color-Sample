package com.example.lottiegradient

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieDrawable
import com.airbnb.lottie.LottieProperty
import com.airbnb.lottie.model.KeyPath
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //for multi layer json
//        multipleLayers()

        //for single layer json
        singleLayer()
    }

    /**
     * for " sprint_gr.json " file
     * Look for layers[] in json file shared, select the keypath accordingly for each shape
     * for eg this lottie file has 6 shapes - Shape Layer 1, Shape Layer 2, Shape Layer 3.... shape Layer 6
     * for each key path name look for 'nm' in json
    **/
    private fun multipleLayers() {
        val color1 = Color.parseColor("#FF4FCE")
        val color2 = Color.parseColor("#C91CFF")

        animation_view.apply {
            repeatCount = LottieDrawable.INFINITE
            repeatMode = LottieDrawable.RESTART
            speed = 0.5f
            addValueCallback(
                KeyPath("Shape Layer 6", "Shape 1", "Gradient Fill 1"),
                LottieProperty.GRADIENT_COLOR,
                {
                    arrayOf(color2, color2, color1)
                })
            addValueCallback(
                KeyPath("Shape Layer 5", "Shape 1", "Gradient Fill 1"),
                LottieProperty.GRADIENT_COLOR,
                {
                    arrayOf(color2, color1, color1)
                })
            addValueCallback(
                KeyPath("Shape Layer 4", "Shape 1", "Gradient Fill 1"),
                LottieProperty.GRADIENT_COLOR,
                {
                    arrayOf(color2, color1, color1)
                })
            addValueCallback(
                KeyPath("Shape Layer 3", "Shape 1", "Gradient Fill 1"),
                LottieProperty.GRADIENT_COLOR,
                {
                    arrayOf(color2, color1, color1)
                })
            addValueCallback(
                KeyPath("Shape Layer 2", "Shape 1", "Gradient Fill 1"),
                LottieProperty.GRADIENT_COLOR,
                {
                    arrayOf(color2, color1, color1)
                })
            addValueCallback(
                KeyPath("Shape Layer 1", "Ellipse 1", "Gradient Fill 1"),
                LottieProperty.GRADIENT_COLOR,
                {
                    arrayOf(color2, color1, color1)
                })


        }
        animation_view.playAnimation()
    }

    /**
     *  for " single_gr.json " file
     **/
    private fun singleLayer() {
        val color1 = Color.parseColor("#FF4FCE")
        val color2 = Color.parseColor("#C91CFF")

        animation_view.apply {
            repeatCount = LottieDrawable.INFINITE
            repeatMode = LottieDrawable.RESTART
            speed = 0.4f
            addValueCallback(
                KeyPath("Shape Layer 1", "Rectangle 1", "Gradient Fill 1"),
                LottieProperty.GRADIENT_COLOR,
                {
                    arrayOf(color2, color1, color2)
                })
        }
        animation_view.playAnimation()

    }

}