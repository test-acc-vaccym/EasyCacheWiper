package com.chornerman.easycachewiper

import android.os.Environment
import java.io.IOException

class Directory(private val path: String, headText: String, descriptionText: String) :
        Item(null, headText, descriptionText) {

    override fun onItemClick(): String? {
        wipe()
        return null
    }

    private fun wipe() {
        val result = execute("rm -rf $path/*")
        if (!result.isEmpty())
            throw IOException("Unable to wipe $path")
    }

    fun getPath(): String {
        return path
    }

    fun isInSdCard(): Boolean {
        return path.startsWith(Environment.getExternalStorageDirectory().path)
    }

    fun getSize(): String {
        val output = execute("du -csh $path | tail -n1\n")
                .replace("total", "").trim()
        return when {
            output.isEmpty() -> throw IOException("Unable to get size of $path")
            else -> "${output}B"
        }
    }
}