package com.example.homework4

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.homework4.databinding.FragmentABinding

class FragmentA : Fragment(R.layout.fragment_a) {

    private lateinit var binding: FragmentABinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentABinding.bind(view)

        binding.btFragmentB.setOnClickListener {
            (requireActivity() as ClickListenersFragmentA)
                .onClickListenerTransitionOnFragmentB()
        }
    }

    interface ClickListenersFragmentA {
        fun onClickListenerTransitionOnFragmentB()
    }

    companion object {
        const val FRAGMENT_A_TAG = "FRAGMENT_A_TAG"

        @JvmStatic
        fun newInstance() = FragmentA()
    }
}