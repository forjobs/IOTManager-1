package com.droid.iotmanager

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.os.Handler


class SplashActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }, 3000)
    }
}
