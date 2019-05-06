package com.myprojectlist.springboot.utils.UDP;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UdpClient {
    private static DatagramSocket clientSocket = null;
    private InetSocketAddress serverAddress = null;

    public UdpClient(String host, int port) throws SocketException {
        clientSocket = new DatagramSocket( );           //创建socket
        serverAddress = new InetSocketAddress(host, port);  //绑定sever的ip与port
    }


    public void send(String msg) throws IOException {
        try {
            byte[] data = msg.getBytes("utf-8");
            DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress);
            clientSocket.send(packet);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //main方法用于测试
    public static void main(String[] args) throws Exception {
        UdpClient client = new UdpClient("127.0.0.1", 14586);
        client.send("hello world");
        clientSocket.close();
    }
}
