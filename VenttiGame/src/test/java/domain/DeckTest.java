package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import venttigame.domain.Card;
import venttigame.domain.Deck;

/**
 * Luokka käytössä Deck-olioiden metodien testauksessa
 *
 */
public class DeckTest {

    Deck testDeck;

    public DeckTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        testDeck = new Deck();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void deckSizeIsCorrectAfterCreation() {
        assertEquals("52", Integer.toString(testDeck.deckSize()));
    }

    @Test
    public void deckSizeIsCorrectAfterCardDraw() {
        testDeck.cardDraw();
        assertEquals("51", Integer.toString(testDeck.deckSize()));
    }

    @Test
    public void deckSizeStaysAfterShuffle() {
        testDeck.shuffle();
        assertEquals("52", Integer.toString(testDeck.deckSize()));
    }

    @Test
    public void deckSizeAfterRemoval() {
        testDeck.cardDraw();
        Card second = testDeck.cardDraw();
        testDeck.removeFromDeck(second);
        assertEquals("50", Integer.toString(testDeck.deckSize()));
    }

    @Test
    public void deckSizecardBacktoDeck() {
        testDeck.cardDraw();
        testDeck.cardsBackToDeck();
        assertEquals("52", Integer.toString(testDeck.deckSize()));
    }
}
