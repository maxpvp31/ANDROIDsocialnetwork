package fr.isen.lopez.socialapplication

import com.google.firebase.database.PropertyName


data class CommentModel(
    @PropertyName("comment_id") val comment_id: String?,
    @PropertyName("text") val text: String?,
    @PropertyName("id_user") val id_user: String?,
    @PropertyName("id_post") val id_post : String?,
    @PropertyName("date_added") val date_added :  String?)
{
    constructor() : this(null,null,null,null,null)
}

