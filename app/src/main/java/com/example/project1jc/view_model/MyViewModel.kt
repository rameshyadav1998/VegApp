package com.example.project1jc.view_model

import androidx.lifecycle.ViewModel
import com.example.project1jc.R
import com.example.project1jc.models.ProductModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MyViewModel : ViewModel() {

    val productList = mutableListOf<ProductModel>().apply {
        add(ProductModel(
            R.drawable.tomato,
            "Tomato",
        ))
        add(ProductModel(
            R.drawable.tomato,
            "Tomato",
        ))
        add(ProductModel(
            R.drawable.tomato,
            "Tomato",
        ))
        add(ProductModel(
            R.drawable.tomato,
            "Tomato",
        ))
        add(ProductModel(
            R.drawable.tomato,
            "Tomato",
        ))
        add(ProductModel(
            R.drawable.tomato,
            "Tomato",
        ))
        add(ProductModel(
            R.drawable.tomato,
            "Tomato",
        ))
    }

    private val _products = MutableStateFlow<List<ProductModel>>(productList)
    val products : StateFlow<List<ProductModel>> = _products

}