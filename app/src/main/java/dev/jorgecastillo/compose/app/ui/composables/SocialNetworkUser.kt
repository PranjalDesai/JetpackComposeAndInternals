package dev.jorgecastillo.compose.app.ui.composables

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SocialNetworkUser(name: String, location: String, onFollow: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Column() {
                Text(text = name)
                Text(text = location)
            }
            Button(onClick = onFollow, Modifier.padding(start = 8.dp)) {
                Text(text = "Follow")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SocialNetworkUserPreview() {
    SocialNetworkUser(name = "John Doe", location = "New York City") {
        Log.d("Test", "Clicked!")
    }
}
