package com.example.yemektariflericompose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.yemektariflericompose.R
import com.example.yemektariflericompose.model.Yemek


// DetayEkrani: Seçilen yemeğin detaylarını gösterir
@Composable
fun DetayEkrani(yemek: Yemek) {

    // Box: İçeriği ortalamak için kullanılan container
    Box(
        modifier = Modifier
            .fillMaxSize() // Tüm ekranı kapla
            .background(color = MaterialTheme.colorScheme.primaryContainer), // Tema renginde arka plan
        contentAlignment = Alignment.Center // Tüm içeriği ortala
    ) {

        // Column: Dikey yerleşim, içerikler alt alta sıralanır
        Column(
            horizontalAlignment = Alignment.CenterHorizontally // Yatayda ortala
        ) {

            // Yemeğin adı, kalın ve büyük puntolu yazılır
            Text(
                text = yemek.isim,
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.padding(5.dp),
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            // Yemeğe ait görsel (resim ID'si üzerinden yükleniyor)
            Image(
                bitmap = ImageBitmap.imageResource(id = yemek.gorsel), // drawable içindeki görsel
                contentDescription = yemek.isim, // erişilebilirlik için açıklama
                modifier = Modifier
                    .padding(16.dp) // Kenarlardan boşluk
                    .size(300.dp, 200.dp) // Genişlik ve yükseklik
            )

            // Malzemeler listesi (normal font, daha küçük)
            Text(
                text = yemek.malzemeler,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(2.dp),
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}


/*
@Preview(showBackground = true)
@Composable
fun DetayPreview() {
    YemekTarifleriComposeTheme {
        val pizza = Yemek("Pizza", "Hamur, Peynir, Sucuk", R.drawable.pizza)
        val makarna = Yemek("Makarna", "Penne, Domates, Fesleğen", R.drawable.makarna)
        val kofte = Yemek("Kofte", "Kıyma, Ekmek, Pirinç", R.drawable.kofte)
        val salata = Yemek("Salata", "Domates, Salatalık, Soğan", R.drawable.salata)
        val ekmek = Yemek("Ekmek", "Hamur, Maya", R.drawable.ekmek)

        DetayEkrani(yemek = pizza)

    }
}
*/
