package dev.jorgecastillo.compose.app.ui.composables

import androidx.cardview.widget.CardView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import dev.jorgecastillo.compose.app.ui.theme.ComposeAndInternalsTheme

@Composable
fun PPUICardviewInCompose() {
    AndroidView(
        factory = {
            // instead of cardview we can use PPUICardView
            CardView(it).apply {
                this.addView(ComposeView(this.context).apply {
                    this.setContent {
                        CardContents()
                    }
                })
            }
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}

@Composable
fun CardContents() {
    // Write your code here
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = "icon", modifier = Modifier.padding(4.dp))
        Text(
            text = "titlesdnvjhdsbvjhdsbvhjdsbvhjdb vhjdsbvdhjvbdshjvbdhbdsjhvbdsjhvbdshvbdj vbjdbvdjhbvhjdvbjsdvbjdsbvdsjv",
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .weight(1f)
                .padding(4.dp)
        )
        Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(4.dp)) {
            Text(text = "badge")
        }

    }
}

@Composable
@Preview(showBackground = true)
private fun PPUICardviewInComposePreview() {
    ComposeAndInternalsTheme {
        PPUICardviewInCompose()
    }
}
