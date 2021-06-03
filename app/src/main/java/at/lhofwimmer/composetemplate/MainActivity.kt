package at.lhofwimmer.composetemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import at.lhofwimmer.composetemplate.ui.Router
import at.lhofwimmer.composetemplate.ui.SignIn
import at.lhofwimmer.composetemplate.ui.SmartCookbook
import at.lhofwimmer.composetemplate.ui.theme.ComposeTemplateTheme

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
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