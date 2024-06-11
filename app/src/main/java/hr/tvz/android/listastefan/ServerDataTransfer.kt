package hr.tvz.android.listastefan

import retrofit2.Call
import retrofit2.http.GET

interface ServerDataTransfer {
    @GET("sharks")
    fun getSharks(): Call<MutableList<DataClass>>
}