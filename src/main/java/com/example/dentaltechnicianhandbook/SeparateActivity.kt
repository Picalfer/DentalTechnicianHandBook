package com.example.dentaltechnicianhandbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dentaltechnicianhandbook.databinding.ActivitySeparateBinding
import com.example.dentaltechnicianhandbook.fragments.AcrylicBridgeFragment
import com.example.dentaltechnicianhandbook.fragments.CastBridgeFragment

class SeparateActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySeparateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeparateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        when(intent.getStringExtra("infoTest")) {
            "Пластмассовый мост" -> {
                supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.dataContainer, AcrylicBridgeFragment()).commit()
            }
            "Литой мост" -> {
                supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.dataContainer, CastBridgeFragment()).commit()
            }
        }
    }
}