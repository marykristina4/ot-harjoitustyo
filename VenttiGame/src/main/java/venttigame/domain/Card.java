/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venttigame.domain;

/**
 * Luokka tarjoaa kortti-olion muuttujat ja metodit. 
 * Kun kortti luodaan, sille annetaan maa (suit) ja arvo (value).
 * Heti luomisen jälkeen kuvakorttien muuttuja number käsitellään ajamalla
 * metodi modifyValues(). Siinä kuvakorttien number-muuttuja saa arvon 10.
 * Korteilla on kaksi arvoa: value erottaa ne toisistaa, eli kuvakorteilla
 * on eri valuet, mutta kaikkien kuvakorttien number-arvo on 10.
 * 
 * 
 */
public class Card {

    int value;
    int suit;
    int number;

    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
        this.number = value;
    }
/**
 * Metodi muuttaa kuvakorttien number-arvon 10:ksi.
 *
 * 
 */
    public void modifyValues() {
        if (this.number > 10) {
            this.number = 10;
        }
    }
/**
 * Metodi palauttaa number-arvon.
 *
 * @return kortin number-arvo 
 */
    public int getNumber() {
        return this.number;
    }
/**
 * Metodi palauttaa kortin string-muotoisena esityksenä
 * jollaisena se näytetään käyttöliittymässä pelaajalle.
 *
 * @return kortin string-muoto.
 */
    public String tostring() {
        String cardDetails = "";
        if (value == 1) {
            cardDetails = "ässä";
        }
        if (value == 2) {
            cardDetails = "kakkonen";
        }
        if (value == 3) {
            cardDetails = "kolmonen";
        }
        if (value == 4) {
            cardDetails = "nelonen";
        }
        if (value == 5) {
            cardDetails = "vitonen";
        }
        if (value == 6) {
            cardDetails = "kutonen";
        }
        if (value == 7) {
            cardDetails = "seiska";
        }
        if (value == 8) {
            cardDetails = "kasi";
        }
        if (value == 9) {
            cardDetails = "ysi";
        }
        if (value == 10) {
            cardDetails = "kymppi";
        }
        if (value == 11) {
            cardDetails = "jätkä";
        }
        if (value == 12) {
            cardDetails = "rouva";
        }
        if (value == 13) {
            cardDetails = "kunkku";
        }

        if (suit == 1) {
            cardDetails = "Pata" + cardDetails;
        }
        if (suit == 2) {
            cardDetails = "Hertta" + cardDetails;
        }
        if (suit == 3) {
            cardDetails = "Ruutu" + cardDetails;
        }
        if (suit == 4) {
            cardDetails = "Risti" + cardDetails;
        }

        return cardDetails;
    }
}
