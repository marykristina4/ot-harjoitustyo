/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author marye
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
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
