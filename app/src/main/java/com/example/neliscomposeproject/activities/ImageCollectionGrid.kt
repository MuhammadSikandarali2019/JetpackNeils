package com.example.neliscomposeproject.activities

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.neliscomposeproject.utils.dummyImagesData

@Preview
@Composable
fun ImagesCollectionsGrid(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxHeight()
    ) {
        items(dummyImagesData) { item ->
            ImagesCollectionCard(item.drawable, item.text)
        }
    }
}



@Composable
fun PhotoGrid() {
    LazyVerticalGrid(

        contentPadding = PaddingValues(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        columns = GridCells.Fixed(3),
        modifier = Modifier.height(400.dp)
    ) {

        items(dummyImagesData) { image ->

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                ImagesCollectionCard(image.drawable,image.text)

            }


        }

    }
}


@Preview
@Composable
fun PreviewPhotos()
{
    PhotoGrid()
}





@Composable
fun ImagesCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(20.dp),
//        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(130.dp)
                .height(130.dp)
        )
    }
}
