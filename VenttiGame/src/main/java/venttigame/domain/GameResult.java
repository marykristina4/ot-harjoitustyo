/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venttigame.domain;

/**
 * Luokka, jonka olio on pelitulos.
 * Luokan metodeina pelitulosta nimen hakeminen, tuloksen hakeminen,
 * tuloksen palauttaminen string-muotoisena, sekä equal-vertailu gameResult-objekteille.
 * 
 */
public class GameResult {

    private String name;
    private String result;

    public GameResult(String name, String result) {
        this.name = name;
        this.result = result;
    }
/**
 * Metodi kertoo pelaajan nimen
 * 
 * @return Pelituloksen saaneen pelaajan nimi
 */
    public String getName() {
        return name;
    }
/**
 * Metodi kertoo pelituloksen sisällön
 * 
 * @return Pelitulos
 */
    public String getResult() {
        return result;
    }
/**
 * Metodi kertoo string-muodossa pelaajan nimen ja pelituloksen
 * 
 * @return Pelituloksen saaneen pelaajan nimi ja pelitulos
 */
    public String tostring() {
        return name + ": " + result;
    }
/**
 * Metodi hoitaa kahden GameResult-objektin vertailun
 * 
 * @param obj Vertailtava objekti
 * 
 * @return true, jos objektit ovat samat
 */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof GameResult)) {
            return false;
        }

        GameResult other = (GameResult) obj;
        return name.equals(other.name);
    }

}
