package com.example.lasthomework

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.launch

class AnimalViewModel : ViewModel() {

    val client = Provider.client

    var userlsList by mutableStateOf(emptyList<users>())
        private set

    init {
        viewModelScope.launch {
            // TODO: Handle failure ex: no internet
            try {
                userlsList = client.get("https://fake-json-api.mock.beeceptor.com/users").body<List<users>>()

            }catch (e: Exception){
                e.printStackTrace()
                println(e.localizedMessage)
            }
        }
    }

}