package com.oneotrix.gosporttest.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.oneotrix.gosporttest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindnig: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindnig = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindnig.root)
    }
}