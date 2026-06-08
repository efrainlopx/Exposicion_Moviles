package com.example.exposicion_moviles.data

import androidx.annotation.LayoutRes

data class Topic(
    val id: String,
    val number: Int,
    val buttonLabel: String,
    val title: String,
    val summary: String,
    val keyPoints: List<String>,
    val logicFiles: List<String>,
    val xmlFiles: List<String>,
    @LayoutRes val demoLayoutRes: Int,
)
