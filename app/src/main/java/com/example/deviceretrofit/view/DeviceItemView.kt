package com.example.deviceretrofit.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.deviceretrofit.data.Device

@Composable
fun DeviceItemView (device: Device) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = Icons.Default.Phone,
            contentDescription = null)
        Column {
            Text(device.name)
            Text(device.data?.color?: "-")
            Text(device.data?.capacity?: "-")
            Text(device.data?.description?: "-")
            HorizontalDivider()
        }
    }
}