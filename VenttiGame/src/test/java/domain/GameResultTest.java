/*
 *
 */
package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import venttigame.domain.GameResult;
/**
 * Luokka käytössä GameResult-olioiden metodien testauksessa
 *
 */

public class GameResultTest {
    GameResult testResult;
    GameResult testNotResult;
    
    public GameResultTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testResult = new GameResult("testplayer", "testresult");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void stringIsCorrect(){
        assertEquals("testplayer: testresult", testResult.tostring());
    }
    @Test
    public void GameResultComparisonWorks(){
        assertTrue(testResult.equals(testResult));
    }
    @Test
    public void GameResultComparisonWorksIfNotEqual(){
        assertTrue(!testResult.equals(testNotResult));
    }
}
