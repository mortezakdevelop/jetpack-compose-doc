package com.example.jetpackcomposepracticedocument

import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.modifier.ModifierLocal
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposepracticedocument.ui.theme.JetpackComposePracticeDocumentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scrollState = rememberScrollState()
            Column (modifier = Modifier.verticalScroll(scrollState).fillMaxSize().padding(16.dp)) {
                Counter()
                TextWithBackground()
                ClickableTextShowAlertDialog()
            }
        }
    }
}


data class MessageList(val name: String, val family: String)

@Composable
fun ShowMessage(name: MessageList) {
    Row(modifier = Modifier.padding(8.dp)) {

        Image(
            painter = painterResource(
                R.drawable.ic_launcher_background
            ), contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Column {
            Text(text = name.name, color = MaterialTheme.colorScheme.secondary)
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = name.family)
        }
    }
}

//a simple button
@Composable
fun ClickCounter(click: Int, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Clicked on text $click time")
    }
}

//show a simple text on center screen
@Composable
fun ShowTextOnCenterScreen(text: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = text)
    }
}

// counter number with remember
@Composable
fun Counter(){
    var count by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Number is $count")
        Button(onClick = {count++}) {
            Text("Add number")
        }
    }
}

//click button and show dialog
@Composable
fun ClickableTextShowAlertDialog() {
    val showDialog  =  remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Button(onClick = {showDialog.value = true}) {
            Text("Alert dialog")
            DefaultAlertDialog(showDialog)
        }
    }
}

@Composable
fun TextWithBackground(){
    CustomStyledText(
        displayText = "this is Custom Text flsdfsdfsfsdfsfsfsf",
        style = TextStyle(
            fontSize = 10.sp,
            shadow = Shadow(
                color = Color.Blue,
                offset = Offset.Infinite,
                blurRadius = 0.2f
            )
        )
    )
}

@Composable
fun CustomStyledText(displayText: String, style: TextStyle? = null, maxLines: Int? = null) {
    // We should think of composable functions to be similar to lego blocks - each composable
    // function is in turn built up of smaller composable functions. Here, the Text() function is
    // pre-defined by the Compose UI library; you call that function to declare and render text
    // in your app.
    Text(
        text = displayText,
        modifier = Modifier.padding(16.dp),
        style = style ?: TextStyle.Default,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines ?: Int.MAX_VALUE
    )
    // A pre-defined composable that renders a thin line on the screen that makes it easy to
    // group contents
    HorizontalDivider(color = Color.Gray)
}


//Alert dialog
@Composable
fun DefaultAlertDialog(showDialog:MutableState<Boolean>){
    if (showDialog.value){
        AlertDialog(
            onDismissRequest = {showDialog.value = false},
            title = { Text("dialog title") },
            text = { Text("this is a compose dialog") },
            confirmButton = {
                Button(onClick = {showDialog.value = false }) {
                    Text("Ok")
                }
            },
            dismissButton = {
                Button(onClick = {showDialog.value = false}) {
                    Text("Dismiss")
                }
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ShowMessagePreview() {
    JetpackComposePracticeDocumentTheme {
        ShowMessage(MessageList("Android", "Compose"))

    }
}