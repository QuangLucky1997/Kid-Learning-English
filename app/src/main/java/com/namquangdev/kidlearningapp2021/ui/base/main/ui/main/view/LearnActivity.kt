package com.namquangdev.kidlearningapp2021.ui.base.main.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.namquangdev.kidlearningapp2021.R

class LearnActivity : AppCompatActivity() {

    companion object{
        const val LEARN="learn"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn)
    }
}