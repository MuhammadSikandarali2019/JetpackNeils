package com.example.neliscomposeproject.activities

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
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
import androidx.compose.ui.unit.sp
import com.example.neliscomposeproject.R
import com.example.neliscomposeproject.ui.theme.NelisComposeProjectTheme
import com.example.neliscomposeproject.ui.theme.Satosh
import com.example.neliscomposeproject.uicomponents.MyTopAppBar
import org.intellij.lang.annotations.JdkConstants

class CreatePostActivity : ComponentActivity() {
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


                    MainContentCreatePost(this)
                }
            }
        }
    }
}


@Composable
fun TaskItem(
    taskName: String,
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
    drawableId: Int
) {
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = drawableId),
            contentDescription = null,
            modifier = Modifier.padding(start = 8.dp)
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = taskName,
            fontFamily = Satosh
        )
        IconButton(
            onClick = onClose,
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_navigate_next_24),
                contentDescription = null
            )
//            painterResource(id = R.drawable.ic_baseline_navigate_next_24)
//            Icon(Icons.Filled.ArrowForward, contentDescription = "Close")
        }
    }
}


@Composable
fun CreatePostRowAutoDelete(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {


    var checkValue by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier,
//        colorResource(id = R.color.lightGrey)
//        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Image(
            painter = painterResource(id = R.drawable.ic_calendar),
            contentDescription = null,
            modifier = Modifier.padding(start = 8.dp)
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = taskName,
            fontFamily = Satosh
        )
        Switch(
            checked = checkValue,
            onCheckedChange = {


                checkValue = it
            }
        )
//        IconButton(onClick = onClose) {
//            Icon(Icons.Filled.Close, contentDescription = "Close")
//        }
    }
}

@Composable
fun PreviewItemRow() {
    CreatePostRowAutoDelete("Auto Delete-Post in Week", true, onCheckedChange = {},
        onClose = {})
//
//    Spacer(modifier = Modifier.height(16.dp))
//    WellnessTaskItem("Nelis Compose", onClose = { })
}


@Composable
private fun WriteCaptionRow(modifier: Modifier, drawableId: Int = R.drawable.ic_rect6) {

    var noteText by remember { mutableStateOf(TextFieldValue("")) }
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = drawableId),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 8.dp)
                .width(72.dp)
                .height(72.dp)
        )


        TextField(
            modifier = Modifier.align(Alignment.Top),
            value = noteText,
            placeholder = {
                Text(stringResource(R.string.note))
            },
            onValueChange = {
                noteText = it
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

//        Text(
//            modifier = Modifier
//                .weight(1f)
//                .padding(start = 16.dp),
//            text = "write a note",
//            fontFamily = Satosh
//        )

    }
}


@Composable
private fun MainContentCreatePost(context: Activity) {
    Scaffold(
//        modifier = Modifier.background(colorResource(id = R.color.followBtnColor)),
        topBar = {
            MyTopAppBar(context, "Create Post")
        },

        bottomBar = {

            PublishButton(context)
        }

    ) { padding ->

        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        )
        {
            Modifier.padding(padding)

            WriteCaptionRow(modifier = Modifier)
            Spacer(modifier = Modifier.height(24.dp))
            Divider()
            TaskItem(
                stringResource(id = R.string.addHashtag),
                onClose = {},
                modifier = Modifier,
                R.drawable.ic_hashtag
            )

            Divider()
            TaskItem(
                stringResource(id = R.string.addFriend),
                onClose = {},
                modifier = Modifier,
                R.drawable.ic_user_add
            )
            Divider()
            CreatePostRowAutoDelete(
                stringResource(id = R.string.autoDelete), true, onCheckedChange = {},
                onClose = {})


        }

    }


}

@Composable
private fun PublishButton(context: Context) {


    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(


            onClick = {

                Toast.makeText(context, "Publish Changes", Toast.LENGTH_SHORT).show()
                // do something here
            },
            Modifier
                .width(300.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.followBtnColor)),

            ) {
            Text(text = "Publish", fontSize = 14.sp, color = Color.White)
        }
    }


}

@Preview
@Composable
private fun PreviewMainContentCreatePost() {
    MainContentCreatePost(context = CreatePostActivity())
}