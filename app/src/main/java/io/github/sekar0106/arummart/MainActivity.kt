package io.github.sekar0106.arummart

import android.content.Intent
import android.media.ImageReader.newInstance
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.reflect.Array.newInstance
import javax.xml.datatype.DatatypeFactory.newInstance
import javax.xml.transform.TransformerFactory.newInstance

class MainActivity : AppCompatActivity() {

    lateinit var etUsername: EditText
    lateinit var etPassword: EditText
    lateinit var btnSubmit: Button

    lateinit var prefUtil: PreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefUtil = PreferenceUtil.newInstance(this)

        etUsername = findViewById(R.id.et_user_name)
        etPassword = findViewById(R.id.et_password)
        btnSubmit = findViewById(R.id.btn_login)

        etUsername.setText(prefUtil.getString("username"))
        btnSubmit.setOnClickListener {

            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            saveData()

            if (username.isEmpty()|| password.isEmpty()) {
                Toast.makeText(this, "Please Insert Name and Nim", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intentHalamanPertama = Intent(this, HalamanPertama::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(intentHalamanPertama)
        }
    }

    private fun saveData() {
        val username = etUsername.text.toString().trim()
        prefUtil.setString("username", username)
        prefUtil.setBoolean("is_login", true)
    }
}