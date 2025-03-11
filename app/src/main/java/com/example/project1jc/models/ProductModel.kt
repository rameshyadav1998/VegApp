package com.example.project1jc.models

data class ProductModel(
    val imageId : Int,
    val title : String,
    var requiredQty : String = "10",
    val pickedQty : String = "0",
    val qtyType : String = "kg"
)
