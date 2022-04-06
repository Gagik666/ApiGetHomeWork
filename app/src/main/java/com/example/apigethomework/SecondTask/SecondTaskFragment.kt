package com.example.apigethomework.SecondTask

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apigethomework.ApiInterface
import com.example.apigethomework.FirstTask.UserData
import com.example.apigethomework.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SecondTaskFragment : Fragment() {
   private lateinit var adapter: MonyAdapter
    private lateinit var rvMony: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvMony = view.findViewById(R.id.rvMony)
        rvMony.layoutManager = LinearLayoutManager(context)

        getMyData()

    }
    private fun getMyData() {
        val retrofitBulder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.privatbank.ua/")
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBulder.getMony()
         retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
             override fun onResponse(
                 call: Call<List<MyDataItem>?>,
                 response: Response<List<MyDataItem>?>
             ) {
                 val responseBody = response.body()!!
                 adapter = MonyAdapter(this@SecondTaskFragment, responseBody as MutableList<MyDataItem>)
                 adapter.notifyDataSetChanged()
                 rvMony.adapter = adapter
             }

             override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                 Log.d("MyLog", "ofFailure ${t.message}")
             }
         })
    }

}


