package at.lhofwimmer.composetemplate.data.local.static

import androidx.annotation.DrawableRes
import at.lhofwimmer.composetemplate.R

data class RecipeListItem(
    val name: String,
    val category: String,
    val rating: Double,
    @DrawableRes val image: Int,
)

val recipeListItems = listOf(
    RecipeListItem(
        "Filetstreifen mit Spargel",
        "Hauptspeise",
        3.5,
        R.drawable.asparagus_2169305_1920
    ),
    RecipeListItem(
        "Schokoladen Cupcakes",
        "Süße Backware",
        5.0,
        R.drawable.cupcakes_690040_1920
    ),
    RecipeListItem(
        "Hamburger",
        "Hauptspeise",
        4.5,
        R.drawable.hamburger_494706_1920
    ),
    RecipeListItem(
        "Pancakes",
        "Nachspeise",
        4.0,
        R.drawable.pancakes_2291908_1920
    ),
    RecipeListItem(
        "Gebratener Lachs mit Blattsalat",
        "Hauptspeise",
        3.0,
        R.drawable.salmon_518032_1920
    )
)