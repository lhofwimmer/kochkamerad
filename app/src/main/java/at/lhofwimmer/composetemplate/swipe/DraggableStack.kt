package at.lhofwimmer.composetemplate.swipe

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import at.lhofwimmer.composetemplate.R
import at.lhofwimmer.composetemplate.data.local.static.RecipeListItem
import at.lhofwimmer.composetemplate.ui.theme.ComposeTemplateTheme

/**
 * Swipeable card. Uses Modifier property of swiper
 * It provides a swipe result with an enum ACCEPT or REJECT
 *
 * https://github.com/cyph3rcod3r/Tinder-Like
 */
@ExperimentalMaterialApi
@Composable
fun SwipeCard(
    modifier: Modifier = Modifier,
    onSwiped: (result: SwipeResult) -> Unit,
    content: @Composable (BoxScope.() -> Unit)
) {
    val swiped = remember { mutableStateOf(false) }
    BoxWithConstraints(modifier = modifier) {
        val swipeState = rememberSwipeState(
            maxWidth = constraints.maxWidth.toFloat(),
            maxHeight = constraints.maxHeight.toFloat()
        )
        if (swiped.value.not()) {
            Box(
                modifier = Modifier
                    .swiper(
                        state = swipeState,
                        onDragAccepted = {
                            swiped.value = true
                            onSwiped(SwipeResult.ACCEPT)
                        },
                        onDragRejected = {
                            swiped.value = true
                            onSwiped(SwipeResult.REJECT)
                        }
                    ),
                content = content
            )
        }
    }
}

@Preview
@ExperimentalMaterialApi
@Composable
fun PreviewSwipeCard() {
    ComposeTemplateTheme {
        SwipeCard(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.Center), onSwiped = { /*TODO*/ }) {
            PersonCard(
                recipe = RecipeListItem(
                    "Lorem ipsum",
                    "Testkategorie",
                    3.5,
                    R.drawable.hamburger_494706_1920
                )
            )
        }
    }
}

enum class SwipeResult { ACCEPT, REJECT }