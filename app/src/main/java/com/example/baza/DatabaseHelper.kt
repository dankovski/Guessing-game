package com.example.baza

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context?) :    SQLiteOpenHelper(context, "tabeleczka", null, 1) {


    private val TABLE_NAME = "tab"
    private val COL1 = "nazwa"
    private val COL2 = "wynik"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL1 + " TEXT, " + COL2 + " INTEGER )")

    }

    override fun onUpgrade(db: SQLiteDatabase, i: Int, i1: Int) {
        db.execSQL("DROP IF TABLE EXISTS $TABLE_NAME")
        onCreate(db)
    }

    
    fun addData(name:String, chances:Int ) {

        var score=0

        if(chances==1){
            score=5
        }
        else if(chances>1 && chances<5){
            score=3
        }
        else if(chances>4 && chances<7){
            score=2
        }
       else{
           score=1
       }

        val db = this.readableDatabase
        var curs=db.rawQuery("SELECT * FROM "+ TABLE_NAME+" WHERE "+COL1+" = '"+name+"'", null)

      if(curs.moveToFirst())  {
          var prec=curs.getInt(2)
          score+=prec
          db.execSQL("UPDATE "+TABLE_NAME+" SET "+COL2+" = "+score+" WHERE "+COL1+" = '"+name+"'")
      }
        else {
          var cv = ContentValues()
          cv.put(COL1, name)
          cv.put(COL2, score)
          this.readableDatabase.insert(TABLE_NAME, null, cv)
      }

    }

    fun getRecord(): Cursor {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM "+TABLE_NAME+" ORDER BY "+COL2+" DESC", null)
    }

}