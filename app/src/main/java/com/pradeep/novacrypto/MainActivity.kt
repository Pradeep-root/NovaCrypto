package com.pradeep.novacrypto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pradeep.novacrypto.presentation.MainScreen
import com.pradeep.novacrypto.ui.theme.NovaCryptoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NovaCryptoTheme {
                MainScreen()
            }
        }
    }
}
