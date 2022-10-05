package dev.toriyama.android.installedapps

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.toriyama.android.installedapps.databinding.ListApplicationBinding
import java.text.SimpleDateFormat

class AppListAdapter(
    context: Context,
    var appList: List<AppInfo>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AppListViewHolder(
            ListApplicationBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AppListViewHolder) {
            val item = appList[position]
            if (item.logo != null) {
                holder.binding.imageviewAppLogo.setImageDrawable(item.logo)
            }
            holder.binding.textAppName.text = item.name
            holder.binding.textAppVersion.text = item.version
            holder.binding.textAppPackagename.text = item.packageName
            holder.binding.textAppLastupdatetime.text = SimpleDateFormat("yyyy/MM/dd HH:mm").format(item.lastUpdateTime)
        }
    }

    override fun getItemCount(): Int {
        return appList.size
    }
}