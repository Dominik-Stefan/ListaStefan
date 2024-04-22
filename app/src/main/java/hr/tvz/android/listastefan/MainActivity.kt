package hr.tvz.android.listastefan

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : BaseClass(), AdapterClass.RecyclerViewEvent {

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleList = resources.getStringArray(R.array.titles)
        descriptionList = resources.getStringArray(R.array.descriptions)

        recyclerView = findViewById(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<DataClass>()
        getData()

        val filter = IntentFilter(Intent.ACTION_BATTERY_LOW)
        val batteryReceiver = BatteryReceiver()
        registerReceiver(batteryReceiver, filter)
    }

    override fun onItemClick(position: Int) {
        val item = dataList[position]

        val intent = Intent(this, DetailedActivity::class.java)
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

    inner class BatteryReceiver: BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent != null) {
                if(intent.action == Intent.ACTION_BATTERY_LOW) {
                    Toast.makeText(context, "Battery low!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}