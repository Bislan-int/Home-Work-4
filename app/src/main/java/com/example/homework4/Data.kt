package com.example.homework4

object Data {


    val listImage = listOf(
        R.drawable.image_1,
        R.drawable.image_2,
        R.drawable.image_3,
        R.drawable.image_4
    )

    private fun listUser(): MutableList<UserModel> {
        return mutableListOf(
            UserModel(
                0,
                listImage[0],
                "Артемий",
                "Мельников",
                "+7 800 111 11 11"
            ),
            UserModel(
                1,
                listImage[1],
                "Алексей",
                "Копылов",
                "+7 800 222 22 22"
            ),
            UserModel(
                2,
                listImage[2],
                "Иван",
                "Борисов",
                "+7 800 333 33 33"
            ),
            UserModel(
                3,
                listImage[3],
                "Екатерина",
                "Давыдова",
                "+7 800 444 44 44"
            )
        )
    }

    val listUser = listUser()

    fun editUserInformation(user: UserModel) {
        val oldUser = getUser(user.id)
        listUser.remove(oldUser)
        listUser.add(user)
        listUser.sortBy { it.id }
    }

    fun getUser(userId: Int): UserModel {
        return listUser.find {
            it.id == userId
        } ?: throw RuntimeException("Element with id $userId not found")
    }
}