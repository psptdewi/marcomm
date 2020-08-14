/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import model.LPJ;
import XML.XmlLPJ;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Puspita Dewi Cahyawardani
 */
public class InfoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private BarChart<?, ?> barChart;
    ObservableList<BarChart.Data> BarchartData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XmlLPJ lpj = new XmlLPJ();
        try {
              lpj.bacaData(lpj);
        } catch (Exception e) {
        }
      
        int Kalimantan=0;
        int Jawa=0;
        int Sumatera=0;
        int Sulawesi=0;
        int Papua=0;
        int Bali=0;
        
        for (int i=0; i<lpj.LPJ.size();i++){
        if("Belum".equals(lpj.LPJ.get(i).getWilayah())){
            continue;
        }else{
            String wilayah=lpj.LPJ.get(i).getWilayah();
          
           
            switch(wilayah){
                case "Kalimantan":
                    Kalimantan++;
                    break;
                case "Jawa":
                    Jawa++;
                    break;
                case "Sumatera":
                    Sumatera++;
                    break;
                case "Sulawesi":
                    Sulawesi++;
                    break;
                case "Papua":
                    Papua++;
                    break;
                case "Bali":
                    Bali++;
                    break;
                }
            }
        }
        XYChart.Series set1 = new XYChart.Series<>();
        set1.getData().add(new XYChart.Data("Kalimantan", Kalimantan));
        set1.getData().add(new XYChart.Data("Jawa", Jawa));
        set1.getData().add(new XYChart.Data("Sulawesi", Sulawesi));
        set1.getData().add(new XYChart.Data("Sumatera", Sumatera));
        set1.getData().add(new XYChart.Data("Papua", Papua));
        set1.getData().add(new XYChart.Data("Bali", Bali));
        barChart.getData().addAll(set1);
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

}
