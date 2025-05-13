package com.example.lazycolumn.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lazycolumn.R
import com.example.lazycolumn.UserViewModel
import com.example.lazycolumn.model.User

@Composable
fun UserListScreen(
    users: List<User>,
    onUserClick: (Int) -> Unit
) {
    Column(modifier = Modifier.padding(40.dp)) {

        // Tampilkan Nama dan NIM
        Text("Nama: Lukas Awan Cahya Buana", style = MaterialTheme.typography.titleMedium)
        Text("NIM : 225150200111037", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(16.dp))

        // LazyColumn daftar user
        LazyColumn {
            items(users) { user ->
                Card(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .fillMaxWidth()
                        .clickable { onUserClick(user.id) },
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("ID: ${user.id}")
                        Text("Name: ${user.name}")
                        Text("Username: ${user.username}")
                        Text("Email: ${user.email}")
                        Text("Alamat: ${user.address.street}, ${user.address.city}")
                        Text("Telepon: ${user.phone}")
                        Text("Website: ${user.website}")
                        Text("Company: ${user.company.name}")
                    }
                }
            }
        }
    }
}


