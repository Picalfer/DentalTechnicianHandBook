package com.example.dentaltechnicianhandbook.content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.dentaltechnicianhandbook.DataModel
import com.example.dentaltechnicianhandbook.R
import com.example.dentaltechnicianhandbook.databinding.FragmentInfoContentBinding

class InfoContent : Fragment() {

    private lateinit var b: FragmentInfoContentBinding
    private val dataModel:DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b = FragmentInfoContentBinding.inflate(inflater)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.kind.observe(activity as LifecycleOwner) {
            when(it) {
                getString(R.string.imp) -> {
                    b.testTv.text = "1"
                    b.testIm.setImageResource(R.drawable.imp)
                }
                getString(R.string.cad_cam) -> {
                    b.testTv.text = "2"
                    b.testIm.setImageResource(R.drawable.cad_cam)
                }
            }

        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = InfoContent()
    }
}