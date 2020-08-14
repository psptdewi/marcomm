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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * FXML Controller class
 *
 * @author Puspita Dewi Cahyawardani
 */
public class CekLPJController implements Initializable {

    @FXML
    private TableView<LPJ> listLPJ;
    @FXML
    private TableColumn<LPJ, String> clickJudul;
    @FXML
    private TableColumn<LPJ, LocalDate> clickTanggal;
    @FXML
    private TableColumn<LPJ, String> clickJenisAcara;
    @FXML
    private TableColumn<LPJ, String> clickStatus;
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
    @FXML
    private TextField tfID;
    @FXML
    private ComboBox<String> btnpilihanStatus;
    ObservableList <String> Status = FXCollections.observableArrayList("DITERIMA", "TIDAK DITERIMA");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnpilihanAcara.setItems(List);
        btnpilihanStatus.setItems(Status);
        XmlLPJ larikLPJ = new XmlLPJ();
        try{
        larikLPJ.bacaData(larikLPJ);
        
        
        }catch (Exception e){
            
        }
        clickJudul.setCellValueFactory(cellData -> cellData.getValue().JudulProperty());
        clickJenisAcara.setCellValueFactory(cellData -> cellData.getValue().JenisAcaraProperty());
        clickTanggal.setCellValueFactory(cellData -> cellData.getValue().TanggalProperty());
        clickStatus.setCellValueFactory(cellData -> cellData.getValue().StatusProperty());
        listLPJ.setItems(larikLPJ.getLPJ());
        showLPJDetails(null);
        listLPJ.getSelectionModel().selectedItemProperty().addListener(
                    (observable, oldValue, lpj) -> showLPJDetails((LPJ) lpj));
    }    
    
    private void showLPJDetails(LPJ lpj) {
        if (lpj != null) {            
            XmlLPJ larikLPJ = new XmlLPJ();
            try{
                larikLPJ.bacaData(larikLPJ);
    //          Fill the labels with info from the LPJ object.
                tfID.setText(lpj.getID());
                tfJudul.setText(lpj.getJudul());
                btnpilihanAcara.setValue(lpj.getJenisAcara());
                btnpilihanStatus.setValue(lpj.getStatus());
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
            }catch(Exception e){
            }            
        } else {
            tfID.setText("");
            tfJudul.setText("");
            btnpilihanAcara.setValue("");
            btnpilihanStatus.setValue("");
            tfWilKeg1.setText("");            
//            tfTGL1.setValue("");
            tfTempat1.setText("");
            tfPJ1.setText("");
            tfAnggota1.setText("");
            tfInstitut1.setText("");
            tfAlmt2.setText("");
            tfCP3.setText("");
            tfRelasi.setText("");
            tfJenisKendaraan.setText("");
            tfTipeKendaraan.setText("");
            tfDriver.setText("");
            tfLeafletLPJ.setText("");
            tfPosterLPJ.setText("");
            tfMugLPJ.setText("");
            tfGantunganKunciLPJ.setText("");
            tfBallpointLPJ.setText("");
            tfKalenderLPJ.setText("");
            tfTasfuringLPJ.setText("");
            tfBlocknoteLPJ.setText("");  
            tfTotebagCanvasLPJ.setText("");
            tfBackpackFTILPJ.setText("");
            tfBagTagLPJ.setText("");
        }       
    }

    @FXML
    private void edit(MouseEvent event) {
        XmlLPJ larikLPJ = new XmlLPJ();
        try{
        larikLPJ.bacaData(larikLPJ);

        LPJ selectedLPJ = (LPJ) listLPJ.getSelectionModel().getSelectedItem();
        if (selectedLPJ != null) {
            boolean SubmitClicked = larikLPJ.showCekLPJEditDialog(selectedLPJ);
            if (SubmitClicked) {
                showLPJDetails(selectedLPJ);
              
                Parent parent = FXMLLoader.load(getClass().getResource("/view/CekLPJ.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();  
                ((Node) event.getSource()).getScene().getWindow().hide();
            }

        } else {
            // Nothing selected.

                Alert alert = new Alert(Alert.AlertType.WARNING);
                //alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("No Selection");
                alert.setHeaderText("No LPJ Selected");
                alert.setContentText("Please select a LPJ in the table.");

                alert.showAndWait();
        }
        }catch (Exception e){
            }
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/MenuDivisi.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();  
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void delete(MouseEvent event) throws TransformerConfigurationException, TransformerException, ParserConfigurationException, SAXException, IOException {
        int selectedIndex = listLPJ.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            listLPJ.getItems().remove(selectedIndex);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            Document dokumen = dbf.newDocumentBuilder().parse(new File("lpj.xml"));
       
            org.w3c.dom.Node lpj= dokumen.getFirstChild();
 
            //Mengambil elemen berdasarkan tag
            Element elementLPJ =  dokumen.getDocumentElement();
            org.w3c.dom.Node XmlLPJ = (org.w3c.dom.Node) elementLPJ.getElementsByTagName("XmlLPJ").item(selectedIndex);        
            elementLPJ.removeChild(XmlLPJ);
       
        
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            t.transform(new DOMSource(dokumen), new StreamResult("lpj.xml"));
            
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No LPJ Selected");
            alert.setContentText("Please select a LPJ in the table.");

            alert.showAndWait();
        }
    }
}
