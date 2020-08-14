/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import XML.XmlAnggota;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Anggota;

/**
 * FXML Controller class
 *
 * @author Puspita Dewi Cahyawardani
 */
public class FormAnggotaController implements Initializable {

    @FXML
    private TextField tfid;
    @FXML
    private TextField tfNama;
    @FXML
    private TextField tfJur;
    @FXML
    private TextField tfContact;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Done(ActionEvent event) throws Exception {
        String Id, Nama, Jurusan, Contact;
        
        Anggota temp_anggota;
        XmlAnggota larikAnggota = new XmlAnggota();
        larikAnggota.bacaData(larikAnggota);
        
        Id = tfid.getText();
        Nama = tfNama.getText();
        Jurusan = tfJur.getText();
        Contact = tfContact.getText();
        
        temp_anggota = new Anggota(Id, Nama, Jurusan, Contact);
        larikAnggota.TambahElemen(larikAnggota, temp_anggota);
        larikAnggota.SimpanDataKeXML(larikAnggota);
        
        Parent parent = FXMLLoader.load(getClass().getResource("/view/DaftarAnggota.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();  
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void back2(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/DaftarAnggota.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();  
        ((Node) event.getSource()).getScene().getWindow().hide();
    }
    
}
