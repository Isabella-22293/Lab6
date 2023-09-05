package uvg.isabella.lab6isabellamiralles

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun LoginScreen() {
    var usuario by remember { mutableStateOf("") }
    var contraseña by remember { mutableStateOf("") }
    var isLogged by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Bienvenido a la Galeria",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
    item {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .shadow(15.dp)
                .background(color = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 50.dp)
                    .align(Alignment.Center)
            ) {
                TextField(
                    value = usuario,
                    onValueChange = { usuario = it },
                    label = { Text("Usuario") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    )
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = contraseña,
                onValueChange = { contraseña = it },
                label = { Text("Contraseña") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (usuario.isNotEmpty() && contraseña.isNotEmpty() && IDUsuario(
                            usuario,
                            contraseña
                        )
                    ) {
                        isLogged = true
                        Toast.makeText(
                            LocalContext.current,
                            "Inicio de sesión exitoso",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            LocalContext.current,
                            "Usuario o contraseña incorrecta",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Login")
            }

            if (isLogged) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "¡Inicio de sesión exitoso!")
            }
        }
    }

    fun item(function: () -> Unit) {

    }

    fun IDUsuario(usuario: String, contraseña: String): Boolean {

    }

    @Composable
    fun LoginApp() {
        var usuario by remember { mutableStateOf("") }
        var contraseña by remember { mutableStateOf("") }
        var isLogged by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Bienvenido a Galerias",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            BasicTextField(
                value = usuario,
                onValueChange = { usuario = it },
                textStyle = TextStyle(fontSize = 18.sp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            BasicTextField(
                value = contraseña,
                onValueChange = { contraseña = it },
                textStyle = TextStyle(fontSize = 18.sp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (usuario.isNotEmpty() && contraseña.isNotEmpty() && IDUsuario(
                            usuario,
                            contraseña
                        )
                    ) {
                        isLogged = true
                        Toast.makeText(
                            LocalContext.,
                            "Inicio de sesión exitoso",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            LocalContext.current,
                            "Usuario o contraseña incorrecta",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Login")
            }

            if (isLogged) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "¡Inicio de sesión exitoso!")
            }
        }
    }

    fun isValid(username: String, password: String): Boolean {
        // Verificación de inicio de sesión

        return username == "isabella" && password == "hola123"
    }
}

fun item(function: () -> Unit) {

}

fun IDUsuario(usuario: String, contraseña: String): Boolean {

}
