package com.example.w1_d4_retrofitlab

class WikiRepository {
    private val call = GlobalModel.service

    suspend fun hitCountCheck(name: String): String = call.getTotalHits(name).query.searchinfo.totalhits.toString()
}
