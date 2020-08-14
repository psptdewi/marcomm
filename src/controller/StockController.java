/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import model.Stock;
import XML.XmlStock;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import XML.XmlLPJ;

/**
 * FXML Controller class
 *
 * @author Puspita Dewi Cahyawardani
 */
public class StockController implements Initializable {

    @FXML
    private TextField tfLeaflet;
    @FXML
    private TextField tfPoster;
    @FXML
    private Label lPoster;
    @FXML
    private TextField tfMug;
    @FXML
    private TextField tfGantunganKunci;
    @FXML
    private TextField tfBallpoint;
    @FXML
    private TextField tfKalender;
    @FXML
    private TextField tfTasfuring;
    @FXML
    private TextField tfBlocknote;
    @FXML
    private TextField tfTotebagCanvas;
    @FXML
    private TextField tfBackpackFTI;
    @FXML
    private TextField tfBagTag;
    @FXML
    private Label lMug;
    @FXML
    private Label lGantunganKunci;
    @FXML
    private Label lBalllpoint;
    @FXML
    private Label lKalender;
    @FXML
    private Label lTasfuring;
    @FXML
    private Label lBlocknote;
    @FXML
    private Label lTotebagCanvas;
    @FXML
    private Label lBackpackFTI;
    @FXML
    private Label lBagTag;
    @FXML
    private Button btnUpdate;
    @FXML
    private Label lLeaflet;

    /**
     * Initializes the controller class.
     */

    @FXML
    private void update(ActionEvent event) throws Exception{  
        int Leaflet, Poster, Mug, GantunganKunci, Ballpoint, Kalender, Tasfuring, 
                Blocknote, TotebagCanvas, BackpackFTI, BagTag;
        
        Stock temp_stock;
        XmlStock LarikStock = new XmlStock();
        LarikStock.SimpanDataKeXML(LarikStock);
        LarikStock.bacaData(LarikStock);
        
        Leaflet = Integer.parseInt(tfLeaflet.getText())+Integer.parseInt(lLeaflet.getText());
        Poster = Integer.parseInt(tfPoster.getText())+Integer.parseInt(lPoster.getText());
        Mug = Integer.parseInt(tfMug.getText())+Integer.parseInt(lMug.getText());
        GantunganKunci = Integer.parseInt(tfGantunganKunci.getText())+Integer.parseInt(lGantunganKunci.getText());
        Ballpoint = Integer.parseInt(tfBallpoint.getText())+Integer.parseInt(lBalllpoint.getText());
        Kalender = Integer.parseInt(tfKalender.getText())+Integer.parseInt(lKalender.getText());
        Tasfuring = Integer.parseInt(tfTasfuring.getText())+Integer.parseInt(lTasfuring.getText());
        Blocknote = Integer.parseInt(tfBlocknote.getText())+Integer.parseInt(lBlocknote.getText());
        TotebagCanvas = Integer.parseInt(tfTotebagCanvas.getText())+Integer.parseInt(lTotebagCanvas.getText());
        BackpackFTI = Integer.parseInt(tfBackpackFTI.getText())+Integer.parseInt(lBackpackFTI.getText());
        BagTag = Integer.parseInt(tfBagTag.getText())+Integer.parseInt(lBagTag.getText());   
        
        lLeaflet.setText(Integer.toString(Leaflet));
        lPoster.setText(Integer.toString(Poster));
        lMug.setText(Integer.toString(Mug));
        lGantunganKunci.setText(Integer.toString(GantunganKunci));
        lBalllpoint.setText(Integer.toString(Ballpoint));
        lKalender.setText(Integer.toString(Kalender));
        lTasfuring.setText(Integer.toString(Tasfuring));
        lBlocknote.setText(Integer.toString(Blocknote));
        lTotebagCanvas.setText(Integer.toString(TotebagCanvas));
        lBackpackFTI.setText(Integer.toString(BackpackFTI));
        lBagTag.setText(Integer.toString(BagTag));
        
        temp_stock = new Stock(Leaflet, Poster, Mug, GantunganKunci, Ballpoint, Kalender, Tasfuring, Blocknote, TotebagCanvas, BackpackFTI, BagTag);
        LarikStock.TambahElemen(LarikStock, temp_stock);
        LarikStock.SimpanDataKeXML(LarikStock);          
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
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Stock temp_stock;
        try {            
            XmlStock LarikStock = new XmlStock();
            LarikStock.bacaData(LarikStock);
            lLeaflet.setText(Integer.toString(LarikStock.Stock.get(0).getLeaflet()));
            lPoster.setText(Integer.toString(LarikStock.Stock.get(0).getPoster()));
            lMug.setText(Integer.toString(LarikStock.Stock.get(0).getMug()));
            lGantunganKunci.setText(Integer.toString(LarikStock.Stock.get(0).getGantunganKunci()));
            lBalllpoint.setText(Integer.toString(LarikStock.Stock.get(0).getBallpoint()));
            lKalender.setText(Integer.toString(LarikStock.Stock.get(0).getKalender()));
            lTasfuring.setText(Integer.toString(LarikStock.Stock.get(0).getTasfuring()));
            lBlocknote.setText(Integer.toString(LarikStock.Stock.get(0).getBlocknote()));
            lTotebagCanvas.setText(Integer.toString(LarikStock.Stock.get(0).getTotebagCanvas()));
            lBackpackFTI.setText(Integer.toString(LarikStock.Stock.get(0).getBackpackFTI()));
            lBagTag.setText(Integer.toString(LarikStock.Stock.get(0).getBagTag()));
        } catch (Exception ex) {
            Logger.getLogger(StockController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}