package com.example.baza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent



class FullscreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fullscreen)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val thread=Thread(){
            run{
                Thread.sleep(3000)
                val intent=Intent(this,FullscreenActivity2::class.java)
                startActivity(intent)
                super.finish()

            }
        }

        thread.start()
    }










}
