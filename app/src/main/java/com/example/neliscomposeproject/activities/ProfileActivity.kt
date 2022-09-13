package com.example.neliscomposeproject.activities

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.Divider
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
import com.example.neliscomposeproject.uicomponents.MyTopAppBar
import com.example.neliscomposeproject.utils.baselineHeight

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NelisComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                   color =  colorResource(id = R.color.followBtnColor),
                    color = MaterialTheme.colors.background
                ) {

                    MainContent(this)

                }
            }
        }
    }
}


@Composable
private fun MainContent(context: Activity) {
    Scaffold(
//        modifier = Modifier.background(colorResource(id = R.color.followBtnColor)),
        topBar = {
            MyTopAppBar(context, "Edit Profile")
        },

        ) { padding ->

        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        )
        {
            Modifier.padding(padding)

            ProfilePicture(R.drawable.editprofimg, R.string.editProfileImg)

            ProfileProperty(label = "Name", value = "Selena Grande")
            ProfileProperty(label = "Username", value = "Selena Grande")
            ProfileProperty(label = "Bio", stringResource(id = R.string.bio))
            Spacer(modifier = Modifier.height(24.dp))
            SaveChangesButton(context)

        }

    }
}


@Composable
fun SaveChangesButton(context : Context) {


    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(


            onClick = {

                      Toast.makeText(context,"Changes Saved.",Toast.LENGTH_SHORT).show()
                // do something here
            }, Modifier.width(300.dp).padding(8.dp),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.followBtnColor)),

            ) {
            Text(text = "Save Changes", fontSize = 14.sp , color = Color.White)
        }
    }


}


@Composable
private fun ProfilePicture(
    @DrawableRes drawable: Int,
    @StringRes name: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = modifier.height(16.dp))
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = modifier.height(8.dp))
        Text(
            color = colorResource(id = R.color.editProfileText),
            text = stringResource(name),
            style = MaterialTheme.typography.h6,
            modifier = Modifier.paddingFromBaseline(
                top = 16.dp, bottom = 8.dp,
            ),

            )
        Spacer(modifier = modifier.height(8.dp))
    }
    Spacer(modifier = Modifier.height(16.dp))
}


@Composable
fun ProfileProperty(label: String, value: String, isLink: Boolean = false) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider()
        Text(
            text = label,
            modifier = Modifier.baselineHeight(24.dp),
            style = MaterialTheme.typography.caption,
//            color = MaterialTheme.colors.onSurface,
            color = colorResource(id = R.color.titleProfile)
        )
        val style = if (isLink) {
            MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.primary)
        } else {
            MaterialTheme.typography.body2
        }
        Text(
            text = value,
            modifier = Modifier.baselineHeight(24.dp),
            style = style
        )
    }

    Spacer(modifier = Modifier.height(8.dp))
}

@Preview
@Composable
private fun ProfilePropPreview() {
    ProfileProperty(label = "Name", value = "Selena Grande")
}

@Preview
@Composable
fun PreviewProfilePhoto() {
    ProfilePicture(R.drawable.userimg_1, R.string.name1)
}

@Preview
@Composable
private fun PreviewMainContent() {
    MainContent(ProfileActivity())
}

//@Composable
//fun Greeting2(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview2() {
//    NelisComposeProjectTheme {
//        Greeting2("Android")
//    }
//}