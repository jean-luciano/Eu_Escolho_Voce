

package com.example.personaroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF151515)
                ) {
                    PersonaRollerApp()
                }
            }
        }
    }
}

// Representa uma Persona
data class Persona(
    val nome: String,
    val imagem: Int
)

// Lista das dez Personas disponíveis
val listaPersonas = listOf(
    Persona("Arsène", R.drawable.persona_01),
    Persona("Izanagi", R.drawable.persona_02),
    Persona("Orpheus", R.drawable.persona_03),
    Persona("Pixie", R.drawable.persona_04),
    Persona("Jack Frost", R.drawable.persona_05),
    Persona("Thanatos", R.drawable.persona_06),
    Persona("Alice", R.drawable.persona_07),
    Persona("Yoshitsune", R.drawable.persona_08),
    Persona("Loki", R.drawable.persona_09),
    Persona("Messiah", R.drawable.persona_10)
)

// Aplicativo principal
@Preview(showBackground = true)
@Composable
fun PersonaRollerApp() {
    PersonaRoller()
}

@Composable
fun PersonaRoller() {

    // Cores do aplicativo
    val fundo = Color(0xFF151515)
    val vermelho = Color(0xFFE60012)
    val branco = Color(0xFFFFFFFF)

    // Persona selecionada inicialmente
    var personaSelecionada by remember {
        mutableStateOf(listaPersonas[0])
    }

    // Interface principal
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(fundo)
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Título
        Text(
            text = "PERSONA ROLLER",
            fontSize = 32.sp,
            fontWeight = FontWeight.Black,
            color = vermelho
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Imagem da Persona
        Image(
            painter = painterResource(personaSelecionada.imagem),
            contentDescription = personaSelecionada.nome,
            modifier = Modifier.size(280.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Nome da Persona
        Text(
            text = personaSelecionada.nome.uppercase(),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = branco
        )

        Spacer(modifier = Modifier.height(36.dp))

        // Botão de rolagem
        Button(
            onClick = {
                personaSelecionada = listaPersonas.random()
            },

            colors = ButtonDefaults.buttonColors(
                containerColor = vermelho,
                contentColor = branco
            ),

            shape = RoundedCornerShape(8.dp),

            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {

            Text(
                text = "ROLL PERSONA",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Informação sobre a rolagem
        Text(
            text = "10 PERSONAS • 10% DE CHANCE CADA",
            fontSize = 12.sp,
            color = Color.LightGray
        )
    }
}
