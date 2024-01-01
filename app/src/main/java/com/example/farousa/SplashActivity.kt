package com.example.farousa

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import com.example.farousa.databinding.ActivitySplashBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels

     // animation
        binding.txtSplash.animate().translationY(height.toFloat()/2).duration=2000
    // move to other screen
        GlobalScope.launch {
             delay(2000)
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
        }
        binding.txtStart.setOnClickListener {
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
        }


    }

}