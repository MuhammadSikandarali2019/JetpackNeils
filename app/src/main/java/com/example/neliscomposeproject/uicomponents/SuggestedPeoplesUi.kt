package com.example.neliscomposeproject.uicomponents

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neliscomposeproject.R
import com.example.neliscomposeproject.ui.theme.NelisComposeProjectTheme

@Composable
fun SuggestedPeople(
    @DrawableRes drawable: Int,
    @StringRes name: Int,
    @StringRes name2: Int,
    modifier: Modifier = Modifier
) {


    Card(
//        shape = MaterialTheme.shapes.small,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = colorResource(id = R.color.lightGrey),
        modifier = modifier,
        elevation = 0.dp
    )
    {
        Column(
            modifier = modifier
                .width(120.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = modifier.height(8.dp))
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
            )
            Text(
                text = stringResource(name),
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier.paddingFromBaseline(
                    top = 24.dp, bottom = 8.dp,
                )
            )

            Text(
                text = stringResource(name2),
                style = MaterialTheme.typography.caption,
                modifier = Modifier.paddingFromBaseline(
                    top = 8.dp, bottom = 8.dp
                )
            )


            Button(
                onClick = {

                    // do something here
                }, Modifier.width(100.dp),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.followBtnColor)),

            ) {
                Text(text = "Follow", fontSize = 10.sp , color = Color.White)
            }

            Spacer(modifier = modifier.height(8.dp))
        }
    }


}


@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun SuggestedPeoplePreview() {
    NelisComposeProjectTheme {
        SuggestedPeople(
            name = R.string.name1,
            name2 = R.string.name12,
            drawable = R.drawable.userimg_1,
            modifier = Modifier.padding(8.dp)
        )
    }
}