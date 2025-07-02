package com.example.yemektariflericompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.yemektariflericompose.model.Yemek
import com.example.yemektariflericompose.ui.theme.DetayEkrani
import com.example.yemektariflericompose.ui.theme.YemekTarifleriComposeTheme
import com.google.gson.Gson

// Uygulamanın ana ekranı olan MainActivity
class MainActivity : ComponentActivity() {

    // Yemekleri saklayacağımız liste
    private val yemekListesi = ArrayList<Yemek>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Kenarlara kadar ekranın kullanılmasını sağlar (örneğin sistem çubuklarını şeffaf yapar)
        enableEdgeToEdge()

        // Jetpack Compose içeriğini burada tanımlıyoruz
        setContent {

            // Sayfalar arasında geçişi yönetecek NavController oluşturuluyor
            val navController = rememberNavController()

            // Uygulama teması uygulanıyor
            YemekTarifleriComposeTheme {

                // Scaffold: Temel sayfa düzeni için kullanılır (appbar, içerik vs.)
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    // İçeriği sistem çubuğuna çarpmaması için padding vererek yerleştiriyoruz
                    Box(modifier = Modifier.padding(innerPadding)) {

                        // Uygulama içi navigasyonu yöneten NavHost
                        NavHost(navController = navController, startDestination = "liste_ekrani") {

                            // Liste ekranı composable'ı
                            composable("liste_ekrani") {

                                // Yemek verilerini oluştur
                                verileriOlustur()

                                // YemekListesi composable'ına veri listesini ve navController'ı gönder
                                YemekListesi(yemekler = yemekListesi, navController = navController)
                            }

                            // Detay ekranı composable'ı (parametreli rota)
                            composable(
                                "detay_ekrani/{secilenYemek}",
                                arguments = listOf(
                                    navArgument("secilenYemek") {
                                        type = NavType.StringType // Parametre tipi string
                                    }
                                )
                            ) {
                                // JSON string olarak gelen yemek verisini al
                                val yemekString = remember {
                                    it.arguments?.getString("secilenYemek")
                                }

                                // JSON string'ini Yemek nesnesine çevir
                                val secilenYemek = Gson().fromJson(yemekString, Yemek::class.java)

                                // Detay ekranını göster
                                DetayEkrani(yemek = secilenYemek)
                            }

                        } // NavHost bitişi
                    } // Box bitişi
                } // Scaffold bitişi
            } // Tema bitişi
        } // setContent bitişi
    } // onCreate bitişi

    // Örnek yemek verilerini oluşturan fonksiyon
    private fun verileriOlustur() {

        // Her yemek için isim, malzemeler ve görsel bilgisi veriliyor
        val pizza = Yemek("Pizza", "Hamur, Peynir, Sucuk", R.drawable.pizza)
        val makarna = Yemek("Makarna", "Penne, Domates, Fesleğen", R.drawable.makarna)
        val kofte = Yemek("Kofte", "Kıyma, Ekmek, Pirinç", R.drawable.kofte)
        val salata = Yemek("Salata", "Domates, Salatalık, Soğan", R.drawable.salata)
        val ekmek = Yemek("Ekmek", "Hamur, Maya", R.drawable.ekmek)

        // Oluşturulan yemekler listeye ekleniyor
        yemekListesi.add(pizza)
        yemekListesi.add(makarna)
        yemekListesi.add(kofte)
        yemekListesi.add(salata)
        yemekListesi.add(ekmek)
    }
}





