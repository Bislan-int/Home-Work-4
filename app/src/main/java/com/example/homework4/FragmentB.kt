package com.example.homework4

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.homework4.databinding.FragmentBBinding

class FragmentB : Fragment(R.layout.fragment_b) {

    private lateinit var binding: FragmentBBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBBinding.bind(view)
        fragmentTransitions()
    }

    private fun fragmentTransitions() {
        with(binding) {
            btBack.setOnClickListener {
                (requireActivity() as ClickListenersFragmentB).onClickListenerBack()
            }
            btFragmentC.setOnClickListener {
                (requireActivity() as ClickListenersFragmentB)
                    .onClickListenerTransitionOnFragmentC("Hello Fragment C")
            }
        }
    }

    interface ClickListenersFragmentB {
        fun onClickListenerTransitionOnFragmentC(massage: String)
        fun onClickListenerBack()
    }

    companion object {

        const val FRAGMENT_B_TAG = "FRAGMENT_B_TAG"

        fun newInstance() = FragmentB()
    }
}