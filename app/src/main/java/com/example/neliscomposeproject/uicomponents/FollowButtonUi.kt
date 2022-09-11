package com.example.neliscomposeproject.uicomponents

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun FollowButton()
{
    Button(
        onClick = {
            // do something here
        },
        shape = RoundedCornerShape(50)
    ) {
        Text(text = "Follow", fontSize = 10.sp)
    }
}


@Preview
@Composable
fun FollowButtonPreview()
{
    FollowButton()
}
