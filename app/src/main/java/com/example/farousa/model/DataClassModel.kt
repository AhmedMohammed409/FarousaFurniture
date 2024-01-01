package com.example.farousa.model

import android.os.Parcel
import android.os.Parcelable

@Paracelize
data class DataClassModel(
    val id: Int,
    val name: String?,
    val price: String?,
    val imageId: Int,
    val delivery: String?,
    val longDescription: String?,
    val modelURL: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(price)
        parcel.writeInt(imageId)
        parcel.writeString(delivery)
        parcel.writeString(longDescription)
        parcel.writeString(modelURL)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataClassModel> {
        override fun createFromParcel(parcel: Parcel): DataClassModel {
            return DataClassModel(parcel)
        }

        override fun newArray(size: Int): Array<DataClassModel?> {
            return arrayOfNulls(size)
        }
    }
}

annotation class Paracelize
