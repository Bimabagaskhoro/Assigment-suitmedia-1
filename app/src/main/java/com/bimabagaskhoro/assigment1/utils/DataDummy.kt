package com.bimabagaskhoro.assigment1.utils

import com.bimabagaskhoro.assigment1.R
import com.bimabagaskhoro.assigment1.domain.model.ItemEvent

object DataDummy {
    fun dataEvent(): List<ItemEvent> {
        val events = ArrayList<ItemEvent>()

        events.add(
            ItemEvent(
                1,
                "good programmer",
                R.drawable.programmer,
                "12 Aug 2022"
            )
        )

        events.add(
            ItemEvent(
                2,
                "Music for life",
                R.drawable.musicrock,
                "1 Sep 2022"
            )
        )

        events.add(
            ItemEvent(
                3,
                "Boot-camp",
                R.drawable.meet,
                "12 Apr 2022"
            )
        )

        events.add(
            ItemEvent(
                4,
                "English lecture",
                R.drawable.englishclub,
                "1 Jan 2022"
            )
        )

        return events
    }

}