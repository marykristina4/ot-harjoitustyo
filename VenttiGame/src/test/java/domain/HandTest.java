package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import venttigame.domain.Card;
import venttigame.domain.Hand;
/**
 * Luokka käytössä Hand-olioiden metodien testauksessa
 *
 */
public class HandTest {

    Hand testHand;

    public HandTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        testHand = new Hand();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void createdHandExists() {
        assertTrue(testHand != null);
    }

    @Test
    public void handIsEmptyWhenCreated() {
        assertEquals("0", Integer.toString(testHand.handSize()));
    }

    @Test
    public void addCardIncreasesSize() {
        testHand.addCard(new Card(1, 1));
        assertEquals("1", Integer.toString(testHand.handSize()));
    }

    @Test
    public void handSumCorrect() {
        testHand.addCard(new Card(1, 1));
        testHand.addCard(new Card(2, 2));
        assertEquals("3", Integer.toString(testHand.handSum()));
    }
}
