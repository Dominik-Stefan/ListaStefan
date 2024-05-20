package hr.tvz.android.listastefan

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment(), AdapterClass.RecyclerViewEvent {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>

    private lateinit var titleList: Array<String>
    private lateinit var descriptionList: Array<String>

    private var imageList: Array<Int> = arrayOf(
        R.drawable.blacknose_shark, R.drawable.blacktip_reef_shark, R.drawable.blacktip_shark,
        R.drawable.blue_shark, R.drawable.brown_shyshark, R.drawable.bull_shark,
        R.drawable.caribbean_reef_shark, R.drawable.copper_bronze_whaler_shark,
        R.drawable.dusky_shark, R.drawable.galapagos_shark, R.drawable.great_hammerhead_shark,
        R.drawable.grey_reef_shark, R.drawable.lemon_shark, R.drawable.leopard_shark,
        R.drawable.oceanic_whitetip_shark, R.drawable.pacific_sharpnose_shark,
        R.drawable.pyjama_shark, R.drawable.sand_tiger_shark,
        R.drawable.scalloped_hammerhead_shark, R.drawable.sharptooth_lemon_shark,
        R.drawable.silky_shark, R.drawable.silvertip_shark,
        R.drawable.smooth_hammerhead, R.drawable.smoothhound,
        R.drawable.spinner_shark, R.drawable.tiger_shark
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView : View = inflater.inflate(R.layout.fragment_list, container, false)

        titleList = resources.getStringArray(R.array.titles)
        descriptionList = resources.getStringArray(R.array.descriptions)

        recyclerView = rootView.findViewById(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(rootView.context)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<DataClass>()
        getData()

        return rootView
    }

    override fun onItemClick(position: Int) {
        val item = dataList[position]

        val intent = Intent(this.context, DetailedActivity::class.java)
        intent.putExtra("shark", item)

        startActivity(intent)
    }

    private fun getData() {
        for (i in imageList.indices) {
            val dataClass = DataClass(imageList[i], titleList[i], descriptionList[i])
            dataList.add(dataClass)
        }
        recyclerView.adapter = AdapterClass(dataList, this)
    }
}