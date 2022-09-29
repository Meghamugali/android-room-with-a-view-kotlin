/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.roomwordssample

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * A basic class representing an entity that is a row in a one-column database table.
 *
 * @ Entity - You must annotate the class as an entity and supply a table name if not class name.
 * @ PrimaryKey - You must identify the primary key.
 * @ ColumnInfo - You must supply the column name if it is different from the variable name.
 *
 * See the documentation for the full rich set of annotations.
 * https://developer.android.com/topic/libraries/architecture/room.html
 */

@Entity(tableName = "SensorData")
data class Word(@PrimaryKey(autoGenerate = true)
                var id:Int,
                var gyroscope: String,
                var latlng: String,
                var bearing: String,
                var accuracy: String,
                var speed: String,
                var accelerometer: String,
                var timeStamp:String,
                var magnetometer:String,
                var isManual:String        ): Parcelable {


    constructor(parcel: Parcel) : this(
        id = parcel.readInt(),
       gyroscope = parcel.readString().toString(),
       latlng = parcel.readString().toString(),
       bearing = parcel.readString().toString(),
       accuracy = parcel.readString().toString(),
        speed = parcel.readString().toString(),
       accelerometer =  parcel.readString().toString(),
       timeStamp = parcel.readString().toString(),
        magnetometer = parcel.readString().toString(),
       isManual = parcel.readString().toString()
    ) {

    }

    override fun describeContents()=0

    override fun writeToParcel(parcel: Parcel?, flags: Int) {
        parcel?.writeInt(id)
        parcel?.writeString(gyroscope)
        parcel?.writeString(latlng)
        parcel?.writeString(bearing)
        parcel?.writeString(accuracy)
        parcel?.writeString(speed)
        parcel?.writeString(accelerometer)
        parcel?.writeString(timeStamp)
        parcel?.writeString(magnetometer)
        parcel?.writeString(isManual)


    }

    companion object CREATOR : Parcelable.Creator<Word> {
        override fun createFromParcel(parcel: Parcel): Word {
            return Word(parcel)
        }

        override fun newArray(size: Int): Array<Word?> {
            return arrayOfNulls(size)
        }
    }
}
