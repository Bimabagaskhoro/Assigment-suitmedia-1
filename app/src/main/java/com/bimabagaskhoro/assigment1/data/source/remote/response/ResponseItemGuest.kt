package com.bimabagaskhoro.assigment1.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseItemGuest(

	@field:SerializedName("per_page")
	val perPage: Int,

	@field:SerializedName("total")
	val total: Int,

	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("total_pages")
	val totalPages: Int,

	@field:SerializedName("support")
	val support: Support
) : Parcelable

@Parcelize
data class DataItem(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("first_name")
	val firstName: String,

	@field:SerializedName("last_name")
	val lastName: String,

	@field:SerializedName("avatar")
	val avatar: String,

	@field:SerializedName("email")
	val email: String
) : Parcelable

@Parcelize
data class Support(

	@field:SerializedName("text")
	val text: String,

	@field:SerializedName("url")
	val url: String
) : Parcelable
