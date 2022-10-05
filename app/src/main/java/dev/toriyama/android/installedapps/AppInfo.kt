package dev.toriyama.android.installedapps

import android.graphics.drawable.Drawable

data class AppInfo(
    val name: String,
    val version: String,
    val logo: Drawable?
)
