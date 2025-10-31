package com.example.questuserinput_187

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textPekerjaan by remember { mutableStateOf("") }

    // hasil akhir yang akan ditampilkan di Card
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var pekerjaan by remember { mutableStateOf("") }

    val gender = listOf("Laki-laki", "Perempuan")
    val pekerjaanList = listOf("Mahasiswa", "Kerja", "Punk")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(MaterialTheme.colorScheme.primary),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Formulir Pendaftaran",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 120.dp, start = 10.dp, end = 10.dp)
                .background(Color.White, shape = RoundedCornerShape(16.dp))
                .padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = "Nama",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 5.dp, start = 4.dp)
            )

            OutlinedTextField(
                value = textNama,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp),
                label = { Text("Nama Lengkap") },
                onValueChange = { textNama = it }
            )

            Text(
                text = "Jenis Kelamin",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 5.dp, start = 4.dp)
            )

            Column(modifier = Modifier.padding(bottom = 15.dp)) {
                gender.forEach { item ->
                    Row(
                        modifier = Modifier
                            .selectable(
                                selected = textJK == item,
                                onClick = { textJK = item }
                            )
                            .padding(vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = textJK == item,
                            onClick = { textJK = item }
                        )
                        Text(item)
                    }
                }
            }

            Text(
                text = "Status Pekerjaan",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 5.dp, start = 4.dp)
            )

            Column(modifier = Modifier.padding(bottom = 15.dp)) {
                pekerjaanList.forEach { item ->
                    Row(
                        modifier = Modifier
                            .selectable(
                                selected = textPekerjaan == item,
                                onClick = { textPekerjaan = item }
                            )
                            .padding(vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = textPekerjaan == item,
                            onClick = { textPekerjaan = item }
                        )
                        Text(item)
                    }
                }
            }

            Text(
                text = "Alamat",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 5.dp, start = 4.dp)
            )

            OutlinedTextField(
                value = textAlamat,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp),
                label = { Text("Alamat Lengkap") },
                onValueChange = { textAlamat = it }
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 5.dp),
                enabled = textNama.isNotEmpty() && textAlamat.isNotEmpty(),
                onClick = {
                    nama = textNama
                    alamat = textAlamat
                    jenis = textJK
                    pekerjaan = textPekerjaan
                }
            ) {
                Text("Submit")
            }

            if (nama.isNotEmpty()) {
                Card(
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Black),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 15.dp)
                    ) {
                        Text(text = "Nama   : $nama", color = Color.White)
                        Text(text = "Gender : $jenis", color = Color.White)
                        Text(text = "Status Pekerjaan : $pekerjaan", color = Color.White)
                        Text(text = "Alamat : $alamat", color = Color.White)
                    }
                }
            }
        }
    }
}