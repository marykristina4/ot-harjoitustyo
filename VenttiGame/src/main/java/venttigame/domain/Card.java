/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venttigame.domain;

/**
 *
 * @author marye
 */
public class Card {
    int value;
    int suit;
    
    public Card(int value, int suit){
        this.value=value;
        this.suit=suit;
    }
    public String tostring(){
        String cardDetails ="";
          if (value == 1) cardDetails = "Ace";
    if (value == 2) cardDetails = "Two";
    if (value == 3) cardDetails = "Three";
    if (value == 4) cardDetails = "Four";
    if (value == 5) cardDetails = "Five";
    if (value == 6) cardDetails = "Six";
    if (value == 7) cardDetails = "Seven";
    if (value == 8) cardDetails = "Eight";
    if (value == 9) cardDetails = "Nine";
    if (value == 10) cardDetails = "Ten";
    if (value == 11) cardDetails = "Jack";
    if (value == 12) cardDetails = "Queen";
    if (value == 13) cardDetails = "King";
    
    if (suit == 1) cardDetails = cardDetails + " of Clubs ";
    if (suit == 2) cardDetails = cardDetails + " of Diamonds ";
    if (suit == 3) cardDetails = cardDetails + " of Hearts ";
    if (suit == 4) cardDetails = cardDetails + " of Spades ";
    
    return cardDetails;
    }
}
