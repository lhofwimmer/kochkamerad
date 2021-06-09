package at.lhofwimmer.composetemplate.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import at.lhofwimmer.composetemplate.data.local.static.recipeListItems
import at.lhofwimmer.composetemplate.swipe.PersonCard
import at.lhofwimmer.composetemplate.swipe.SwipeCard
import at.lhofwimmer.composetemplate.swipe.SwipeResult
import at.lhofwimmer.composetemplate.ui.theme.Size
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
@Preview
fun SmartCookbook() {
    val navController = LocalNavController.current
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = {
            SnackbarHost(it) { data ->
                Snackbar(
                    modifier = Modifier.padding(bottom = 70.dp, start = Size.Large, end = Size.Large),
                    action = {
                        Button(
                            onClick = { navController.navigate(Screen.RecipeDetails.route) },
                            shape = RoundedCornerShape(Size.Medium)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                                Text("Recipe")
                                Spacer(modifier = Modifier.width(Size.Medium))
                                Icon(Icons.Rounded.ArrowForward, null)
                            }
                        }
                    }
                ) {
                    Text(data.message)
                }
            }
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            recipeListItems.forEach {
                SwipeCard(
                    modifier = Modifier
                        .padding(Size.Large)
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.TopCenter),
                    onSwiped = { result ->
                        coroutineScope.launch {
                            when (result) {
                                SwipeResult.ACCEPT -> scaffoldState.snackbarHostState.showSnackbar("Added recipe to favourites")
                                SwipeResult.REJECT -> {}
                            }
                        }

                    }
                ) {
                    PersonCard(
                        recipe = it
                    )
                }
            }
        }
    }
}

