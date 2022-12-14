package com.axisoverseascareers.finwintech

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
      lateinit var progressBarr: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBarr = findViewById<ProgressBar>(R.id.progrssbar)


        Handler().postDelayed({
            val i = Intent(this@MainActivity, FirstActivity::class.java)
            startActivity(i)
            finish()
        }, 1000)
    }
}