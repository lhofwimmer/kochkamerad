package at.lhofwimmer.composetemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import at.lhofwimmer.composetemplate.ui.Router
import at.lhofwimmer.composetemplate.ui.SignIn
import at.lhofwimmer.composetemplate.ui.theme.ComposeTemplateTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTemplateTheme {
                // A surface container using the 'background' color from the theme
                Router()
            }
        }
    }
}