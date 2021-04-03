package com.android.radworld.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.android.radworld.R


// single activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragmentMap()
    }
    private fun loadFragmentMap(){
        supportFragmentManager.commit {
            replace<FragmentMap>(R.id.fragmentContainerView)
        }
    }
}