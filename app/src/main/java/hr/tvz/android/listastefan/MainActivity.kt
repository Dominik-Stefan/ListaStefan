package hr.tvz.android.listastefan

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast

class MainActivity : BaseClass() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filter = IntentFilter(Intent.ACTION_BATTERY_LOW)
        val batteryReceiver = BatteryReceiver()
        registerReceiver(batteryReceiver, filter)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main, ListFragment())
            .commit()
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