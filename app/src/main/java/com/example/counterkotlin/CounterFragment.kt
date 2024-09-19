package com.example.counterkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.counterkotlin.databinding.FragmentCounterBinding

class CounterFragment : Fragment() {

    private var _binding: FragmentCounterBinding? = null
    private val binding get() = _binding!!
    private var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCounterBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.counterText.text = counter.toString()

        binding.buttonPlus.setOnClickListener {
            counter++
            binding.counterText.text = counter.toString()
        }

        binding.buttonMinus.setOnClickListener {
            counter--
            binding.counterText.text = counter.toString()
        }

        binding.buttonReset.setOnClickListener {
            counter = 0
            binding.counterText.text = counter.toString()
        }

        binding.buttonSendResult.setOnClickListener {
            val resultFragment = ResultFragment.newInstance(counter)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, resultFragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
