package com.example.homework4

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework4.databinding.FragmentListUsersBinding

class ListUsersFragment : Fragment(R.layout.fragment_list_users) {

    private lateinit var binding: FragmentListUsersBinding
    private lateinit var userAdapter: UserAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListUsersBinding.bind(view)
        initRecyclerView()

        userAdapter.onItemClickListener = { user ->
            (requireActivity() as ClickListenerTransitionOnDetailsFragment)
                .onClickItem(user.id)
        }
    }

    private fun initRecyclerView() {
        userAdapter = UserAdapter()
        userAdapter.submitList(Data.listUser)
        binding.recyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.recyclerView.adapter = userAdapter
    }

    interface ClickListenerTransitionOnDetailsFragment {
        fun onClickItem(id: Int)
    }

    companion object {

        const val LIST_USERS_FRAGMENT_TAG = "LIST_USERS_FRAGMENT_TAG"

        @JvmStatic
        fun newInstance() = ListUsersFragment()
    }
}