package com.example.homework4

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.homework4.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var user: UserModel
    private val data = Data
    private var image = 0
    private var count = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)
        user = data.getUser(arguments?.getInt(ID_EXTRA) ?: -1)
        image = user.image

        for (i in 0 until data.listImage.size) {
            if (data.listImage[i] == image) {
                count = i
            }
        }

        setInformationAboutUser()
        setClickListenersOnButtons()
        editImage()
    }

    private fun setInformationAboutUser() {
        with(binding) {
            image.setImageResource(user.image)
            edtFirstName.setText(user.firstName)
            edtLastName.setText(user.lastName)
            edtPhoneNumber.setText(user.phoneNumber)
        }
    }

    private fun setClickListenersOnButtons() {
        binding.btAdd.setOnClickListener {
            val editingUser = user.copy(
                image = image,
                firstName = binding.edtFirstName.text.toString(),
                lastName = binding.edtLastName.text.toString(),
                phoneNumber = binding.edtPhoneNumber.text.toString(),
            )
            data.editUserInformation(editingUser)
            (requireActivity() as ClickListenerBackOnListUserFragment).onClickBackOnListUserFragment()
        }

        binding.btCancellation.setOnClickListener {
            (requireActivity() as ClickListenerBackOnListUserFragment).onClickBack()
        }
    }

    private fun editImage() {
        binding.btNext.setOnClickListener {
            if (count != data.listImage.size - 1) {
                ++count
                binding.image.setImageResource(data.listImage[count])
                image = data.listImage[count]
            }
        }

        binding.btPrevious.setOnClickListener {
            if (count != 0) {
                count--
                binding.image.setImageResource(data.listImage[count])
                image = data.listImage[count]
            }
        }
    }

    interface ClickListenerBackOnListUserFragment {
        fun onClickBackOnListUserFragment()
        fun onClickBack()
    }

    companion object {

        const val DETAILS_FRAGMENT_TAG = "DETAILS_FRAGMENT_TAG"
        private const val ID_EXTRA = "ID_EXTRA"

        @JvmStatic
        fun newInstance(
            id: Int
        ) = DetailsFragment().apply {
            arguments = bundleOf(ID_EXTRA to id)
        }
    }
}