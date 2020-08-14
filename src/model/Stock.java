/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;

/**
 *
 * @author Puspita Dewi Cahyawardani
 */
public class Stock {
    
    private final int tPoster;
    private final int tLeaflet;
    private final int tGantunganKunci;
    private final int tMug;
    private final int tKalender;
    private final int tBallpoint;
    private final int tBlocknote;
    private final int tTasfuring;
    private final int tTotebagCanvas;
    private final int tBagTag;
    private final int tBackpackFTI;
    
    public Stock(int Leaflet, int Poster, int Mug, int GantunganKunci, int Ballpoint, int Kalender, int Tasfuring, int Blocknote, int TotebagCanvas, int BackpackFTI, int BagTag){
        this.tLeaflet = Leaflet;
        this.tPoster = Poster;
        this.tMug = Mug;
        this.tGantunganKunci = GantunganKunci;
        this.tBallpoint = Ballpoint;
        this.tKalender = Kalender;
        this.tTasfuring = Tasfuring;
        this.tBlocknote = Blocknote;
        this.tTotebagCanvas = TotebagCanvas;
        this.tBackpackFTI = BackpackFTI;
        this.tBagTag = BagTag;
    }
    
    public int getLeaflet(){
        return this.tLeaflet;
    }
    
    public int getPoster(){
        return this.tPoster;
    }
    
    public int getMug(){
        return this.tMug;
    }
    
    public int getGantunganKunci(){
        return this.tGantunganKunci;
    }
    
    public int getBallpoint(){
        return this.tBallpoint;    
    }
    
    public int getKalender(){
        return tKalender;
    }
     
    public int getTasfuring(){
        return tTasfuring;
    }
    
    public int getBlocknote(){
        return tBlocknote;
    }
    
    public int getTotebagCanvas(){
        return tTotebagCanvas;
    }
    
    public int getBackpackFTI(){
        return tBackpackFTI;
    }
    
    public int getBagTag(){
        return tBagTag;
    }
}
