/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class ParticipantSer implements Serializable{
    
    private String firstName;
    private String lastName;
    private int age;
    
    public ParticipantSer(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    public void printData(){
        System.out.println("Nama\t : "+firstName +" "+lastName);
        System.out.println("Usia\t : "+age);
    }
    //to serializable object and save in a file
    public void saveObject(ParticipantSer Obj){
        try {
            FileOutputStream fos = new FileOutputStream("data.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Obj);
            oos.flush();
            fos.close();
        }catch(IOException ioe){
            System.out.println("a problem accured during serialize \n" +ioe.getMessage());
        }
    }
    
    // read a file and desearilize into object
    public void readObject(ParticipantSer Obj){
        try{
            FileInputStream fis = new FileInputStream("data.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Obj = (ParticipantSer) ois.readObject();
            Obj.printData();
            fis.close();
        }catch(IOException | ClassNotFoundException ex){
            System.out.println("a poblem accured during deserialize. \n"+ex);
            System.exit(1);
        }
    }
    
    public static void main(String[] args) {
        ParticipantSer is = new ParticipantSer("Salsabila","Firdausi", 20);
        is.saveObject(is);
        is.readObject(is);
    }
    
}
