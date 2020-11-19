/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venttigame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author marye
 */
public class Deck {

    public ArrayList<Card> cardDeck;

    //let's create cards so that there is 1 card per value 1-13 and suit 1-4
    public Deck() {
        this.cardDeck = new ArrayList<>();
        //System.out.println("testi");
        for (int i = 1; i <= 13; i++) {
            for (int j = 1; j <= 4; j++) {
                this.cardDeck.add(new Card(i, j));
            }
        }
        for (int k = 0; k < this.cardDeck.size(); k++) {
            System.out.println(this.cardDeck.get(k).tostring());
        }
        for (int k = 0; k < this.cardDeck.size(); k++) {
            this.cardDeck.get(k).modifyValues();
        }
        for (int k = 0; k < this.cardDeck.size(); k++) {
            System.out.println(this.cardDeck.get(k).tostring());
        }
    }

    public void shuffle() {
        //shuffling cards
        Collections.shuffle(cardDeck);
    }

    public Card cardDraw() {
        Random randCard = new Random();
        //check from Deck any card
        //random index
        int cardIndex = randCard.nextInt(cardDeck.size());
        //I need to consider later which one is better
        //Card drawnCard = cardDeck.get(randCard.nextInt(cardDeck.size()));
        //or should I just take always the last one from Array for performance improvement
        Card drawnCard = this.cardDeck.get(cardDeck.size() - 1);
        removeFromDeck(drawnCard);
        return drawnCard;
    }

    public void removeFromDeck(Card card) {
        //take the card away from deck from certain index
        this.cardDeck.remove(card);
    }

    public int deckSize() {
        return cardDeck.size();
    }

}
