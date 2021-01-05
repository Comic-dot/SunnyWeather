package com.unnyweather.android.ui.place

import androidx.lifecycle.*

import com.sunnyweather.android.logic.model.Place
import com.unnyweather.android.logic.Repository

class PlaceViewModel : ViewModel() {

    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }



}