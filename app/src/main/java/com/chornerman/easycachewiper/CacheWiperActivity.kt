package com.chornerman.easycachewiper

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cache_wiper.*
import kotlinx.android.synthetic.main.layout_bottom_toolbar.view.*

class CacheWiperActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cache_wiper)
        toolbar.titleTextView.text = "Cache Wiper"

        val sdCardPath = Environment.getExternalStorageDirectory().path
        val cacheFilesArrayList = ArrayList<Directory>()
        cacheFilesArrayList.add(Directory("/data/dalvik-cache", "wipe art(dalvik) cache",
                "ART cache is a runtime application cache, It will regenerate automatically after being wiped. Wiping this cache might help solving rom and application problem, such as crashing"))
        cacheFilesArrayList.add(Directory("/cache", "wipe partition cache",
                "Cache partition stores temporary system data, wiping it might help making system run more smoothly"))
        cacheFilesArrayList.add(Directory("/data/data/*/cache", "applications cache 1",
                ""))
        cacheFilesArrayList.add(Directory("$sdCardPath/Android/data/*/cache", "applications cache 2",
                ""))
        cacheFilesArrayList.add(Directory("$sdCardPath/DCIM./thumbnails", "wipe gallery thumbnail",
                ""))
        cacheFilesArrayList.add(Directory("/data/local/tmp", "wipe temporary files",
                ""))
        cacheFilesArrayList.add(Directory("/data/log", "wipe log",
                ""))
        cacheFilesArrayList.add(Directory("/data/logger", "wipe logger",
                ""))
        cacheFilesArrayList.add(Directory("/data/system/dropbox", "wipe dropbox",
                ""))
        cacheFilesArrayList.add(Directory("/data/tombstones", "wipe tombstones",
                ""))
        cacheFilesArrayList.add(Directory("/data/system/usagestats", "wipe usage stats",
                ""))
        cacheFilesArrayList.add(Directory("/data/anr", "wipe ANR",
                ""))
        cacheFilesArrayList.add(Directory("$sdCardPath/LOST.DIR", "wipe LOST.DIR directory",
                ""))

        cacheFilesList.layoutManager = LinearLayoutManager(this)
        cacheFilesList.adapter = CacheFilesListAdapter(cacheFilesArrayList, this)
    }
}