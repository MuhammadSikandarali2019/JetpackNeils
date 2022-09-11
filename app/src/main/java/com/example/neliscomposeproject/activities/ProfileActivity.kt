package com.example.neliscomposeproject.activities

import android.app.Activity
import android.os.Bundle
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neliscomposeproject.R
import com.example.neliscomposeproject.activities.ui.theme.NelisComposeProjectTheme
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

//                    Greeting2("Android")
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
            Spacer(modifier = Modifier.height(16.dp))
            ProfileProperty(label = "Name", value = "Selena Grande")
            Spacer(modifier = Modifier.height(16.dp))
            ProfileProperty(label = "Username", value = "Selena Grande")
            Spacer(modifier = Modifier.height(16.dp))
            ProfileProperty(label = "Bio", stringResource(id = R.string.bio))
            Spacer(modifier = Modifier.height(16.dp))

            Row() {
                SaveChangesButton()
            }


        }

    }
}


@Composable
fun SaveChangesButton() {
    Button(
        modifier = Modifier.fillMaxWidth().height(40.dp),
        onClick = {
            // do something here
        },
        shape = RoundedCornerShape(50)
    ) {
        Text(text = "Save Changes", fontSize = 12.sp)
    }
}


//@Composable
//private fun ProfileHeader(
//    scrollState: ScrollState,
//    data: ProfileScreenState,
//    containerHeight: Dp
//) {
//    val offset = (scrollState.value / 2)
//    val offsetDp = with(LocalDensity.current) { offset.toDp() }
//
//    data.photo?.let {
//        Image(
//            modifier = Modifier
//                .heightIn(max = containerHeight / 2)
//                .fillMaxWidth()
//                // TODO: Update to use offset to avoid recomposition
//                .padding(
//                    start = 16.dp,
//                    top = offsetDp,
//                    end = 16.dp
//                )
//                .clip(CircleShape),
//            painter = painterResource(id = it),
//            contentScale = ContentScale.Crop,
//            contentDescription = null
//        )
//    }
//}


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
}


@Composable
fun ProfileProperty(label: String, value: String, isLink: Boolean = false) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider()
        Text(
            text = label,
            modifier = Modifier.baselineHeight(24.dp),
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onSurface
        )
        val style = if (isLink) {
            MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.primary)
        } else {
            MaterialTheme.typography.h6
        }
        Text(
            text = value,
            modifier = Modifier.baselineHeight(24.dp),
            style = style
        )
    }
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

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    NelisComposeProjectTheme {
        Greeting2("Android")
    }
}