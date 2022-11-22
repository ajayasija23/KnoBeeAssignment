package com.nfc.knobeeassignment.util

import android.content.Context
import android.util.Log
import android.widget.Toast

fun String.log(){
    Log.d("kno_bee",this)
}
fun String.toast(mContext: Context){
    Toast.makeText(mContext,this,Toast.LENGTH_LONG).show()
}