package at.lhofwimmer.composetemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import at.lhofwimmer.composetemplate.ui.SignIn
import at.lhofwimmer.composetemplate.ui.theme.ComposeTemplateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTemplateTheme {
                // A surface container using the 'background' color from the theme
                SignIn()
            }
        }
    }
}