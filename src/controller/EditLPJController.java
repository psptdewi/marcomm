/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import XML.XmlLPJ;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import model.LPJ;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * FXML Controller class
 *
 * @author Puspita Dewi Cahyawardani
 */
public class EditLPJController implements Initializable {

    @FXML
    private Label labelJudul;
    @FXML
    private TextField tfWilKeg1;
    @FXML
    private TextField tfTempat1;
    @FXML
    private TextField tfPJ1;
    @FXML
    private TextField tfAnggota1;
    @FXML
    private TextField tfInstitut1;
    @FXML
    private TextField tfAlmt2;
    @FXML
    private TextField tfCP3;
    @FXML
    private TextField tfRelasi;
    @FXML
    private TextField tfJenisKendaraan;
    @FXML
    private TextField tfTipeKendaraan;
    @FXML
    private TextField tfDriver;
    @FXML
    private ComboBox<String> btnpilihanAcara;    
    ObservableList <String> List = FXCollections.observableArrayList("EXPO", "KUNJUNGAN", "ROADSHOW");
    @FXML
    private TextField tfLeafletLPJ;
    @FXML
    private TextField tfPosterLPJ;
    @FXML
    private TextField tfMugLPJ;
    @FXML
    private TextField tfGantunganKunciLPJ;
    @FXML
    private TextField tfBallpointLPJ;
    @FXML
    private TextField tfKalenderLPJ;
    @FXML
    private TextField tfTasfuringLPJ;
    @FXML
    private TextField tfBlocknoteLPJ;
    @FXML
    private TextField tfTotebagCanvasLPJ;
    @FXML
    private TextField tfBackpackFTILPJ;
    @FXML
    private TextField tfBagTagLPJ;
    @FXML
    private DatePicker tfTGL1;
    @FXML
    private TextField tfJudul;
    public Stage dialogStage;
    private boolean SubmitClicked = false;
    @FXML
    private TextField tfID;
    @FXML
    private TextField showID;
    @FXML
    private ComboBox<String> btnStatus;
    ObservableList <String> Status = FXCollections.observableArrayList("DITERIMA", "TIDAK DITERIMA");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         btnpilihanAcara.setItems(List);
         btnStatus.setItems(Status);
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
        
    public void setLPJ(LPJ lpj) {
        try{
                XmlLPJ larikLPJ = new XmlLPJ();
                larikLPJ.bacaData(larikLPJ);
                if(lpj != null){
                    tfID.setText(lpj.getID());
                    int posisi = larikLPJ.cariElemen(tfID.getText(), larikLPJ);
                    tfJudul.setText(lpj.getJudul());
                    btnpilihanAcara.setValue(lpj.getJenisAcara());
                    btnStatus.setValue(lpj.getStatus());
                    tfWilKeg1.setText(lpj.getWilayah());
                    tfTGL1.setValue(lpj.getTanggal());
                    tfTempat1.setText(lpj.getTempat());
                    tfPJ1.setText(lpj.getPJ());
                    tfAnggota1.setText(lpj.getAnggota());
                    tfInstitut1.setText(lpj.getInstitusi());
                    tfAlmt2.setText(lpj.getAlamat());
                    tfCP3.setText(lpj.getCP());
                    tfRelasi.setText(lpj.getRelasiKegiatan());
                    tfJenisKendaraan.setText(lpj.getJenisKendaraan());
                    tfTipeKendaraan.setText(lpj.getTipeKendaraan());
                    tfDriver.setText(lpj.getDriver());
                    tfLeafletLPJ.setText(Integer.toString(lpj.getLeafletLPJ()));
                    tfPosterLPJ.setText(Integer.toString(lpj.getPosterLPJ()));
                    tfMugLPJ.setText(Integer.toString(lpj.getMugLPJ()));
                    tfGantunganKunciLPJ.setText(Integer.toString(lpj.getGantunganKunciLPJ()));
                    tfBallpointLPJ.setText(Integer.toString(lpj.getBallpointLPJ()));
                    tfKalenderLPJ.setText(Integer.toString(lpj.getKalenderLPJ()));
                    tfTasfuringLPJ.setText(Integer.toString(lpj.getTasfuringLPJ()));
                    tfBlocknoteLPJ.setText(Integer.toString(lpj.getBlocknoteLPJ()));  
                    tfTotebagCanvasLPJ.setText(Integer.toString(lpj.getTotebagCanvasLPJ()));
                    tfBackpackFTILPJ.setText(Integer.toString(lpj.getBackpackFTILPJ()));
                    tfBagTagLPJ.setText(Integer.toString(lpj.getBagTagLPJ()));
                    showID.setText(lpj.getID());                
                }
            }catch (Exception e){                
            }    
    }
    
