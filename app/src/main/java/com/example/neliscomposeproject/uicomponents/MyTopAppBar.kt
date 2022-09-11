package com.example.neliscomposeproject.uicomponents

import android.app.Activity
import android.app.Application
import android.provider.ContactsContract
import android.widget.Toast
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.neliscomposeproject.activities.ProfileActivity


@Composable
fun MyTopAppBar(context: Activity, title: String = "") {
    TopAppBar(
        title = { Text(title) },
        backgroundColor = Color.White,
        navigationIcon = {
            IconButton(onClick = {

                context.finish()
                Toast.makeText(context, "go back ", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
//                    painterResource(id = R.drawable.ic_back_btn),
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Navigation icon"
                )
            }
        }, elevation = 0.dp
    )
}

@Composable
fun MyTopAppBarMainScreen(context: Application, title: String = "") {
    TopAppBar(
        title = { Text(title) },
        backgroundColor = Color.White,
//        navigationIcon = {
//            IconButton(onClick = {
//
//                Toast.makeText(context, "go back ", Toast.LENGTH_SHORT).show()
//            }) {
//                Icon(
////                    painterResource(id = R.drawable.ic_back_btn),
//                    imageVector = Icons.Filled.ArrowBack,
//                    contentDescription = "Navigation icon"
//                )
//            }
//        },
        elevation = 0.dp
    )
}

@Preview
@Composable
fun PreviewTopBar() {
    MyTopAppBar(ProfileActivity(), "Top App Bar")
}
