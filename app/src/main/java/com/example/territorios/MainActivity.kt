package com.example.territorios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                TerritoryListScreen()
            }
        }
    }
}

@Composable
fun TerritoryListScreen(viewModel: TerritoryViewModel = viewModel()) {
    val territories by viewModel.territories.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Territorios") })
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(territories) { territory ->
                TerritoryCard(territory)
            }
        }
    }
}

@Composable
fun TerritoryCard(territory: Territory) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Territorio #${territory.id}", style = MaterialTheme.typography.h6)
            Text(text = "Ubicaciones: ${territory.locations.size}")
        }
    }
}