    public boolean isSubmitClicked() {
        return SubmitClicked;
    }
        
    @FXML
    private void back(MouseEvent event){
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (tfJudul.getText() == null || tfJudul.getText().length() == 0) {
            errorMessage += "Judul tidak valid"; 
        }
        if (tfWilKeg1.getText() == null || tfWilKeg1.getText().length() == 0) {
            errorMessage += "Wilayah tidak valid"; 
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
    private void submit(ActionEvent event) {
        String Id, Judul, JenisAcara, Wilayah, Tempat, PJ, Anggota, Institusi, Alamat, CP, RelasiKegiatan, JenisKendaraan, TipeKendaraan, Driver, Status;
        Integer LeafletLPJ, PosterLPJ, MugLPJ, GantunganKunciLPJ, BallpointLPJ, KalenderLPJ, TasfuringLPJ, BlocknoteLPJ, TotebagCanvasLPJ, BackpackFTILPJ, BagTagLPJ;
        LocalDate Tanggal;
        
        LPJ tempLPJ;        
        XmlLPJ larikLPJ = new XmlLPJ();
        
        try{
            if (isInputValid()) {
                larikLPJ.bacaData(larikLPJ);
                Id = tfID.getText();
                Judul = tfJudul.getText();
                JenisAcara = btnpilihanAcara.getSelectionModel().selectedItemProperty().getValue();
                Status = btnStatus.getSelectionModel().selectedItemProperty().getValue();
                Wilayah = tfWilKeg1.getText();
                Tanggal = LocalDate.parse(tfTGL1.getValue().toString());
                Tempat = tfTempat1.getText();
                PJ = tfPJ1.getText();
                Anggota = tfAnggota1.getText();
                Institusi = tfInstitut1.getText();
                Alamat = tfAlmt2.getText();
                CP = tfCP3.getText();
                RelasiKegiatan = tfRelasi.getText();
                JenisKendaraan = tfJenisKendaraan.getText();
                TipeKendaraan = tfTipeKendaraan.getText();
                Driver = tfDriver.getText();
                LeafletLPJ = Integer.parseInt(tfLeafletLPJ.getText());
                PosterLPJ = Integer.parseInt(tfPosterLPJ.getText());
                MugLPJ = Integer.parseInt(tfMugLPJ.getText());          
                GantunganKunciLPJ = Integer.parseInt(tfGantunganKunciLPJ.getText());
                BallpointLPJ = Integer.parseInt(tfBallpointLPJ.getText());
                KalenderLPJ = Integer.parseInt(tfKalenderLPJ.getText());
                TasfuringLPJ = Integer.parseInt(tfTasfuringLPJ.getText());
                BlocknoteLPJ = Integer.parseInt(tfBlocknoteLPJ.getText());
                TotebagCanvasLPJ = Integer.parseInt(tfTotebagCanvasLPJ.getText());
                BackpackFTILPJ = Integer.parseInt(tfBackpackFTILPJ.getText());
                BagTagLPJ = Integer.parseInt(tfBagTagLPJ.getText());
                
                Alert alertt = new Alert(Alert.AlertType.CONFIRMATION);
                alertt.setTitle("Konfirmasi");
                alertt.setHeaderText("Data LPJ akan disimpan");
                alertt.setContentText("Anda yakin?");

                Optional<ButtonType> result = alertt.showAndWait();                
                
                int posisi = larikLPJ.cariElemen(tfID.getText(), larikLPJ);
                tempLPJ = new LPJ(Id, Judul, JenisAcara, Wilayah, Tanggal, Tempat, PJ, Anggota, Institusi, Alamat, CP, RelasiKegiatan, JenisKendaraan, TipeKendaraan, Driver, LeafletLPJ, PosterLPJ, MugLPJ, GantunganKunciLPJ, BallpointLPJ, KalenderLPJ, TasfuringLPJ, BlocknoteLPJ, TotebagCanvasLPJ, BackpackFTILPJ, BagTagLPJ, Status);
                larikLPJ.LPJ.get(posisi).setLPJ(Id, Judul, JenisAcara, Wilayah, Tanggal, Tempat, PJ, Anggota, Institusi, Alamat, CP, RelasiKegiatan, JenisKendaraan, TipeKendaraan, Driver, LeafletLPJ, PosterLPJ, MugLPJ, GantunganKunciLPJ, BallpointLPJ, KalenderLPJ, TasfuringLPJ, BlocknoteLPJ, TotebagCanvasLPJ, BackpackFTILPJ, BagTagLPJ, Status);
                larikLPJ.SimpanDataKeXML(larikLPJ);
            }
            }catch (Exception e){            
        }
        
        SubmitClicked = true;
        dialogStage.close();
    }    
}
