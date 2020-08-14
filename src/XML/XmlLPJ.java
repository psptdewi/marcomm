/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import controller.EditCekLPJController;
import controller.EditLPJController;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
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
import model.Pengguna;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Puspita Dewi Cahyawardani
 */
public class XmlLPJ {
    public ObservableList <LPJ> LPJ;
    
    public XmlLPJ(){
        this.LPJ = FXCollections.observableArrayList();
    }
    
    public void SimpanDataKeXML(XmlLPJ _listLPJ) throws Exception{
        DocumentBuilderFactory produsen = DocumentBuilderFactory.newInstance();
        DocumentBuilder pembuat = produsen.newDocumentBuilder();
        Document dokumen = pembuat.newDocument();
        dokumen.setXmlStandalone(true);
        Element rootElement = dokumen.createElement("LPJ");
        dokumen.appendChild(rootElement);
       
        //Tulis XML (Membangun Data XML dari List)
        for(int i=0; i <_listLPJ.LPJ.size(); i++){
            Element elementLPJ = dokumen.createElement("XmlLPJ");
            elementLPJ.setAttribute("ID", ""+_listLPJ.LPJ.get(i).getID());
            rootElement.appendChild(elementLPJ);
            
            Element elemenJudul = dokumen.createElement("Judul");
            elemenJudul.setTextContent(_listLPJ.LPJ.get(i).getJudul());
            elementLPJ.appendChild(elemenJudul); 
            
            Element elemenJenisAcara = dokumen.createElement("JenisAcara");
            elemenJenisAcara.setTextContent(_listLPJ.LPJ.get(i).getJenisAcara());
            elementLPJ.appendChild(elemenJenisAcara); 
            
            Element elemenWilayah = dokumen.createElement("Wilayah");
            elemenWilayah.setTextContent(_listLPJ.LPJ.get(i).getWilayah());
            elementLPJ.appendChild(elemenWilayah);        
            
            Element elemenTanggal = dokumen.createElement("Tanggal");
            elemenTanggal.setTextContent(_listLPJ.LPJ.get(i).getTanggal().toString());
            elementLPJ.appendChild(elemenTanggal);         
            
            Element elemenTempat = dokumen.createElement("Tempat");
            elemenTempat.setTextContent(_listLPJ.LPJ.get(i).getTempat());
            elementLPJ.appendChild(elemenTempat);
            
            Element elemenPJ = dokumen.createElement("PJ");
            elemenPJ.setTextContent(_listLPJ.LPJ.get(i).getPJ());
            elementLPJ.appendChild(elemenPJ);
            
            Element elemenAnggota = dokumen.createElement("Anggota");
            elemenAnggota.setTextContent(_listLPJ.LPJ.get(i).getAnggota());
            elementLPJ.appendChild(elemenAnggota);
            
            Element elemenInstitusi = dokumen.createElement("Institusi");
            elemenInstitusi.setTextContent(_listLPJ.LPJ.get(i).getInstitusi());
            elementLPJ.appendChild(elemenInstitusi);
            
            Element elemenAlamat = dokumen.createElement("Alamat");
            elemenAlamat.setTextContent(_listLPJ.LPJ.get(i).getAlamat());
            elementLPJ.appendChild(elemenAlamat);
            
            Element elemenCP = dokumen.createElement("CP");
            elemenCP.setTextContent(_listLPJ.LPJ.get(i).getCP());
            elementLPJ.appendChild(elemenCP);
            
            Element elemenRelasiKegiatan = dokumen.createElement("RelasiKegiatan");
            elemenRelasiKegiatan.setTextContent(_listLPJ.LPJ.get(i).getRelasiKegiatan());
            elementLPJ.appendChild(elemenRelasiKegiatan);
            
            Element elemenJenisKendaraan = dokumen.createElement("JenisKendaraan");
            elemenJenisKendaraan.setTextContent(_listLPJ.LPJ.get(i).getJenisKendaraan());
            elementLPJ.appendChild(elemenJenisKendaraan);
            
            Element elemenTipeKendaraan = dokumen.createElement("TipeKendaraan");
            elemenTipeKendaraan.setTextContent(_listLPJ.LPJ.get(i).getTipeKendaraan());
            elementLPJ.appendChild(elemenTipeKendaraan);
            
            Element elemenDriver = dokumen.createElement("Driver");
            elemenDriver.setTextContent(_listLPJ.LPJ.get(i).getDriver());
            elementLPJ.appendChild(elemenDriver);
            
            Element elemenLeafletLPJ = dokumen.createElement("LeafletLPJ");
            elemenLeafletLPJ.setTextContent(Integer.toString(_listLPJ.LPJ.get(i).getLeafletLPJ()));
            elementLPJ.appendChild(elemenLeafletLPJ);
            
            Element elemenPosterLPJ = dokumen.createElement("PosterLPJ");
            elemenPosterLPJ.setTextContent(Integer.toString(_listLPJ.LPJ.get(i).getPosterLPJ()));
            elementLPJ.appendChild(elemenPosterLPJ);         
            
            Element elemenMugLPJ = dokumen.createElement("MugLPJ");
            elemenMugLPJ.setTextContent(Integer.toString(_listLPJ.LPJ.get(i).getMugLPJ()));
            elementLPJ.appendChild(elemenMugLPJ);
            
            Element elemenGantunganKunciLPJ = dokumen.createElement("GantunganKunciLPJ");
            elemenGantunganKunciLPJ.setTextContent(Integer.toString(_listLPJ.LPJ.get(i).getGantunganKunciLPJ()));
            elementLPJ.appendChild(elemenGantunganKunciLPJ);
            
            Element elemenBallpointLPJ = dokumen.createElement("BallpointLPJ");
            elemenBallpointLPJ.setTextContent(Integer.toString(_listLPJ.LPJ.get(i).getBallpointLPJ()));
            elementLPJ.appendChild(elemenBallpointLPJ);
            
            Element elemenKalenderLPJ = dokumen.createElement("KalenderLPJ");
            elemenKalenderLPJ.setTextContent(Integer.toString(_listLPJ.LPJ.get(i).getKalenderLPJ()));
            elementLPJ.appendChild(elemenKalenderLPJ);
            
            Element elemenTasfuringLPJ = dokumen.createElement("TasfuringLPJ");
            elemenTasfuringLPJ.setTextContent(Integer.toString(_listLPJ.LPJ.get(i).getTasfuringLPJ()));
            elementLPJ.appendChild(elemenTasfuringLPJ);
            
            Element elemenBlocknoteLPJ = dokumen.createElement("BlocknoteLPJ");
            elemenBlocknoteLPJ.setTextContent(Integer.toString(_listLPJ.LPJ.get(i).getBlocknoteLPJ()));
            elementLPJ.appendChild(elemenBlocknoteLPJ);
            
            Element elemenTotebagCanvasLPJ = dokumen.createElement("TotebagCanvasLPJ");
            elemenTotebagCanvasLPJ.setTextContent(Integer.toString(_listLPJ.LPJ.get(i).getTotebagCanvasLPJ()));
            elementLPJ.appendChild(elemenTotebagCanvasLPJ);
            
            Element elemenBackpackFTILPJ = dokumen.createElement("BackpackFTILPJ");
            elemenBackpackFTILPJ.setTextContent(Integer.toString(_listLPJ.LPJ.get(i).getBackpackFTILPJ()));
            elementLPJ.appendChild(elemenBackpackFTILPJ);
            
            Element elemenBagTagLPJ = dokumen.createElement("BagTagLPJ");
            elemenBagTagLPJ.setTextContent(Integer.toString(_listLPJ.LPJ.get(i).getBagTagLPJ()));
            elementLPJ.appendChild(elemenBagTagLPJ);
            
            Element elemenStatus = dokumen.createElement("Status");
            elemenStatus.setTextContent(_listLPJ.LPJ.get(i).getStatus());
            elementLPJ.appendChild(elemenStatus);
        }
       
        //Membuat file XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource dom = new DOMSource(dokumen);
        StreamResult result = new StreamResult(new File("lpj.xml"));
        transformer.transform(dom, result);
    }
    
