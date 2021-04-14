package io.github.sekar0106.arummart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.datepicker.MaterialCalendar.newInstance
import javax.xml.datatype.DatatypeFactory.newInstance
import javax.xml.parsers.DocumentBuilderFactory.newInstance

class HalamanPertama : AppCompatActivity() {

    lateinit var tvHlmPertama: TextView
    lateinit var btnnext: Button

    lateinit var prefUtil: PreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_pertama)

        prefUtil = PreferenceUtil.newInstance(this)

        if (!prefUtil.getBoolean("is_login")){
            val intentMainActivity = Intent(this, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(intentMainActivity)
        }
        tvHlmPertama = findViewById(R.id.tv_hlm_pertm)
        btnnext = findViewById(R.id.btn_next)

        updateData()

        btnnext.setOnClickListener {
            val intentHalamanKedua = Intent(this, HalamanKedua::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
            startActivity(intentHalamanKedua)
        }
    }

    private fun updateData() {
        val username = prefUtil.getString("username")
        val halamanPertamaMessage = "Selamat Datang, $username"
        tvHlmPertama.text = halamanPertamaMessage
        if (username.isNullOrEmpty()){
            tvHlmPertama.visibility = View.GONE
        } else{
            tvHlmPertama.visibility = View.VISIBLE
        }

        }
    }

