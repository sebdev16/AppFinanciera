package com.example.appdescuento.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DosTarjetas(titulo1: String, numero1:Double,titulo2: String, numero2:Double)
{
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween)
    {
        MainCard(titulo = titulo1, numero = numero1, modifier = Modifier
            .padding(30.dp)
            .weight(1f)
        )
        SpaceW(10.dp)
        MainCard(titulo = titulo2, numero = numero2, modifier = Modifier
            .padding(30.dp)
            .weight(1f))
    }
}

@Composable
fun MainCard(titulo:String,numero:Double,modifier: Modifier = Modifier)
{
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    )
    {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ){
            Text(text =titulo, color = Color.Black, fontSize = 20.sp)
            Text(text="$numero",color=Color.Black,fontSize = 20.sp)
        }
    }
}
