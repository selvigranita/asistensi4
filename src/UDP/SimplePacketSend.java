/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SimplePacketSend {
    
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        
        DatagramSocket socket = new DatagramSocket();
        String message = "Salsabila Firdausi";
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), InetAddress.getLocalHost(), 2000);
        socket.send(packet);
        socket.close();
    }
}
