package com.example.modul13

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    var showTask by rememberSaveable { mutableStateOf(true) } // Ensure persistence

    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0 && showTask) {
            WellnessTaskItem(
                onClose = { showTask = false },
                taskName = "Have you taken your 15-minute walk today?",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp)) // Improve spacing
        }

        StatelessCounter(
            count = count,
            onIncrement = { count++ },
            onClear = { count = 0; showTask = true },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,
    onClear: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
            Spacer(modifier = Modifier.height(8.dp))
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween // Improved alignment
        ) {
            Button(onClick = onIncrement, enabled = count < 10) {
                Text("Add one")
            }
            Button(onClick = onClear) {
                Text("Clear water count")
            }
        }
    }
}
