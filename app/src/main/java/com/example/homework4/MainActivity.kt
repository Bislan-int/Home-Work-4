package com.example.homework4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.homework4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentA.ClickListenersFragmentA,
    FragmentB.ClickListenersFragmentB, FragmentC.ClickListenersFragmentC,
    FragmentD.ClickListenersFragmentD {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        fragmentTransitions(FragmentA.newInstance(), FragmentA.FRAGMENT_A_TAG)
    }

    private fun fragmentTransitions(fragment: Fragment, fragmentTag: String) {
        supportFragmentManager.commit {
            replace(R.id.fragment_container, fragment, fragmentTag)
            addToBackStack(fragmentTag)
        }
    }

    override fun onClickListenerTransitionOnFragmentB() {
        fragmentTransitions(FragmentB.newInstance(), FragmentB.FRAGMENT_B_TAG)
    }

    override fun onClickListenerTransitionOnFragmentC(massage: String) {
        fragmentTransitions(FragmentC.newInstance(massage), FragmentC.FRAGMENT_C_TAG)
    }

    override fun onClickListenerBack() {
        supportFragmentManager.popBackStack()
    }

    override fun onClickListenerTransitionOnFragmentD() {
        fragmentTransitions(FragmentD.newInstance(), FragmentD.FRAGMENT_D_TAG)
    }

    override fun onClickListenerBackOnFragmentA() {
        supportFragmentManager.popBackStack(FragmentA.FRAGMENT_A_TAG, 0)
    }

    override fun onClickListenerBackOnFragmentB() {
        supportFragmentManager.popBackStack(FragmentB.FRAGMENT_B_TAG, 0)
    }
}