package com.ludwigbmw.udpsender

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            Thread(Sender()).start()
        }
    }

    class Sender : Runnable {
        override fun run() {
            var socket: DatagramSocket? = null
            try {
                socket = DatagramSocket()
                socket.broadcast = true
                var data = "hello".toByteArray()
                var packet = DatagramPacket(data, data.size, InetAddress.getByName("192.168.2.30"), 5004)
                socket.send(packet)
                Log.d("sent", "sent")
            } catch (e: Exception) {
                Log.d("hi", "hhh", e)
            } finally {
                socket?.close()
            }
        }
    }
}