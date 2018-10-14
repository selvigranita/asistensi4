/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PacketSendDemo {
    
    public static void main(String[] args) {
        System.out.println("Packet Send\n===================");
        String hostname = "localhost";
        try{
            System.out.println("Binding to a local port");
            // Create a datagram socket, bound to any available local port
            DatagramSocket socket = new DatagramSocket();
            System.out.println("Bound to local port "+ socket.getLocalPort());
            // Create a message to send using a UDP packet
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            String b = buf.readLine();
            PrintStream pout = new PrintStream(bout);
            pout.print(b);
            // Get the contents of our message as an array of bytes
            byte[] barray = bout.toByteArray();
            // Create a datagram packet, containing our byte array
            DatagramPacket packet = new DatagramPacket(barray, barray.length);
            
            System.out.println("Looking up hostname "+hostname);
            // Lookup the specified hostname, and get an inetAddress
            InetAddress remote_addr = InetAddress.getByName(hostname);
            System.out.println("Hostname recolved as "+remote_addr.getHostAddress());
            
            // Address packet to sender
            packet.setAddress(remote_addr);
            
            packet.setPort(2000);
            // Send the packet - remember no guarantee of delivery
            socket.send(packet);
            System.out.println("Packet Sent !");
        } catch(UnknownHostException uhe){
            System.err.println("Can't find host "+hostname+" cause something trouble in "+uhe);
        } catch(IOException ioe){
            System.err.println("Erroe - "+ioe);
        }
    }
}
