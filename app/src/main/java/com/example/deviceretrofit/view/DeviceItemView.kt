package com.example.deviceretrofit.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.deviceretrofit.data.Device

@Composable
fun DeviceItemView (device: Device) {
    Card(modifier = Modifier.padding(16.dp)
            .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors( containerColor = MaterialTheme.colorScheme.surface)) {

        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)) {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = null
            )
            Column (modifier = Modifier.padding(8.dp)) {
                Text(device.name)
                HorizontalDivider()
                Text(device.data?.color ?: "-")
                Text(device.data?.capacity ?: "-")
                Text(device.data?.description ?: "-")
            }
        }

    }
}