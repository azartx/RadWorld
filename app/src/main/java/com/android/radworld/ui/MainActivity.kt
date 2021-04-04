package com.android.radworld.ui

import android.Manifest.permission.ACCESS_FINE_LOCATION
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.android.radworld.R
import com.android.radworld.databinding.ActivityMainBinding
import com.android.radworld.ui.anomalyMap.AnomalyMapFragment

// single activity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        getLocationPermission() // если юзер не разрешит доступ, то будет эксэпшн
        loadFragmentMap()
        fragmentsNavListening()
    }

    private fun loadFragmentMap(){
        supportFragmentManager.commit {
            add<AnomalyMapFragment>(R.id.fragmentContainerView)
        }
    }

    // слушает нажатия по нижней менюшке
    private fun fragmentsNavListening() {
        binding.navMenu.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.nav_map_global -> true
                else -> false
            }
        }
    }

    // запрос разрешения на отслеживание геолокации.
    // так понимаю, если есть реквэст код, значит куда то результат приходит выбора.
    // в таком случае, можно проверить, какую кнопку нажал юзер, и обработать.
    private fun getLocationPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(ACCESS_FINE_LOCATION), 1000)
    }

}