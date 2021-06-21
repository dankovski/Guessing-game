package com.example.baza


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fullscreen3.*



class FullscreenActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fullscreen3)

        var helper=DatabaseHelper(applicationContext)

        val cursor=helper.getRecord()
        if(cursor.moveToFirst()) {
            wynik1.text = "1. " + cursor.getString(1)
            wyn1.text=cursor.getString(2)
        }
        if(cursor.moveToNext()) {
            wynik2.text = "2. " + cursor.getString(1)
            wyn2.text=cursor.getString(2)
        }
        if(cursor.moveToNext()) {
            wynik3.text = "3. " + cursor.getString(1)
            wyn3.text=cursor.getString(2)
        }
        if(cursor.moveToNext()) {
            wynik4.text = "4. " + cursor.getString(1)
            wyn4.text=cursor.getString(2)
        }
        if(cursor.moveToNext()) {
                wynik5.text = "5. " + cursor.getString(1)
            wyn5.text=cursor.getString(2)
            }
        if(cursor.moveToNext()) {
            wynik6.text = "6. " + cursor.getString(1)
            wyn6.text=cursor.getString(2)
        }
        if(cursor.moveToNext()) {
            wynik7.text = "7. " + cursor.getString(1)
            wyn7.text=cursor.getString(2)
        }
        if(cursor.moveToNext()) {
            wynik8.text = "8. " + cursor.getString(1)
            wyn8.text=cursor.getString(2)
        }
        if(cursor.moveToNext()) {
            wynik9.text = "9. " + cursor.getString(1)
            wyn9.text=cursor.getString(2)
        }
        if(cursor.moveToNext()) {
            wynik10.text = "10. " + cursor.getString(1)
            wyn10.text=cursor.getString(2)
        }

        button6.setOnClickListener{
            super.finish()
        }

    }

    }

