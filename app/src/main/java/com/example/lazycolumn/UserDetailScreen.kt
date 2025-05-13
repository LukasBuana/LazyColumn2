package com.example.lazycolumn

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lazycolumn.model.User

@Composable
fun UserDetailScreen(user: User?) {
    if (user == null) {
        Text("User tidak ditemukan.")
        return
    }

    Column(modifier = Modifier.padding(40.dp)) {
        Text("Detail Pengguna", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text("ID: ${user.id}")
        Text("Nama: ${user.name}")
        Text("Email: ${user.email}")
        Text("Username: ${user.username}")
        Text("Alamat: ${user.address.street}, ${user.address.city}")
        Text("Telepon: ${user.phone}")
        Text("Website: ${user.website}")
        Text("Perusahaan: ${user.company.name}")
        Text("Catchphrase: ${user.company.catchPhrase}")
    }
}
