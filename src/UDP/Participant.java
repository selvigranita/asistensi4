/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.Serializable;

public class Participant implements Serializable{
    private final String firstName;
    private final String lastName;
    private int age;
    
    public Participant(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    @Override
    public String toString(){
        return firstName+" "+lastName+" ("+age+") ";
    }
}
