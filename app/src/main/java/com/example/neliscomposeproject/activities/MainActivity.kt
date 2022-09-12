package com.example.neliscomposeproject.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.neliscomposeproject.R
import com.example.neliscomposeproject.ui.theme.NelisComposeProjectTheme
import com.example.neliscomposeproject.ui.theme.Satosh
import com.example.neliscomposeproject.uicomponents.AlignSuggestedPeople
import com.example.neliscomposeproject.uicomponents.MySearchBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NelisComposeProjectTheme {

                MainActivityContent(this)
            }
        }
    }
}

@Composable
private fun MyBottomNavigation(modifier: Modifier = Modifier, activity: MainActivity) {
    BottomNavigation(modifier, backgroundColor = MaterialTheme.colors.background) {
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_home),
                    contentDescription = null
                )
            },
//            label = {
//                Text(stringResource(R.string.bottomNav_home))
//            },
            selected = true,
            onClick = {


            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_search),
                    contentDescription = null
                )
            },
//            label = {
//                Text(stringResource(R.string.bottomNav_search))
//            },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_add),
                    contentDescription = null
                )
            },
//            label = {
//                Text(stringResource(R.string.bottomNav_add))
//            },
            selected = false,
            onClick = {

                val intent = Intent(activity, CreatePostActivity::class.java)
                activity.startActivity(intent)
            }
        )

        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_sms),
                    contentDescription = null
                )
            },
//            label = {
//                Text(stringResource(R.string.bottomNav_message))
//            },
            selected = false,
            onClick = {}
        )

        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_user),
                    contentDescription = null
                )
            },
//            label = {
//                Text(stringResource(R.string.bottomNav_user))
//            },
            selected = false,
            onClick = {

                val intent = Intent(activity, ProfileActivity::class.java)
                activity.startActivity(intent)

            }
        )
    }
}


@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier.verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(32.dp))
        MySearchBar()
//        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSectionOne(title = R.string.suggestedPeople) {
            AlignSuggestedPeople()
        }
        HomeSection(title = R.string.discoverFeeds) {
//            AlignSuggestedPeople()
//            ImagesCollectionsGrid()
            PhotoGrid()
//            ImagesCollectionsGrid()

        }
        Spacer(Modifier.height(16.dp))
    }
}


@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        Spacer(Modifier.height(16.dp))
        content()
    }
}

@Composable
fun HomeSectionOne(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(16.dp),
            textAlign = TextAlign.End,
            text = "View All",
            fontFamily = Satosh,
            color = MaterialTheme.colors.primary
        )


    }

    Column {
        Spacer(Modifier.height(16.dp))
        content()
    }
}


@Composable
fun MainActivityContent(context: MainActivity) {
    NelisComposeProjectTheme {
        Scaffold(

//            topBar = {
//                MyTopAppBarMainScreen(context)
//            },
            bottomBar = { MyBottomNavigation(Modifier, context) }
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NelisComposeProjectTheme {

        MainActivityContent(MainActivity())
//        Scaffold(
//            bottomBar = { MyBottomNavigation() }
//        ) { padding ->
//            HomeScreen(Modifier.padding(padding))
//        }


    }
}

