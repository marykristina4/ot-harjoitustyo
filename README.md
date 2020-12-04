# Ohjelmistotekniikka, harjoitustyö: VenttiGame

Sovelluksella voi pelata tietokonetta tai muuta vastustajaa vastaan Venttiä. Sovellus on vielä kehityksen alla. Päivitykset kehitystyössä 
julkaistaan tässä repositoriossa. Suunniteltu aikataulu sovelluksen valmistumiselle on Helsingin yliopiston periodin 2 loppu
vuonna 2020. Tämän suunnitelman mukaan sovellus on siis pelattavissa joulukuun puolivälissä 2020.


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

Checkstyles-raportin voi ajaa komennolla: 
```
mvn jxr:jxr checkstyle:checkstyle
```
Checkstyles-raporttia voi tarkastella osoitteesta: target/site/checkstyle.html

## UUSI RELEASE: 

[Release vk5](https://github.com/marykristina4/ot-harjoitustyo/releases/tag/viikko5)

## Dokumentaatio
[Tuntikirjanpito](https://github.com/marykristina4/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Vaatimusmäärittely](https://github.com/marykristina4/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/marykristina4/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)




