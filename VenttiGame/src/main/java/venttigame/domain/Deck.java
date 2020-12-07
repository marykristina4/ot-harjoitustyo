package venttigame.domain;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Luokka Deck tarjoaa korttipakan, jossa 52 korttia. Lisäksi Deck tarjoaa
 * metodit korttipakan sekoittamiseen, kortin nostamiseen pakasta, kortin
 * poistamiseen pakasta sekä korttipakan korttien lukumäärän tarkastamiseen.
 *
 *
 */
public class Deck {

    public ArrayList<Card> cardDeck;
    public ArrayList<Card> removedCards;

    public Deck() {
        this.cardDeck = new ArrayList<>();
        this.removedCards = new ArrayList<>();

        for (int i = 1; i <= 13; i++) {
            for (int j = 1; j <= 4; j++) {
                this.cardDeck.add(new Card(i, j));
            }
        }

        for (int k = 0; k < this.cardDeck.size(); k++) {
            this.cardDeck.get(k).modifyValues();
        }
    }

    /**
     * Metodi korttipakan sekoittamiseksi. Korttien määrä ei muutu.
     *
     */
    public void shuffle() {
        Collections.shuffle(cardDeck);
    }

    /**
     * Metodi kortin nostamiseksi korttipakasta. Kutsuu metodia, joka poistaa
     * pakasta kortin.
     *
     * @return nostettu kortin
     */
    public Card cardDraw() {
        Card drawnCard = this.cardDeck.get(cardDeck.size() - 1);
        removedCards.add(drawnCard);
        removeFromDeck(drawnCard);
        return drawnCard;

    }

    /**
     * Metodi kortin nostamiseksi korttipakasta.
     *
     * @param card Kortti, joka poistetaan pakasta
     *
     */
    public void removeFromDeck(Card card) {
        this.cardDeck.remove(card);
    }

    /**
     * Metodi korttipakan koon tarkistamiseksi.
     *
     * @return korttipakan koko eli siellä olevien korttien lukumäärä
     *
     */
    public int deckSize() {
        return cardDeck.size();
    }

    public void cardsBackToDeck() {

        for (int i = 0; i < removedCards.size(); i++) {
            Card cardToAdd = removedCards.get(i);
            cardDeck.add(cardToAdd);

        }
        removedCards.clear();
    }
}
