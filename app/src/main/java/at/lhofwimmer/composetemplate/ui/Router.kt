package at.lhofwimmer.composetemplate.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi

val LocalNavController = compositionLocalOf<NavController> { error("No navController found") }

sealed class Screen(
    val route: String,
    val name: String,
    val icon: ImageVector? = null
) {
    object SignIn : Screen("sign_in", "Sign In")
    object RecipeList : Screen("recipes", "Recipes", Icons.Outlined.MenuBook)
    object RecipeDetails : Screen("recipe_detail", "Recipe Details")
    object SmartCookbook : Screen("smart_cookbook", "Smart Cookbook", Icons.Outlined.FavoriteBorder)
    object Calendar : Screen("calendar", "Calendar", Icons.Outlined.Event)
}

@ExperimentalPagerApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun Router() {
    val navController = rememberNavController()

    val navBarItems = listOf(
        Screen.RecipeList,
        Screen.SmartCookbook,
        Screen.Calendar
    )

    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                navBarItems.forEach { screen ->
                    BottomNavigationItem(
                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.startDestinationRoute ?: Screen.RecipeList.route) {
                                    saveState = true
                                }

                                launchSingleTop = true

                                restoreState = true
                            }
                        },
                        label = { Text(screen.name) },
                        icon = { Icon(screen.icon ?: Icons.Outlined.ErrorOutline, null) },
                    )
                }
            }
        }
    ) {
        CompositionLocalProvider(LocalNavController provides navController) {
            NavHost(navController = navController, startDestination = Screen.RecipeList.route) {
                composable(Screen.RecipeList.route) { RecipeList() }
                composable(Screen.SmartCookbook.route) { SmartCookbook() }
                composable(Screen.RecipeDetails.route) { RecipeDetail() }
                composable(Screen.Calendar.route) { SimpleCalendar() }
            }
        }
    }
}