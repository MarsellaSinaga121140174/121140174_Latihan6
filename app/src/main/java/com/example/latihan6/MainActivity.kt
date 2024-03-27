package com.example.latihan6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihan6.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : ComponentActivity() {

    private val users = mutableListOf<User>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val json = resources.openRawResource(R.raw.users)
            .bufferedReader().use { it.readText() }

        val type = object : TypeToken<List<User>>() {}.type
        val userList: List<User> = Gson().fromJson(json, type)

        users.addAll(userList)

        val recyclerView = binding.rvUsers
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UserAdapter(users)
    }
}