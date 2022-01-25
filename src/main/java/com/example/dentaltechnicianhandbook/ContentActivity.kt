package com.example.dentaltechnicianhandbook

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dentaltechnicianhandbook.content.info1images
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
        binding.tvContent6.setOnClickListener(this)

        when (intent.getStringExtra("title")) {
            /* Главная */
            getString(R.string.imp) -> {
                hide(6)
                supportFragmentManager.beginTransaction().replace(R.id.information, info1images.newInstance()).commit()
            }
            getString(R.string.cad_cam) -> {
            }
            getString(R.string.cer_main) -> {
            }
            getString(R.string.rem_full) -> {
            }
            getString(R.string.rem_part) -> {
            }
            getString(R.string.fix) -> {
            }
            getString(R.string.cast_main) -> {
            }
            getString(R.string.material) -> {
            }
            /* Полные съёмные */
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
            getString(R.string.about_cast_on_main),
            getString(R.string.quat),
            getString(R.string.neylon),
            getString(R.string.acry), -> {
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
            R.id.tvContent1 -> when (intent.getStringExtra("title")) {
                getString(R.string.bridges) -> {
                    Toast.makeText(this, getString(R.string.acrylic_bridge), Toast
                        .LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.acrylic_bridge))
                    startActivity(i)
                }
                getString(R.string.crowns) -> {
                    Toast.makeText(this, getString(R.string.acrylic_crown), Toast
                        .LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.acrylic_crown))
                    startActivity(i)
                }
                getString(R.string.incl) -> {
                    Toast.makeText(this, getString(R.string.inlayShort), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.inlayShort))
                    startActivity(i)
                }
                getString(R.string.cla) -> {
                    Toast.makeText(this, getString(R.string.clam), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.clam))
                    startActivity(i)
                }
                getString(R.string.plast) -> {
                    Toast.makeText(this, getString(R.string.part), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.part))
                    startActivity(i)
                }
            }
            R.id.tvContent2 -> when (intent.getStringExtra("title")) {
                getString(R.string.bridges) -> {
                    Toast.makeText(this, getString(R.string.cast_bridge), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.cast_bridge))
                    startActivity(i)
                }
                getString(R.string.crowns) -> {
                    Toast.makeText(this, getString(R.string.cast_crown), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.cast_crown))
                    startActivity(i)
                }
                getString(R.string.incl) -> {
                    Toast.makeText(this, getString(R.string.onlayShort), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.onlayShort))
                    startActivity(i)
                }
                getString(R.string.cla) -> {
                    Toast.makeText(this, getString(R.string.attach), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.attach))
                    startActivity(i)
                }
                getString(R.string.plast) -> {
                    Toast.makeText(this, getString(R.string.whole), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.whole))
                    startActivity(i)
                }
            }
            R.id.tvContent3 -> when (intent.getStringExtra("title")) {
                getString(R.string.bridges) -> {
                    Toast.makeText(this, getString(R.string.met_cer_bridge), Toast
                        .LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.met_cer_bridge))
                    startActivity(i)
                }
                getString(R.string.crowns) -> {
                    Toast.makeText(this, getString(R.string.met_cer_crown), Toast
                        .LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.met_cer_crown))
                    startActivity(i)
                }
                getString(R.string.incl) -> {
                    Toast.makeText(this, getString(R.string.overlayShort), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest",getString(R.string.overlayShort))
                    startActivity(i)
                }
                getString(R.string.cla) -> {
                    Toast.makeText(this, getString(R.string.teles), Toast
                        .LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.teles))
                    startActivity(i)
                }
            }
            R.id.tvContent4 -> when (intent.getStringExtra("title")) {
                getString(R.string.bridges) -> {
                    Toast.makeText(this, getString(R.string.zir_bridge), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.zir_bridge))
                    startActivity(i)
                }
                getString(R.string.crowns) -> {
                    Toast.makeText(this, getString(R.string.zir_crown), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.zir_crown))
                    startActivity(i)
                }
                getString(R.string.incl) -> {
                    Toast.makeText(this, getString(R.string.pinlayShort), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.pinlayShort))
                    startActivity(i)
                }
            }
            R.id.tvContent5 -> when (intent.getStringExtra("title")) {
                getString(R.string.bridges) -> {
                    Toast.makeText(this, getString(R.string.cer_bridge), Toast.LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.cer_bridge))
                    startActivity(i)
                }
                getString(R.string.crowns) -> {
                    Toast.makeText(this, getString(R.string.cer_crown), Toast
                        .LENGTH_SHORT)
                        .show()
                    i.putExtra("infoTest", getString(R.string.cer_crown))
                    startActivity(i)
                }
            }
            R.id.tvContent6 -> {
                        Toast
                            .makeText(this, getString(R.string.met_cer_bridge),
                                Toast.LENGTH_SHORT)
                            .show()
                        i.putExtra("infoTest", getString(R.string.met_acrylic_crown))
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
        for (i in (content.size - 1) downTo border) content[i].visibility = GONE
    }
}