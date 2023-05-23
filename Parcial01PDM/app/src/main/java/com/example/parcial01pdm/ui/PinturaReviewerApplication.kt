package com.example.parcial01pdm.ui

import android.app.Application
import com.example.parcial01pdm.repositories.PinturaRepository
import com.example.parcial01pdm.data.pinturas


class PinturaReviewerApplication Application() {
    val pinturaRepository: PinturaRepository by lazy {
        PinturaRepository(pinturas)
    }
}