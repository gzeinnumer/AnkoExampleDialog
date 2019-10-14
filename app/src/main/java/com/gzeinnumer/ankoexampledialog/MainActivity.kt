package com.gzeinnumer.ankoexampledialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

@Suppress("UNUSED_ANONYMOUS_PARAMETER")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            toast("Hi there!")
            toast(R.string.app_name)
            longToast("Wow, such duration")
        }

        btn2.setOnClickListener {
            alert("Hi, I'm Zein", "Have you tried turning it off and on again?") {
                yesButton { toast("Oh…") }
                noButton {}
            }.show()
        }


        btn3.setOnClickListener {
            val countries = listOf("Russia", "USA", "Japan", "Australia")
            selector("Where are you from?", countries) { dialogInterface, i ->
                toast("So you're living in ${countries[i]}, right?")
            }
        }
        btn4.setOnClickListener {
            val dialog = progressDialog(message = "Please wait a bit…", title = "Fetching data")
        }
    }
}
