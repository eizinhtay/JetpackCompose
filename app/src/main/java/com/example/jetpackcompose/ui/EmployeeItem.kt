package com.example.jetpackcompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.User
import com.google.accompanist.coil.rememberCoilPainter

//https://github.com/ashgautamDev/WalkIn-/tree/master/app/src/main/java/com/ashish/walkin
@ExperimentalMaterial3Api
@Composable
fun EmployeeItem(empData: User, onClick: () -> Unit) {
    Card(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()
        .clickable(onClick = onClick),
        shape = RoundedCornerShape(15.dp),
    ) {

        Row(modifier = Modifier.clip(RoundedCornerShape(4.dp)).background(MaterialTheme.colorScheme.surface)) {
            Surface(
                modifier = Modifier.size(130.dp),
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.surface.copy(
                    alpha = 0.2f)
            ){
                val image = rememberCoilPainter(
                    request = empData.avatar,
                    fadeIn = true)
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .height(100.dp)
                        .clip(shape = RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .align(Alignment.CenterVertically)
            ){
                Text(
                    text = empData.first_name,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(fontSize = 22.sp),
                    color = Color.Black
                )

//                CompositionLocalProvider(
//                    LocalContentAlpha provides ContentAlpha.medium
//                ) {
//
//                }
                Text(
                    text = empData.email,
                    style = typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(end = 25.dp)
                )

            }
        }
    }
    
}