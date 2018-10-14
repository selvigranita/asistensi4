/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TaskPrak1 {
    public static void main(String[] args) throws IOException {
        List<Participant> participants = new ArrayList<Participant>();
        SerializationDemo demo = new SerializationDemo();
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        for(;;){
            System.out.println("Masukkan Nama depan : ");
            String c = buf.readLine();
            System.out.println("Masukkan Nama belakang : ");
            String d = buf.readLine();
            System.out.println("Masukkan Umur");
            int e = Integer.parseInt(buf.readLine());
            if(c.equalsIgnoreCase("exit")||d.equalsIgnoreCase("exit")||e == 0){
                System.out.println("System close!");
                break;
            }else{
               participants.add(new Participant(c,d,e));
               System.out.println("Participants : " +participants);
               demo.serialize(participants, "tugas1.ser");
               System.out.println("Serialization is done");
            }
        }
        
        System.out.println("Deserialize object ...");
        List<Participant> newList = demo.deserialize("tugas1.ser");
        System.out.println("New List : "+newList);
    }
}
