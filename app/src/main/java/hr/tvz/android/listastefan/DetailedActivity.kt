package hr.tvz.android.listastefan

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailedActivity : BaseClass() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val shark = intent.getParcelableExtra("shark", DataClass::class.java)
        if(shark != null){
            val title: TextView = findViewById(R.id.itemTitle)
            val description: TextView = findViewById(R.id.itemDescription)
            val itemImage: ImageView = findViewById(R.id.itemImage)
            val linkButton: Button = findViewById(R.id.linkBt)

            title.text = shark.dataTitle
            description.text = shark.dataDescription
            itemImage.setImageResource(shark.dataImage)

            itemImage.setOnClickListener {
                val intent = Intent(this, ImageActivity::class.java)
                intent.putExtra("shark_image", shark)
                startActivity(intent)
            }

            linkButton.setOnClickListener{
                val url = resources.getString(R.string.link)
                val urlIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(url)
                )
                startActivity(urlIntent)
            }
        }
    }
}