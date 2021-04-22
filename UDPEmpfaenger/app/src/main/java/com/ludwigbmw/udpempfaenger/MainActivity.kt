package com.ludwigbmw.udpempfaenger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.lang.Exception
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

open class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Thread(UDPDataArrival()).start()
    }

    open fun receiveUDP() {
        val buffer = ByteArray(2048)
        var socket: DatagramSocket? = null
        try {
            //Keep a socket open to listen to all the UDP trafic that is destined for this port
            socket = DatagramSocket(5004, InetAddress.getByName("192.168.2.30"))
            socket.broadcast = true
            val packet = DatagramPacket(buffer, buffer.size)
            socket.receive(packet)
            println("open fun receiveUDP packet received = " + packet.data.toString())

        } catch (e: Exception) {
            println("open fun receiveUDP catch exception." + e.toString())
            e.printStackTrace()
        } finally {
            socket?.close()
        }
    }
}

class UDPDataArrival: Runnable, MainActivity() {
    override fun run() {
        while (true) {
            receiveUDP()
        }
    }

}