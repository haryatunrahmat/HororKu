package id.utdi.haryatun

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import id.utdi.haryatun.ui.theme.HororKuTheme
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.LazyColumn

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HororKuTheme {
                // Surface container yang menggunakan warna 'latar belakang' dari tema
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProyekHoror()
                }
            }
        }
    }
}

data class Artwork(
    val title: String,
    val year: Int,
    val imageResource: Int
)

@Composable
fun ProyekHoror() {
    var currentImageIndex by remember { mutableStateOf(0) }

    // Daftar gambar yang akan ditampilkan
    val artworks = listOf(
        Artwork("Judul Film : Sunyi", 2022, R.drawable.pict1),
        Artwork("Judul Film : Mumun", 2022, R.drawable.pict2),
        Artwork("Judul Film : Perjanjian Gaib", 2022, R.drawable.pict3),
        Artwork("Judul Film : Asih 2", 2022, R.drawable.pict4),
        Artwork("Judul Film : Sewu Dino", 2022, R.drawable.pict5),
    )

    val isMoreInfoVisible = remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
            .background(Color.Gray)
    ) {
        item {
            // Column 1: Gambar
            MyImage(imageResource = artworks[currentImageIndex].imageResource)
            // Spacer
            Spacer(modifier = Modifier.height(10.dp))

            // Column 2: Judul Gambar dan Tahun Pembuatan (Berada di tengah secara horizontal)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            ) {
                Column(
                    modifier = Modifier.align(Alignment.Center)
                ) {
//                    Text(
//                        text = artworks[currentImageIndex].title,
//                        fontSize = 24.sp,
//                        color = Color.White
//                    )
                }
            }

            // Column 3: Tombol Tindakan (Previous, Next, More Info)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        // Aksi untuk tombol Previous
                        currentImageIndex = (currentImageIndex - 1).coerceIn(0, artworks.size - 1)
                        isMoreInfoVisible.value = false
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Back")
                }
                Button(
                    onClick = {
                        // Aksi untuk tombol Next
                        currentImageIndex = (currentImageIndex + 1).coerceIn(0, artworks.size - 1)
                        isMoreInfoVisible.value = false
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Next")
                }
                Button(
                    onClick = {
                        // Aksi untuk tombol More Info
                        isMoreInfoVisible.value = true
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Detail Film")
                }
            }

            // Deskripsi Film (ditampilkan di bawah Detail Film)
            if (isMoreInfoVisible.value) {
                Text(
                    text = when (currentImageIndex) {
                        0 -> "Judul Film : Sunyi\n" +
                                "Tahun Rilis : 2022\n" +
                                "Durasi : 1 jam 50 menit\n" +
                                "Deskripsi Film:\n" +
                                "\"Sunyi\" adalah sebuah film horor yang dirilis pada tahun 2022. " +
                                "Film ini menghadirkan pengalaman horor yang menggigit, dengan cerita yang penuh ketegangan dan misteri.\n" +
                                "Cerita film \"Sunyi\" berkisah tentang kejadian-kejadian supranatural yang terjadi di sekitar sebuah rumah tua yang terpencil. " +
                                "Sebuah keluarga muda baru saja pindah ke rumah tersebut, dan mereka segera menyadari bahwa rumah itu memiliki sejarah yang gelap dan misterius. " +
                                "Ketegangan semakin memuncak ketika mereka mulai mengalami peristiwa gaib dan penampakan makhluk yang tak terjelaskan."

                        1 -> "Judul Film : Mumun\n" +
                                "Tahun Rilis : 2022\n" +
                                "Durasi : 1 jam 30 menit\n" +
                                "Deskripsi Film:\n" +
                                "\"Mumun\" adalah film horor yang mengisahkan kisah seram di sebuah desa terpencil. " +
                                "Ketika seorang mahasiswa datang ke desa ini untuk melakukan penelitian, " +
                                "dia mulai mengungkap misteri yang tersembunyi di balik desa tersebut. " +
                                "Film ini menghadirkan ketegangan dan ketakutan melalui cerita yang gelap dan atmosfer yang mencekam."

                        2 ->  "Judul Film : Perjanjian Gaib\n" +
                                "Tahun Rilis : 2023\n" +
                                "Durasi : 1 jam 19 menit\n" +
                                "Deskripsi Film:\n" +
                                "\"Perjanjian Gaib\" adalah film horor yang mengisahkan tentang sebuah perjanjian supernatural " +
                                "yang melibatkan kekuatan gaib. Ketika seorang karakter utama menemukan dirinya terperangkap dalam perjanjian ini, " +
                                "ia harus mencari cara untuk memutuskannya sebelum malapetaka terjadi. " +
                                "Film ini menggabungkan elemen horor supernatural dengan ketegangan psikologis untuk menciptakan pengalaman menakutkan."

                        3 -> "Judul Film : Asih 2\n" +
                                "Tahun Rilis : 2023\n" +
                                "Durasi : 1 jam 11 menit\n" +
                                "Deskripsi Film:\n" +
                                "\"Perjanjian Gaib\" adalah film horor yang mengisahkan tentang sebuah perjanjian supernatural " +
                                "yang melibatkan kekuatan gaib. Ketika seorang karakter utama menemukan dirinya terperangkap dalam perjanjian ini, " +
                                "ia harus mencari cara untuk memutuskannya sebelum malapetaka terjadi. " +
                                "Film ini menggabungkan elemen horor supernatural dengan ketegangan psikologis untuk menciptakan pengalaman menakutkan."

                        4 ->  "Judul Film : Sewu Dino\n" +
                                "Tahun Rilis : 2023\n" +
                                "Durasi : 1 jam 11 menit\n" +
                                "Deskripsi Film:\n" +
                                "\"Asih 2\" adalah sekuel dari film horor Indonesia yang terkenal, Asih. " +
                                "Film ini dirilis pada tahun 2023 dan mengisahkan kelanjutan kisah horor asal Indonesia yang menyeramkan. " +
                                "Cerita film berpusat pada karakter Asih, seorang makhluk gaib yang menghantui orang-orang. " + "Di sekuel ini, " +
                                "Asih kembali untuk menemui para penggemar dengan lebih banyak ketakutan dan misteri. " +
                                "Para karakter harus menghadapi teror supernatural yang mengancam kehidupan mereka, " +
                                "dan mereka berusaha mencari cara untuk menghentikannya. " +
                                "Film ini menyajikan suasana yang mencekam dan kisah yang seram, dan akan memuaskan para penggemar genre horor."

                        else ->""
                    },
                    modifier = Modifier.padding(8.dp)
                )
            }

        }
    }
}

@Composable
fun MyImage(imageResource: Int) {
    Image(
        painter = painterResource(id = imageResource),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(600.dp) // Lebar tetap maksimal, tinggi diatur ke 600dp
    )
}

@Preview(showBackground = true)
@Composable
fun ProyekArtSpaceHatyatunPreview() {
    HororKuTheme {
        ProyekHoror()
    }
}
