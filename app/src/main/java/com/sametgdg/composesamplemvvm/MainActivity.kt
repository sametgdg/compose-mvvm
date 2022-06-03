package com.sametgdg.composesamplemvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sametgdg.composesamplemvvm.presentation.DisneyApplication
import com.sametgdg.composesamplemvvm.ui.theme.ComposeSampleMvvmTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSampleMvvmTheme {
                DisneyApplication()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeSampleMvvmTheme {
        DisneyApplication()
    }
}