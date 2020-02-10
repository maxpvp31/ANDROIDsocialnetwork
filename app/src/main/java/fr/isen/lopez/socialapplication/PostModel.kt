package fr.isen.lopez.socialapplication

import com.google.firebase.database.PropertyName


data class PostModel(
    @PropertyName("id_post") val id_post: String?,
    @PropertyName("text") val text: String?,
    @PropertyName("img") val img: String?,
    @PropertyName("date") val date : String?,
    @PropertyName("user_id") val user_id :  String?,
    @PropertyName("comments") val comments : ArrayList<String>?,
    @PropertyName("likes") val likes : ArrayList<String>?)
 {
     constructor() : this(null,null,null,null,null,null,null)
 }

