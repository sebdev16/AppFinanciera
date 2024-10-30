package com.example.appdescuento.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appdescuento.Components.BotonReutilizable
import com.example.appdescuento.Components.BotonReutilizable
import com.example.appdescuento.Components.DosTarjetas
import com.example.appdescuento.Components.SpaceH
import com.example.appdescuento.Components.TextFields

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HomeView() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "App Descuentos", color = Color.White) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor =
                    MaterialTheme.colorScheme.primary
                )
            )

        }) {
        ContentHomeView(it)
    }
}
@Composable
fun ContentHomeView(paddingValues: PaddingValues)
{
    Column(modifier = Modifier
        .padding(paddingValues)
        .padding(10.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        var precio by remember { mutableStateOf("") }
        var descuento by remember { mutableStateOf("") }
        var precioDescuento by remember { mutableStateOf("") }
        var precioTotal by remember { mutableStateOf("") }
        DosTarjetas(
            titulo1 = "Total",
            numero1 = 0.0,
            titulo2 = "Descuento",
            numero2 = 0.0
        )

        TextFields(value = precio, onValueChange = {precio = it}, label = "Precio")
        SpaceH()
        TextFields(value = descuento, onValueChange = {descuento = it}, label = "Descuento")
        SpaceH(10.dp)
        BotonReutilizable(text = "Calcular") {
            precioDescuento = ((descuento.toDouble() / 100)*precio.toDouble()).toString()
            precioTotal = (precio.toDouble() - descuento.toDouble()).toString()
        }
    }
}
