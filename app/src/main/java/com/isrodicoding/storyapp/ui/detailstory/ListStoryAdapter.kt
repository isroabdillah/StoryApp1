package com.isrodicoding.storyapp.ui.detailstory

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.isrodicoding.storyapp.R

class ListStoryAdapter(private val listStories: ArrayList<Story>) : RecyclerView.Adapter<ListStoryAdapter.ViewHolder>(){
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvUser: TextView = view.findViewById(R.id.tv_item_name)
        val imgPhoto: ImageView = view.findViewById(R.id.iv_item_photo)
        val tvDesc: TextView = view.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_story, viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Glide.with(viewHolder.itemView.context)
            .load(listStories[position].photo)
            .into(viewHolder.imgPhoto)
        viewHolder.tvUser.text = listStories[position].user
        viewHolder.tvDesc.text = listStories[position].description

        viewHolder.itemView.setOnClickListener {
            val optionsCompat: ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                viewHolder.itemView.context as Activity,
                Pair(viewHolder.imgPhoto, "img_story_detail_transition"),
                Pair(viewHolder.tvUser, "tv_username_detail_transition"),
                Pair(viewHolder.tvDesc, "tv_description_detail_transition")
            )

            val intent = Intent(viewHolder.itemView.context, DetailStoryActivity::class.java)
            intent.putExtra(DetailStoryActivity.DETAIL_STORY, listStories[position])
            viewHolder.itemView.context.startActivity(intent, optionsCompat.toBundle())
        }
    }

    override fun getItemCount(): Int {
        return listStories.size
    }
}