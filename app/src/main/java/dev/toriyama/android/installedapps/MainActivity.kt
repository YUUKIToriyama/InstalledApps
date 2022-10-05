package dev.toriyama.android.installedapps

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dev.toriyama.android.installedapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AppListAdapter

    private var appList: MutableList<AppInfo> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = AppListAdapter(this, appList.toList())

        binding.recyclerViewContainer.setHasFixedSize(true)
        binding.recyclerViewContainer.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewContainer.adapter = adapter
        updateAppInfomations()
    }

    private fun updateAppInfomations() {
        val packageManager = applicationContext.packageManager
        appList.clear()
        val packages: List<PackageInfo> =
            packageManager.getInstalledPackages(PackageManager.GET_META_DATA)
        packages.forEach {
            appList.add(
                AppInfo(
                    it.packageName,
                    it.versionName,
                    it.applicationInfo.loadLogo(packageManager)
                )
            )
        }
        adapter.appList = appList.toList()
        adapter.notifyDataSetChanged()
    }
}