package at.lhofwimmer.composetemplate.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

sealed class Screen(
    val route: String,
    val name: String,
    val icon: ImageVector? = null
) {
    object SignIn : Screen("sign_in", "Sign In")
    object RecipeList : Screen("recipes", "Recipes", Icons.Outlined.MenuBook)
    object RecipeDetails : Screen("recipe_detail", "Recipe Details")
    object SmartCookbook : Screen("smart_cookbook", "Smart Cookbook", Icons.Outlined.FavoriteBorder)
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun Router() {
    val navController = rememberNavController()

    val navBarItems = listOf(
        Screen.RecipeList,
        Screen.SmartCookbook
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
        NavHost(navController = navController, startDestination = Screen.RecipeList.route) {
            composable(Screen.RecipeList.route) { RecipeList()  }
            composable(Screen.SmartCookbook.route) { SmartCookbook() }
        }
    }
}