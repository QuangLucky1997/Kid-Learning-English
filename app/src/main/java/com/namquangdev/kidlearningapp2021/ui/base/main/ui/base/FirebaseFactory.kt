package com.namquangdev.kidlearningapp2021.ui.base.main.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.namquangdev.kidlearningapp2021.data.model.FirebaseRepository
import com.namquangdev.kidlearningapp2021.ui.base.main.ui.main.viewmodel.FirebaseViewModel


class FirebaseFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FirebaseViewModel::class.java)) {
            return FirebaseViewModel(FirebaseRepository()) as T
        }
        throw IllegalAccessException("Unknow class name")
    }
}