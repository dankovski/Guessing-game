package com.example.baza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fullscreen2.*



class FullscreenActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fullscreen2)
        button3.setOnClickListener {

            if(!editText2.text.isNullOrEmpty()) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("loginek", editText2.text.toString())
                startActivity(intent)
            }
        }


    }


    }

