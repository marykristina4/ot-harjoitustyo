/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venttigame.ui;

import java.util.concurrent.TimeUnit;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import venttigame.domain.Card;
import venttigame.domain.Deck;
import venttigame.domain.Hand;

/**
 *
 * @author marye
 */
public class VenttiUi extends Application {

    private Deck gameDeck;
    private Hand playerHand;
    private Hand computerHand;
    private String playerName;
    private String gameResult;

    @Override
    public void init() {
        gameDeck = new Deck();
        gameDeck.shuffle();

        playerHand = new Hand();
        computerHand = new Hand();
    }

    @Override
    public void start(Stage window) {
        BorderPane setUp = new BorderPane();
        Label text = new Label("Peliohjeet");
        Button instructions = new Button("Paina tästä nähdäksesi ohjeet");
        Label emptyText = new Label("");
        Button gameStart = new Button("Jaa aloituskortit");
        Label gameStatus = new Label("Jaa aloituskortit aloittaaksesi pelin");
        Button testButton = new Button("testaus");

        Button playerButton = new Button("Pelaajalle kortti");
        Label playerStart = new Label("Pelaajan aloituskortit");
        Label playerStartCards = new Label();
        playerStartCards.setTextFill(Color.web("#0068a3"));
        playerStartCards.setWrapText(true);
        Label playerTextSum = new Label("Pelaajan korttien summa");
        Label playerSum = new Label();
        playerSum.setTextFill(Color.web("#0068a3"));
        Label playerCard = new Label("Pelaajan uusi kortti");
        Label playerNewCard = new Label();
        playerNewCard.setTextFill(Color.web("#00a32d"));

        Button compButton = new Button("Tietokoneelle kortti");
        Label compStart = new Label("Tietokoneen aloituskortit");
        Label compStartCards = new Label();
        compStartCards.setTextFill(Color.web("#a30076"));
        compStartCards.setWrapText(true);
        Label compTextSum = new Label("Tietokoneen korttien summa");
        Label compSum = new Label();
        compSum.setTextFill(Color.web("#a30076"));
        Label compCard = new Label("Tietokoneen uusi kortti");
        Label compNewCard = new Label();
        compNewCard.setTextFill(Color.web("#a30025"));

        Label textName = new Label("Kirjaa nimesi jos haluat tallentaa pelituloksen");
        TextField nameField = new TextField();
        nameField.setPromptText("Nimesi");
        Button save = new Button("Tallenna nimesi");

        //game events
        gameStart.setOnAction((event) -> {
            gameDeck.shuffle();
            Card firstToPlayer = gameDeck.cardDraw();
            playerHand.addCard(firstToPlayer);
            gameDeck.shuffle();
            gameStatus.setText("Peli kesken");
            Card secondToPlayer = gameDeck.cardDraw();
            playerHand.addCard(secondToPlayer);
            playerStartCards.setText(firstToPlayer.tostring() + " ja " + secondToPlayer.tostring());

            playerSum.setText(Integer.toString(playerHand.handSum()));

            gameDeck.shuffle();
            Card firstToComp = gameDeck.cardDraw();
            computerHand.addCard(firstToComp);
            gameDeck.shuffle();
            Card secondToComp = gameDeck.cardDraw();
            computerHand.addCard(secondToComp);
            compStartCards.setText(firstToComp.tostring() + " ja " + secondToComp.tostring());

            compSum.setText(Integer.toString(computerHand.handSum()));
        });
        playerButton.setOnAction((event) -> {
            gameDeck.shuffle();
            Card toPlayer = gameDeck.cardDraw();
            playerNewCard.setText(toPlayer.tostring());
            playerHand.addCard(toPlayer);
            playerSum.setText(Integer.toString(playerHand.handSum()));
            if (playerHand.handSum() == 21) {
                gameStatus.setTextFill(Color.web("#52af52"));
                gameStatus.setText("Voitto pelaajalle!");
                gameStatus.setFont(Font.font("Cambria", 32));
                gameResult = "Voitto";
            } else if (playerHand.handSum() >= 21) {
                gameStatus.setTextFill(Color.web("#fe2e2e"));
                gameStatus.setText("Game Over!");
                gameStatus.setFont(Font.font("Cambria", 32));
                gameStatus.setRotate(305);
                gameResult = "Häviö";
            }

        });
        compButton.setOnAction((event) -> {
            gameDeck.shuffle();
            Card toComp = gameDeck.cardDraw();
            compNewCard.setText(toComp.tostring());
            computerHand.addCard(toComp);
            compSum.setText(Integer.toString(computerHand.handSum()));

            if (computerHand.handSum() == 21) {
                gameStatus.setTextFill(Color.web("#fe2e2e"));
                gameStatus.setText("Game Over!");
                gameStatus.setFont(Font.font("Cambria", 32));
                gameStatus.setRotate(305);
                gameResult = "Häviö";
            } else if (computerHand.handSum() >= 21) {
                gameStatus.setTextFill(Color.web("#52af52"));
                gameStatus.setText("Voitto pelaajalle!");
                gameStatus.setFont(Font.font("Cambria", 32));
                gameResult = "Voitto";
            } else if (computerHand.handSum() > playerHand.handSum()) {
                gameStatus.setTextFill(Color.web("#fe2e2e"));
                gameStatus.setText("Game Over!");
                gameStatus.setFont(Font.font("Cambria", 32));
                gameStatus.setRotate(305);
                gameResult = "Häviö";
            } else if (computerHand.handSum() == playerHand.handSum()) {
                gameStatus.setTextFill(Color.web("#008080"));
                gameStatus.setText("Tasapeli!");
                gameStatus.setFont(Font.font("Cambria", 32));
                gameResult = "Tasapeli";
            }

        });
        testButton.setOnAction((event) -> {
            //onko mahdollista saada uusi peli alusta nappia painamalla?
        });
        Label playerSpace = new Label("PELAAJA");

        Label compSpace = new Label("TIETOKONE");

        VBox toLeft = new VBox();
        toLeft.setSpacing(20);
        toLeft.getChildren().add(compSpace);
        toLeft.getChildren().add(compStart);
        toLeft.getChildren().add(compStartCards);
        toLeft.getChildren().add(compCard);
        toLeft.getChildren().add(compNewCard);
        toLeft.getChildren().add(compTextSum);
        toLeft.getChildren().add(compSum);
        toLeft.getChildren().add(compButton);

        VBox toRight = new VBox();
        toRight.setSpacing(20);
        toRight.getChildren().add(playerSpace);
        toRight.getChildren().add(playerStart);
        toRight.getChildren().add(playerStartCards);
        toRight.getChildren().add(playerCard);
        toRight.getChildren().add(playerNewCard);
        toRight.getChildren().add(playerTextSum);
        toRight.getChildren().add(playerSum);
        toRight.getChildren().add(playerButton);

        HBox toTop = new HBox();
        toTop.setSpacing(50);
        toTop.getChildren().add(text);
        toTop.getChildren().add(instructions);
        toTop.getChildren().add(emptyText);
        toTop.getChildren().add(gameStatus);
        //toTop.getChildren().add(emptyText);

        HBox toBottom = new HBox();
        toBottom.setSpacing(30);
        toBottom.getChildren().add(textName);
        toBottom.getChildren().add(nameField);
        toBottom.getChildren().add(save);

        VBox toCenter = new VBox();
        toCenter.setSpacing(10);
        toCenter.getChildren().add(testButton);
        toCenter.getChildren().add(gameStart);
        toCenter.getChildren().add(gameStatus);

        setUp.setTop(toTop);
        setUp.setBottom(toBottom);
        setUp.setLeft(toLeft);
        setUp.setRight(toRight);
        setUp.setCenter(toCenter);

        Scene mainView = new Scene(setUp);

        //toka näkymä
        Button toGame = new Button("Paina tästä palataksesi peliin");
        Label instructionText = new Label(TextToInstruct);

        VBox instrSet = new VBox();
        instrSet.setSpacing(30);
        instrSet.getChildren().add(instructionText);
        instrSet.getChildren().add(toGame);

        Scene instructionView = new Scene(instrSet);

        //scene events
        instructions.setOnAction((event) -> {
            window.setScene(instructionView);
        });
        toGame.setOnAction((event) -> {
            window.setScene(mainView);
        });

        //nimen tallennus
        save.setOnAction((ActionEvent e) -> {
            if ((nameField.getText() != null && !nameField.getText().isEmpty())) {
                playerName = nameField.getText();
            }
            //tässä pitäisi käyttää pelitulosta ja saatua nimeä ja tallentaa johonkin
        });
        window.setTitle("Venttipeli");
        window.setScene(mainView);
        window.show();
    }
    private static final String TextToInstruct
            = "Aloita peli - pelaajalle ja tietokoneelle jaetaan 2 korttia\n"
            + "Pelaajalle lisäkortti - Jos summa yli 21, pelaaja häviää. Jos alle, \n"
            + "vielä mukana pelissä ja edelleen pelaajan vuoro ja voi päättää ottaako uuden kortin\n"
            + "Tietokoneelle lisäkortti - Jos summa yli 21, pelaaja voittaa. Jos summa\n"
            + "vähemmän kun pelaajalla, tietokoneelle uusi kortti valitsemalla uudelleen 3. Jos summa\n"
            + " tasan 21, tietokone voittaa. Jos summa sama kun pelaajalla, tasapeli.";

    public static void main(String[] args) {
        launch(VenttiUi.class);
    }
}
