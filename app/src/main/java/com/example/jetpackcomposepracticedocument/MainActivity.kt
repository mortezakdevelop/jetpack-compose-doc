package com.example.jetpackcomposepracticedocument

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposepracticedocument.ui.theme.JetpackComposePracticeDocumentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePracticeDocumentTheme {
                Surface {
                    ShowMessage(MessageList("Android", "Compose"))
                }
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
        )
        Spacer(modifier = Modifier.size(8.dp))
        Column {
            Text(text = name.name)
            Text(text = name.family)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowMessagePreview() {
    JetpackComposePracticeDocumentTheme {
        Surface {
            ShowMessage(MessageList("Android", "Compose"))
        }
    }
}