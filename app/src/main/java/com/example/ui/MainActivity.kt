package com.example.ui

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.title = ""
        setSupportActionBar(toolbar)

        val horizontalLayoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        rv_app_screenshots.layoutManager = horizontalLayoutManager
        rv_app_screenshots.setHasFixedSize(true)
        loadScreenshotsDataAndSetAdapter()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    private fun loadScreenshotsDataAndSetAdapter() {
        val screenshotImages = ArrayList<String>()
        screenshotImages.add("sc_1")
        screenshotImages.add("sc_2")
        screenshotImages.add("sc_3")
        screenshotImages.add("sc_4")
        screenshotImages.add("sc_5")
        screenshotImages.add("sc_6")

        rv_app_screenshots.adapter = AppScreenshotsAdapter(screenshotImages, this)
    }
}