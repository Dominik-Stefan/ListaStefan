package hr.tvz.android.listastefan

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.os.Parcelable
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ImageActivity : BaseClass() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val sharkImage = intent.getParcelableExtra("shark_image", DataClass::class.java)
        if(sharkImage != null){
            val itemImage: ImageView = findViewById(R.id.imageShow)

            itemImage.setImageResource(sharkImage.dataImage)

            itemImage.setOnClickListener{
                val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.image_animation)

                it.startAnimation(animation)
            }
        }
    }
}