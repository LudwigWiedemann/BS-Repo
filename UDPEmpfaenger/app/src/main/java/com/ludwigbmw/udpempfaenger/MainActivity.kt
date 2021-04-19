package com.ludwigbmw.udpempfaenger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.lang.Exception
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

class MainActivity : AppCompatActivity() {
    class UDPEmpfaenger : Runnable {
        override fun run() {
            var socket: DatagramSocket? = null
            while (true) {
                try {
                    socket = DatagramSocket(5004,
                            InetAddress.getByName("192.168.2.19"))
                    socket.broadcast = true
                    val buffer = ByteArray(2048)
                    val packet = DatagramPacket(buffer, buffer.size)
                    socket.receive(packet)
                    Log.d("hjhj", "Packet received")
                } catch (e: Exception) {
                    Log.d("jj", "jk", e)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Thread(UDPEmpfaenger()).start()
    }

}