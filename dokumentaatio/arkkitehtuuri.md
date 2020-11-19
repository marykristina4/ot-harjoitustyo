# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattaa kerrosarkkitehtuuria, jossa päällimmäisenä käyttöliittymä venttigame.ui, joka on
toistaiseksi tekstikäyttöliittymä ja alempana sovelluslogiikkaa käsittelevä pakkaus venttigame.domain.

--tähän kuva arkkitehtuurista

## Käyttöliittymä

Käyttöliittymä on toistaiseksi tekstikäyttöliittymä, jolla voi ohjeiden mukaan pelata venttiä. Oletetaan, että
pelaaja tuntee säännöt.

Käyttöliittymä on pakkauksessa venttigame.ui ja käyttöliittymän logiikka on luokassa PlayerCommunication.java.
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

--tähän luokka/pakkauskaavio

### Sovelluksen päätoiminnallisuudet

--tähän sekvenssikaavio

## Tietojen pysyväistallennus

Käyttäjätiedot tallennetaan tiedostoon. Tässä hyödynnetään dao-mallia (tämä toiminnallisuus työn alla).
Sovelluksen juureen sijoitettu konfiguraatiotiedosto config.properties määrittelee tiedostojen nimet.

Sovellus tallettaa käyttäjät seuraavassa formaatissa

tunnus;Käyttäjän nimi

eli ensin käyttäjätunnus ja puolipisteellä erotettuna käyttäjän nimi. 

## Huomioita ohjelmasta / kehitysehdotuksia / heikkouksia
