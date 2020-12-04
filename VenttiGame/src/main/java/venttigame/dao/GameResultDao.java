/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
