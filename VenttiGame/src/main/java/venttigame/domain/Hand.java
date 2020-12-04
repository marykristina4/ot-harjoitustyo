/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venttigame.domain;

import java.util.ArrayList;

/**
 * Luokka, jossa korttien hallinnointi kädessä.
 * Sisältää metodit kortin laittamiseksi käteen, kädet korttien 
 * summan laskemiseksi, sekä kädessä olevien korttien lukumäärän tarkastamiseksi
 * 
 */
public class Hand {

    public ArrayList<Card> cardHand;

    public Hand() {
        this.cardHand = new ArrayList<>();
    }
 /**
 * Metodi lisää syötteenä saadun kortin käteen
 * 
 * @param card Syötteenä saatu kortti joka lisätään käteen
 */
    public void addCard(Card card) {
        this.cardHand.add(card);
    }
 /**
 * Metodi palauttaa kädessä olevien korttien summan
 * 
 * @return Kädessä olevien korttien summa
 */
    public int handSum() {
        int sum = 0;
        for (int i = 0; i < this.cardHand.size(); i++) {
            sum = sum + this.cardHand.get(i).number;
        }
        return sum;
    }
 /**
 * Metodi palauttaa kädessä olevien korttien lukumäärän
 * 
 * @return Kädessä olevien korttien lukumäärä
 */
    public int handSize() {
        return cardHand.size();
    }
}
