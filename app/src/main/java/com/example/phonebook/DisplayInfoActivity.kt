package com.example.phonebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class DisplayInfoActivity : AppCompatActivity() {

    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        if(intent.hasExtra(MainActivity.DISPLAY_INFO_ACTIVITY_CODE)){
            user = intent.getParcelableExtra(MainActivity.DISPLAY_INFO_ACTIVITY_CODE)
        }

        findViewById<EditText>(R.id.editTextName).setText(user?.name ?: "")
        findViewById<EditText>(R.id.editTextPhone).setText(user?.phone ?: "")
        findViewById<EditText>(R.id.editTextEmail).setText(user?.email ?: "")
    }
}