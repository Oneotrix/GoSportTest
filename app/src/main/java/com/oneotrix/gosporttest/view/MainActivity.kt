package com.oneotrix.gosporttest.view

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.oneotrix.gosporttest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindnig: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindnig = ActivityMainBinding.inflate(layoutInflater)




    }
}