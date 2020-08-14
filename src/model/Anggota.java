/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Puspita Dewi Cahyawardani
 */
public class Anggota {
       
    StringProperty tId;
    StringProperty tNama;
    String tJurusan;
    String tContact;
    
    public Anggota(String Id, String Nama, String Jurusan, String Contact){
        this.tId = new SimpleStringProperty(Id);
        this.tNama = new SimpleStringProperty(Nama);
        this.tJurusan = Jurusan;
        this.tContact = Contact;
    }
    
    public void setAnggota(String Id, String Nama, String Jurusan, String Contact){
        this.tId = new SimpleStringProperty(Id);
        this.tNama = new SimpleStringProperty(Nama);
        this.tJurusan = Jurusan;
        this.tContact = Contact;
    }
    
    public String getId(){
        return this.tId.get();
    }
    
    public StringProperty IdProperty(){
        return this.tId;    
    }
    
    public void setId(String Id){
        this.tId.set(Id);    
    }
    
    public String getNama(){
        return this.tNama.get();
    }
    
    public StringProperty NamaProperty(){
        return this.tNama;    
    }
    
    public void setNama(String Nama){
        this.tId.set(Nama);    
    }
    
    public String getJurusan(){
        return this.tJurusan;
    }
    
    public String getContact(){
        return this.tContact;
    }
}
