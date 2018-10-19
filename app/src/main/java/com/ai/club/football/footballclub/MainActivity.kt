package com.ai.club.football.footballclub


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initData()

        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecyclerViewAdapter(this, items){
           startActivity<ClubDetails>("name" to it.name, "detail" to it.detail, "imageID" to it.image)
        }
    }



    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val detail = resources.getStringArray(R.array.club_detail)
        val image = resources.obtainTypedArray(R.array.club_image)

        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],
                    image.getResourceId(i, 0),detail[i]))
            Log.d("LOG", "Loaded image's ID is...."+image.getResourceId(i, 0))
        }


        //Recycle the typed array
        image.recycle()
    }
}
