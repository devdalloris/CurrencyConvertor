package com.example.currencyconvertor.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.currencyconvertor.Currency
import com.example.currencyconvertor.R
import com.example.currencyconvertor.adapter.RvCurrencyListAdapter
import com.example.currencyconvertor.databinding.FragmentCurrencyListBinding
import com.example.retrofit.ApiClient
import com.example.currencyconvertor.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrencyListFragment : Fragment(R.layout.fragment_currency_list) {
    private var _binding: FragmentCurrencyListBinding? = null
    private val binding get() = _binding!!

    private var rvCurrencyListAdapter: RvCurrencyListAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCurrencyListBinding.bind(view)

        val apiClient = ApiClient()
        val apiService = apiClient.getRetrofit().create(ApiService::class.java)

        apiService.getAllCurrency().enqueue(object : Callback<List<Currency>> {
            override fun onResponse(
                call: Call<List<Currency>>,
                response: Response<List<Currency>>,
            ) {
                val body = response.body()
                rvCurrencyListAdapter = RvCurrencyListAdapter(body ?: emptyList())
                binding.recyclerview.adapter = rvCurrencyListAdapter

                val itemDecoration =
                    DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
                binding.recyclerview.addItemDecoration(itemDecoration)

                rvCurrencyListAdapter!!.setOnCurrencyClickedListener {

                    val editAmountFragment = EditAmountFragment()
                    val bundle = Bundle()
                    bundle.putString("Ccy", body?.get(it)?.Ccy)
                    bundle.putString("Rate", body?.get(it)?.Rate)
                    editAmountFragment.arguments = bundle
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, editAmountFragment).commit()

                }
            }

            override fun onFailure(call: Call<List<Currency>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}