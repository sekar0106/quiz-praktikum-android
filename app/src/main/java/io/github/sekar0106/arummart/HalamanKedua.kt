package io.github.sekar0106.arummart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HalamanKedua : AppCompatActivity() {

    private lateinit var btnfragment1: Button
    private lateinit var btnfragment2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_kedua)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        btnfragment1 = findViewById(R.id.btnFragment1)
        btnfragment2 = findViewById(R.id.btnFragment2)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, firstFragment)
            commit()
        }

        btnfragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, firstFragment)
                addToBackStack(null)
                commit()
            }
        }

        btnfragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, secondFragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}