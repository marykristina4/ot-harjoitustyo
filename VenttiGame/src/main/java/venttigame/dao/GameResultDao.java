
package venttigame.dao;

import java.util.List;
import venttigame.domain.GameResult;

/**
 * Luokka, jonka FileGameResultDao implementoi.
 * 
 * Sisältää metodit pelitulosten luomiseen tiedostoon
 * ja tiedostosta hakemiseen
 * 
 */
public interface GameResultDao {

    GameResult create(GameResult result) throws Exception;

    List<GameResult> findByName(String name);

    List<GameResult> getAll();

}
