package com.sundaydavid.materialdesignfun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.setContentView

class AnkoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AnkoActivityUi().setContentView(this)
    }
}