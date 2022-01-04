package com.namquangdev.kidlearningapp2021.ui.base.main.ui.main.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.namquangdev.kidlearningapp2021.R
import com.namquangdev.kidlearningapp2021.adapter.AdapterSlideLearn
import com.namquangdev.kidlearningapp2021.ui.base.main.ui.base.FirebaseFactory
import com.namquangdev.kidlearningapp2021.ui.base.main.ui.main.viewmodel.FirebaseViewModel
import kotlinx.android.synthetic.main.activity_learn.*

class LearnActivity : AppCompatActivity() {
    private lateinit var firebaseViewModel: FirebaseViewModel
    private lateinit var learnAdapter: AdapterSlideLearn
    private var titleDataLearn: String? = null
    private val viewModelLearn by lazy {
        ViewModelProviders.of(this)[FirebaseViewModel::class.java]
    }


    companion object {
        const val LEARN = "learn"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn)
        titleDataLearn = intent.getStringExtra(LEARN).toString()
        setUPRecycleViewLearn()
        setUpViewModel()
        setUpObserver()
    }

    private fun setUpViewModel() {
        val firebaseViewModelFactory = FirebaseFactory()
        firebaseViewModel =
            ViewModelProvider(this, firebaseViewModelFactory)[FirebaseViewModel::class.java]

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setUpObserver() {
        viewModelLearn.getLearnEnglish(titleDataLearn!!).observe(this, {
            learnAdapter.setDataRecycleView(it)
            learnAdapter.notifyDataSetChanged()
        })
    }

    private fun setUPRecycleViewLearn() {
        learnAdapter = AdapterSlideLearn(this)
        viewPaperLearn.adapter=learnAdapter
    }
}