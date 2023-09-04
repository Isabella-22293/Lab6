package uvg.isabella.lab6isabellamiralles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import uvg.isabella.lab6isabellamiralles.ui.theme.Lab6IsabellaMirallesTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab6IsabellaMirallesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("")
                    Button(onClick = { /*TODO*/ }) {

                    }
                }
            }
        }
    }
}
@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GalleryScreen() {
    val imagesAndTexts = listOf(
        GalleryItem("Image 1", R.drawable.img_20230830_wa0009),
        GalleryItem("Image 2", R.drawable.img_20230830_wa0011),
        GalleryItem("Image 3", R.drawable.img_20230830_wa0012),
        GalleryItem("Image 4", R.drawable.img_20230830_wa0013),
        GalleryItem("Image 5", R.drawable.img_20230830_wa0014),
        GalleryItem("Image 6", R.drawable.img_20230830_wa0015),
        GalleryItem("Image 7", R.drawable.img_20230830_wa0016),
        GalleryItem("Image 8", R.drawable.img_20230830_wa0017),
        GalleryItem("Image 9", R.drawable.img_20230830_wa0018),
        GalleryItem("Image 10", R.drawable.img_20230830_wa0019),

    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Mi Galeria") },
                actions = {
                    IconButton(onClick = { /* Agrega aquí la lógica de logout */ }) {
                        Icon(imageVector = Icons.Default.ExitToApp, contentDescription = null)
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                items(imagesAndTexts) { item -> GalleryItemCard(item)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    )
}

@Composable
fun GalleryItemCard(item: GalleryItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        elevation = 4.dp,
        Click = { /* Agrega aquí la lógica para ver la imagen a pantalla completa */ }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .padding(16.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = item.title,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

data class GalleryItem(val title: String, val imageRes: Int)
