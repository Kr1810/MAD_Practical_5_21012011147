package com.krinasuthar.mad_practical_5_21012011147

import android.content.Intent
import android.graphics.Camera
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.telecom.Call
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnBrowser:Button=findViewById(R.id.buttonBrowser)
        val editBrowser:EditText=findViewById(R.id.editTextBrowser)
        btnBrowser.setOnClickListener {(editBrowser.text.toString()) }
        val btnCall:Button = findViewById(R.id.buttonCall)
        val editCall:EditText=findViewById(R.id.editTextCall)
        btnCall.setOnClickListener(){ call(editCall.text.toString()) }
        val btnCallLog:Button=findViewById(R.id.buttonCallLog)
        btnCallLog.setOnClickListener(){ call(editCall.text.toString())}
        val btnGallery:Button=findViewById(R.id.buttonGallery)
        btnGallery.setOnClickListener(){ gallery() }
        val btnCamera:Button=findViewById(R.id.button2Camera)
        btnCamera.setOnClickListener(){ Camera() }
        val btnAlarm:Button=findViewById(R.id.button3Alarm)
        btnAlarm.setOnClickListener(){ AlarmClock() }
    }
    fun Browser(url:String) {
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).also { startActivity(it) }
    }
    fun call(number:String){
        Intent(Intent.ACTION_DIAL).setData(Uri.parse("tell:$number")).also { startActivity(it) }
    }
    fun callog(){
        Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }
    }
    fun gallery(){
        Intent(Intent.ACTION_VIEW).setType("image/*").also { startActivity(it) }
    }
}


