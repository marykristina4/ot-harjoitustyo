package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import venttigame.dao.GameResultDao;
import venttigame.domain.GameResult;
import domain.FakeGameResultDao;
import java.io.FileWriter;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import venttigame.dao.FileGameResultDao;
/**
 * Luokka käytössä tiedostotallennuksen testauksessa
 *
 */
public class FileGameResultDaoTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    File resultFile;
    GameResultDao dao;

    @Before
    public void setUp() throws Exception {
        resultFile = testFolder.newFile("testfile_results.txt");
        GameResultDao gameResultDao = new FakeGameResultDao();
        gameResultDao.create(new GameResult("testplayer", "Ei tulosta"));

        try (FileWriter file = new FileWriter(resultFile.getAbsolutePath())) {
            file.write("testtestplayer;tulos puuttuu\n");
        }

        dao = new FileGameResultDao(resultFile.getAbsolutePath());
    }

    @Test
    public void gameResultNameAreReadCorrectlyFromFile() {
        List<GameResult> results = dao.getAll();
        assertEquals(1, results.size());
        GameResult gameResult = results.get(0);
        assertEquals("testtestplayer", gameResult.getName());
    }

    @Test
    public void gameResultResultAreReadCorrectlyFromFile() {
        List<GameResult> results = dao.getAll();
        assertEquals(1, results.size());
        GameResult gameResult = results.get(0);
        assertEquals("tulos puuttuu", gameResult.getResult());
    }

    @Test
    public void findByNameWorks() {
        List<GameResult> gameResult = dao.findByName("testtestplayer");
        assertEquals("testtestplayer", gameResult.get(0).getName());
    }

    @Test
    public void createdResultsAreListed() throws Exception {
        dao.create(new GameResult("newplayer", "no information"));
        List<GameResult> results = dao.getAll();
        assertEquals(2, results.size());
    }

    @Test
    public void createdResultsAreListedNameCorrect() throws Exception {
        dao.create(new GameResult("newplayer", "no information"));
        List<GameResult> results = dao.getAll();
        GameResult gameResult = results.get(1);
        assertEquals("newplayer", gameResult.getName());
    }

    @Test
    public void createdResultsAreListedResultCorrect() throws Exception {
        dao.create(new GameResult("newplayer", "no information"));
        List<GameResult> results = dao.getAll();
        GameResult gameResult = results.get(1);
        assertNotEquals("tulos puuttuu", gameResult.getResult());
    }

    @After
    public void tearDown() {
        resultFile.delete();
    }
}
