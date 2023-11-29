package com.example.catminder

data class Password(
    var id: Int,
    var serviceWebsiteName: String,
    var email: String,
    var username: String,
    var password: String,
    var note: String
)