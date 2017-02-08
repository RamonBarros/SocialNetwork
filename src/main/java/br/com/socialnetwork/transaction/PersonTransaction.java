package br.com.socialnetwork.transaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import br.com.socialnetwork.domain.Person;

public class PersonTransaction {
    
    public Person transactionIn(Person person) {
        
        File file = new File(person.getAddressImage());
        byte[] bFile = new byte[(int) file.length()];
        
        try {
            
            FileInputStream fileInputStream = new FileInputStream(file);
            
            //convert file into array of byte
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        person.setImage(bFile);
        
        return person;
    }
    
    public void transactionOut(Person person) {
        
        //get image from database
        byte[] bPerson = person.getImage();
        
        try {
            
            FileOutputStream fos = new FileOutputStream("/home/ramonbarros/Documentos/testes/output.jpg");
            fos.write(bPerson);
            fos.close();
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
}
