package com.namquangdev.kidlearningapp2021.data.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FirebaseRepository {

    fun getLearnFirebase(title: String): LiveData<MutableList<DataLearn>> {
        val mutableLearn = MutableLiveData<MutableList<DataLearn>>()
        val learnListData = mutableListOf<DataLearn>()
        val dataLearn = FirebaseDatabase.getInstance().reference
        val learnEnglish = dataLearn.child("LearningEnglish").orderByChild("title").equalTo(title)
        learnEnglish.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (snapShotLearn in snapshot.children) {
                        val learns = snapShotLearn.child("learn")
                        for (i in learns.children) {
                            val name = i.child("name").getValue(String::class.java) ?: ""
                            val url = i.child("url").getValue(String::class.java) ?: ""
                            learnListData.add(DataLearn(name, url))
                            Log.d("Main12345", "Id: $name --- url: $url")
                        }
                    }
                    mutableLearn.value = learnListData
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
        return mutableLearn
    }
}