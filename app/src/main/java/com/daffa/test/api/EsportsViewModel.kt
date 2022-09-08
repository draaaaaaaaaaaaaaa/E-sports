package com.daffa.test.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EsportsViewModel : ViewModel() {

    private val listEsports = MutableLiveData<List<EsportsResponseItem>>()

    fun getEsportModel(){
        ApiConfig().getEsportService().getEsport().enqueue(object :
            Callback<List<EsportsResponseItem>> {
            override fun onResponse(
                call: Call<List<EsportsResponseItem>>,
                response: Response<List<EsportsResponseItem>>
            ) {
                listEsports.value = response.body()
            }

            override fun onFailure(call: Call<List<EsportsResponseItem>>, t: Throwable) {

            }
        })
    }

    fun getListEsport() : LiveData<List<EsportsResponseItem>> = listEsports
}