# Käyttöohje

Lataa tiedosto [VenttiGame.jar](https://github.com/marykristina4/ot-harjoitustyo/releases/tag/viikko5)

## Konfigurointi

Jotta ohjelman voi suorittaa, tulee hakemistossa, jossa se suoritetaan olla konfiguraatiotiedosto config.properties,
jossa määritellään tiedoston nimi, johon pelitulokset tallennetaan. Tiedosto on muodoltaan seuraavanalainen:

```
gameFile=results.txt
```

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla 

```
java -jar VenttiGame.jar
```
tai ajamalla komentoriviltä kansiossa VenttiGame:

```
 mvn compile exec:java -Dexec.mainClass=venttigame.MainGame
```
## Pelin käynnistäminen

Kun peli käynnistetään, avautuu pelinäkymä

--tähän myöhemmin kuva <img src="">

## Peliohjeet

Jos peli ei ole ennaltaan tuttu, voi peliohjeet lukea näkymästä, joka aukeaa painamalla nappia "Paina tästä
nähdäksesi ohjeet". Ohjenäkymästä pääsee takaisin peliin painamalla nappia "paina tästä päästäksesi peliin".

### Pelin aloitus

Peli alkaa painamalla nappia "Jaa aloituskortit". Tällöin sekä pelaajalle että tietokoneelle/vastustajalle jaetaan
kaksi korttia.

### Pelin edistyminen

Ruudulla näkyy myös näiden kahden kortin summa. Tämän jälkeen pelaaja saa päättää mitä tekee: jos hän
päättää ottaa vielä kortin, se tapahtuu painamalla nappia "Pelaajalle kortti". Pelaajan korttien summa päivittyy
näkymässä aina kun hän ottaa kortin. Jos summa ylittää 21, peli päättyy ja pelaaja häviää ja ruudulle ilmestyy 
teksti "Game Over". Jos pelaaja saa korttiensa summaksi tasan 21, peli päättyy ja pelaaja voittaa. Ruudulle ilmestyy
teksti "Voitto pelaajalle". Jos pelaaja pääsee mielestään tarpeeksi lähelle summaa 21, eikä halua ottaa uutta korttia, 
painamalla nappia "Pelaaja lopettaa, vastustajalle kortti" vuoro siirtyy tietokoneelle vastustajalle. Tämän jälkeen
vastustaja ottaa kortteja painamalla nappia "Vastustajalle kortti" kunnes peli loppuu joko pelaajan voittoon, häviöön
tai tasapeliin.

## Pelitulosten tallentaminen

Pelaaja voi tallentaa pelin päätyttyä pelituloksensa kirjoittamalla tekstikenttään "Nimesi" haluamansa pelaajanimen.
Samalla pelaajalla voi olla näitä useita. Tulosten tallentaminen ei ole pakollista.

## Pelitulosten tutkiminen

Painamalla nappia "Katso pelituloksia" pääsee näkymään jossa voi painamalla nappia "Näytä kaikki tulokset" nähdä
kaikki tallennetut tulokset, tai käyttämällä hakutoiminnallisuutta määritelläm minkä pelaajanimen tulokset haluaa
nähdä. Tulosnäkymästä pääsee takaisin pelinäkymään painamalla nappia "Paina tästä palataksesi peliin".