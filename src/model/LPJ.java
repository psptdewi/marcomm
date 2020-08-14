 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.util.Scanner;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Puspita Dewi Cahyawardani
 */
public class LPJ {
    
    String tID;
    StringProperty tJudul;
    StringProperty tJenisAcara;
    String tWilayah;
    ObjectProperty<LocalDate> tTanggal;
    String tTempat;
    String tPJ;
    String tAnggota;
    String tInstitusi;
    String tAlamat;
    String tCP;
    String tRelasiKegiatan;
    String tJenisKendaraan;
    String tTipeKendaraan;
    String tDriver;
    int tLeafletLPJ;
    int tPosterLPJ;
    int tMugLPJ;
    int tGantunganKunciLPJ;
    int tBallpointLPJ;
    int tKalenderLPJ;
    int tTasfuringLPJ;
    int tBlocknoteLPJ;
    int tTotebagCanvasLPJ;
    int tBackpackFTILPJ;
    int tBagTagLPJ;
    StringProperty tStatus;
    
    public LPJ(String Id, String Judul, String JenisAcara, String Wilayah, LocalDate Tanggal, String Tempat, String PJ, String Anggota, String Institusi, String Alamat, String CP, String RelasiKegiatan, String JenisKendaraan, String TipeKendaraan, String Driver, int LeafletLPJ, int PosterLPJ, int MugLPJ, int GantunganKunciLPJ, int BallpointLPJ, int KalenderLPJ, int TasfuringLPJ, int BlocknoteLPJ, int TotebagCanvasLPJ, int BackpackFTILPJ, int BagTagLPJ, String Status){
        this.tID = Id;
        this.tJudul = new SimpleStringProperty(Judul);
        this.tJenisAcara = new SimpleStringProperty (JenisAcara);
        this.tWilayah = Wilayah;
        this.tTanggal = new SimpleObjectProperty<LocalDate>(Tanggal);
        this.tTempat = Tempat;
        this.tPJ = PJ;
        this.tAnggota = Anggota;
        this.tInstitusi = Institusi;
        this.tAlamat = Alamat;
        this.tCP = CP;
        this.tRelasiKegiatan = RelasiKegiatan;
        this.tJenisKendaraan = JenisKendaraan;
        this.tTipeKendaraan = TipeKendaraan;
        this.tDriver = Driver;
        this.tLeafletLPJ = LeafletLPJ;
        this.tPosterLPJ = PosterLPJ;
        this.tMugLPJ = MugLPJ;
        this.tGantunganKunciLPJ = GantunganKunciLPJ;
        this.tBallpointLPJ = BallpointLPJ;
        this.tKalenderLPJ = KalenderLPJ;
        this.tTasfuringLPJ = TasfuringLPJ;
        this.tBlocknoteLPJ = BlocknoteLPJ;
        this.tTotebagCanvasLPJ = TotebagCanvasLPJ;
        this.tBackpackFTILPJ = BackpackFTILPJ;
        this.tBagTagLPJ = BagTagLPJ;
        this.tStatus = new SimpleStringProperty(Status);
    }
   
