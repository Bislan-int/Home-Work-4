package com.example.homework4

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit

class MainActivity : FragmentActivity(R.layout.activity_main),
    ListUsersFragment.ClickListenerTransitionOnDetailsFragment,
    DetailsFragment.ClickListenerBackOnListUserFragment {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragmentTransitions(
            ListUsersFragment.newInstance(),
            ListUsersFragment.LIST_USERS_FRAGMENT_TAG
        )
    }

    private fun fragmentTransitions(fragment: Fragment, fragmentTag: String) {
        supportFragmentManager.commit {
            replace(R.id.fragment_container, fragment, fragmentTag)
            addToBackStack(fragmentTag)
        }
    }

    override fun onClickItem(id: Int) {
        fragmentTransitions(
            DetailsFragment.newInstance(id),
            DetailsFragment.DETAILS_FRAGMENT_TAG
        )
    }

    override fun onClickBackOnListUserFragment() {
        fragmentTransitions(
            ListUsersFragment.newInstance(),
            ListUsersFragment.LIST_USERS_FRAGMENT_TAG
        )
    }

    override fun onClickBack() {
        supportFragmentManager.popBackStack()
    }
}