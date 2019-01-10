package com.chornerman.easycachewiper

open class Item(private val command: String?, private val headText: String,
                private val descriptionText: String) : Executable {

    open fun onItemClick(): String? {
        return execute(command!!)
    }

    fun getHeadText(): String {
        return headText
    }

    fun getDescriptionText(): String {
        return descriptionText
    }
}