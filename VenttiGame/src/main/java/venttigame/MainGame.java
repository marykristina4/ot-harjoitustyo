/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venttigame;

import java.util.Scanner;
import venttigame.domain.Deck;
import venttigame.domain.Hand;

/**
 *
 * @author marye
 */
public class MainGame {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        //Numerotiedustelu numerotiedustelu = new Numerotiedustelu(lukija);
        //numerotiedustelu.kaynnista();
        
        //initialize new game
        Deck gameDeck = new Deck();
        gameDeck.shuffle();
        
        Hand playerHand = new Hand();
        Hand computerHand = new Hand();
        
        //game starts: deal two cards to both hands
        
    }
}
