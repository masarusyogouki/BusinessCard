package com.example.businesscard.component

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.businesscard.screen.Add
import com.example.businesscard.screen.Card
import com.example.businesscard.screen.Login
import com.example.businesscard.screen.Profile

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar() {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavigationItem(
            title = "Card",
            selectedIcon = Icons.Filled.List,
            unselectedIcon = Icons.Filled.List,
            hasNews = false
        ),
        BottomNavigationItem(
            title = "Add",
            selectedIcon = Icons.Filled.Add,
            unselectedIcon = Icons.Filled.Add,
            hasNews = false
        ),
        BottomNavigationItem(
            title = "Profile",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Filled.Person,
            hasNews = false
        )
    )
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
                                navController.navigate(item.title)
                            },
                            icon = {
                                BadgedBox(
                                    badge ={
                                        if(item.badgeCount != null){
                                            Badge {
                                                Text(text= item.badgeCount.toString())
                                            }
                                        }else if (item.hasNews){
                                            Badge()
                                        }
                                    }
                                ) {
                                    Icon(
                                        imageVector = if (index == selectedItemIndex){
                                            item.selectedIcon
                                        }else item.unselectedIcon,
                                        contentDescription = "Profile")
                                }
                            }
                        )
                    }
                }
            }
        ) {
            BusinessCardNavHost(
                navController = navController
            )
        }
    }
}

@Composable
fun BusinessCardNavHost(
    navController: NavHostController
) {
    val activity = (LocalContext.current as Activity)
    NavHost(navController = navController, startDestination = "card" ){
        composable("card"){
            Card()
        }
        composable("add"){
            Add()
        }
        composable("profile"){
            Profile(navController = navController)
        }
        composable("login"){
            Login()
        }
//        composable("signup"){
//            val userDao = UserDao()
//            val signupViewModel = SignupViewModel(userDao)
//            SignupScreen(signupViewModel)
//        }
    }
}