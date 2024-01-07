package com.example.businesscard.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.businesscard.component.CardDesign
import com.example.businesscard.component.CustomTopAppBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Card(
) {
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(topAppBarState)
    Column {
        CustomTopAppBar(title = "Card", scrollBehavior = scrollBehavior)
        LazyColumn(
            contentPadding = PaddingValues(bottom = 80.dp, start = 30.dp, end = 30.dp)
        ) {
            for (i in 1..5) {
                item() {
                    CardDesign()
                }
            }
        }

    }
}