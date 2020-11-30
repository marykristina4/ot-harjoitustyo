# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattaa kerrosarkkitehtuuria, jossa päällimmäisenä käyttöliittymä venttigame.ui, joka on
graafinen käyttöliittymä ja alempana sovelluslogiikkaa käsittelevä pakkaus venttigame.domain.

<img src="https://github.com/marykristina4/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/venttigame_pakkauskaavio.png" width="260">
Kuva arkkitehtuurista

## Käyttöliittymä

Käyttöliittymä on graafinen käyttöliittymä, jolla voi ohjeiden mukaan pelata venttiä. Oletetaan, että
pelaaja tuntee säännöt.

Käyttöliittymä on pakkauksessa venttigame.ui ja käyttöliittymän logiikka on luokassa VenttiUi.java.
Käyttöliittymä on eriytetty sovelluslogiikasta, ja käyttöliittymästä kutsutaan sovellusluokkaa toteuttavia olioita
ja niiden metodeja.

## Sovelluslogiikka

Sovelluslogiikka on paketissa venttigame.domain. Loogisen datamallin muodostavat luokat Deck, Hand ja Card.
Luokassa Card on pelikortit, yhteensä 52 kpl - 13 kpl kutakin neljää maata. Numeroarvoltaan kortit jätkä, rouva ja 
kunkku ovat kukin 10. Ässä on tässä versiossa aina numeroarvoltaan yksi. Luokassa Deck on pelikorteista koostuva kortti-
pakka. Korttipakassa on 52 korttia pelin alkaessa. Luokassa Hand on sekä pelaajan että tietokoneen kädessä olevat 
kortit.

Luokan Card toiminnallisuutena on ainoastaa näyttää korttien tiedot: mitä maata kortti on, mikä kortti ja mikä on
sen numeroarvo.

Luokassa Deck on korttipakan toiminnallisuudet:
- korttipakan sekoittaminen shuffle()
- kortin nostaminen pakasta cardDraw()
- pakan koon kysymiseen deckSize()

Luokassa Hand on seuraavat toiminnallisuudet:
- kortin lisääminen käteen addCard(Card)
- käden sisällön katsominen showHand()
- kädessä olevien korttien numeroarvojen laskeminen yhteen handSum()

<img src="https://github.com/marykristina4/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/venttigame_luokkakaavio.png" width="400">
Kuva luokka/pakkauskaaviosta

### Sovelluksen päätoiminnallisuudet

Käyttöliittymä VenttiUi.java toimii rajapintana käyttäjän suuntaan. Tarvittavat oliot luodaan init() -vaiheessa.
Pelin komentojen mukaan toiminnallisuudet on toteutettu, ja VenttiUi:sta kutsutaan luokkien Deck, Hand ja Card
-olioiden metodeja napin painallusten mukaan. Käytössä on siis reagoiva tapahtumankäsittelijä. Ajetun metodin
tulokset (pelaajan saama kortti, korttien summa) palautetaan käyttöliittymään pelaajan näkyviin.

<img src="https://github.com/marykristina4/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/venttigame_sekvenssikaavio.png" width="560">
kuva sekvenssikaaviosta


Pääasiallinen rajapinta käyttäjälle on siis VenttiUi, mutta halutessaan katsoa pelin sääntöjä, käyttäjä pääsee nappia
painamalla siirtymään toiseen näkymään jossa on pelin säännöt. Sieltä pääsee takaisin pelinäkymään jälleen napin
painalluksella.

## Tietojen pysyväistallennus

Alkuperäinen suunnitelma:
Käyttäjätiedot tallennetaan tiedostoon. Tässä hyödynnetään dao-mallia (tämä toiminnallisuus työn alla).
Sovelluksen juureen sijoitettu konfiguraatiotiedosto config.properties määrittelee tiedostojen nimet.

Sovellus tallettaa käyttäjät seuraavassa formaatissa

tunnus;Käyttäjän nimi

eli ensin käyttäjätunnus ja puolipisteellä erotettuna käyttäjän nimi.
 
Päivitys 25.11:
Harkinnassa on myös, jos ainoa tarve on pelitulosten tallentaminen, tarviiko käyttäjätietoja sellaisenaan tallentaa,
vai riittäisikö se, että käyttöliittymässä kysyy pelaajan nimen jos pelaaja haluaa tallentaa tuloksen. Ei kuitenkaan
alunperinkään ollut tarvetta että kaikki pelitulokset olisi pakko tallentaa. Tällöin näkymästä VenttiUi voisi olla 
tapahtumankäsittelijä, joka käsittelee tallennuksen pelaajan näin halutessa.
 
## Huomioita ohjelmasta / kehitysehdotuksia / heikkouksia

Päivitetään myöhemmin
