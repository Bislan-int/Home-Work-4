package com.example.homework4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework4.databinding.UserItemBinding

class UserAdapter : ListAdapter<UserModel, UserAdapter.UserViewHolder>(DIFF_CALLBACK) {

    var onItemClickListener: (UserModel) -> Unit = {}

    class UserViewHolder(
        private val binding: UserItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: UserModel) {
            with(binding) {
                image.setImageResource(item.image)
                tvFirstName.text = item.firstName
                tvLastName.text = item.lastName
                tvPhoneNumber.text = item.phoneNumber
            }
        }

        companion object {
            fun createViewHolder(parent: ViewGroup): UserViewHolder {
                return UserViewHolder(
                    UserItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder.createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(currentList[position])
        holder.itemView.setOnClickListener {
            onItemClickListener.invoke(getItem(position))
        }
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<UserModel>() {

            override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}