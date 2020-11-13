/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venttigame.domain;

import java.util.ArrayList;

/**
 *
 * @author marye
 */
public class Hand {
    public ArrayList<Card> cardHand;
    
    public Hand(){
        this.cardHand=new ArrayList<>();
    }
    
    public void addCard(Card card){
        this.cardHand.add(card);
    }
    
    public void showHand(){
        for (int i = 0; i<this.cardHand.size();i++){
            System.out.println(this.cardHand.get(i).tostring());
        }
    }
    public int handSum(){
        int sum = 0;
        for (int i = 0; i<this.cardHand.size();i++){
           sum = sum + this.cardHand.get(i).value;
    }
        return sum;
}
}
