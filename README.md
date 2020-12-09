# VenttiGame

Tämä sovellus on kehitetty kurssille Ohjelmistotekniikka syksyllä 2020. Sovelluksella voi pelata tietokonetta tai muuta vastustajaa vastaan Venttiä.
Sovelluksen voi joko kloonata omalle koneelleen tai ladata jar-tiedoston. Luethan käyttöohjeen aluksi!


## Releaset: 

[Releaset](https://github.com/marykristina4/ot-harjoitustyo/releases)

## Dokumentaatio

[Käyttöohje](https://github.com/marykristina4/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/marykristina4/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/marykristina4/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Sovelluksen toiminnallisuus](https://github.com/marykristina4/ot-harjoitustyo/blob/master/dokumentaatio/maarittely.md)

[Testausdokumentti](https://github.com/marykristina4/ot-harjoitustyo/blob/master/dokumentaatio/testaus.md)

[Tuntikirjanpito](https://github.com/marykristina4/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

## Komentorivitoiminnot

Tämän hetkisen version voi ajaa komennolla:

```
mvn compile exec:java -Dexec.mainClass=venttigame.MainGame
```
Testauksen voi suorittaa komennolla:
```
mvn test
```
Testausraportin voi ajaa komennolla: 
```
mvn test jacoco:report
```
Testausraporttia voi tarkastella osoitteesta: target/site/jacoco/index.html

### Suoritettavan jarin generointi

Jar-tiedoston voi luoda komennolla:
```
mvn package
```
Generoitu jar löytyy osoitteesta target ja on nimeltään VenttiGame-1.0-SNAPSHOT.jar 

### Javadoc

Käytössä on javadoc, ja tämän dokumentaation voi muodostaa komennolla:
```
mvn javadoc:javadoc
```
Generoitu JavaDoc löytyy hakemistosta target/site/apidocs/

### Checkstyle

Käytössä on myös tyylin ylläpidon avustamiseen checkstyle, ja halutut tyyliseikat on määritelty tiedostossa [checkstyle.xml](https://github.com/marykristina4/ot-harjoitustyo/blob/master/VenttiGame/checkstyle.xml). Tarkistuksen voi tehdä ajamalla komennon:
```
mvn jxr:jxr checkstyle:checkstyle
```
Raportti löytyy hakemistosta  target/site/checkstyle.html




