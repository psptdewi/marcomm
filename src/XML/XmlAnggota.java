/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import controller.EditAnggotaController;
import java.io.File;
import java.io.IOException;
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
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import model.Anggota;
import model.Pengguna;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Puspita Dewi Cahyawardani
 */

public class XmlAnggota {
    public ObservableList <Anggota> Anggota;
    
    public XmlAnggota(){
        this.Anggota = FXCollections.observableArrayList();
    }
    
    public void SimpanDataKeXML(XmlAnggota _listAnggota) throws Exception{
        DocumentBuilderFactory produsen = DocumentBuilderFactory.newInstance();
        DocumentBuilder pembuat = produsen.newDocumentBuilder();
        Document dokumen = pembuat.newDocument();
        dokumen.setXmlStandalone(true);
        Element rootElement = dokumen.createElement("Anggota");
        dokumen.appendChild(rootElement);
       
        //Tulis XML (Membangun Data XML dari List)
        for(int i=0; i <_listAnggota.Anggota.size(); i++){
            Element elementAnggota = dokumen.createElement("XmlAnggota");
            elementAnggota.setAttribute("ID", ""+_listAnggota.Anggota.get(i).getId());
            rootElement.appendChild(elementAnggota);
            
            Element elemenNama = dokumen.createElement("Nama");
            elemenNama.setTextContent(_listAnggota.Anggota.get(i).getNama());
            elementAnggota.appendChild(elemenNama);         
            
            Element elemenJurusan = dokumen.createElement("Jurusan");
            elemenJurusan.setTextContent(_listAnggota.Anggota.get(i).getJurusan());
            elementAnggota.appendChild(elemenJurusan);
            
            Element elemenContact = dokumen.createElement("Contact");
            elemenContact.setTextContent(_listAnggota.Anggota.get(i).getContact());
            elementAnggota.appendChild(elemenContact);
        }
       
        //Membuat file XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource dom = new DOMSource(dokumen);
        StreamResult result = new StreamResult(new File("anggota.xml"));
        transformer.transform(dom, result);
    }
    
    public void TambahElemen(XmlAnggota _listAnggota, Anggota Anggota){
        _listAnggota.Anggota.add(Anggota);
    }
    
    public int cariElemen(String Id, XmlAnggota _listAnggota){
      
        Boolean ketemu=false;
        int j=0;
        while (j<=_listAnggota.Anggota.size()-1 & !ketemu){
            if (_listAnggota.Anggota.get(j).getId().equals(Id)){
                ketemu = true;
            } else {
                j = j + 1;
            }
        }
        return j;
    }
    
    public void bacaData(XmlAnggota _listAnggota) throws IOException, Exception{
        String Id, Nama, Jurusan, Contact, tagUtama, tagAtribut;
        
        //Persiapan membaca File XML
        File fileXML = new File("anggota.xml");
        DocumentBuilderFactory produsen = DocumentBuilderFactory.newInstance();
        DocumentBuilder pembuat = produsen.newDocumentBuilder();
        Document dok = pembuat.parse(fileXML);
        dok.getDocumentElement().normalize();
        
        //Membaca tag utama (opsional)
        tagUtama = dok.getDocumentElement().getNodeName();
        
        //Menginisialisasi tag yang akan dibaca
        NodeList listXML = dok.getElementsByTagName("XmlAnggota");
        
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
                Nama = elemenku.getElementsByTagName("Nama").item(0).getTextContent();
                Jurusan = elemenku.getElementsByTagName("Jurusan").item(0).getTextContent();
                Contact = elemenku.getElementsByTagName("Contact").item(0).getTextContent();
                
                //Memasukkan data yang didapat ke List
                Anggota B = new Anggota(Id, Nama, Jurusan, Contact);
                _listAnggota.Anggota.add(B);
            }
        }
    }
    
    public ObservableList<Anggota> getAnggota(){ 
      return Anggota;
    }
    
    public boolean showAnggotaEditDialog(Anggota Anggota) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Pengguna.class.getResource("/view/EditAnggota.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Anggota");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            //dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the lpj into the controller.
            EditAnggotaController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setAnggota(Anggota);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isSubmitClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

