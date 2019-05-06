package com.myprojectlist.springboot.utils.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {
    private byte[] data = new byte[1024];
    private static DatagramSocket serverSocket = null;
    private DatagramPacket packet = null;

    public UdpServer(int port) throws SocketException {
        serverSocket = new DatagramSocket(port);
        System.out.println("sever start!");
    }

    //接收消息
    public String recieve() throws IOException {
        packet = new DatagramPacket(data, data.length);
        serverSocket.receive(packet);
        String info = new String(packet.getData(), 0, packet.getLength());
        System.out.println("recieve message from " + packet.getAddress().getHostAddress()
                + ":" + packet.getPort() + "\t"+ info);
        return info;
    }

    //本地测试
    public static void main(String[] args) throws Exception {
        UdpServer server = new UdpServer(14586);
        server.recieve();
    }
}