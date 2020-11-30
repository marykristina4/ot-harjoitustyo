/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venttigame.ui;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import venttigame.domain.Card;
import venttigame.domain.Deck;
import venttigame.domain.Hand;

/**
 *
 * @author marye
 */
public class PlayerCommunication {

    private Scanner reader;
    private Deck gameDeck;
    private Hand playerHand;
    private Hand computerHand;
    private TreeMap<String, String> command;

    public PlayerCommunication(Scanner reader, Deck gameDeck, Hand playerHand, Hand computerHand) {
        this.reader = reader;
        this.gameDeck = gameDeck;
        this.playerHand = playerHand;
        this.computerHand = computerHand;
        command = new TreeMap<>();

        command.put("x", "x lopeta");
        command.put("1", "1 lisää aloita peli");
        command.put("2", "2 pelaajalle kortti");
        command.put("3", "3 tietokoneelle kortti");
        command.put("4", "4 katso tilastoja (ei vielä käytössä");
    }

    public void start() {
        System.out.println("Tervetuloa pelaamaan Venttiä");
        printInstructions();
        while (true) {
            System.out.println();
            System.out.println("Komentosi: ");
            String playerAction = reader.nextLine();
            if (!command.keySet().contains(playerAction)) {
                System.out.println("virheellinen komento.");
                printInstructions();
            }
            if (playerAction.equals("x")) {
                break;
            } else if (playerAction.equals("1")) {
                System.out.println("Tässä alkaa peli:");
                gameStarts();
            } else if (playerAction.equals("2")) {
                System.out.println("Tässä pelaajalle kortti:");
                cardToPlayer();
            } else if (playerAction.equals("3")) {
                System.out.println("Tässä tietokoneelle vuoro");
                cardToComputer();
            } else if (playerAction.equals("4")) {
                System.out.println("Tässä näytetään tilastoja tietokannasta");
            }

        }
    }

    public void printInstructions() {
        System.out.println("Komennot alla:");
        System.out.println("1: Aloita peli - pelaajalle ja tietokoneelle jaetaan 2 korttia");
        System.out.println("2: Pelaajalle lisäkortti - Jos summa yli 21, pelaaja häviää. Jos alle, "
                + "vielä mukana pelissä ja edelleen pelaajan vuoro ja voi päättää ottaako uuden kortin");
        System.out.println("3: Tietokoneelle lisäkortti - Jos summa yli 21, pelaaja voittaa. Jos summa"
                + "vähemmän kun pelaajalla, tietokoneelle uusi kortti valitsemalla uudelleen 3. Jos summa"
                + " tasan 21, tietokone voittaa. Jos summa sama kun pelaajalla, tasapeli");
        System.out.println("4: katso aiempia tuloksia (ei vielä käytössä");
        System.out.println("x: lopeta peli");
    }

    public void roundForBoth() {
        gameDeck.shuffle();
        Card firstToPlayer = gameDeck.cardDraw();
        System.out.println("Pelaajan kortti: " + firstToPlayer.tostring());
        playerHand.addCard(firstToPlayer);
        System.out.println("Pelaajan korttien summa: " + playerHand.handSum());
        System.out.println("");
        //TimeUnit.SECONDS.sleep(1);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
        }
        gameDeck.shuffle();
        Card firstToComputer = gameDeck.cardDraw();
        System.out.println("Tietokoneen kortti: " + firstToComputer.tostring());
        computerHand.addCard(firstToComputer);
        System.out.println("Tietokoneen korttien summa: " + computerHand.handSum());
        System.out.println("");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
        }
    }

    public void gameStarts() {
        roundForBoth();
        roundForBoth();

    }

    public void cardToPlayer() {
        gameDeck.shuffle();
        Card toPlayer = gameDeck.cardDraw();
        System.out.println("Pelaajan kortti: " + toPlayer.tostring());
        playerHand.addCard(toPlayer);
        System.out.println("Pelaajalle nyt kortit: ");
        //playerHand.showHand();
        System.out.println("");
        System.out.println("Korttien summa: " + playerHand.handSum());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
        }
        if (playerHand.handSum() == 21) {
            System.out.println("Voitit!");
            System.out.println("Paina x ja aloita uudestaan");
        } else if (playerHand.handSum() >= 21) {
            System.out.println("Hävisit!");
            System.out.println("Paina x ja aloita uudestaan");
        }
    }

    public void cardToComputer() {
        //this happens until computer wins or looses
        gameDeck.shuffle();
        Card toComputer = gameDeck.cardDraw();
        System.out.println("Tietokoneen kortti: " + toComputer.tostring());
        computerHand.addCard(toComputer);
        System.out.println("Tietokoneella nyt kortit: ");
        //computerHand.showHand();
        System.out.println("");
        System.out.println("Korttien summa: " + computerHand.handSum());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
        }
        if (computerHand.handSum() == 21) {
            System.out.println("Tietokone voitti sinä hävisit!");
            System.out.println("Paina x ja aloita uudestaan");
        } else if (computerHand.handSum() >= 21) {
            System.out.println("Tietokone hävisi, sinä voitit!");
            System.out.println("Paina x ja aloita uudestaan");
        } else if (computerHand.handSum() > playerHand.handSum()) {
            System.out.println("Tietokone voitti, sinä hävisit!");
            System.out.println("Paina x ja aloita uudestaan");
        } else if (computerHand.handSum() == playerHand.handSum()) {
            System.out.println("Tasapeli!");
            System.out.println("Paina x ja aloita uudestaan");
        }

    }
}
