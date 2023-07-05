package com.example.homework4

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.homework4.databinding.FragmentDBinding

class FragmentD : Fragment(R.layout.fragment_d) {

    private lateinit var binding: FragmentDBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDBinding.bind(view)

        binding.btFragmentB.setOnClickListener {
            (requireActivity() as ClickListenersFragmentD)
                .onClickListenerBackOnFragmentB()
        }
    }

    interface ClickListenersFragmentD {
        fun onClickListenerBackOnFragmentB()
    }

    companion object {

        const val FRAGMENT_D_TAG = "FRAGMENT_D_TAG"

        fun newInstance() = FragmentD()
    }
}