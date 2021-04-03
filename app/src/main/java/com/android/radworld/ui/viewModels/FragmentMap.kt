package com.android.radworld.ui.viewModels

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker.PERMISSION_GRANTED
import androidx.fragment.app.Fragment
import com.android.radworld.R
import com.android.radworld.databinding.FragmentMapBinding
import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.GoogleMap
import com.google.android.libraries.maps.SupportMapFragment
import com.google.android.libraries.maps.model.LatLng

private const val LOCATION_PERMISSION_CODE = 1

class FragmentMap : Fragment() {
    private var binding: FragmentMapBinding? = null
    private var map: GoogleMap? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBinding.bind(inflater.inflate(R.layout.fragment_map, container, false))
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createMap()
    }

    private fun createMap() {
        val mapFragment =
            requireActivity().supportFragmentManager.findFragmentById(R.id.fragmentContainerViewMap) as? SupportMapFragment
        mapFragment?.run {
            getMapAsync { initMap(it) }
        }
    }

    private fun initMap(m: GoogleMap) {
        map = m.apply {
            if (checkLocationPermission()) {
                val startLocation = LatLng(myLocation.latitude, myLocation.longitude)
                isMyLocationEnabled = true
                val cameraLocation = CameraUpdateFactory.newLatLngZoom(startLocation, 15f)
                moveCamera(cameraLocation)
            } else {
                askLocationPermission()
            }
        }
    }

    private fun checkLocationPermission() =
        ContextCompat.checkSelfPermission(
            context as Context,
            ACCESS_FINE_LOCATION
        ) == PERMISSION_GRANTED

    private fun askLocationPermission() {
        ActivityCompat.requestPermissions(
            requireActivity().parent,
            arrayOf(ACCESS_FINE_LOCATION),
            LOCATION_PERMISSION_CODE
        )
    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == LOCATION_PERMISSION_CODE && grantResults[0] == PERMISSION_GRANTED) {
            map?.isMyLocationEnabled = true
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}