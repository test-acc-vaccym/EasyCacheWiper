package com.chornerman.easycachewiper

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_items_list.view.*

class CacheFilesListAdapter(private val files: ArrayList<Directory>, private val context: Context) :
        RecyclerView.Adapter<CacheFilesListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CacheFilesListViewHolder {
        return CacheFilesListViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_items_list,
                parent, false))
    }

    override fun getItemCount(): Int {
        return files.size
    }

    override fun onBindViewHolder(viewHolder: CacheFilesListViewHolder, position: Int) {
        viewHolder.mMainContainer.setOnClickListener {
            files[position].onItemClick()
            viewHolder.mFileSizeTextView.text = files[position].getSize()
        }

        viewHolder.mHeadTextView.text = files[position].getHeadText().toUpperCase()
        viewHolder.mDescriptionTextView.text = files[position].getDescriptionText()

        viewHolder.mFileComponentsContainer.visibility = View.VISIBLE
        if (files[position].isInSdCard())
            viewHolder.mFileSizeImageView.setImageResource(R.drawable.ic_sd_storage_accent_22dp)
        else
            viewHolder.mFileSizeImageView.setImageResource(R.drawable.ic_storage_accent_22dp)
        viewHolder.mFileSizeTextView.text = files[position].getSize()
        viewHolder.mFileLocationTextView.text = files[position].getPath()
    }
}

class CacheFilesListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val mMainContainer = view.mainContainer!!
    val mHeadTextView = view.headTextView!!
    val mDescriptionTextView = view.descriptionTextView!!
    val mFileComponentsContainer = view.fileContainer!!
    val mFileSizeImageView = view.fileSizeImageView!!
    val mFileSizeTextView = view.fileSizeTextView!!
    val mFileLocationTextView = view.fileLocationTextView!!
}