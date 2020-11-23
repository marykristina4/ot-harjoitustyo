# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovellus on peli nimeltä Ventti, jota yksi pelaaja voi pelata kerrallaan tietokonetta vastaan. Sovelluksen toiminta
mukailee korttipeliä Ventti, joka on suomalainen vastine BlackJackille (Tämä osuus toteutettu 20.11.2020). Pelaaja
 pystyy rekisteröitymään ja tallentamaan pelituloksensa.

## Käyttäjät

Sovelluksella on vain peruskäyttäjiä, eli pelaajia, jotka voivat omalla nimellään kirjautua ja tallentaa
pelituloksiaan.

## Käyttöliittymäluonnos

Kun sovellus käynnistyy tulee esiin rekisteröitymis/kirjautumisruutu. Kun pelaaja rekisteröityy muodostetaan hänelle
oma käyttäjätunnus. Kun rekisteröityminen on tehty palataan kirjautumisruutuun. Salasanaa ei tarvitse. Kun pelaaja
kirjautuu aukeaa hänelle pelinäkymä. Pelinäkymän suunnittelu on vielä kesken, mutta siinä pelaaja pystyy pelaamaan
venttiä ja hän voi tallentaa pelituloksensa. Halutessaan pelaaja voi ajaa raportin, josta näkee aiempia pelituloksia. 
(Teksikäyttöliittymä tehty 23.11.2020. Pelin pelaaminen toimii suunnitellusti, käyttäjiä ei voi vielä tallentaa
eikä pelituloksia.)

## Perusversion tarjoama toiminnallisuus

Perusversiossa toimii vain yksinpeli. Aloituskortit jaetaan. Tämän jälkeen pelaaja saa päättää kortti kerrallaan
ottaako hän vielä uuden kortin. Jos pelaaja ottaa kortin niin että korttien arvojen summa menee yli 21:n, tietokone
voittaa. Jos pelaaja saavuttaa tilanteen, jossa hänen korttiensa summa on tasan 21, hän voittaa suoraan. Jos pelaaja
ei enää ota uutta korttia niin että hänen korttiensa summa on alle 21, on tietokoneen vuoro. Tietokone ottaa aina
uuden kortin jos sen korttien summa on alle pelaajan korttien summan. Siis, jos tietokone saa summan joka on 21, se
voittaa. Jos tietokone saa summan joka on suurempi kun pelaajalla, mutta kuitenkin alle 21, se voittaa. Tietokone
häviää jos sen korttien summa on yli 21 (Tämä toteutettu 20.11.2020, lisäksi lisätty mahdollisuus tasapeliin). 

### Ennen kirjautumista

- Pelaajan tulee luoda käyttäjätunnus jolla hän voi kirjautua. Käyttäjätunnus ei saa olla jo aiemmin olemassa.

### Kirjautumisen jälkeen

- Pelaaja voi käynnistää uuden pelin tai tarkkailla aiempia tilastojaan. (Uusi peli käynnistyy ajamalla komento
 mvn compile exec:java -Dexec.mainClass=venttigame.MainGame, tehty 20.11.2020 ja testattu 23.11.2020)
- Pelaaja voi kirjautua ulos järjestelmästä.

## Jatkokehitysideoita	

Jos aikaa on, voi pelistä tehdä myös moninpeliversion, jossa tietokonetta vastaan voi olla samaan aikaan pelaamassa
useampi pelaaja. Tällöin heidän tulee muodostaa uusi käyttäjätunnus, ryhmätunnus, jolla voi kirjautua. Pelaajat
voidaan liittää eri ryhmiin eli ryhmää muodostettaessa kysytään ryhmään kuuluvien pelaajien käyttäjätunnukset.
Lisäksi perusversion graaginen käyttöliittymä tulee olemaan oletettavasti melko alkeellinen, myös sitä voi jatkossa
kehittää hienompaan suuntaan.
