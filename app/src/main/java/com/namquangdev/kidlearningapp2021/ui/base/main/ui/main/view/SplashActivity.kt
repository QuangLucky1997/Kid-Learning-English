package com.namquangdev.kidlearningapp2021.ui.base.main.ui.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.namquangdev.kidlearningapp2021.R
import com.namquangdev.kidlearningapp2021.adapter.SliderAdapter
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : AppCompatActivity() {
    private lateinit var sliderAdapter: SliderAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val images = intArrayOf(
            R.drawable.schoolbg,
            R.drawable.chlidrenbg,
            R.drawable.animabg,
            R.drawable.abc2
        )
        sliderAdapter = SliderAdapter(images)
        image_slider.setSliderAdapter(sliderAdapter)
        image_slider.setIndicatorAnimation(IndicatorAnimationType.WORM)
        image_slider.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
        image_slider.startAutoCycle()
        initListener()

    }

    private fun initListener() {
        background_play.setOnClickListener {
            val intentMain = Intent(this, PlayActivity::class.java)
            startActivity(intentMain)
        }
    }
}