    public void TambahElemen(XmlLPJ _listLPJ, LPJ LPJ){
        _listLPJ.LPJ.add(LPJ);
    }
    
    public int cariElemen(String Id, XmlLPJ _listLPJ){
      
        Boolean ketemu=false;
        int j=0;
        while (j<=_listLPJ.LPJ.size()-1 & !ketemu){
            if (_listLPJ.LPJ.get(j).getID().equals(Id)){
                ketemu = true;
            } else {
                j = j + 1;
            }
        }
        return j;
    }
        
    public void bacaData(XmlLPJ _listLPJ) throws IOException, Exception{
        String Id, Judul, JenisAcara, Wilayah, Tempat, PJ, Anggota, Institusi, Alamat, CP, RelasiKegiatan, JenisKendaraan, TipeKendaraan, Driver, tagUtama, tagAtribut, Status;
        Integer LeafletLPJ, PosterLPJ, MugLPJ, GantunganKunciLPJ, BallpointLPJ, KalenderLPJ, TasfuringLPJ, BlocknoteLPJ, TotebagCanvasLPJ, BackpackFTILPJ, BagTagLPJ;
        LocalDate Tanggal;
        
        //Persiapan membaca File XML
        File fileXML = new File("lpj.xml");
        DocumentBuilderFactory produsen = DocumentBuilderFactory.newInstance();
        DocumentBuilder pembuat = produsen.newDocumentBuilder();
        Document dok = pembuat.parse(fileXML);
        dok.getDocumentElement().normalize();
        
        //Membaca tag utama (opsional)
        tagUtama = dok.getDocumentElement().getNodeName();
        
        //Menginisialisasi tag yang akan dibaca
        NodeList listXML = dok.getElementsByTagName("XmlLPJ");
        
        for(int i=0; i < listXML.getLength(); i++){
            //Membuat node (atribut) yang akan dibaca (di contoh ada 5 node)
            org.w3c.dom.Node nodeXML = listXML.item(i);
            
            //Membaca tiap node (atribut) (opsional)
            tagAtribut = nodeXML.getNodeName();
            
            //Mengambil node untuk tiap iterasi (5 node = 5 iterasi)
            if(nodeXML.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
                Element elemenku = (Element) nodeXML;
                
                //Memindahkan ke variabel sementara
                Id = elemenku.getAttribute("ID");
                Judul = elemenku.getElementsByTagName("Judul").item(0).getTextContent();       
                JenisAcara = elemenku.getElementsByTagName("JenisAcara").item(0).getTextContent();              
                Wilayah = elemenku.getElementsByTagName("Wilayah").item(0).getTextContent();                
                Tanggal = LocalDate.parse(elemenku.getElementsByTagName("Tanggal").item(0).getTextContent());
                Tempat = elemenku.getElementsByTagName("Tempat").item(0).getTextContent();
                PJ = elemenku.getElementsByTagName("PJ").item(0).getTextContent();
                Anggota = elemenku.getElementsByTagName("Anggota").item(0).getTextContent();
                Institusi = elemenku.getElementsByTagName("Institusi").item(0).getTextContent();
                Alamat = elemenku.getElementsByTagName("Alamat").item(0).getTextContent();
                CP = elemenku.getElementsByTagName("CP").item(0).getTextContent();
                RelasiKegiatan = elemenku.getElementsByTagName("RelasiKegiatan").item(0).getTextContent();
                JenisKendaraan = elemenku.getElementsByTagName("JenisKendaraan").item(0).getTextContent();
                TipeKendaraan = elemenku.getElementsByTagName("TipeKendaraan").item(0).getTextContent();
                Driver = elemenku.getElementsByTagName("Driver").item(0).getTextContent();
                LeafletLPJ = Integer.parseInt(elemenku.getElementsByTagName("LeafletLPJ").item(0).getTextContent());
                PosterLPJ = Integer.parseInt(elemenku.getElementsByTagName("PosterLPJ").item(0).getTextContent());
                MugLPJ = Integer.parseInt(elemenku.getElementsByTagName("MugLPJ").item(0).getTextContent());
                GantunganKunciLPJ = Integer.parseInt(elemenku.getElementsByTagName("GantunganKunciLPJ").item(0).getTextContent());
                BallpointLPJ = Integer.parseInt(elemenku.getElementsByTagName("BallpointLPJ").item(0).getTextContent());
                KalenderLPJ = Integer.parseInt(elemenku.getElementsByTagName("KalenderLPJ").item(0).getTextContent());
                TasfuringLPJ = Integer.parseInt(elemenku.getElementsByTagName("TasfuringLPJ").item(0).getTextContent());
                BlocknoteLPJ = Integer.parseInt(elemenku.getElementsByTagName("BlocknoteLPJ").item(0).getTextContent());
                TotebagCanvasLPJ = Integer.parseInt(elemenku.getElementsByTagName("TotebagCanvasLPJ").item(0).getTextContent());
                BackpackFTILPJ = Integer.parseInt(elemenku.getElementsByTagName("BackpackFTILPJ").item(0).getTextContent());
                BagTagLPJ = Integer.parseInt(elemenku.getElementsByTagName("BagTagLPJ").item(0).getTextContent());
                Status = elemenku.getElementsByTagName("Status").item(0).getTextContent();
                //Memasukkan data yang didapat ke List
                LPJ C = new LPJ(Id, Judul, JenisAcara, Wilayah, Tanggal, Tempat, PJ, Anggota, Institusi, Alamat, CP, RelasiKegiatan, JenisKendaraan, TipeKendaraan, Driver, LeafletLPJ, PosterLPJ, MugLPJ, GantunganKunciLPJ, BallpointLPJ, KalenderLPJ, TasfuringLPJ, BlocknoteLPJ, TotebagCanvasLPJ, BackpackFTILPJ, BagTagLPJ, Status);
                _listLPJ.LPJ.add(C);
            }
        }
    }  
    
    public ObservableList<LPJ> getLPJ(){ 
      return LPJ;
    }
    
    public boolean showLPJEditDialog(LPJ lpj) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Pengguna.class.getResource("/view/TampilLPJ.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit LPJ");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            //dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the lpj into the controller.
            EditLPJController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setLPJ(lpj);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isSubmitClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }    
    
    public boolean showCekLPJEditDialog(LPJ lpj) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Pengguna.class.getResource("/view/EditCekLPJ.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit LPJ");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            //dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the lpj into the controller.
            EditCekLPJController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setLPJ(lpj);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isSubmitClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }    
  }

