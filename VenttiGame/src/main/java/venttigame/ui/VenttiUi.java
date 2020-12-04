/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /**
 * Luokka hoitaa käyttöliittymän toiminnallisuudet.
 * 
 * 
 */
package venttigame.ui;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import venttigame.dao.FileGameResultDao;
import venttigame.domain.GameResult;
import venttigame.domain.GameService;
import venttigame.domain.Hand;

/**
 *
 * @author marye
 */
public class VenttiUi extends Application {

    private String playerName;
    private String searchName;
    private String gameResult;
    private GameService gameService;
    private Hand playerHand;
    private Hand computerHand;

    @Override
    public void init() throws Exception {

        Properties properties = new Properties();

        properties.load(new FileInputStream("config.properties"));

        String gameFile = properties.getProperty("gameFile");

        FileGameResultDao gameResultDao = new FileGameResultDao(gameFile);

        gameService = new GameService(gameResultDao);
        playerHand = new Hand();
        computerHand = new Hand();
    }

    @Override
    public void start(Stage window) {
        BorderPane setUp = new BorderPane();
        Label text = new Label("Peliohjeet");
        Button instructions = new Button("Paina tästä nähdäksesi ohjeet");
        instructions.setStyle("-fx-background-color: #df99d8; ");
        Label emptyText = new Label("");
        Button gameStart = new Button("Jaa aloituskortit");
        gameStart.setStyle("-fx-border-color: #010b0d; ");
        gameStart.setStyle("-fx-background-color: #69c4d2; ");
        Label gameStatus = new Label("Jaa aloituskortit aloittaaksesi pelin");
        Button resultButton = new Button("Katso pelituloksia");

        Button playerButton = new Button("Pelaajalle kortti");
        playerButton.setDisable(true);
        playerButton.setStyle("-fx-border-color: #e5a35f; ");
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

        Button compButton = new Button("Pelaaja lopettaa, vastustajalle kortti");
        compButton.setDisable(true);
        compButton.setStyle("-fx-border-color: #e5a35f; ");
        Label compStart = new Label("Vastustajan aloituskortit");
        Label compStartCards = new Label();
        compStartCards.setTextFill(Color.web("#a30076"));
        compStartCards.setWrapText(true);
        Label compTextSum = new Label("Vastustajan korttien summa");
        Label compSum = new Label();
        compSum.setTextFill(Color.web("#a30076"));
        Label compCard = new Label("Vastustajan uusi kortti");
        Label compNewCard = new Label();
        compNewCard.setTextFill(Color.web("#a30025"));

        Label textName = new Label("Kirjaa nimesi pelin päätyttyä jos haluat tallentaa pelituloksen");
        TextField nameField = new TextField();
        nameField.setPromptText("Nimesi");
        Button save = new Button("Tallenna nimesi");
        Label saved = new Label("Tulosta ei tallennettu");
        save.setDisable(true);
        nameField.setDisable(true);

        //game events
        gameStart.setOnAction((event) -> {
            gameStatus.setText("Peli kesken");
            playerButton.setDisable(false);
            compButton.setDisable(false);
            playerStartCards.setText(gameService.cardFromDeck(playerHand) + " ja " + gameService.cardFromDeck(playerHand));
            playerSum.setText(Integer.toString(playerHand.handSum()));
            compStartCards.setText(gameService.cardFromDeck(computerHand) + " ja " + gameService.cardFromDeck(computerHand));
            compSum.setText(Integer.toString(computerHand.handSum()));
        });
        playerButton.setOnAction((event) -> {
            playerNewCard.setText(gameService.cardFromDeck(playerHand));
            playerSum.setText(Integer.toString(playerHand.handSum()));
            if (playerHand.handSum() == 21) {
                gameStatus.setTextFill(Color.web("#52af52"));
                gameStatus.setText("Voitto pelaajalle!");
                gameStatus.setFont(Font.font("Cambria", 32));
                gameResult = "Voitto";
                playerButton.setDisable(true);
                compButton.setDisable(true);
                gameStart.setDisable(true);
                save.setDisable(false);
                saved.setDisable(true);
                nameField.setDisable(false);
            } else if (playerHand.handSum() >= 21) {
                gameStatus.setTextFill(Color.web("#fe2e2e"));
                gameStatus.setText("Game Over!");
                gameStatus.setFont(Font.font("Cambria", 32));
                gameStatus.setRotate(305);
                gameResult = "Häviö";
                playerButton.setDisable(true);
                compButton.setDisable(true);
                gameStart.setDisable(true);
                save.setDisable(false);
                saved.setDisable(true);
                nameField.setDisable(false);
            }

        });
        compButton.setOnAction((event) -> {
            playerButton.setDisable(true);
            compNewCard.setText(gameService.cardFromDeck(computerHand));
            compSum.setText(Integer.toString(computerHand.handSum()));
            compButton.setText("Vastustajalle kortti");

            if (computerHand.handSum() == 21) {
                gameStatus.setTextFill(Color.web("#fe2e2e"));
                gameStatus.setText("Game Over!");
                gameStatus.setFont(Font.font("Cambria", 32));
                gameStatus.setRotate(305);
                gameResult = "Häviö";
                playerButton.setDisable(true);
                compButton.setDisable(true);
                gameStart.setDisable(true);
                save.setDisable(false);
                saved.setDisable(true);
                nameField.setDisable(false);
            } else if (computerHand.handSum() >= 21) {
                gameStatus.setTextFill(Color.web("#52af52"));
                gameStatus.setText("Voitto pelaajalle!");
                gameStatus.setFont(Font.font("Cambria", 32));
                gameResult = "Voitto";
                playerButton.setDisable(true);
                compButton.setDisable(true);
                gameStart.setDisable(true);
                save.setDisable(false);
                saved.setDisable(true);
                nameField.setDisable(false);
            } else if (computerHand.handSum() > playerHand.handSum()) {
                gameStatus.setTextFill(Color.web("#fe2e2e"));
                gameStatus.setText("Game Over!");
                gameStatus.setFont(Font.font("Cambria", 32));
                gameStatus.setRotate(305);
                gameResult = "Häviö";
                playerButton.setDisable(true);
                compButton.setDisable(true);
                gameStart.setDisable(true);
                save.setDisable(false);
                saved.setDisable(true);
                nameField.setDisable(false);
            } else if (computerHand.handSum() == playerHand.handSum()) {
                gameStatus.setTextFill(Color.web("#008080"));
                gameStatus.setText("Tasapeli!");
                gameStatus.setFont(Font.font("Cambria", 32));
                gameResult = "Tasapeli";
                playerButton.setDisable(true);
                compButton.setDisable(true);
                gameStart.setDisable(true);
                save.setDisable(false);
                saved.setDisable(true);
                nameField.setDisable(false);
            }

        });

        Label playerSpace = new Label("PELAAJA");

        Label compSpace = new Label("VASTUSTAJA");

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

        HBox toBottom = new HBox();
        toBottom.setSpacing(30);
        toBottom.getChildren().add(textName);
        toBottom.getChildren().add(nameField);
        toBottom.getChildren().add(save);
        toBottom.getChildren().add(saved);

        VBox toCenter = new VBox();
        toCenter.setSpacing(10);
        toCenter.getChildren().add(resultButton);
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

        //tulosnäkymä
        Button backToGame = new Button("Paina tästä palataksesi peliin");
        Button showResults = new Button("Näytä kaikki tulokset");
        Button showFilteredResults = new Button("Näytä valitsemasi pelaajan tulokset");
        TextField searchField = new TextField();
        searchField.setPromptText("Kirjoita pelaaja");
        Label resultText = new Label();
        ListView<String> list = new ListView<>();
        //napin painalluksella tietyn pelaajan tulokset
        showFilteredResults.setOnAction((ActionEvent e) -> {
            if ((searchField.getText() != null && !searchField.getText().isEmpty())) {
                searchName = searchField.getText();
            }
            List<GameResult> listSearchResults = gameService.findByName(searchName);

            ObservableList<String> items = FXCollections.observableArrayList();
            for (int i = 0; i < listSearchResults.size(); i++) {
                String a = listSearchResults.get(i).tostring();
                items.add(a);
            }
            list.setItems(items);
        });
        //napin painalluksella tulokset
        showResults.setOnAction((event) -> {

            resultText.setText("Kaikki pelitulokset:");
            List<GameResult> listResults = gameService.getResults();
            ObservableList<String> items = FXCollections.observableArrayList();
            for (int i = 0; i < listResults.size(); i++) {
                String a = listResults.get(i).tostring();
                items.add(a);
            }
            list.setItems(items);
        });
        VBox resultSet = new VBox();
        resultSet.setSpacing(30);
        resultSet.getChildren().add(backToGame);
        resultSet.getChildren().add(showResults);
        resultSet.getChildren().add(resultText);
        resultSet.getChildren().add(searchField);
        resultSet.getChildren().add(showFilteredResults);
        resultSet.getChildren().add(list);

        Scene resultView = new Scene(resultSet);

        //scene events
        instructions.setOnAction((event) -> {
            window.setScene(instructionView);
        });
        toGame.setOnAction((event) -> {
            window.setScene(mainView);
        });
        resultButton.setOnAction((event) -> {
            window.setScene(resultView);
        });
        backToGame.setOnAction((event) -> {
            list.getItems().clear();
            window.setScene(mainView);
        });

        //nimen tallennus
        save.setOnAction((ActionEvent e) -> {
            if ((nameField.getText() != null && !nameField.getText().isEmpty())) {
                playerName = nameField.getText();
            }
            //tässä pitäisi käyttää pelitulosta ja saatua nimeä ja tallentaa johonkin
            gameService.createGameResult(playerName, gameResult);
            saved.setText("Tulos tallennettu");
            saved.setTextFill(Color.web("#a5043d"));
            nameField.setDisable(true);
            save.setDisable(true);
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
