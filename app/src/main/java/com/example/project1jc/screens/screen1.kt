package com.example.project1jc.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
    
    Box {
        LazyColumn() {
            items(productLists) { product ->
                ProductItem(product,navController)
            }
        }
        
        Button(
            onClick = { navController.navigate("screen2") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .align(Alignment.BottomCenter),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Yellow,
                contentColor = Color.Black
            )
        ) {
            Text(text = "Start Picking")
            
        }
    }

    

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductItem(product: ProductModel, navController: NavHostController) {

    Box(
        modifier = Modifier.background(Color.White).padding(5.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Row {
                Image(
                    painter = painterResource(id = product.imageId),
                    contentDescription = "image",
                    modifier = Modifier.size(120.dp)
                )

                Spacer(modifier = Modifier.padding(6.dp))

                Column(
                ) {
                    Text(text = product.title, fontWeight = FontWeight.Black, fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column() {
                            Text(text = "Required Qty", fontSize = 12.sp, color = Color.Gray)
                            Card(
                                shape = RoundedCornerShape(4.dp),
                                colors = CardDefaults.cardColors(Color.Gray),
                                modifier = Modifier.padding(10.dp)
                            ){
                                Text(text = "${product.requiredQty} kg", color = Color.Black, modifier = Modifier.padding(16.dp),textAlign = TextAlign.End)
                            }
                        }

                        Column () {
                            Text(text = "Picked Qty", fontSize = 12.sp, color = Color.Gray)
                            Card(
                                shape = RoundedCornerShape(4.dp),
                                colors = CardDefaults.cardColors(Color.Gray),
                                modifier = Modifier.padding(10.dp)
                            ){
                                Text(text = "${product.pickedQty} kg", color = Color.Black, modifier = Modifier.padding(16.dp), textAlign = TextAlign.End)
                            }
                        }

                    }
                }
            }
        }
    }
}
