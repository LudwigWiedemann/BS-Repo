package com.ludwigbmw.udpempfaenger

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.nio.file.Files.find

open class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Thread(UdpDataArrival()).start()
       }

    private var updateUIHandler = object: Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            this@MainActivity.runOnUiThread {
                tv_message.text = msg.data?.getString("message_content")
            }
        }
    }

    class UdpDataArrival: Runnable {
        override fun run() {
            Log.d("LogTag", "Thread started")
            while (true) {
                val buffer = ByteArray(2048)
                var socket: DatagramSocket? = null
                try {
                    val locIP = InetAddress.getByName("192.168.2.31")
                    socket = DatagramSocket(5004, locIP)
                    socket.broadcast = true
                    val packet = DatagramPacket(buffer, buffer.size)
                    Log.e("LogTag", "before")

                    socket.receive(packet)
                    var msg = "String(packet.data)"
                    val message = Message.obtain()
                    message.data.putString("message_content", msg)
                    // TODO: find a way to use the UI Handler in this class
                    Log.e("LogTag", msg)
                } catch (e: Exception) {
                    Log.e("LogTag", "error", e)
                } finally {
                    socket?.close()
                }
            }

        }

    }
}