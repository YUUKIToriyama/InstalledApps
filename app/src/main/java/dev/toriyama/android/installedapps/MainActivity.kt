package dev.toriyama.android.installedapps

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showPackages()
    }

    private fun showPackages() {
        val packageManager = applicationContext.packageManager
        val packages: List<PackageInfo> = packageManager.getInstalledPackages(PackageManager.GET_META_DATA)
        packages.forEach {
            val name = it.packageName
            println(name)
        }
    }
}