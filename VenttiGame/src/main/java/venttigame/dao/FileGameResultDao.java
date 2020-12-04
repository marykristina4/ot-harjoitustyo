/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /**
 * Luokka hoitaa GameResultDao:n implementoinnin
 * 
 */
package venttigame.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import venttigame.domain.GameResult;

/**
 *
 * 
 */
public class FileGameResultDao implements GameResultDao {

    private List<GameResult> results;
    private String file;

    public FileGameResultDao(String file) throws Exception {
        results = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                GameResult u = new GameResult(parts[0], parts[1]);
                results.add(u);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }

    }
 /**
 * Metodi hoitaa pelituloksen kirjoittamisen tiedostoon sekä sen tallentamisen.
 * 
 * 
 */
    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (GameResult result : results) {
                writer.write(result.getName() + ";" + result.getResult() + "\n");
            }
        }
    }
 /**
 * Metodi hakee tiedostosta kaikki pelitulokset
 * 
 * @return Kaikki tallennetut pelitulokset listana
 */
    @Override
    public List<GameResult> getAll() {
        return results;
    }
 /**
 * Metodi hakee tiedostosta syötteen mukaisesti filtteröidyt pelitulokset
 * 
 * @param name Pelaaja, jonka pelitulokset haetaan ja palautetaan
 * 
 * @return Suodatetut pelitulokset listana
 */
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
 /**
 * Metodi luo tiedostoon syötteen mukaisen pelituloksen
 * 
 * @param result Pelitulos, joka tallennetaan tiedostoon
 * 
 * @return palauttaa kyseisen pelituloksen
 */
    @Override
    public GameResult create(GameResult result) throws Exception {
        results.add(result);
        save();
        return result;
    }
}
