package com.example.dentaltechnicianhandbook.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dentaltechnicianhandbook.R

class AcrylicBridgeFragment : BaseFragment(R.layout.fragment_acrylic_bridge) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_acrylic_bridge, container, false)
    }

    override fun onResume() {
        super.onResume()
    }
}