/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /**
 * Luokka on se, josta ohjelma käynnistyy
 * 
 * 
 */
package venttigame;

import java.util.Scanner;
import venttigame.domain.Deck;
import venttigame.domain.Hand;
import venttigame.ui.PlayerCommunication;
import venttigame.ui.VenttiUi;

/**
 *
 * @author marye
 */
public class MainGame {

    public static void main(String[] args) {
        //Scanner reader = new Scanner(System.in);

        //initialize new game
        //Deck gameDeck = new Deck();
        //gameDeck.shuffle();

        //Hand playerHand = new Hand();
        //Hand computerHand = new Hand();

        //PlayerCommunication playComm = new PlayerCommunication(reader, gameDeck, playerHand, computerHand);
        //playComm.start();
        VenttiUi.main(args);
    }
}
