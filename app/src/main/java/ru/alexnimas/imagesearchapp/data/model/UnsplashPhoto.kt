package ru.alexnimas.imagesearchapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UnsplashPhoto(
    var id: String?,
    @SerializedName("created_at") var createdAt: String?,
    var width: Int?,
    var height: Int?,
    var color: String?,
    @SerializedName("blur_hash") var blurHash: String?,
    var likes: Int?,
    @SerializedName("liked_by_user") var likedByUser: Boolean?,
    var description: String?,
    var user: User?,
    var urls: Urls?,
    var links: Links?
) : Parcelable {

    @Parcelize
    data class User(
        var id: String?,
        var username: String?,
        var name: String?,
        @SerializedName("first_name") var firstName: String?,
        @SerializedName("last_name") var lastName: String?,
        @SerializedName("instagram_username") var instagramUsername: String?,
        @SerializedName("twitter_username") var twitterUsername: String?,
        @SerializedName("portfolio_url") var portfolioUrl: String?,
        @SerializedName("profile_image") var profileImage: ProfileImage?,
        var links: UserLinks?
    ) : Parcelable {

        @Parcelize
        data class ProfileImage(
            var small: String?,
            var medium: String?,
            var large: String?
        ) : Parcelable

        @Parcelize
        data class UserLinks(
            var self: String?,
            var html: String?,
            var photos: String?,
            var likes: String?
        ) : Parcelable
    }

    @Parcelize
    data class Urls(
        var raw: String?,
        var full: String?,
        var regular: String?,
        var small: String?,
        var thumb: String?
    ) : Parcelable

    @Parcelize
    data class Links(
        var self: String?,
        var html: String?,
        var download: String?
    ) : Parcelable
}