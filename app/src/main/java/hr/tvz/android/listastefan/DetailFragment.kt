package hr.tvz.android.listastefan

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    private lateinit var title: TextView
    private lateinit var description: TextView
    private lateinit var itemImage: ImageView

    lateinit var shark : DataClass

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView : View = inflater.inflate(R.layout.fragment_detail, container, false)

        shark = DataClass(R.mipmap.shark, "", "")

        title= rootView.findViewById(R.id.itemTitle)
        description = rootView.findViewById(R.id.itemDescription)
        itemImage = rootView.findViewById(R.id.itemImage)
        val linkButton: Button = rootView.findViewById(R.id.linkBt)

        itemImage.setOnClickListener {
            val intent = Intent(this.context, ImageActivity::class.java)
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

        return rootView
    }

    fun change(titleText : String, descriptionText : String, image : Int) {
        title.text = titleText
        description.text = descriptionText
        itemImage.setImageResource(image)
        shark = DataClass(image, titleText, descriptionText)
    }

}