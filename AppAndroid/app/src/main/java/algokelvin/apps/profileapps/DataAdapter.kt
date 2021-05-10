package algokelvin.apps.profileapps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_name.view.*
import java.util.ArrayList

class DataAdapter(private val list: ArrayList<People>): RecyclerView.Adapter<DataViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_name, parent, false))
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.itemView.name_people.text = ("${list[position].name} - ${list[position].address} - ${list[position].description}")
    }

    override fun getItemCount(): Int = list.size
}
class DataViewHolder(view: View): RecyclerView.ViewHolder(view)