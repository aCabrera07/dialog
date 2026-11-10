package com.example.dialogos

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dialogos.ui.theme.DialogosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DialogosTheme {
                DialogScreen()
            }
        }
    }
}

@Composable
fun DialogScreen() {
    var showDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { showDialog = true }) {
            Text(text = "Diálogo")
        }

        MyDialog(
            show = showDialog,
            onDismiss = { showDialog = false },
            onConfirm = {
                Log.d("Dialogos", "ODEG jugará Granny")
                showDialog = false
            }
        )
    }
}

@Composable
fun MyDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(text = "ODEG jugando Granny")
            },
            text = {
                Text(
                    text = "¿Quieres ver a ODEG jugando Granny?"
                )
            },
            confirmButton = {
                TextButton(onClick = onConfirm) {
                    Text(text = "Sí")
                }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) {
                    Text(text = "No")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DialogosTheme {
        DialogScreen()
    }
}
