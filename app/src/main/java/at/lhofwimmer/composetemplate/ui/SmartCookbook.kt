package at.lhofwimmer.composetemplate.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import at.lhofwimmer.composetemplate.R
import at.lhofwimmer.composetemplate.data.local.static.recipeListItems
import at.lhofwimmer.composetemplate.swipe.PersonCard
import at.lhofwimmer.composetemplate.swipe.SwipeCard

@ExperimentalMaterialApi
@Composable
fun SmartCookbook() {
    SwipeCard(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(align = Alignment.Center), onSwiped = { /*TODO*/ }) {
        PersonCard(
            recipe = at.lhofwimmer.composetemplate.data.local.static.RecipeListItem(
                "Lorem ipsum",
                "Testkategorie",
                3.5,
                R.drawable.hamburger_494706_1920
            )
        )
    }
}

