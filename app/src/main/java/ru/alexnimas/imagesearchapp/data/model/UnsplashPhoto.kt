package ru.alexnimas.imagesearchapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UnsplashPhoto(
    val id: String?,
    @SerializedName("created_at") val createdAt: String?,
    val width: Int?,
    val height: Int?,
    val color: String?,
    @SerializedName("blur_hash") val blurHash: String?,
    val likes: Int?,
    @SerializedName("liked_by_user") val likedByUser: Boolean?,
    val description: String?,
    val user: User?,
    val urls: Urls?,
    val links: Links?
) : Parcelable {

    @Parcelize
    data class User(
        var id: String?,
        var username: String?,
        var name: String?,
        @SerializedName("first_name") val firstName: String?,
        @SerializedName("last_name") val lastName: String?,
        @SerializedName("instagram_username") val instagramUsername: String?,
        @SerializedName("twitter_username") val twitterUsername: String?,
        @SerializedName("portfolio_url") val portfolioUrl: String?,
        @SerializedName("profile_image") val profileImage: ProfileImage?,
        var links: UserLinks?
    ) : Parcelable {

        @Parcelize
        data class ProfileImage(
            val small: String?,
            val medium: String?,
            val large: String?
        ) : Parcelable

        @Parcelize
        data class UserLinks(
            val self: String?,
            val html: String?,
            val photos: String?,
            val likes: String?
        ) : Parcelable
    }

    @Parcelize
    data class Urls(
        val raw: String?,
        val full: String?,
        val regular: String?,
        val small: String?,
        val thumb: String?
    ) : Parcelable

    @Parcelize
    data class Links(
        val self: String?,
        val html: String?,
        val download: String?
    ) : Parcelable
}