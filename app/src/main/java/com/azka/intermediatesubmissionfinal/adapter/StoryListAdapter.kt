package com.azka.intermediatesubmissionfinal.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.azka.intermediatesubmissionfinal.R
import com.azka.intermediatesubmissionfinal.data.local.entity.Story
import com.azka.intermediatesubmissionfinal.databinding.ItemStoryBinding
import com.azka.intermediatesubmissionfinal.ui.story.StoryDetailActivity
import com.azka.intermediatesubmissionfinal.ui.story.StoryDetailActivity.Companion.EXTRA_STORY
import com.azka.intermediatesubmissionfinal.ui.story.StoryDetailActivity.Companion.EXTRA_STORY_ID
import com.azka.intermediatesubmissionfinal.utils.DateFormater
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class StoryListAdapter(private val onFavoriteClick: (Story) -> Unit) :
    ListAdapter<Story, StoryListAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val story = getItem(position)
        holder.bind(story)

        val ivFavorite = holder.binding
        if (story.isFavorited) {

        } else {

        }

    }

    class MyViewHolder(val binding: ItemStoryBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(story: Story) {
            binding.tvUserName.text = story.name
            binding.tvDescription.text = story.description
            binding.tvDateUpload.text = DateFormater.formatDate(story.createdAt)
            Glide.with(itemView.context)
                .load(story.photoUrl)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)
                )
                .into(binding.imgPhoto)
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, StoryDetailActivity::class.java)
                intent.putExtra(EXTRA_STORY, story)
                intent.putExtra(EXTRA_STORY_ID, story.id)
                itemView.context.startActivity(intent)
            }
        }
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<Story> =
            object : DiffUtil.ItemCallback<Story>() {
                override fun areItemsTheSame(oldItem: Story, newItem: Story): Boolean {
                    return oldItem.id == newItem.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(oldItem: Story, newItem: Story): Boolean {
                    return oldItem == newItem
                }
            }
    }
}