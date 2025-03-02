package com.example.twittersearch

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.domashna1.R

class MainActivity : AppCompatActivity() {
    private lateinit var searchQuery: EditText
    private lateinit var searchTag: EditText
    private lateinit var saveButton: Button
    private lateinit var taggedListView: ListView
    private lateinit var clearButton: Button

    private val taggedSearches = mutableListOf("Cat", "Dog", "Mountain", "AI", "Flying cars", "Nature")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchQuery = findViewById(R.id.searchQuery)
        searchTag = findViewById(R.id.searchTag)
        saveButton = findViewById(R.id.saveButton)
        taggedListView = findViewById(R.id.taggedListView)
        clearButton = findViewById(R.id.clearButton)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, taggedSearches)
        taggedListView.adapter = adapter

        saveButton.setOnClickListener {
            val tag = searchTag.text.toString()
            if (tag.isNotEmpty()) {
                taggedSearches.add(tag)
                adapter.notifyDataSetChanged()
                searchTag.text.clear()
                searchQuery.text.clear()
            } else {
                Toast.makeText(this, "Enter a valid tag", Toast.LENGTH_SHORT).show()
            }
        }

        clearButton.setOnClickListener {
            taggedSearches.clear()
            adapter.notifyDataSetChanged()
        }
    }
}
