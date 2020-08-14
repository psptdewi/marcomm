/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import XML.XmlAnggota;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Anggota;

/**
 * FXML Controller class
 *
 * @author Puspita Dewi Cahyawardani
 */
public class EditAnggotaController implements Initializable {

    @FXML
    private TextField tfid;
    @FXML
    private TextField tfNama;
    @FXML
    private TextField tfJur;
    @FXML
    private TextField tfContact;
    public Stage dialogStage;
    private boolean SubmitClicked = false;
    @FXML
    private TextField showID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setAnggota(Anggota anggota) {
        try{
                XmlAnggota larikAnggota = new XmlAnggota();
                larikAnggota.bacaData(larikAnggota);
                if(anggota != null){
                    tfid.setText(anggota.getId());
                    int posisi = larikAnggota.cariElemen(tfid.getText(), larikAnggota);
                    tfNama.setText(anggota.getNama());
                    tfJur.setText(anggota.getJurusan());
                    tfContact.setText(anggota.getContact());
                    showID.setText(anggota.getId());                
                }
            }catch (Exception e){                
            }    
    }
    
    public boolean isSubmitClicked() {
        return SubmitClicked;
    }
    
    private boolean isInputValid() {
        String errorMessage = "";

        if (tfid.getText() == null || tfid.getText().length() == 0) {
            errorMessage += "ID tidak valid"; 
        }
        if (tfNama.getText() == null || tfNama.getText().length() == 0) {
            errorMessage += "Nama tidak valid"; 
        }
        if (errorMessage.length() == 0) {
        return true;
        } else {
            // Show the error message.

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(dialogStage);
                alert.setTitle("Invalid Fields");
                alert.setHeaderText("Please correct invalid fields");
                alert.setContentText(errorMessage);

                alert.showAndWait();
            return false;
        }
        
    }
    
    @FXML
    private void Done2(ActionEvent event) throws IOException {
        String Id, Nama, Jurusan, Contact;
        
        Anggota temp_anggota;
        XmlAnggota larikAnggota = new XmlAnggota();
        try {
            if(isInputValid()){
                larikAnggota.bacaData(larikAnggota);
                Id = tfid.getText();
                Nama = tfNama.getText();
                Jurusan = tfJur.getText();
                Contact = tfContact.getText();
                
                Alert alertt = new Alert(Alert.AlertType.CONFIRMATION);
                alertt.setTitle("Konfirmasi");
                alertt.setHeaderText("Data Anggota akan disimpan");
                alertt.setContentText("Anda yakin?");

                Optional<ButtonType> result = alertt.showAndWait();
                
                int posisi = larikAnggota.cariElemen(tfid.getText(), larikAnggota);
                temp_anggota = new Anggota(Id, Nama, Jurusan, Contact);
                larikAnggota.Anggota.get(posisi).setAnggota(Id, Nama, Jurusan, Contact);
                larikAnggota.SimpanDataKeXML(larikAnggota);
            }
        } catch (Exception e) {
        }
        
        SubmitClicked = true;
        dialogStage.close();
    }

    @FXML
    private void back3(MouseEvent event) throws IOException {
        dialogStage.close();
    }
    
}
