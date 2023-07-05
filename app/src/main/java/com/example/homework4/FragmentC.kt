package com.example.homework4

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.homework4.databinding.FragmentCBinding

class FragmentC : Fragment(R.layout.fragment_c) {

    private lateinit var binding: FragmentCBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCBinding.bind(view)
        fragmentTransitions()
    }

    private fun fragmentTransitions() {
        with(binding) {
            tvMassage.text = arguments?.getString(MASSAGE_EXTRA, "null")
            btFragmentA.setOnClickListener {
                (requireActivity() as ClickListenersFragmentC)
                    .onClickListenerBackOnFragmentA()
            }
            btFragmentD.setOnClickListener {
                (requireActivity() as ClickListenersFragmentC)
                    .onClickListenerTransitionOnFragmentD()
            }
        }
    }

    interface ClickListenersFragmentC {
        fun onClickListenerTransitionOnFragmentD()
        fun onClickListenerBackOnFragmentA()
    }

    companion object {

        const val FRAGMENT_C_TAG = "FRAGMENT_C_TAG"
        private const val MASSAGE_EXTRA = "MASSAGE_EXTRA"

        fun newInstance(massage: String) = FragmentC().apply {
            arguments = bundleOf(MASSAGE_EXTRA to massage)
        }
    }
}