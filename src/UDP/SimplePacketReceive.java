/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class SimplePacketReceive {
    
    public static void main(String[] args) throws IOException {
        String fileBaru = "d:/dataBaru.txt";
        DatagramSocket socket = new DatagramSocket(2000);
        
        DatagramPacket packet = new DatagramPacket(new byte[256], 256);
        socket.receive(packet);
        
        String message = new String(packet.getData(), 0, packet.getLength());
        FileOutputStream fou = new FileOutputStream(fileBaru);
        for(int i=0; i<message.length(); i++){
                fou.write(message.charAt(i));
            }
        System.out.println(message);
    }
}
