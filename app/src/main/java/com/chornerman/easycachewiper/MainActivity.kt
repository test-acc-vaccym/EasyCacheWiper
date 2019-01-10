package com.chornerman.easycachewiper

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_items_list.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    fun initUI() {
        sysCacheWiperViewGroup.headTextView.text = "SYSTEM CACHE WIPER"
        sysCacheWiperViewGroup.descriptionTextView
                .text = "Wipe ART cache and cache partition, help solving rom and application problem, such as crashing, also required when flashing something new"
        sysCacheWiperViewGroup.mainContainer.setOnClickListener {
            startActivity(Intent(this@MainActivity, CacheWiperActivity::class.java))
        }

        deviceOptimizerViewGroup.headTextView.text = "DEVICE OPTIMIZER"
        deviceOptimizerViewGroup.descriptionTextView
                .text = "Improve performance and battery life by modifying files"
        deviceOptimizerViewGroup.mainContainer.setOnClickListener {
            startActivity(Intent(this@MainActivity, DeviceOptimizerActivity::class.java))
        }

        appManagerViewGroup.headTextView.text = "APPLICATIONS MANAGER"
        appManagerViewGroup.descriptionTextView
                .text = "Manage your applications to free storage space and improve performance by uninstall, hibernate, clear cache, etc"
        appManagerViewGroup.mainContainer.setOnClickListener {
            startActivity(Intent(this@MainActivity, ApplicationsManagerActivity::class.java))
        }
    }
}