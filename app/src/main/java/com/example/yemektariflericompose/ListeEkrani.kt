package com.example.yemektariflericompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.yemektariflericompose.model.Yemek
import com.google.gson.Gson

@Composable
fun YemekListesi(yemekler : List<Yemek>, navController: NavController) {
    LazyColumn(contentPadding = PaddingValues(5.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        items(yemekler) {
            YemekRow(yemek = it, navController = navController)
        }
    }
}

@Composable
fun YemekRow(yemek: Yemek, navController: NavController) {
    Column(modifier= Modifier
        .fillMaxWidth()
        .background(color = MaterialTheme.colorScheme.background)
        .clickable {
            navController.navigate("detay_ekrani/${Gson().toJson(yemek)}")
        }
    ) {
        Text(text=yemek.isim,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.padding(5.dp),
            fontWeight = FontWeight.Bold

        )
        Text(text=yemek.malzemeler,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(5.dp),
            fontWeight = FontWeight.Normal
        )
    }
}
/*
@Preview(showBackground = true)
@Composable
fun YemekListesiPreview() {
    YemekTarifleriComposeTheme {
        val yemekListesi = listOf(
            Yemek("Pizza", "Sucuk, Peynir, Sos, Mantar, Zeytin, Mısır", R.drawable.pizza),
            Yemek("Makarna", "Makarna, Sos, Peynir", R.drawable.makarna),
            Yemek("Köfte", "Kıyma, Ekmek, Köfte Harcı", R.drawable.kofte),
            Yemek("Salata", "Salatalık, Domates, Soğan, Mısır, Marul", R.drawable.salata),
            Yemek("Ekmek", "Hamur, Maya", R.drawable.ekmek)
        )

        yemekListesi.add(pizza)
            yemekListesi.add(makarna)
            yemekListesi.add(kofte)
            yemekListesi.add(salata)
            yemekListesi.add(ekmek)


       YemekListesi(yemekler=yemekListesi)
    }
}
*/