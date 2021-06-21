package com.example.baza

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_fullscreen2.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_fullscreen3.*
import kotlin.random.Random




class MainActivity : AppCompatActivity() {
    var num = 0
    var chance = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       var login = getIntent().getStringExtra("loginek")

        roundNumber()
        button.setOnClickListener {
            roundNumber()
            textView2.text=" "
            Toast.makeText(applicationContext, "Wylosowano nową liczbę", Toast.LENGTH_SHORT)
                .show()
        }

        button2.setOnClickListener {
            var inputValue = textView.text.toString()
            if (!inputValue.isNullOrEmpty()) {
                if (!inputValue.isNullOrEmpty() && inputValue.toInt() < 20 && inputValue.toInt() > 0) {
                    chance++
                    if (num == inputValue.toInt()) {
                        dialogShow()
                       var helper=DatabaseHelper(applicationContext)
                       helper.addData(login.toString(), chance)
                    }
                    else {
                        if (num > inputValue.toInt()) {
                            textView2.text = "WIECEJ! Strzeliłeś już " + chance.toString()
                        }
                        else {
                            textView2.text = "MNIEJ! Strzeliłeś już " + chance.toString()
                        }
                        if(chance>10){
                            roundNumber()
                            Toast.makeText(applicationContext, "Przegrałeś! Wylosowano nową liczbę...", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
                else {
                    Toast.makeText(applicationContext,"Liczba powinna być z przedziału <0,20>",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
                textView.setText("")
            }
            else {
                Toast.makeText(applicationContext,"Liczba powinna być z przedziału <0,20>", Toast.LENGTH_SHORT
                )
                    .show()
            }

        }

        button5.setOnClickListener{
            textView.setText("")
            textView2.text=" "
            roundNumber()
            val intent= Intent(this,FullscreenActivity3::class.java)
            startActivity(intent)
        }

        button4.setOnClickListener{
            super.finish()
        }

    }

    private fun roundNumber() {
        num = Random.nextInt(0, 20)
        chance = 0
    }

    private fun dialogShow() {
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Wygrałeś")
        builder.setMessage("Udało Ci się za " + chance.toString() + " podejściem!")
        builder.setPositiveButton("Super") { dialog, which ->
            Toast.makeText(applicationContext, "Wylosowano nową liczbę", Toast.LENGTH_SHORT)
                .show()
            roundNumber()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()

    }



}

