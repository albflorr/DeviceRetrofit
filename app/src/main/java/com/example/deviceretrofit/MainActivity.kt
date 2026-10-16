package com.example.deviceretrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.deviceretrofit.data.Constants
import com.example.deviceretrofit.data.Device
import com.example.deviceretrofit.data.Spec
import com.example.deviceretrofit.service.DeviceService
import com.example.deviceretrofit.ui.theme.DeviceRetrofitTheme
import com.example.deviceretrofit.view.MainView
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeviceRetrofitTheme {

                var devices by remember { mutableStateOf(listOf<Device>()) }
                getDevices { result ->
                    devices = result
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainView(modifier = Modifier.padding(innerPadding),
                        devices)
                }
            }
        }
    }

    private fun getDevices(onResult: (List<Device>)->Unit){
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(DeviceService::class.java)

        lifecycleScope.launch {
            val devices = service.getAllDevices()
            onResult(devices)
        }

    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DeviceRetrofitTheme {
        Greeting("Android")
    }
}