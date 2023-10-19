package com.example.currencyconvertor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.currencyconvertor.databinding.ActivityMainBinding
import com.example.currencyconvertor.fragments.CurrencyListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, CurrencyListFragment()).commit()

    }
}