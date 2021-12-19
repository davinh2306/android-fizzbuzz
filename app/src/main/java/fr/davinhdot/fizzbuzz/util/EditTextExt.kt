package fr.davinhdot.fizzbuzz.util

import android.widget.EditText

val EditText.trimmedTextOrNull: String?
    get() = if (this.text.isNullOrEmpty()) {
        null
    } else {
        this.text.toString().trim()
    }

val EditText.trimmedIntOrNull: Int?
    get() = this.trimmedTextOrNull?.toIntOrNull()