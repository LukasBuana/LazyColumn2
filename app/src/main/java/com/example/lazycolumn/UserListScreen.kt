package com.example.lazycolumn.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lazycolumn.R
import com.example.lazycolumn.UserViewModel
import com.example.lazycolumn.model.User

@Composable
fun UserListScreen(viewModel: UserViewModel = viewModel()) {
    val users by viewModel.users.collectAsState()

    Column(modifier = Modifier.padding(40.dp)) {
        Text("NIM: 225150200111037", fontSize = 16.sp)
        Text("Nama: Lukas Awan Cahya Buana", fontSize = 16.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Daftar Pengguna", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(users) { user ->
                UserCard(user)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun UserCard(user: User) {
    Card(
        shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE0E7FF)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "User Icon",
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text("${user.id}", fontSize = 16.sp)
                Text("Name : ${user.name}", fontSize = 16.sp)
                Text("Username: ${user.username}", fontSize = 16.sp)
                Text("Email: user.email", fontSize = 16.sp)
                Text("Address: ${user.address.street}, ${user.address.city}", fontSize = 16.sp)
                Text("Phone: ${user.phone}", fontSize = 16.sp)
                Text("Website: ${user.website}", fontSize = 16.sp)
                Text("Company: ${user.company.name}", fontSize = 16.sp)
            }
        }
    }
}
