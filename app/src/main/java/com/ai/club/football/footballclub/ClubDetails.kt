package com.ai.club.football.footballclub

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Layout
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar

class ClubDetails : AppCompatActivity() {

    private var name: String = ""
    private var detail: String = ""
    private var clubImageID: Int = 0

    lateinit var nameTextView: TextView
    lateinit var detailsTextView: TextView
    lateinit var imgView: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        verticalLayout {
            padding = dip(16)
            gravity = Gravity.CENTER_HORIZONTAL

            imgView = imageView {
            }.lparams(width= matchParent) {
                        padding = dip(20)
                        margin = dip(15)
                        width = dip (60)
                        height = dip (80)
                    }

            nameTextView = textView {
                textSize = 24f
                textColor = Color.BLACK
            }.lparams {

                padding = dip(20)
                margin = dip(15)
                height = dip (40)
            }


            detailsTextView = textView {
                textColor = Color.DKGRAY
            }.lparams {
                padding = dip(20)
                margin = dip(15)
            }


        }

        val intent = intent
        name = intent.getStringExtra("name")
        detail = intent.getStringExtra("detail")
        clubImageID = intent.getIntExtra("imageID",0)

        nameTextView.text = name
        detailsTextView.text = detail
        Glide.with(this).load(clubImageID).into(imgView)

    }
}