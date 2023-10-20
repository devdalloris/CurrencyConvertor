package com.example.currencyconvertor.fragments

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.currencyconvertor.R
import com.example.currencyconvertor.databinding.FragmentEditAmountBinding

class EditAmountFragment : Fragment(R.layout.fragment_edit_amount) {
    private var _binding: FragmentEditAmountBinding? = null
    private val binding get() = _binding!!
    var value1=0.0
    var finalResult=0.0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentEditAmountBinding.bind(view)
        val bundle = arguments
        if(bundle!=null){
            binding.textEqual.text="1 UZS = ${bundle.getString("Rate")} ${bundle.getString("Ccy")}"
            binding.txtCcy.text=bundle.getString("Ccy")
        }

        binding.txtTitle.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CurrencyListFragment()).commit()
        }

        binding.btnDot.setOnClickListener {
            onNumberClicked(binding.btnDot)
        }
        binding.btn0.setOnClickListener {
            onNumberClicked(binding.btn0)
        }
        binding.btn1.setOnClickListener {
            onNumberClicked(binding.btn1)
        }
        binding.btn2.setOnClickListener {
            onNumberClicked(binding.btn2)
        }
        binding.btn3.setOnClickListener {
            onNumberClicked(binding.btn3)
        }
        binding.btn4.setOnClickListener {
            onNumberClicked(binding.btn4)
        }
        binding.btn5.setOnClickListener {
            onNumberClicked(binding.btn5)
        }
        binding.btn6.setOnClickListener {
            onNumberClicked(binding.btn6)
        }
        binding.btn7.setOnClickListener {
            onNumberClicked(binding.btn7)
        }
        binding.btn8.setOnClickListener {
            onNumberClicked(binding.btn8)
        }
        binding.btn9.setOnClickListener {
            onNumberClicked(binding.btn9)
        }
        binding.btnC.setOnClickListener {
            onNumberClicked(binding.btnC)
        }
        binding.btnDel.setOnClickListener {
            onNumberClicked(binding.btnDel)
        }
        binding.btnConvert.setOnClickListener {
            onConvertClicked(binding.btnConvert)
        }

    }
    private fun onNumberClicked(view: View) {
        var valueBuilder = StringBuilder(binding.etQuantity.text.toString())
        when (view.id) {
            R.id.btn_dot->{
                if(valueBuilder.indexOf(".")==-1){
                    if(valueBuilder.isNotEmpty()){
                        valueBuilder.append(".")
                    }
                }
            }
            R.id.btn0 -> {
                valueBuilder.append("0")

            }

            R.id.btn1 -> {
                valueBuilder.append("1")

            }

            R.id.btn2 -> {
                valueBuilder.append("2")

            }

            R.id.btn3 -> {
                valueBuilder.append("3")

            }

            R.id.btn4 -> {
                valueBuilder.append("4")

            }

            R.id.btn5 -> {
                valueBuilder.append("5")
            }

            R.id.btn6 -> {
                valueBuilder.append("6")
            }

            R.id.btn7 -> {
                valueBuilder.append("7")
            }

            R.id.btn8 -> {
                valueBuilder.append("8")
            }

            R.id.btn9 -> {
                valueBuilder.append("9")
            }

            R.id.btn_c -> {
                valueBuilder.setLength(0)
            }

            R.id.btn_del -> {
                if (valueBuilder.isNotEmpty()) {
                    valueBuilder.deleteCharAt(valueBuilder.length - 1)
                }
            }
        }
        binding.etQuantity.setText(valueBuilder.toString(), TextView.BufferType.EDITABLE)

    }
    private fun onConvertClicked(view: View){
        if(binding.etQuantity.text.isNotEmpty()){
            var value=binding.etQuantity.text.toString()
            value1=value.toDouble()
        }
        val bundle = arguments
        if(bundle!=null){
            finalResult=value1*bundle.getString("Rate")!!.toDouble()
            binding.textQuantity.text="${value1} ${bundle.getString("Ccy")} = "+ String.format("%.3f",finalResult) +" UZS"
        }


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}