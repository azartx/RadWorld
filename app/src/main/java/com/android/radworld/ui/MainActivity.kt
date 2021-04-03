package com.android.radworld.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.radworld.R

// single activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}