package dev.toriyama.android.installedapps

import android.graphics.drawable.Drawable
import java.util.Date

data class AppInfo(
    val name: String,
    val version: String,
    val packageName: String,
    val lastUpdateTime: Date,
    val logo: Drawable?
)
