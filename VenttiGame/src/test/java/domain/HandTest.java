package domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import venttigame.domain.Card;
import venttigame.domain.Hand;

/**
 *
 * @author marye
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
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
