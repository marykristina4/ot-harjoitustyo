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
import venttigame.dao.GameResultDao;
import venttigame.domain.GameResult;
import venttigame.domain.GameService;
import venttigame.domain.Hand;

/**
 *
 * @author marye
 */
public class GameServiceTest {

    GameService testService;
    FakeGameResultDao gameResultDao;
    Hand testHand;

    public GameServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        gameResultDao = new FakeGameResultDao();
        GameResult gameResult = new GameResult("tester", "winning");
        gameResultDao.create(gameResult);
        testService = new GameService(gameResultDao);
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
    public void listSizeWorks() {
        assertEquals("2", Integer.toString(testService.getResults().size()));
    }

    @Test
    public void creatingGameResultsAddsToList() {
        testService.createGameResult("testingplayer", "not stated");
        assertEquals("3", Integer.toString(testService.getResults().size()));
    }

    @Test
    public void findByNameResultsWorks() {
        testService.createGameResult("testingplayer", "not stated");
        GameResult testR = testService.findByName("tester").get(0);
        assertEquals("tester", testR.getName());
    }

    @Test
    public void cardDrawWorks() {
        testService.cardFromDeck(testHand);
        assertEquals("1", Integer.toString(testHand.handSize()));
    }

}
