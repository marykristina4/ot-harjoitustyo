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

/**
 *
 * @author marye
 */
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
        System.out.println(testCard.tostring());
        smallTestCard = new Card(4, 2);
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
    public void cardNumberTenOrBelow() {
        testCard.modifyValues();
        assertEquals("10", Integer.toString(testCard.getNumber()));
    }

    @Test
    public void cardNumberStaysIfBelowTen() {
        testCard.modifyValues();
        assertEquals("4", Integer.toString(smallTestCard.getNumber()));
    }
}
