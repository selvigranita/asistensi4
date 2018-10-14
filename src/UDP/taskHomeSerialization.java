/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class taskHomeSerialization {
    public void Serialize(ArrayList<taskHomeParticipant> pList, String fileName){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
            out.writeObject(pList);
        }catch(IOException ex){
            System.out.println("a problem assured during serialization\n"+ex.getMessage());
        }
    }
    public void save(ArrayList<taskHomeParticipant> pList, String fileBaru){
        try(FileOutputStream fou = new FileOutputStream(fileBaru)){
            String v = String.valueOf(pList);
            for(int i=0; i<v.length(); i++){
                fou.write(v.charAt(i));
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public ArrayList<taskHomeParticipant> print(String fileName){
        List<taskHomeParticipant> pList = null;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
            pList = (List<taskHomeParticipant>) in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.printf("a problem accured deserializing %s%n", fileName);
            System.out.println(ex.getMessage());
        }
        return (ArrayList<taskHomeParticipant>) pList;
    }
   
}
