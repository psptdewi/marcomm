/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import XML.XmlAnggota;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
import model.Anggota;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * FXML Controller class
 *
 * @author Puspita Dewi Cahyawardani
 */
public class AnggotaController implements Initializable {

    @FXML
    private TableView<Anggota> listAnggota;
    @FXML
    private TableColumn<Anggota, String> listID;
    @FXML
    private TableColumn<Anggota, String> listNama;
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
        XmlAnggota larikAnggota = new XmlAnggota();
        try {
            larikAnggota.bacaData(larikAnggota);
        } catch (Exception e) {
        }
        listID.setCellValueFactory(cellData -> cellData.getValue().IdProperty());
        listNama.setCellValueFactory(cellData -> cellData.getValue().NamaProperty());
        listAnggota.setItems(larikAnggota.getAnggota());
        showAnggotaDetails(null);
        listAnggota.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, Anggota) -> showAnggotaDetails((Anggota) Anggota));
    }    

    private void showAnggotaDetails(Anggota anggota){
        if(anggota!=null){
            XmlAnggota larikAnggota = new XmlAnggota();
            try{
                larikAnggota.bacaData(larikAnggota);
                tfid.setText(anggota.getId());
                tfNama.setText(anggota.getNama());
                tfJur.setText(anggota.getJurusan());
                tfContact.setText(anggota.getContact());
            }catch(Exception e){
            }
        }else{
                tfid.setText("");
                tfNama.setText("");
                tfJur.setText("");
                tfContact.setText("");
                    }
    }
    
    @FXML
    private void back(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/MenuMarcomm.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();  
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void form(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/IsiAnggota.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();  
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void editAnggota(MouseEvent event) {
        XmlAnggota larikAnggota = new XmlAnggota();
        try{
        larikAnggota.bacaData(larikAnggota);

        Anggota selectedAnggota = (Anggota) listAnggota.getSelectionModel().getSelectedItem();
        if (selectedAnggota != null) {
            boolean SubmitClicked = larikAnggota.showAnggotaEditDialog(selectedAnggota);
            if (SubmitClicked) {
                showAnggotaDetails(selectedAnggota);
              
                Parent parent = FXMLLoader.load(getClass().getResource("/view/DaftarAnggota.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();  
                ((Node) event.getSource()).getScene().getWindow().hide();
            }

        } else {
            // Nothing selected.

                Alert alert = new Alert(AlertType.WARNING);
                //alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("No Selection");
                alert.setHeaderText("No Anggota Selected");
                alert.setContentText("Please select a Anggota in the table.");

                alert.showAndWait();
        }
        }catch (Exception e){
            }
    }

    @FXML
    private void deleteAnggotaa(MouseEvent event) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {
        int selectedIndex = listAnggota.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            listAnggota.getItems().remove(selectedIndex);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            Document dokumen = dbf.newDocumentBuilder().parse(new File("anggota.xml"));
       
            org.w3c.dom.Node anggota= dokumen.getFirstChild();
 
            //Mengambil elemen berdasarkan tag
            Element elementAnggota =  dokumen.getDocumentElement();
            org.w3c.dom.Node XmlAnggota = (org.w3c.dom.Node) elementAnggota.getElementsByTagName("XmlAnggota").item(selectedIndex);        
            elementAnggota.removeChild(XmlAnggota);
       
        
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            t.transform(new DOMSource(dokumen), new StreamResult("anggota.xml"));
            
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Anggota Selected");
            alert.setContentText("Please select a Anggota in the table.");

            alert.showAndWait();
        }
    }    
}
