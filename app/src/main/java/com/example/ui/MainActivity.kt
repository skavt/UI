package com.example.ui

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Snackbar messages
        btn_uninstall.setOnClickListener {
            Snackbar.make(btn_uninstall, R.string.button_uninstall, Snackbar.LENGTH_SHORT).show()
        }
        btn_open.setOnClickListener {
            Snackbar.make(btn_open, R.string.button_open, Snackbar.LENGTH_SHORT).show()
        }
        similar.setOnClickListener {
            Snackbar.make(similar, R.string.sample_similar, Snackbar.LENGTH_SHORT).show()
        }
        travel.setOnClickListener {
            Snackbar.make(travel, R.string.sample_travel, Snackbar.LENGTH_SHORT).show()
        }

        // Toolbar back arrow
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.title = ""
        setSupportActionBar(toolbar)

        // Horizontal scrollable images
        val horizontalLayoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        images.layoutManager = horizontalLayoutManager
        images.setHasFixedSize(true)
        loadImagesAndSetAdapter()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    private fun loadImagesAndSetAdapter() {
        val imageList = ArrayList<String>()
        imageList.add("sc_1")
        imageList.add("sc_2")
        imageList.add("sc_3")
        imageList.add("sc_4")
        imageList.add("sc_5")
        imageList.add("sc_6")

        images.adapter = AppImagesAdapter(imageList, this)
    }
}