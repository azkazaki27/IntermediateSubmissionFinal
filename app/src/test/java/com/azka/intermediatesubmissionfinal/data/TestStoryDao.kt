package com.azka.intermediatesubmissionfinal.data

import androidx.paging.PagingSource
import com.azka.intermediatesubmissionfinal.data.local.entity.Story
import com.azka.intermediatesubmissionfinal.data.local.room.StoryDao

class TestStoryDao: StoryDao {

    private var storyData = mutableListOf<Story>()

    override suspend fun insert(stories: List<Story>) {
        TODO("Not yet implemented")
//        storyData.addAll(stories)
    }

    override fun getAll(): PagingSource<Int, Story> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAll() {
        TODO("Not yet implemented")
//        storyData.clear()
    }
}