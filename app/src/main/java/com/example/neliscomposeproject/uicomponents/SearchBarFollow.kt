package com.example.neliscomposeproject.uicomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.neliscomposeproject.R


@Composable
fun MySearchBar(modifier: Modifier = Modifier) {

    var searchText by remember { mutableStateOf(TextFieldValue("")) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(colorResource(id = R.color.lightGrey), CircleShape),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painterResource(id = R.drawable.ic_search),
//            imageVector = Icons.Default.Search,
            contentDescription = null,
            modifier = Modifier.padding(start = 16.dp),
//            tint = MaterialTheme.colors.primary
        )


        TextField(
            value = searchText,
            placeholder = {
                Text(stringResource(R.string.searchPlaceHolder))
            },

            onValueChange = {
                searchText = it
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.None
            ),
            textStyle = TextStyle(
                color = Color.Black,
                fontFamily = FontFamily.SansSerif
            ),
        )

    }
}


@Preview
@Composable
fun SearchPreview() {
    MySearchBar()
}