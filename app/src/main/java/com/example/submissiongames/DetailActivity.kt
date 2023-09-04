package com.example.submissiongames

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_activity)
        supportActionBar?.title = "Detailed Games"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val imageGames = findViewById<ImageView>(R.id.img_item_photo)
        val nameGames = findViewById<TextView>(R.id.tv_item_name)
        val descGames = findViewById<TextView>(R.id.tv_item_description)
        val btnShare = findViewById<FloatingActionButton>(R.id.action_share)

        btnShare.setOnClickListener {

            val actionShare = "${nameGames.text}\n${descGames.text}"
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, actionShare)

            val chooser = Intent.createChooser(intent, "Share using...")
            startActivity(chooser)
        }

        val games: Games? = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("key_games", Games::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("key_games")
        }
        imageGames.setImageResource(games!!.photo)
        nameGames.text = games.name
        descGames.text = games.description
    }
}
