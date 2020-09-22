package com.example.w1_d4_retrofitlab

class President(var name: String, var startDuty: Int, var endDuty: Int, var description: String): Comparable<President> {
    override fun compareTo(other: President): Int {
        return this.startDuty.compareTo(other.startDuty)
    }

    override fun toString(): String {
        return "$name $startDuty $endDuty"
    }
}