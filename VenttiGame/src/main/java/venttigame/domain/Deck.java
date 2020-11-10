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
    public ArrayList<Card> cardDeck = new ArrayList<>();
    
    //let's create cards so that there is 1 card per value 1-13 and suit 1-4
    public Deck(){
        for (int i=1; i<=13; i++){
            for (int j=1; j<=4; i++){
                cardDeck.add(new Card(i,j));
                
            }
        }
           for(int k = 0; k < cardDeck.size(); k++) {   
            System.out.print(cardDeck.get(k));
           }
        }
    

     public void shuffle() {
         //shuffling cards
    Collections.shuffle(cardDeck);
  }
     public Card CardDraw(){
         Random randCard = new Random();
         //check from Deck any card
         //random index
         int cardIndex = randCard.nextInt(cardDeck.size());
         //I need to consider later which one is better
         Card drawnCard = cardDeck.get(randCard.nextInt(cardDeck.size()));
         return drawnCard;
     }
     public Card RemoveFromDeck(int a){
         //take the card away from deck from certain index
         Card taken = cardDeck.get(a);
         cardDeck.remove(taken);
         return taken;
     }
     public int deckSize(){
         return cardDeck.size();
     }
    
}
