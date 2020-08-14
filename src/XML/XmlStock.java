/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import model.Stock;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Puspita Dewi Cahyawardani
 */
public class XmlStock {
    public List <Stock> Stock;
    
    public XmlStock(){
        this.Stock = new ArrayList();
    }
    
    public void SimpanDataKeXML(XmlStock _listStock) throws Exception{
        DocumentBuilderFactory produsen = DocumentBuilderFactory.newInstance();
        DocumentBuilder pembuat = produsen.newDocumentBuilder();
        Document dokumen = pembuat.newDocument();
        dokumen.setXmlStandalone(true);
        Element rootElement = dokumen.createElement("Stock");
        dokumen.appendChild(rootElement);
       
        //Tulis XML (Membangun Data XML dari List)
        for(int i=0; i <_listStock.Stock.size(); i++){
            Element elementStock = dokumen.createElement("XmlStock");
            elementStock.setAttribute("Leaflet", ""+_listStock.Stock.get(i).getLeaflet());
            rootElement.appendChild(elementStock);
            
            Element elemenPoster = dokumen.createElement("Poster");
            elemenPoster.setTextContent(Integer.toString(_listStock.Stock.get(i).getPoster()));
            elementStock.appendChild(elemenPoster);         
            
            Element elemenMug = dokumen.createElement("Mug");
            elemenMug.setTextContent(Integer.toString(_listStock.Stock.get(i).getMug()));
            elementStock.appendChild(elemenMug);
            
            Element elemenGantunganKunci = dokumen.createElement("GantunganKunci");
            elemenGantunganKunci.setTextContent(Integer.toString(_listStock.Stock.get(i).getGantunganKunci()));
            elementStock.appendChild(elemenGantunganKunci);
            
            Element elemenBallpoint = dokumen.createElement("Ballpoint");
            elemenBallpoint.setTextContent(Integer.toString(_listStock.Stock.get(i).getBallpoint()));
            elementStock.appendChild(elemenBallpoint);
            
            Element elemenKalender = dokumen.createElement("Kalender");
            elemenKalender.setTextContent(Integer.toString(_listStock.Stock.get(i).getKalender()));
            elementStock.appendChild(elemenKalender);
            
            Element elemenTasfuring = dokumen.createElement("Tasfuring");
            elemenTasfuring.setTextContent(Integer.toString(_listStock.Stock.get(i).getTasfuring()));
            elementStock.appendChild(elemenTasfuring);
            
            Element elemenBlocknote = dokumen.createElement("Blocknote");
            elemenBlocknote.setTextContent(Integer.toString(_listStock.Stock.get(i).getBlocknote()));
            elementStock.appendChild(elemenBlocknote);
            
            Element elemenTotebagCanvas = dokumen.createElement("TotebagCanvas");
            elemenTotebagCanvas.setTextContent(Integer.toString(_listStock.Stock.get(i).getTotebagCanvas()));
            elementStock.appendChild(elemenTotebagCanvas);
            
            Element elemenBackpackFTI = dokumen.createElement("BackpackFTI");
            elemenBackpackFTI.setTextContent(Integer.toString(_listStock.Stock.get(i).getBackpackFTI()));
            elementStock.appendChild(elemenBackpackFTI);
            
            Element elemenBagTag = dokumen.createElement("BagTag");
            elemenBagTag.setTextContent(Integer.toString(_listStock.Stock.get(i).getBagTag()));
            elementStock.appendChild(elemenBagTag);
        }
       
        //Membuat file XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource dom = new DOMSource(dokumen);
        StreamResult result = new StreamResult(new File("stock.xml"));
        transformer.transform(dom, result);
    }
    
    public void TambahElemen(XmlStock _listStock, Stock Stock){
        _listStock.Stock.add(Stock);
    }
    public void bacaData(XmlStock _XmlStock) throws IOException, Exception{
        int Leaflet, Poster, Mug, GantunganKunci, Ballpoint, Kalender, Tasfuring, Blocknote, TotebagCanvas, BackpackFTI, BagTag;
        String tagUtama, tagAtribut;
                
        //Persiapan membaca File XML
        File fileXML = new File("stock.xml");
        DocumentBuilderFactory produsen = DocumentBuilderFactory.newInstance();
        DocumentBuilder pembuat = produsen.newDocumentBuilder();
        Document dok = pembuat.parse(fileXML);
        dok.getDocumentElement().normalize();
        
        //Membaca tag utama (opsional)
        tagUtama = dok.getDocumentElement().getNodeName();
        
        //Menginisialisasi tag yang akan dibaca
        NodeList listXML = dok.getElementsByTagName("XmlStock");
        
        for(int i=0; i < listXML.getLength(); i++){
            //Membuat node (atribut) yang akan dibaca (di contoh ada 5 node)
            org.w3c.dom.Node nodeXML = listXML.item(i);
            
            //Membaca tiap node (atribut) (opsional)
            tagAtribut = nodeXML.getNodeName();
            
            //Mengambil node untuk tiap iterasi (5 node = 5 iterasi)
            if(nodeXML.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
                Element elemenku = (Element) nodeXML;
                
                //Memindahkan ke variabel sementara
                Leaflet = (Integer.parseInt(elemenku.getAttribute("Leaflet")));
                Poster = (Integer.parseInt(elemenku.getElementsByTagName("Poster").item(0).getTextContent()));
                Mug = (Integer.parseInt(elemenku.getElementsByTagName("Mug").item(0).getTextContent()));
                GantunganKunci = (Integer.parseInt(elemenku.getElementsByTagName("GantunganKunci").item(0).getTextContent()));
                Ballpoint = (Integer.parseInt(elemenku.getElementsByTagName("Ballpoint").item(0).getTextContent()));
                Kalender = (Integer.parseInt(elemenku.getElementsByTagName("Kalender").item(0).getTextContent()));
                Tasfuring = (Integer.parseInt(elemenku.getElementsByTagName("Tasfuring").item(0).getTextContent()));
                Blocknote = (Integer.parseInt(elemenku.getElementsByTagName("Blocknote").item(0).getTextContent()));
                TotebagCanvas = (Integer.parseInt(elemenku.getElementsByTagName("TotebagCanvas").item(0).getTextContent()));
                BackpackFTI = (Integer.parseInt(elemenku.getElementsByTagName("BackpackFTI").item(0).getTextContent()));
                BagTag = (Integer.parseInt(elemenku.getElementsByTagName("BagTag").item(0).getTextContent()));
                
                //Memasukkan data yang didapat ke List
                Stock A = new Stock(Leaflet, Poster, Mug, GantunganKunci, Ballpoint, Kalender, Tasfuring, Blocknote, TotebagCanvas, BackpackFTI, BagTag);
                _XmlStock.Stock.add(A);
            }
        }
    }
}

