package com.cst2335.entitylist // Make sure this matches your package name

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Assuming you have activity_main.xml

        listView = findViewById(R.id.listView) // Assuming you have a ListView in activity_main.xml

        // Load and parse JSON data
        try {
            val jsonString = assets.open("entities.json").bufferedReader().use { it.readText() }
            val jsonArray = JSONArray(jsonString)

            // Process the JSON array and populate the ListView
            val entities = mutableListOf<Entity>() // Assuming you have an Entity data class
            for (i in 0 until jsonArray.length()) {
                val jsonObject: JSONObject = jsonArray.getJSONObject(i)
                val type = jsonObject.getInt("type")
                val name = jsonObject.getString("name")
                val textType = jsonObject.getString("text_type")

                // Create an Entity object and add it to the list
                entities.add(Entity(type, name, textType))
            }

            // Set the adapter for the ListView (assuming you have an EntityAdapter class)
            val adapter = EntityAdapter(this, entities) // Assuming you have an EntityAdapter class
            listView.adapter = adapter

        } catch (e: IOException) {
            e.printStackTrace() // Handle the exception (e.g., show a message)
        } catch (e: Exception) {
            e.printStackTrace() // Handle any other exceptions
        }
    }
}