package com.example.andfic

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

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

        // Fix the IDs to match XML
        searchQuery = findViewById(R.id.editTextSearch)
        searchTag = findViewById(R.id.editTextTag)
        saveButton = findViewById(R.id.buttonSave)
        clearButton = findViewById(R.id.buttonClear)
        taggedListView = findViewById(R.id.taggedListView) // Ensure ListView exists in XML

        // Set up ListView adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, taggedSearches)
        taggedListView.adapter = adapter

        // Save button click event
        saveButton.setOnClickListener {
            val tag = searchTag.text.toString().trim()
            if (tag.isNotEmpty()) {
                taggedSearches.add(tag)
                adapter.notifyDataSetChanged()
                searchTag.text.clear()
                searchQuery.text.clear()
            } else {
                Toast.makeText(this, "Enter a valid tag", Toast.LENGTH_SHORT).show()
            }
        }

        // Clear button click event
        clearButton.setOnClickListener {
            taggedSearches.clear()
            adapter.notifyDataSetChanged()
        }
    }
}
