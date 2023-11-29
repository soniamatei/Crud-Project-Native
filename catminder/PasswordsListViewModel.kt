package com.example.catminder

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class PasswordsListViewModel : ViewModel() {
    var passwordList = mutableStateListOf<Password>()
        private set
    private var nextId: Int = 0

    init {
        for (i in 1..20) {
            val password = Password(nextId++, "Google", "smth@joke.ro",
                "joker", "hahhahha", "")
            passwordList.add(password)
        }
    }

    fun insert(serviceWebsiteName: String, email: String,
               username: String, password: String, note: String) {
        var p = Password(nextId++, serviceWebsiteName, email, username, password, note)
        passwordList.add(p)
    }

    fun update(id: Int, serviceWebsiteName: String, email: String,
               username: String, password: String, note: String) {
        val newPassword = Password(id, serviceWebsiteName, email, username, password, note)
        var i = -1
        passwordList.forEachIndexed { index, it ->
            if (it.id == newPassword.id) {
                i = index
            }
        }
        passwordList[i] = newPassword
    }

    fun delete(id: Int) {
        passwordList.removeIf { it.id == id }
    }
}
