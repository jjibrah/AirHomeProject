package com.Abdifatah.airhome

import android.os.Parcel
import android.os.Parcelable

data class Homes(var image:Int, var location:String, var details:String ,var price:String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(location)
        parcel.writeString(details)
        parcel.writeString(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Homes> {
        override fun createFromParcel(parcel: Parcel): Homes {
            return Homes(parcel)
        }

        override fun newArray(size: Int): Array<Homes?> {
            return arrayOfNulls(size)
        }
    }
}
