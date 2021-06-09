package at.lhofwimmer.composetemplate.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material.icons.outlined.Event
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.rounded.Event
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.MenuBook
import androidx.compose.material.icons.rounded.ReceiptLong
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

val LocalNavController = compositionLocalOf<NavController> { error("No navController found") }

sealed class Screen(
    val route: String,
    val name: String,
    val icon: ImageVector? = null
) {
    object SignIn : Screen("sign_in", "Sign In")
    object RecipeList : Screen("recipes", "Recipes", Icons.Rounded.MenuBook)
    object RecipeDetails : Screen("recipe_detail", "Recipe Details")
    object SmartCookbook : Screen("smart_cookbook", "Cookbook", Icons.Rounded.FavoriteBorder)
    object Calendar : Screen("calendar", "Calendar", Icons.Rounded.Event)
    object Shop : Screen("shopping_list","List", Icons.Rounded.ReceiptLong)
}

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun Router() {
    val navController = rememberNavController()

    val navBarItems = listOf(
        Screen.RecipeList,
        Screen.SmartCookbook,
        Screen.Calendar,
        Screen.Shop
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
            NavHost(navController = navController, startDestination = Screen.Calendar.route) {
                composable(Screen.RecipeList.route) { RecipeList() }
                composable(Screen.SmartCookbook.route) { SmartCookbook() }
                composable(Screen.RecipeDetails.route) { RecipeDetail() }
                composable(Screen.Calendar.route) { SimpleCalender() }
                composable(Screen.Shop.route) { ShopList()}
            }
        }
    }
}