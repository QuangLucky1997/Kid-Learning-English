package com.namquangdev.kidlearningapp2021.ui.base.main.ui.main.view

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import com.namquangdev.kidlearningapp2021.R
import com.namquangdev.kidlearningapp2021.`interface`.ClickListener
import com.namquangdev.kidlearningapp2021.adapter.CollectionExerciseAdapter
import com.namquangdev.kidlearningapp2021.data.model.Collection
import kotlinx.android.synthetic.main.activity_play.*
import kotlinx.android.synthetic.main.dialog.*

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
        listCollectionData.add(Collection(R.drawable.transport, "Transport", R.color.orange))
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
        showDialogChosen(collection)
    }


    private fun showDialogChosen(collection: Collection) {
        val viewDialog = View.inflate(this, R.layout.dialog, null)
        val dialog = Dialog(this, R.style.MyAlertDialogStyle)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val window = dialog.window
        window!!.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        window.setGravity(Gravity.CENTER)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(viewDialog)
        dialog.avt_dialog.setImageResource(collection.img)
        dialog.show()
    }
}