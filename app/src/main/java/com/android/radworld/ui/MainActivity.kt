package com.android.radworld.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.android.radworld.R
import com.android.radworld.ui.anomalyMap.AnomalyMapFragment

// single activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragmentMap()
    }

    private fun loadFragmentMap(){
        supportFragmentManager.commit {
            add<AnomalyMapFragment>(R.id.fragmentContainerView)
        }
    }
}