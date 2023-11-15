package com.example.phonebook

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    companion object {
        const val DISPLAY_INFO_ACTIVITY_CODE = "DISPLAY_INFO_ACTIVITY_CODE"
    }

    private val userList: ArrayList<User> = arrayListOf()
    private lateinit var mAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAdapter = UserAdapter(userList).apply {
            onClickItem = {
                navigateToUserDetail(it)
            }
        }

        repeat(5) {
            userList.add(
                User(
                    it,
                    "Chi Hieu",
                    "0969123456",
                    "chihieu@gmail.com"
                )
            )
        }
        repeat(5) {
            userList.add(
                User(
                    it,
                    "Hieu",
                    "1234567890",
                    "hieu@gmail.com"
                )
            )
        }


        findViewById<RecyclerView>(R.id.recyclerViewMain).apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun navigateToUserDetail(user: User) {
        val i = Intent(applicationContext, DisplayInfoActivity::class.java)
        i.putExtra(DISPLAY_INFO_ACTIVITY_CODE, user)
        startActivity(i)
    }
}
