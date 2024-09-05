package com.example.lasthomework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.lasthomework.ui.theme.LastHomeworkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LastHomeworkTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    val animalViewModel: AnimalViewModel = viewModel()
                    LazyColumn(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(
                            16.dp,
                            Alignment.CenterVertically
                        ),
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {
                        item {
                            if (animalViewModel.userlsList.isEmpty()) {
                                CircularProgressIndicator()
                            }
                        }
                        items(animalViewModel.userlsList) { animal ->
                            Item(
                                modifier = Modifier.fillMaxWidth(),
                                name = animal.name,
                                country = animal.country,
                                phone = animal.phone,
                                state = animal.state,
                                company = animal.company,
                                email = animal.email,
                                picture = animal.photo
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Item(
    modifier: Modifier = Modifier,
    email: String,
    country: String,
    phone: String,
    state: String,
    name: String,
    company: String,
    picture: String
) {
    Card() {
        Row(modifier.padding(8.dp), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            AsyncImage(model = picture, contentDescription = "", modifier = Modifier.size(150.dp))

            Column {
                Row() {
                    Text(
                        "name:  ",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 3.dp)
                    )

                    Text(name, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.height(5.dp))
                Row() {
                    Text(
                        "email:  ",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 3.dp)
                    )

                    Text(email, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.height(5.dp))

                Row() {
                    Text(
                        "country:  ",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 3.dp)
                    )

                    Text(country, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.height(5.dp))

                Row() {
                    Text(
                        "state:  ",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 3.dp)
                    )

                    Text(state, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.height(5.dp))

                Row() {
                    Text(
                        "company:  ",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 3.dp)
                    )

                    Text(company, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.height(5.dp))

                Row() {
                    Text(
                        "phone:  ",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 3.dp)
                    )

                    Text(phone, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Preview
@Composable
private fun ItemPreview() {
    Item(
        email = "email",
        name = "name",
        country = "country",
        state = "state",
        company = "company",
        phone = "phone",
        picture = ""
    )
}
