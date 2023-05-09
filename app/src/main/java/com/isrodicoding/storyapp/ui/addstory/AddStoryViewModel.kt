package com.isrodicoding.storyapp.ui.addstory

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.isrodicoding.storyapp.model.User
import com.isrodicoding.storyapp.model.UserPreference

class AddStoryViewModel(private val pref: UserPreference) : ViewModel() {
    fun getUser(): LiveData<User> {
        return pref.getUser().asLiveData()
    }
}