package com.namquangdev.kidlearningapp2021.data.model

import java.io.Serializable

data class English(
    val title: String = "",
    val learn: List<DataLearn>,
    val id: String = ""
) : Serializable