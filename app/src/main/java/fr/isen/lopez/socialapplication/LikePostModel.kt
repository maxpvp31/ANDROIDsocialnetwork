package fr.isen.lopez.socialapplication

import com.google.firebase.database.PropertyName


data class LikePostModel(
    @PropertyName("user_id") val user_id: String?,
    @PropertyName("post_id") val post_id: String?,
    @PropertyName("type") val type : Int?,
    @PropertyName("date_added") val date_added :  String?)
{
    constructor() : this("","",null,"")
}

