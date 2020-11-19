/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venttigame.dao;
import java.util.List;
import venttigame.domain.Player;

/**
 *
 * @author marye
 */
public interface PlayerDao {
    
    Player create(Player player) throws Exception;

    Player findByUsername(String username);

    List<Player> getAll();

}

