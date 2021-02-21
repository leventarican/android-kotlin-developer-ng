package com.github.leventarican.room

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class NewProgrammingLanguageActivity : AppCompatActivity() {

    private lateinit var editProgrammingLanguageView: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_programming_language)

        editProgrammingLanguageView = findViewById(R.id.edit_programmingLanguage)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editProgrammingLanguageView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val programmingLanguage = editProgrammingLanguageView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, programmingLanguage)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }

    }

    companion object {
        const val EXTRA_REPLY = "programmingLanguage.REPLY"
    }

}