package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    @Test
    public void kortinSaldoAlussaOikein() {
        

        String vastaus = kortti.toString();

        assertEquals("saldo: 0.10", vastaus);
    
}
    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein(){
        kortti.lataaRahaa(20);
        assertEquals("saldo: 0.30", kortti.toString());
    }
    @Test
    public void rahanOttaminenVahentaaSaldoaOikein(){
        kortti.otaRahaa(10);
        assertEquals("saldo: 0.0", kortti.toString());
    }
    @Test
    public void SaldoEiMuutuJosEiRahaa(){
        kortti.otaRahaa(20);
        assertEquals("saldo: 0.10",kortti.toString());
    }
    @Test public void MetodiPalauttaaOikeinFalsenRahanOtossa(){
        boolean palautus=kortti.otaRahaa(20);
        assertEquals("false", Boolean.toString(palautus));
    }
    @Test public void MetodiPalauttaaOikeinTruenRahanOtossa(){
        boolean palautus=kortti.otaRahaa(10);
        assertEquals("true", Boolean.toString(palautus));
    }
    @Test public void SaldoKysely(){
        int saldotarkistus=kortti.saldo();
        assertEquals("10", Integer.toString(saldotarkistus));
    }
}
