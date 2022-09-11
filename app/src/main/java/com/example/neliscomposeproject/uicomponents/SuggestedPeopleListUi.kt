package com.example.neliscomposeproject.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.neliscomposeproject.ui.theme.NelisComposeProjectTheme
import com.example.neliscomposeproject.utils.dummyUserData

@Composable
fun AlignSuggestedPeople(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 8.dp),
        modifier = modifier
    ) {
        items(dummyUserData) { item ->
            SuggestedPeople(item.drawable, item.text, item.text)
        }
    }
}




@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun AlignSuggestedPeopleRowPreview() {
    NelisComposeProjectTheme { AlignSuggestedPeople() }
}


