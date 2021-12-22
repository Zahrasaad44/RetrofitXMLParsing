package com.example.retrofitxmlparsing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitxmlparsing.databinding.FeedItemBinding

class FeedAdapter(var feed: ArrayList<Feed?>): RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {
    class FeedViewHolder(val binding: FeedItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return FeedViewHolder(FeedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val item = feed[position]

        holder.binding.apply {
            titleTV.text = item?.channel.toString()
        }
    }

    override fun getItemCount() = feed.size

    fun showFeed(feed: ArrayList<Feed?>) {
        this.feed = feed
        notifyDataSetChanged()
    }
}