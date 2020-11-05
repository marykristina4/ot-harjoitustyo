/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marye
 */
public class KassapaateTest {
    Kassapaate kassa;
    Maksukortti kortti;
    
    public KassapaateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(500);
    }
    
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void luotuKassaOlemassa() {
        assertTrue(kassa!=null);      
    }
    @Test
    public void luodunKassanSaldoOikein() {
        assertEquals("100000", Integer.toString(kassa.kassassaRahaa()));      
    }
    @Test
    public void luodunKassanLounasmaaraOikeinMaukasLounas(){
        assertEquals("0", Integer.toString(kassa.maukkaitaLounaitaMyyty()));
    }
    @Test
    public void luodunKassanLounasmaaraOikeinEdullinenLounas(){
        assertEquals("0", Integer.toString(kassa.edullisiaLounaitaMyyty()));
    }
    @Test
    public void rahaaTakaisinOikeinEdullinenLounas(){
        int rahaaTakaisin= kassa.syoEdullisesti(400);
        assertEquals("160",Integer.toString(rahaaTakaisin));
    }
    @Test
    public void kassaanOikeinRahaaEdullinenLounas(){
        kassa.syoEdullisesti(400);
        assertEquals("100240", Integer.toString(kassa.kassassaRahaa())); 
    }
    @Test
    public void myytyjenLounaidenMaaraKasvaaEdullinenLounas(){
        kassa.syoEdullisesti(400);
        assertEquals("1", Integer.toString(kassa.edullisiaLounaitaMyyty()));
    }
    @Test
    public void rahaaTakaisinOikeinMaukasLounas(){
        int rahaaTakaisin= kassa.syoMaukkaasti(500);
        assertEquals("100",Integer.toString(rahaaTakaisin));
    }
    @Test
    public void kassaanOikeinRahaaMaukasLounas(){
        kassa.syoMaukkaasti(500);
        assertEquals("100400", Integer.toString(kassa.kassassaRahaa())); 
    }
    @Test
    public void myytyjenLounaidenMaaraKasvaaMaukasLounas(){
        kassa.syoMaukkaasti(500);
        assertEquals("1", Integer.toString(kassa.maukkaitaLounaitaMyyty()));
    }
    @Test
    public void kassanSaldoKunRahaEiRiitaEdullinenLounas(){
        kassa.syoEdullisesti(200);
        assertEquals("100000",Integer.toString(kassa.kassassaRahaa()));
    }
    @Test
    public void kassanSaldoKunRahaEiRiitaMaukasLounas(){
        kassa.syoMaukkaasti(200);
        assertEquals("100000",Integer.toString(kassa.kassassaRahaa()));
    }
    @Test
    public void rahanPalautusKunRahaEiRiitaEdullinenLounas(){
       int rahaaTakaisin= kassa.syoEdullisesti(200);
        assertEquals("200",Integer.toString(rahaaTakaisin)); 
    }
    @Test
    public void rahanPalautusKunRahaEiRiitaMaukasLounas(){
       int rahaaTakaisin= kassa.syoEdullisesti(200);
        assertEquals("200",Integer.toString(rahaaTakaisin)); 
    }
    @Test
    public void lounaidenSaldoEiKasvaKunRahaEiRiitaEdullinenLounas(){
        kassa.syoEdullisesti(200);
        assertEquals("0", Integer.toString(kassa.edullisiaLounaitaMyyty()));
    }
    @Test
    public void lounaidenSaldoEiKasvaKunRahaEiRiitaMaukasLounas(){
        kassa.syoEdullisesti(200);
        assertEquals("0", Integer.toString(kassa.maukkaitaLounaitaMyyty()));
    }
    @Test
    public void korttiToimiiOikeinEdullinenLounas(){
        boolean onnistuiko=kassa.syoEdullisesti(kortti);
        assertEquals("true", Boolean.toString(onnistuiko));
    }
    @Test
    public void korttiToimiiOikeinMaukasLounas(){
        boolean onnistuiko=kassa.syoMaukkaasti(kortti);
        assertEquals("true", Boolean.toString(onnistuiko));
    }
    @Test
    public void kortillaEdullinenLounasLounassaldoKasvaa(){
        kassa.syoEdullisesti(kortti);
        assertEquals("1", Integer.toString(kassa.edullisiaLounaitaMyyty()));
    }
    @Test
    public void kortillaMaukasLounasLounassaldoKasvaa(){
        kassa.syoMaukkaasti(kortti);
        assertEquals("1", Integer.toString(kassa.maukkaitaLounaitaMyyty()));
    }
    @Test
    public void kortillaEiTarpeeksiKorttiEiToimiEdullinenLounas(){
        kassa.syoMaukkaasti(kortti);
      boolean onnistuiko=kassa.syoEdullisesti(kortti);
        assertEquals("false", Boolean.toString(onnistuiko));  
    }
    @Test
    public void kortillaEiTarpeeksiKorttiEiToimiMaukasLounas(){
        kassa.syoMaukkaasti(kortti);
      boolean onnistuiko=kassa.syoMaukkaasti(kortti);
        assertEquals("false", Boolean.toString(onnistuiko));  
    }
    @Test
    public void kortillaEiTarpeeksiKortinSaldoPysyyEdullinenLounas(){
        kassa.syoMaukkaasti(kortti);
        kassa.syoEdullisesti(kortti);
        assertEquals("100", Integer.toString(kortti.saldo()));  
    }
    @Test
    public void kortillaEiTarpeeksiKortinSaldoPysyyMaukasLounas(){
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals("100", Integer.toString(kortti.saldo()));  
    }
    @Test
    public void kortillaEiTarpeeksiMyyntiSaldoPysyyEdullinenLounas(){
        kassa.syoMaukkaasti(kortti);
        kassa.syoEdullisesti(kortti);
        assertEquals("0", Integer.toString(kassa.edullisiaLounaitaMyyty()));  
    }
    @Test
    public void kortillaEiTarpeeksiMyyntiSaldoPysyyMaukasLounas(){
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals("1", Integer.toString(kassa.maukkaitaLounaitaMyyty()));  
    }
    @Test
    public void kortillaMyyntiKassaSaldoPysyyEdullinenLounas(){
        kassa.syoEdullisesti(kortti);
        
        assertEquals("100000", Integer.toString(kassa.kassassaRahaa()));  
    }
    @Test
    public void kortillaMyyntiKassaSaldoPysyyMaukasLounas(){
        kassa.syoMaukkaasti(kortti);
        assertEquals("100000", Integer.toString(kassa.kassassaRahaa())); 
    }
    @Test
    public void rahanLatausKortinSaldoKasvaa(){
        kassa.lataaRahaaKortille(kortti, 100);
        assertEquals("600",Integer.toString(kortti.saldo()));
    }
    @Test
    public void rahanLatausKassaSaldoVahenee(){
        kassa.lataaRahaaKortille(kortti, 100);
        assertEquals("100100",Integer.toString(kassa.kassassaRahaa()));
    }
    @Test
    public void rahanLatausKassaSaldoSamaJosNegLataus(){
        kassa.lataaRahaaKortille(kortti, -100);
        assertEquals("100000",Integer.toString(kassa.kassassaRahaa()));
    }
}
