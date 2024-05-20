package hr.tvz.android.listastefan

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast

class MainActivity : BaseClass() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filter = IntentFilter(Intent.ACTION_BATTERY_LOW)
        val batteryReceiver = BatteryReceiver()
        registerReceiver(batteryReceiver, filter)

        val fragmentManager = supportFragmentManager.beginTransaction()

        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            fragmentManager.replace(R.id.main, ListFragment())

            val detailFragment = supportFragmentManager.findFragmentByTag("detail") as DetailFragment?
            if (detailFragment != null) {
                fragmentManager
                    .remove(detailFragment)
                    .commit()
            } else {
                fragmentManager.commit()
            }
        } else {
            fragmentManager
                .replace(R.id.main, ListFragment())
                .replace(R.id.detail_frame, DetailFragment(), "detail")
                .commit()
        }
    }

    fun change(item : DataClass) {
        val detailFragment = supportFragmentManager.findFragmentByTag("detail") as DetailFragment

        detailFragment.change(item.dataTitle, item.dataDescription, item.dataImage)
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