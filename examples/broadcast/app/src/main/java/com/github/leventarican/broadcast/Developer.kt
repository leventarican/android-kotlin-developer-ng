package com.github.leventarican.broadcast

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Serialization, DTO, ...
 * use Parcelize when basic types (string, bool, ...) are not enough.
 *
 * add plugin to use https://developer.android.com/kotlin/parcelize
 * plugins { id 'kotlin-parcelize' }
 */
@Parcelize
data class Developer(val id: Int, val programmingLang: String, val exp: Short) : Parcelable