package com.namquangdev.kidlearningapp2021.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.namquangdev.kidlearningapp2021.R
import com.namquangdev.kidlearningapp2021.`interface`.ClickListener
import com.namquangdev.kidlearningapp2021.adapter.CollectionExerciseAdapter
import com.namquangdev.kidlearningapp2021.model.Collection
import kotlinx.android.synthetic.main.activity_play.*

class PlayActivity : AppCompatActivity(), ClickListener {
    private lateinit var adapterCollection: CollectionExerciseAdapter
    private lateinit var listCollectionData: ArrayList<Collection>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        setDataRecycleView()
        initData()
        initListener()
    }

    private fun initListener() {
        background_home.setOnClickListener {
            onBackPressed()
        }
        background_report.setOnClickListener {
            // send mail to development
        }
    }

    private fun initData() {
        adapterCollection = CollectionExerciseAdapter(this, listCollectionData, this)
        recycle_view_collection.setHasFixedSize(true)
        recycle_view_collection.adapter = adapterCollection

    }

    private fun setDataRecycleView() {
        listCollectionData = arrayListOf()
        listCollectionData.add(Collection(R.drawable.dog, "Animals", R.color.green))
        listCollectionData.add(Collection(R.drawable.abc, "Alphabet", R.color.yellow))
        listCollectionData.add(Collection(R.drawable.one, "Numbers", R.color.red))
        listCollectionData.add(Collection(R.drawable.trans, "Transport", R.color.orange))
        listCollectionData.add(Collection(R.drawable.fruits, "Fruits", R.color.purple))
        listCollectionData.add(Collection(R.drawable.ves, "Vegetable", R.color.blue2))
        listCollectionData.add(Collection(R.drawable.school, "School", R.color.blue))
        listCollectionData.add(Collection(R.drawable.sports2, "Sports", R.color.orange))
        listCollectionData.add(Collection(R.drawable.piano, "Instruments", R.color.black))
        listCollectionData.add(Collection(R.drawable.flag, "Country", R.color.yellow))
        listCollectionData.add(Collection(R.drawable.hat, "Clothes", R.color.brown))
        listCollectionData.add(Collection(R.drawable.bedroom, "BedRoom", R.color.purple))
    }

    override fun onClick(collection: Collection) {

    }
}