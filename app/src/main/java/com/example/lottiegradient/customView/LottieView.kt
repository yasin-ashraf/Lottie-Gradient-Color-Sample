package com.example.lottiegradient.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import com.airbnb.lottie.LottieCompositionFactory
import com.airbnb.lottie.LottieDrawable
import com.airbnb.lottie.LottieProperty
import com.airbnb.lottie.model.KeyPath
import com.example.lottiegradient.R


class LottieView : View {

    private var lottieDrawable: LottieDrawable? = null

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrSet: AttributeSet?) : super(context, attrSet) {
        init()
    }

    constructor(context: Context?, attrSet: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrSet,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        val color1 = Color.parseColor("#FF4FCE")
        val color2 = Color.parseColor("#C91CFF")

        lottieDrawable = LottieDrawable()
        lottieDrawable.let {
            it?.callback = this
            it?.repeatCount = LottieDrawable.INFINITE
            it?.addAnimatorUpdateListener { invalidate() }
            it?.addValueCallback(
                KeyPath("Shape Layer 1", "Rectangle 1", "Gradient Fill 1"),
                LottieProperty.GRADIENT_COLOR,
                {
                    arrayOf(color2, color1, color2)
                })

        }
        LottieCompositionFactory.fromRawRes(
            context.applicationContext,
            R.raw.single_gr
        ).addListener {
            lottieDrawable!!.composition = it
        }
        lottieDrawable!!.start()

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        lottieDrawable!!.draw(canvas)
    }
}