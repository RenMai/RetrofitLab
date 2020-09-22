package com.example.w1_d4_retrofitlab

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.ArrayList

object GlobalModel {
    private const val URL = "https://en.wikipedia.org/w/"
    val presidents: MutableList<President> = ArrayList()

    init {
        presidents.add(President("Kaarlo Stahlberg", 1919, 1925, "Eka presidentti"))
        presidents.add(President("Lauri Relander", 1925, 1931, "Toka presidentti"))
        presidents.add(President("P. E. Svinhufvud", 1931, 1937, "Kolmas presidentti"))
        presidents.add(President("Kyösti Kallio", 1937, 1940, "Neljas presidentti"))
        presidents.add(President("Risto Ryti", 1940, 1944, "Viides presidentti"))
        presidents.add(President("Carl Gustaf Emil Mannerheim", 1944, 1946, "Kuudes presidentti"))
        presidents.add(President("Juho Kusti Paasikivi", 1946, 1956, "Äkäinen ukko"))
        presidents.add(President("Urho Kekkonen", 1956, 1982, "Pelimies"))
        presidents.add(President("Mauno Koivisto", 1982, 1994, "Manu"))
        presidents.add(President("Martti Ahtisaari", 1994, 2000, "Mahtisaari"))
        presidents.add(President("Tarjia Halonen", 2000, 2012, "Eka naispresidentti"))
        presidents.sort()
    }

    object Model {
        data class PresidentInfo(val batchComplete: String, val query: Query)
        data class Query(val searchinfo: SearchInfo)
        data class SearchInfo(val totalhits: Int)
    }

    interface Service {
        @GET("api.php?action=query&format=json&list=search")
        suspend fun getTotalHits(@Query("srsearch") action: String): Model.PresidentInfo
    }
    private val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service: Service = retrofit.create(Service::class.java)
}