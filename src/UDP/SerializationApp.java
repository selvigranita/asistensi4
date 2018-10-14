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

public class SerializationApp {
    
    public static void main(String[] args) throws IOException {
        List<Participant> participants = new ArrayList<Participant>();
        participants.add(new Participant("Salsabila", "Firdausi", 20));
        participants.add(new Participant("Ahmad", "Dzulfikri", 20));
        participants.add(new Participant("Frank", "Leroux", 24));
        SerializationDemo demo = new SerializationDemo();
        demo.serialize(participants, "participantData.ser");
        System.out.println("serialization is done");
        
        System.out.println("Deserialize object .....");
        List<Participant> newList = demo.deserialize("participantData.ser");
        System.out.println("New List : "+ newList);
    }
}
