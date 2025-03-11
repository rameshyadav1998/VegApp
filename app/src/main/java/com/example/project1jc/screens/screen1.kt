package com.example.project1jc.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.project1jc.models.ProductModel
import com.example.project1jc.view_model.MyViewModel

@Composable
fun Screen1(
    navController: NavHostController,
    viewModel: MyViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    val productLists by viewModel.products.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(productLists) { item ->
                VegetableItem(item)
            }
        }
        Button(
            onClick = { /* Handle click */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFD900)),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(50.dp)
        ) {
            Text("Start Picking", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        }
    }
}

@Composable
fun VegetableItem(item: ProductModel) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = item.imageId),
                contentDescription = "image",
                modifier = Modifier.size(60.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(item.title, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                Spacer(modifier = Modifier.height(4.dp))

                Row {
                    Column(modifier = Modifier.weight(1f)) {
                        Text("Required Qty", fontSize = 14.sp, color = Color.Gray)
                        QuantityBox(item.requiredQty)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text("Picked Qty", fontSize = 14.sp, color = Color.Gray)
                        QuantityBox(item.pickedQty)
                    }
                }
            }
        }
    }
}

@Composable
fun QuantityBox(quantity: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFF0F0F0))
            .padding(vertical = 10.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(quantity, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Black)
    }
}