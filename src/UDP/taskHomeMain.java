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

public class taskHomeMain {
    
    public static void main(String[] args) throws IOException {
        
        String fileName = "d:/dataMahasiswa.txt";
        String fileBaru = "d:/dataBaru.txt";
        ArrayList<taskHomeParticipant> datamu = new ArrayList<taskHomeParticipant>();
        taskHomeSerialization task = new taskHomeSerialization();
        ArrayList<taskHomeParticipant> newList = null;
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        for(;;){
            System.out.println("Menu :-");
            System.out.println("1.. Insert Data");
            System.out.println("2.. Update Data");
            System.out.println("3.. Delete Data");
            System.out.println("4.. Save Data");
            System.out.println("5.. Show Data");
            System.out.println("6.. Quit");
            System.out.print("Choice : ");
            
            int choice = Integer.parseInt(buf.readLine());
            switch(choice){
                case 1 : 
                         System.out.println("Enter NIM : ");
                         int a = Integer.parseInt(buf.readLine());
                         System.out.println("Enter Nama : ");
                         String b = buf.readLine();
                         System.out.println("Enter Asal : ");
                         String c = buf.readLine();
                         System.out.println("Enter Kelas : ");
                         String d = buf.readLine();
                         datamu.add(new taskHomeParticipant(a, b, c, d));
                         task.Serialize(datamu, fileName);
                    break;
                case 2 : System.out.println("Menampilkan data : ");
                         newList = (ArrayList<taskHomeParticipant>) task.print(fileName);
                         System.out.println("List Data : "+newList);
                         System.out.println("Pilih index data yang akan diubah : ");
                         int pilihIndex = Integer.parseInt(buf.readLine());
                         System.out.println("Pilih item dari index data ke "+pilihIndex);
                         int pilihItem = Integer.parseInt(buf.readLine());
                         if(pilihItem == 0){
                             System.out.println("Enter NIM : ");
                             a = Integer.parseInt(buf.readLine());
                             datamu.get(pilihIndex).setNim(a);
                         }else if(pilihItem == 1){
                             System.out.println("Enter Nama : ");
                             b = buf.readLine();
                             datamu.get(pilihIndex).setNama(b);
                         }else if(pilihItem == 2){
                             System.out.println("Enter Asal : ");
                             c = buf.readLine();
                             datamu.get(pilihIndex).setAsal(c);
                         }else if(pilihItem == 3){
                             System.out.println("Enter Kelas : ");
                             d = buf.readLine();
                             datamu.get(pilihIndex).setKelas(d);
                         }
                         task.Serialize(datamu, fileName);
                    break;
                case 3 : System.out.println("Menampilkan data : ");
                         newList = (ArrayList<taskHomeParticipant>) task.print(fileName);
                         System.out.println("List Data : "+newList);
                         System.out.println("Pilih index data yang akan dihapus : ");
                         pilihIndex = Integer.parseInt(buf.readLine());
                         datamu.remove(pilihIndex);
                         task.Serialize(datamu, fileName);
                    break;
                case 4 : task.save(datamu, fileBaru);
                         System.out.println("Data was Saved in "+ fileBaru);
                         
                    break;
                case 5 : newList = task.print(fileName);
                         System.out.println("List Data : "+newList);
                    break; 
                case 6 :    
                    System.exit(0);
            }
        }
        
    }
}
