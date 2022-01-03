package com.namquangdev.kidlearningapp2021.ui.base.main.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.namquangdev.kidlearningapp2021.data.model.DataLearn
import com.namquangdev.kidlearningapp2021.data.model.FirebaseRepository

class FirebaseViewModel(private val firebaseRepository: FirebaseRepository) : ViewModel() {
    fun getLearnEnglish(titleEnglish: String): LiveData<MutableList<DataLearn>> {
        val mutableListLearn = MutableLiveData<MutableList<DataLearn>>()
        firebaseRepository.getLearnFirebase(titleEnglish)
            .observeForever { learnList -> mutableListLearn.value = learnList }
        return mutableListLearn
    }
}