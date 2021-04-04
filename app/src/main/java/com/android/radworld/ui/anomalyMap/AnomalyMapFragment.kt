package com.android.radworld.ui.anomalyMap

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.android.radworld.R
import com.android.radworld.databinding.FragmentMapBinding
import com.google.android.libraries.maps.GoogleMap
import com.google.android.libraries.maps.OnMapReadyCallback
import com.google.android.libraries.maps.SupportMapFragment

class AnomalyMapFragment : Fragment(R.layout.fragment_map), OnMapReadyCallback {
    private lateinit var binding: FragmentMapBinding
    private var map: GoogleMap? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentMapBinding.bind(view)
        createMap()

        // some code

    }

    private fun createMap() {
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.fragmentContainerViewMap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(gmap: GoogleMap?) {
        map = gmap

        // some code

        /**
         * Далее, наверное надо получить местоположение пользователя, а потом как то расчетами
         * раскидать вокруг пользователя аномалии кругами. Эту обработку лучше во вью модель переносить.
         */

    }

}