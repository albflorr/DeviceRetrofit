package com.example.deviceretrofit.service

import com.example.deviceretrofit.data.Constants
import com.example.deviceretrofit.data.Device
import retrofit2.http.GET

interface DeviceService {
    @GET(Constants.OBJECTS_PATH)
    suspend fun getAllDevices(): List<Device>
}