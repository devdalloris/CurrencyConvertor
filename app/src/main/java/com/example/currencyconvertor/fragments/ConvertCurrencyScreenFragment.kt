package com.example.currencyconvertor.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.currencyconvertor.Currency
import com.example.currencyconvertor.R
import com.example.currencyconvertor.adapter.RvCurrencyListAdapter
import com.example.currencyconvertor.databinding.FragmentConvertCurrencyScreenBinding
import com.example.retrofit.ApiClient
import com.example.currencyconvertor.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConvertCurrencyScreenFragment : Fragment(R.layout.fragment_convert_currency_screen) {
    private var _binding: FragmentConvertCurrencyScreenBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentConvertCurrencyScreenBinding.bind(view)

                val bundle = arguments
                if (bundle != null) {
                    binding.txtCurrencyCcy1.text = bundle.getString("Ccy")
                    binding.txtCurrency2.text = bundle.getString("Rate")
                }
      

        binding.txtTitle.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CurrencyListFragment()).commit()
        }

        binding.iconConvert.setOnClickListener {
            var bundle1 = Bundle()
            val editAmountFragment = EditAmountFragment()
            if (bundle != null) {
                bundle1.putString("Rate", bundle.getString("Rate"))
            }
            editAmountFragment.arguments=bundle1
            parentFragmentManager.beginTransaction().replace(R.id.fragment_container, editAmountFragment).commit()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}