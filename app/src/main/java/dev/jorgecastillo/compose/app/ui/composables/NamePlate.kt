package dev.jorgecastillo.compose.app.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.jorgecastillo.compose.app.ui.theme.ComposeAndInternalsTheme

@Composable
fun NamePlate(name: String) {
}

@Composable
@Preview(showBackground = true)
fun NamePlatePreview() {
    ComposeAndInternalsTheme {
        NamePlate(name = "Test name")
    }
}
