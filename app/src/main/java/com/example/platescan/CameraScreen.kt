package com.example.platescan

import android.content.Context
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.platescan.R

@Composable
fun CameraScreen(onImageCapture: () -> Unit, onVideoCapture: () -> Unit) {
    val context: Context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        // Vista previa de la cámara
        AndroidView(
            factory = { PreviewView(context) },
            modifier = Modifier.fillMaxSize()
        )

        // Botones de captura
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Button(onClick = onImageCapture) {
                Text(text = Strings.TAKE_PHOTO)
            }

            Button(onClick = onVideoCapture) {
                Text(text = Strings.START_CAPTURE)
            }
        }
    }
}