    public void setLPJ(String Id, String Judul, String JenisAcara, String Wilayah, LocalDate Tanggal, String Tempat, String PJ, String Anggota, String Institusi, String Alamat, String CP, String RelasiKegiatan, String JenisKendaraan, String TipeKendaraan, String Driver, int LeafletLPJ, int PosterLPJ, int MugLPJ, int GantunganKunciLPJ, int BallpointLPJ, int KalenderLPJ, int TasfuringLPJ, int BlocknoteLPJ, int TotebagCanvasLPJ, int BackpackFTILPJ, int BagTagLPJ, String Status){
        this.tID = Id;
        this.tJudul = new SimpleStringProperty(Judul);
        this.tJenisAcara = new SimpleStringProperty (JenisAcara);
        this.tWilayah = Wilayah;
        this.tTanggal = new SimpleObjectProperty<LocalDate>(Tanggal);
        this.tTempat = Tempat;
        this.tPJ = PJ;
        this.tAnggota = Anggota;
        this.tInstitusi = Institusi;
        this.tAlamat = Alamat;
        this.tCP = CP;
        this.tRelasiKegiatan = RelasiKegiatan;
        this.tJenisKendaraan = JenisKendaraan;
        this.tTipeKendaraan = TipeKendaraan;
        this.tDriver = Driver;
        this.tLeafletLPJ = LeafletLPJ;
        this.tPosterLPJ = PosterLPJ;
        this.tMugLPJ = MugLPJ;
        this.tGantunganKunciLPJ = GantunganKunciLPJ;
        this.tBallpointLPJ = BallpointLPJ;
        this.tKalenderLPJ = KalenderLPJ;
        this.tTasfuringLPJ = TasfuringLPJ;
        this.tBlocknoteLPJ = BlocknoteLPJ;
        this.tTotebagCanvasLPJ = TotebagCanvasLPJ;
        this.tBackpackFTILPJ = BackpackFTILPJ;
        this.tBagTagLPJ = BagTagLPJ;
        this.tStatus = new SimpleStringProperty(Status);
    }
    
    public String getID(){
        return this.tID;
    }
    
    public StringProperty JudulProperty(){
        return this.tJudul;    
    }
    
    public String getJudul(){
        return this.tJudul.get();    
    }
    
    public void setJudul(String Judul){
        this.tJudul.set(Judul);    
    }
    
    public StringProperty JenisAcaraProperty(){
        return this.tJenisAcara;    
    }
    
    public String getJenisAcara(){
        return this.tJenisAcara.get();    
    }
    
    public void setJenisAcara(String JenisAcara){
        this.tJenisAcara.set(JenisAcara);    
    }
    
    public String getWilayah(){
        return this.tWilayah;
    }
    
    public ObjectProperty<LocalDate> TanggalProperty(){
        return this.tTanggal;
    }
    
    public LocalDate getTanggal() {
        return tTanggal.get();
    }
    
    public void setTanggal(LocalDate Tanggal){
        this.tTanggal.set(Tanggal);    
    }
    
    public String getTempat(){
        return this.tTempat;
    }
    
    public String getPJ(){
        return this.tPJ;
    }
    
    public String getAnggota(){
        return this.tAnggota;
    }
    
    public String getInstitusi(){
        return this.tInstitusi;
    }
    
    public String getAlamat(){
        return this.tAlamat;
    }
    
    public String getCP(){
        return this.tCP;
    }
    
    public String getRelasiKegiatan(){
        return this.tRelasiKegiatan;
    }
    
    public String getJenisKendaraan(){
        return this.tJenisKendaraan;
    }
    
    public String getTipeKendaraan(){
        return this.tTipeKendaraan;
    }
    
    public String getDriver(){
        return this.tDriver;
    }
    
    public int getLeafletLPJ(){
        return this.tLeafletLPJ;
    }
    
    public int getPosterLPJ(){
        return this.tPosterLPJ;
    }
    
    public int getMugLPJ(){
        return this.tMugLPJ;
    }
    
    public int getGantunganKunciLPJ(){
        return this.tGantunganKunciLPJ;
    }
    
    public int getBallpointLPJ(){
        return this.tBallpointLPJ;
    }
    
    public int getKalenderLPJ(){
        return this.tKalenderLPJ;
    }
    
    public int getTasfuringLPJ(){
        return this.tTasfuringLPJ;
    }
    
    public int getBlocknoteLPJ(){
        return this.tBlocknoteLPJ;
    }
    
    public int getTotebagCanvasLPJ(){
        return this.tTotebagCanvasLPJ;
    }
    
    public int getBackpackFTILPJ(){
        return this.tBackpackFTILPJ;
    }
    
    public int getBagTagLPJ(){
        return this.tBagTagLPJ;
    }
    
    public StringProperty StatusProperty(){
        return this.tStatus;    
    }
    
    public String getStatus(){
        return this.tStatus.get();    
    }
    
    public void setStatus(String Status){
        this.tStatus.set(Status);    
    }
}
