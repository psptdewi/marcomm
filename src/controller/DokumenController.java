/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import model.LPJ;
import XML.XmlLPJ;
import java.time.LocalDate;
import javafx.scene.control.DatePicker;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * FXML Controller class
 *
 * @author Puspita Dewi Cahyawardani
 */
public class DokumenController implements Initializable {

    @FXML
    private TextField tfWilKeg1;
    @FXML
    private DatePicker tfTGL1;
    @FXML
    private TextField tfTempat1;
    @FXML
    private TextField tfPJ1;
    @FXML
    private TextField tfAnggota1;
    @FXML
    private TextField tfInstitut1;
    @FXML
    private TextField tfRelasi;
    @FXML
    private TextField tfJenisKendaraan;
    @FXML
    private TextField tfTipeKendaraan;
    @FXML
    private TextField tfDriver;
    @FXML
    private TextField tfAlmt2;
    @FXML
    private TextField tfCP3;
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
    private ComboBox<String> btnpilihanAcara;
    ObservableList <String> List = FXCollections.observableArrayList("EXPO", "KUNJUNGAN", "ROADSHOW");
    @FXML
    private TextField tfJudul;
    @FXML
    private TextField tfID;
    @FXML
    private Label labelJudul;
    @FXML
    private ComboBox<String> btnpilihanStatus;
    ObservableList <String> Status = FXCollections.observableArrayList("DITERIMA", "TIDAK DITERIMA");

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnpilihanAcara.setItems(List);
        btnpilihanStatus.setItems(Status);
    }
    
    @FXML
    private void back(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/DaftarLPJ.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();  
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    
    @FXML
    private void submit(ActionEvent event) throws Exception {
        String Id, Judul, JenisAcara, Wilayah, Tempat, PJ, Anggota, Institusi, Alamat, CP, RelasiKegiatan, JenisKendaraan, TipeKendaraan, Driver, Status;
        Integer LeafletLPJ, PosterLPJ, MugLPJ, GantunganKunciLPJ, BallpointLPJ, KalenderLPJ, TasfuringLPJ, BlocknoteLPJ, TotebagCanvasLPJ, BackpackFTILPJ, BagTagLPJ;
        LocalDate Tanggal;
        
        LPJ temp_lpj;
        XmlLPJ LarikLPJ = new XmlLPJ();
        LarikLPJ.bacaData(LarikLPJ);
        
        Id = tfID.getText();
        Judul = tfJudul.getText();
        JenisAcara = btnpilihanAcara.getSelectionModel().selectedItemProperty().getValue();
        Status = btnpilihanStatus.getSelectionModel().selectedItemProperty().getValue();
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
        
        temp_lpj = new LPJ(Id, Judul, JenisAcara, Wilayah, Tanggal, Tempat, PJ, Anggota, Institusi, Alamat, CP, RelasiKegiatan, JenisKendaraan, TipeKendaraan, Driver, LeafletLPJ, PosterLPJ, MugLPJ, GantunganKunciLPJ, BallpointLPJ, KalenderLPJ, TasfuringLPJ, BlocknoteLPJ, TotebagCanvasLPJ, BackpackFTILPJ, BagTagLPJ, Status);
        LarikLPJ.TambahElemen(LarikLPJ, temp_lpj);
        LarikLPJ.SimpanDataKeXML(LarikLPJ);  
        
        Parent parent = FXMLLoader.load(getClass().getResource("/view/DaftarLPJ.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();  
        ((Node) event.getSource()).getScene().getWindow().hide();
    }    
}
