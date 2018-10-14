/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class EchoClient {
    
    public static final int SERVICE_PORT = 7;
    public static final int BUFSIZE = 256;
    
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        String hostname = ("localhost");
        InetAddress addr = null;
        addr = InetAddress.getByName(hostname);
        
        DatagramSocket socket = new DatagramSocket();
        socket.setSoTimeout(3);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Write your message here..");
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            PrintStream pout = new PrintStream(bout);
           
            pout.print(reader.readLine());
            // Get the contents of our message as an array of bytes
            byte [] barray = bout.toByteArray();
            // Create a datagram packet, contianing our byte array
            DatagramPacket packet = new DatagramPacket(barray, barray.length, addr, SERVICE_PORT);
            System.out.println("Sending packet to "+hostname);
            socket.send(packet);
            System.out.println("Waiting for packet....");
            // Create a small packet for receiving UDP packets
            byte[] recbuf = new byte[BUFSIZE];
            DatagramPacket receivePacket = new DatagramPacket(recbuf, BUFSIZE);
            // Declare a timout flag
            boolean timeout = false;
            // Catch any InterupteIOException that is throws
            // while waitng receive UDP packet
            try{
                socket.receive(receivePacket);
            }catch(InterruptedIOException ioe){
                timeout = true;
            }
            if(!timeout){
                System.out.println("packet received!");
                System.out.println("Details : "+receivePacket.getAddress().getCanonicalHostName());
                // Obtain a byte input stream to read the UDP packet
                ByteArrayInputStream bin = new ByteArrayInputStream(receivePacket.getData(), 0, receivePacket.getLength());
                // Connect a reader for easier access
                BufferedReader reader2 = new BufferedReader(new InputStreamReader(bin));
                // loop indefinitely
                for(;;){
                    String line = reader2.readLine();
                    // Check for end of data
                    if(line==null){
                        break;
                    }else {
                        System.out.println(line);
                    }
                }
            }else{
                System.out.println("Packet lost!");
                System.err.println();
            }
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ie){
            
            }
        }
    }

}
