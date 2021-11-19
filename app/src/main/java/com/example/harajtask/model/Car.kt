package com.example.harajtask.model

import com.google.gson.annotations.SerializedName

data class Car (
    @SerializedName("title") var title: String?,
    @SerializedName("username") var username: String?,
    @SerializedName("thumbURL") var thumbURL: String?,
    @SerializedName("commentCount") var commentCount: Int?,
    @SerializedName("city") var city: String?,
    @SerializedName("date") var date: Long?,
    @SerializedName("body") var body: String

)
