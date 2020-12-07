package domain;

import java.util.ArrayList;
import java.util.List;
import venttigame.dao.GameResultDao;
import venttigame.domain.GameResult;

/**
 * Luokka käytössä tiedostotallennuksen testauksessa
 *
 */
public class FakeGameResultDao implements GameResultDao {

    private List<GameResult> results = new ArrayList<>();

    public FakeGameResultDao() {
        results.add(new GameResult("Possu", "voitto"));

    }

    @Override
    public List<GameResult> getAll() {
        return results;
    }

    @Override
    public List<GameResult> findByName(String name) {
        List<GameResult> filtered = new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).getName().equals(name)) {
                filtered.add(results.get(i));
            }
        }
        return filtered;
    }

    @Override
    public GameResult create(GameResult result) {
        results.add(result);
        return result;
    }
}
