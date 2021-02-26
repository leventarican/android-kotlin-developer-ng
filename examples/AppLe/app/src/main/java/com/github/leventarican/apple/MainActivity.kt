package com.github.leventarican.apple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val dataset = Datasource().loadProgrammingLanguages()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        // we have our data and our RecyclerView
        // time to connect.

        recyclerView.adapter = ItemAdapter(this, dataset)
    }

}
