package at.lhofwimmer.composetemplate.data.local.static

import androidx.annotation.DrawableRes
import at.lhofwimmer.composetemplate.R

data class RecipeListItem(
    val name: String,
    val category: String,
    val rating: Double,
    @DrawableRes val image: Int,
)

var recordedRecipes : MutableList<String> = mutableListOf()

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

val recipeDetail = RecipeDetail(
    "Hamburger",
    "Hauptspeise",
    4.5,
    R.drawable.hamburger_494706_1920,
    listOf(
        Ingredient("Faschiertes Rindfleisch", "800g"),
        Ingredient("Blattsalat","400g"),
        Ingredient("Buns", "4x"),
        Ingredient("Tomaten", "2x"),
        Ingredient("Salz", null),
        Ingredient("Pfeffer", null),
        Ingredient("Olivenöl", null),
        Ingredient("beliebige Gewürzsaucen", null),
    ),
    "3 Stunden",
    "30 Minuten",
    listOf(
        "Das Faschierte zu 4 Laibchen formen, mit Salz und Pfeffer würzen und leicht einölen.",
        "Die Patties für 2 Stunden in den Kühlschrank.",
        "Olivenöl in Pfanne und auf hohe Hitze zum kochen bringen.",
        "Patties kochen, bis diese einen leicht rosa Kern haben.",
        "Buns halbieren und kurz zu den Patties in die Pfanne geben, sodass diese auf der Innenseite leicht angebraten werden.",
        "Die Buns mit Patties, Gemüse und Saucen belegen und essen."
    ),
    4
)

data class RecipeDetail(
    val name: String,
    val category: String,
    val rating: Double,
    @DrawableRes val image: Int,
    val ingredients: List<Ingredient>,
    val workExpenditure: String,
    val totalExpenditure: String,
    val steps: List<String>,
    val portions: Int
)

data class Ingredient(
    val name: String,
    val amount: String?
)