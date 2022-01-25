package com.example.dentaltechnicianhandbook.content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dentaltechnicianhandbook.R

class info1images : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info1images, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = info1images()
    }
}