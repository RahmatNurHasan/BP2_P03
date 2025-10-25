package com.example.myamikomapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myamikomapp.ui.theme.MyApplicationTheme

/**
 * Versi gabungan: Bisa menampilkan UI Compose,
 * tapi tetap memuat fungsionalitas HomeActivity (buka situs AMIKOM & tampilkan nama user).
 */
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ambil nama dari Intent (dikirim dari Login)
        val username = intent.getStringExtra("EXTRA_USERNAME") ?: "Pengguna"

        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        name = username,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Selamat Datang, $name!",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                // Intent implicit di dalam Compose pakai context
                val context = androidx.compose.ui.platform.LocalContext.current
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://amikom.ac.id"))
                context.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Buka Situs AMIKOM")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    MyApplicationTheme {
        HomeScreen("Android")
    }
}
