package com.example.dentaltechnicianhandbook

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dentaltechnicianhandbook.databinding.ContentItemBinding

class ContentActivity: AppCompatActivity(), View.OnClickListener {

private lateinit var binding: ContentItemBinding

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContentItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTitleContent2.text = intent.getStringExtra("title")
        binding.tvContent.text = intent.getStringExtra("content")
        binding.imageContent2.setImageResource(intent.getIntExtra("image", R.drawable.rem))

        binding.tvContent1.setOnClickListener(this)
        binding.tvContent2.setOnClickListener(this)
        binding.tvContent3.setOnClickListener(this)
        binding.tvContent4.setOnClickListener(this)
        binding.tvContent5.setOnClickListener(this)
        binding.tvContent6.setOnClickListener(this)

        when (intent.getStringExtra("title")) {
            getString(R.string.bridges) -> {
                binding.tvContent1.text = getString(R.string.acrylic_bridge)
                binding.tvContent2.text = getString(R.string.cast_bridge)
                binding.tvContent3.text = getString(R.string.met_cer_bridge)
                binding.tvContent4.text = getString(R.string.zir_bridge)
                binding.tvContent5.text = getString(R.string.cer_bridge)
                hide(1)
            }
            getString(R.string.crowns) -> {
                binding.tvContent1.text = getString(R.string.acrylic_crown)
                binding.tvContent2.text = getString(R.string.cast_crown)
                binding.tvContent3.text = getString(R.string.met_cer_crown)
                binding.tvContent4.text = getString(R.string.zir_crown)
                binding.tvContent5.text = getString(R.string.cer_crown)
                binding.tvContent6.text = getString(R.string.met_acrylic_crown)
            }
            getString(R.string.incl) -> {
                binding.tvContent1.text = getString(R.string.inlay)
                binding.tvContent2.text = getString(R.string.onlay)
                binding.tvContent3.text = getString(R.string.overlay)
                binding.tvContent4.text = getString(R.string.pinlay)
                hide(2)
            }
            getString(R.string.veneers_lumineers),
            getString(R.string.about_imp),
            getString(R.string.pr_imp),
            getString(R.string.imp),
            getString(R.string.quat),
            getString(R.string.about_cast_on_main),
            getString(R.string.neylon),
            getString(R.string.acry),
            getString(R.string.about_fix),
            getString(R.string.about_rem),
            getString(R.string.about_cla) -> {
                //тут не будет перехода на другой layout, так как нет выбора
                //сразу будет здесь контент показываться
                //или все-таки будет переход на layout, если будет реализован общий layout
                //для любого контента
                hide(6)
            }
            getString(R.string.cla) -> {
                binding.tvContent1.text = getString(R.string.clam)
                binding.tvContent2.text = getString(R.string.attach)
                binding.tvContent3.text = getString(R.string.teles)
                hide(3)
            }
            getString(R.string.plast) -> {
                binding.tvContent1.text = getString(R.string.part)
                binding.tvContent2.text = getString(R.string.whole)
                hide(4)
            }
        }
    }

    override fun onClick(v: View?) {
        val i = Intent(this, SeparateActivity::class.java)
        when (v?.id) {
            R.id.tvContent1 -> {
                when (intent.getStringExtra("title")) {
                    getString(R.string.bridges) -> {
                        Toast.makeText(this, "Пластмассовый мост", Toast
                            .LENGTH_SHORT)
                            .show()
                        i.putExtra("infoTest","Пластмассовый мост")
                        startActivity(i)
                    }
                    getString(R.string.crowns) -> {
                        Toast.makeText(this, "Пластмассовая коронка", Toast
                            .LENGTH_SHORT)
                            .show()
                        i.putExtra("infoTest","Пластмассовая коронка")
                        startActivity(i)
                    }
                    getString(R.string.incl) -> {
                        Toast.makeText(this, "InLay", Toast.LENGTH_SHORT)
                            .show()
                        i.putExtra("infoTest","InLay")
                        startActivity(i)
                    }
                    getString(R.string.cla) -> {
                        Toast.makeText(this, "На кламмерах", Toast.LENGTH_SHORT)
                            .show()
                        i.putExtra("infoTest","На кламмерах")
                        startActivity(i)
                    }
                    getString(R.string.plast) -> {
                        Toast.makeText(this, "Частичные", Toast.LENGTH_SHORT)
                            .show()
                        i.putExtra("infoTest","Частичные")
                        startActivity(i)
                    }
                }
            }
            R.id.tvContent2 -> {
                when (intent.getStringExtra("title")) {
                    getString(R.string.bridges) -> {
                        Toast.makeText(this, "Литой мост", Toast.LENGTH_SHORT)
                            .show()
                        i.putExtra("infoTest","Литой мост")
                        startActivity(i)
                    }
                    getString(R.string.crowns) -> {
                        Toast.makeText(this, "Цельнолитая коронка", Toast.LENGTH_SHORT)
                            .show()
                        i.putExtra("infoTest","Цельнолитая коронка")
                        startActivity(i)
                    }
                    getString(R.string.incl) -> {
                        Toast.makeText(this, "OnLay", Toast.LENGTH_SHORT)
                            .show()
                        i.putExtra("infoTest","OnLay")
                        startActivity(i)
                    }
                    getString(R.string.cla) -> {
                        Toast.makeText(this, "На аттачментах", Toast.LENGTH_SHORT)
                            .show()
                        i.putExtra("infoTest","На аттачментах")
                        startActivity(i)
                    }
                    getString(R.string.plast) -> {
                        Toast.makeText(this, "Полные", Toast.LENGTH_SHORT)
                            .show()
                        i.putExtra("infoTest","Полные")
                        startActivity(i)
                    }
                }
            }
            R.id.tvContent3 -> {
                when (intent.getStringExtra("title")) {
                    getString(R.string.bridges) -> {
                        Toast.makeText(this, "Металлокермический мост", Toast
                            .LENGTH_SHORT)
                            .show()
                        i.putExtra("infoTest","Металлокермический мост")
                        startActivity(i)
                    }
                    getString(R.string.crowns) -> {
                        Toast.makeText(this, "Металлокермическая коронка", Toast
                            .LENGTH_SHORT)
                            .show()
                        i.putExtra("infoTest","Металлокермическая коронка")
                        startActivity(i)
                    }
                    getString(R.string.incl) -> {
                        Toast.makeText(this, "OverLay", Toast.LENGTH_SHORT)
                            .show()
                        i.putExtra("infoTest","OverLay")
                        startActivity(i)
                    }
                    getString(R.string.cla) -> {
                        Toast.makeText(this, "На телескопических коронках", Toast
                            .LENGTH_SHORT)
                            .show()
                        i.putExtra("infoTest","На телескопических коронках")
                        startActivity(i)
                    }
                }
            }
            R.id.tvContent4 -> {
                when (intent.getStringExtra("title")) {
                    getString(R.string.bridges) -> {
                        Toast.makeText(this, "Циркониевый мост", Toast.LENGTH_SHORT)
                            .show()
                        i.putExtra("infoTest","Циркониевый мост")
                        startActivity(i)
                    }
                    getString(R.string.crowns) -> {
                        Toast.makeText(this, "Циркониевая коронка", Toast.LENGTH_SHORT)
                            .show()
                        i.putExtra("infoTest","Циркониевая коронка")
                        startActivity(i)
                    }
                    getString(R.string.incl) -> {
                        Toast.makeText(this, "PinLay", Toast.LENGTH_SHORT)
                            .show()
                        i.putExtra("infoTest","PinLay")
                        startActivity(i)
                    }
                }
            }
            R.id.tvContent5 -> {
                when (intent.getStringExtra("title")) {
                    getString(R.string.bridges) -> {
                        Toast.makeText(this, "Керамичесикий мост", Toast.LENGTH_SHORT)
                            .show()
                        i.putExtra("infoTest","Керамичесикий мост")
                        startActivity(i)
                    }
                    getString(R.string.crowns) -> {
                        Toast.makeText(this, "Керамичесикая коронка", Toast
                            .LENGTH_SHORT)
                            .show()
                        i.putExtra("infoTest","Керамичесикая коронка")
                        startActivity(i)
                    }
                }
            }
            R.id.tvContent6 -> {
                        Toast
                            .makeText(this, "Металлопластмассовая коронка",
                                Toast.LENGTH_SHORT)
                            .show()
                        i.putExtra("infoTest","Металлопластмассовая коронка")
                        startActivity(i)
            }
        }
    }

    private fun hide(number: Int) {
        val content = arrayListOf(
            binding.tvContent1,
            binding.tvContent2,
            binding.tvContent3,
            binding.tvContent4,
            binding.tvContent5,
            binding.tvContent6
        )
        val border = content.size - number
        for (i in (content.size - 1) downTo border) {
            content[i].visibility = GONE
        }
    }
}