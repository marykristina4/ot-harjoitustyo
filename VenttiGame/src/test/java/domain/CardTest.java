package domain;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import venttigame.domain.Card;


public class CardTest {

    Card testCard;
    Card smallTestCard;

    public CardTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        testCard = new Card(13, 1);
        smallTestCard = new Card(4, 2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void cardNumberTenOrBelow() {
        testCard.modifyValues();
        assertEquals("10", Integer.toString(testCard.getNumber()));
    }

    @Test
    public void cardNumberStaysIfBelowTen() {
        testCard.modifyValues();
        assertEquals("4", Integer.toString(smallTestCard.getNumber()));
    }
     @Test
    public void cardDetailsCorrect() {
        testCard.modifyValues();
        assertEquals("Patakunkku", testCard.tostring());
    }
     @Test
    public void cardDetailsCorrectSmallCard() {
        testCard.modifyValues();
        assertEquals("Herttanelonen", smallTestCard.tostring());
    }
}
