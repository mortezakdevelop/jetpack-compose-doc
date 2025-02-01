package com.example.jetpackcomposepracticedocument

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposepracticedocument.ui.theme.JetpackComposePracticeDocumentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    // Here, SimpleText is a Composable function which is going to describe the contents of
                    // this activity that will be rendered on the screen.
                    ShowTextOnCenterScreen("This is the Learn Jetpack Compose By Example tutorial")
                }
            )
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

@Composable
fun ClickCounter(click: Int, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Clicked on text $click time")
    }
}

//show a simple text on center screen
@Composable
fun ShowTextOnCenterScreen(text: String) {
    Text(text = text)
}


@Preview(showBackground = true)
@Composable
fun ShowMessagePreview() {
    JetpackComposePracticeDocumentTheme {
        ShowMessage(MessageList("Android", "Compose"))

    }
}