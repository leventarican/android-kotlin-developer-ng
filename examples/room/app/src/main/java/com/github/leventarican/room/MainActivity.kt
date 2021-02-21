package com.github.leventarican.room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.leventarican.room.recyclerview.ProgrammingLanguageListAdapter
import com.github.leventarican.room.room.ProgrammingLanguage
import com.github.leventarican.room.viewmodel.ProgrammingLanguageViewModel
import com.github.leventarican.room.viewmodel.ProgrammingLanguageViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val newProgrammingLanguageActivityRequestCode = 1
    private val programmingLanguageViewModel: ProgrammingLanguageViewModel by viewModels {
        ProgrammingLanguageViewModelFactory((application as ProgrammingLanguageApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = ProgrammingLanguageListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        programmingLanguageViewModel.allLanguages.observe(this) {
            it.let {
                adapter.submitList(it)
            }
        }

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewProgrammingLanguageActivity::class.java)
            startActivityForResult(intent, newProgrammingLanguageActivityRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newProgrammingLanguageActivityRequestCode && resultCode == RESULT_OK) {
            intentData?.getStringExtra(NewProgrammingLanguageActivity.EXTRA_REPLY)?.let { reply ->
                val programmingLanguage = ProgrammingLanguage(reply)
                programmingLanguageViewModel.insert(programmingLanguage)
            }
        } else {
            Toast.makeText(applicationContext, "not saved", Toast.LENGTH_LONG).show()
        }
    }

}