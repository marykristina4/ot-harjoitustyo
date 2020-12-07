
package venttigame.domain;

import java.util.List;
import java.util.stream.Collectors;
import venttigame.dao.GameResultDao;

/**
 * Luokka, joka hoitaa tiedonvälityksen ja vastaanottamisen tallennuksen suuntaan
 * Sisältää metodit tulosten tallentamiseen, niiden hakemiseen tiedostosta sekä
 * niiden hakemiseen tietylle pelaajanimelle
 */
public class GameService {

    private GameResultDao gameResultDao;
    private Deck gameDeck;

    public GameService(GameResultDao gameResultDao) {
        this.gameResultDao = gameResultDao;
        gameDeck = new Deck();
        gameDeck.shuffle();

    }

 /**
 * Metodi luo tiedostoon uuden pelituloksen
 * @param name Pelaajanimi, jonka pelaaja syöttänyt käyttöliittymässä
 * @param result Pelitulos, johon pelaaja on pelissään päätynyt
 * 
 * @return true jos virhettä ei tapahdu
 */
    public boolean createGameResult(String name, String result) {
        GameResult gameResult = new GameResult(name, result);
        try {
            gameResultDao.create(gameResult);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

 /**
 * Metodi hakee tiedostosta kaikki pelitulokset
 * 
 * @return Kaikki tallennetut pelitulokset listana
 */
    public List<GameResult> getResults() {

        return gameResultDao.getAll()
                .stream()
                .collect(Collectors.toList());
    }
 /**
 * Metodi hakee tiedostosta pelitulokset syötteen mukaiselle pelaajalle
 * 
 * @param name Pelaaja, jonka tulokset haetaan
 * 
 * @return Kyseisen pelaajan tallennetut pelitulokset listana
 */
    public List<GameResult> findByName(String name) {

        return gameResultDao.findByName(name)
                .stream()
                .collect(Collectors.toList());
    }
 /**
 * Metodi hoitaa kortin nostamisen pakasta, sen poistamisen pakasta
 * sekä kortin laittamisen syötteenä saatuun käteen
 * 
 * @param hand Käsi, johon nostettu kortti laitetaan 
 * 
 * @return Nostettu kortti string-muodossa
 */
    public String cardFromDeck(Hand hand) {
        gameDeck.shuffle();
        Card drawnCard = gameDeck.cardDraw();
        hand.addCard(drawnCard);
        return drawnCard.tostring();
    }
    public void restartGame() {
        gameDeck.cardsBackToDeck();
    }
}
