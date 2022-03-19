package com.bimabagaskhoro.assigment1.ui.event

import androidx.lifecycle.ViewModel
import com.bimabagaskhoro.assigment1.domain.model.ItemEvent
import com.bimabagaskhoro.assigment1.utils.DataDummy
import javax.inject.Inject

class EventViewModel : ViewModel() {
    fun getMovie(): List<ItemEvent> = DataDummy.dataEvent()
}