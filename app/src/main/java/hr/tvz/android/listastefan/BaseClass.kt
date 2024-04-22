package hr.tvz.android.listastefan

import android.app.AlertDialog
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

open class BaseClass: AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.share_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.share -> {
                val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                builder
                    .setMessage("Are you sure you want to share this data?")
                    .setTitle("Share data")
                    .setPositiveButton("Share") { _, _ ->
                        val uniqueActionString = "hr.tvz.android.listastefan"
                        val broadcastIntent = Intent()
                        broadcastIntent.action = uniqueActionString
                        sendBroadcast(broadcastIntent)
                    }
                    .setNegativeButton("Cancel") { _, _ -> }

                val dialog: AlertDialog = builder.create()
                dialog.show()

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}