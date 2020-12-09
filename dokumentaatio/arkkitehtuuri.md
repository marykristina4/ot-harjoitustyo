# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattaa kerrosarkkitehtuuria, jossa päällimmäisenä on käyttöliittymä venttigame.ui, joka on 
JavaFX:llä toteutettu graafinen käyttöliittymä ja keskimmäisenä sovelluslogiikkaa käsittelevä pakkaus
venttigame.domain. Alimpana kerroksena on tietojen pysyväistallennuksesta vastaava venttigame.dao.

<img src="https://github.com/marykristina4/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/venttigame_pakkauskaavio.png" width="260">
Kuva arkkitehtuurista

## Käyttöliittymä

Käyttöliittymä on JavaFX:llä toteutettu graafinen käyttöliittymä, jolla voi ohjeiden mukaan pelata venttiä.
Oletetaan, että pelaaja tuntee säännöt, mutta niitä voi myös katsoa käyttöliittymän ohjeille varatusta näkymästä.
Käyttöliittymän toiminnallisuudessa on huolehdittu siitä, että käyttäjää ohjeistetaan painamaan oikeita nappeja ja
pelaamaan peliä oikeilla säännöillä.

Käyttöliittymä on pakkauksessa venttigame.ui ja käyttöliittymän logiikka on luokassa VenttiUi.java.
Käyttöliittymä on eriytetty sovelluslogiikasta, ja käyttöliittymästä kutsutaan sovellusluokkaa toteuttavia olioita
ja niiden metodeja. Etenkin luokat Deck ja Card on viety luokan GameService-luokan taakse, koska niillä toteutetaan
pelin sisäisiä toiminnallisuusksia. Käyttöliittymää lähempänä on luokka Hand, jonka oliot jäljittelevät pelaajan
kättä - niiden toiminnallisuus on läheisesti tekemisissä käyttöliittymän komponenttien toiminnallisuuksien kanssa ja
käden sisällöstä riippuukin esim se mitkä käyttöliittymän napit ovat aktiivisia ja mitkä inaktivoituja.

## Sovelluslogiikka

Sovelluslogiikka on paketissa venttigame.domain. Loogisen datamallin muodostavat luokat GameService, GameResult, Deck,
Hand ja Card. Luokassa Card on pelikortit, yhteensä 52 kpl - 13 kpl kutakin neljää maata. Numeroarvoltaan kortit jätkä,
rouva ja kunkku ovat kukin 10. Ässä on tässä versiossa aina numeroarvoltaan yksi. Luokassa Deck on pelikorteista
koostuva korttipakka. Korttipakassa on 52 korttia pelin alkaessa. Luokassa Hand on sekä pelaajan että tietokoneen/vas-
tustajan kädessä olevat kortit. Luokka GameService toimii käyttöliittymän rajapintana tietojen pitkäaikaistallennusta
toteuttaville luokille. Luokka GameResult on käytössä nimenomaan pitkäaikastallennuksessa.

Luokan Card toiminnallisuutena on ainoastaa näyttää korttien tiedot: mitä maata kortti on, mikä kortti ja mikä on
sen numeroarvo.

Luokassa Deck on korttipakan toiminnallisuudet:
- korttipakan sekoittaminen shuffle()
- kortin nostaminen pakasta cardDraw()
- kortin poistaminen pakasta cardRemove(Card)
- pakan koon kysymiseen deckSize()
- korttien palauttamiseksi pelipakkaan cardsBackToDeck()

Luokassa Hand on seuraavat toiminnallisuudet:
- kortin lisääminen käteen addCard(Card)
- kädessä olevien korttien numeroarvojen laskeminen yhteen handSum()
- kädessä olevien korttien lukumäärän laskeminen handSize()
- käden tyhjentäminen korteista emptyHand()

Luokassa GameService on korttipakka Deck kyseiselle pelille, että GameResultDao, jota käytetään tulosten tallentami-
seen. Toiminnallisuudet luokassa GameService ovat:
- uuden pelituloksen luominen createGameResult(String name, String result)
- tallennettujen pelitulosten listaaminen getResults()
- tallennettujen pelitulosten listaaminen tietylle pelaajalle findByName(String name)
- korttipakasta korttien nostaminen tiettyyn käteen cardFromDeck(Hand hand)

Luokassa GameResult on lähinnä toiminnallisuudet getName, getResult, tostring ja equals tulosten listaamiseksi.

<img src="https://github.com/marykristina4/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/venttigame_luokkakaavio.png" width="400">
Kuva luokka/pakkauskaaviosta

### Sovelluksen päätoiminnallisuudet

Käyttöliittymä VenttiUi.java toimii rajapintana käyttäjän suuntaan. Tarvittavat oliot luodaan init() -vaiheessa, 
kuten myös tietojen tallentamiseen tarvittavat oliot.

Sovelluslogiikka ja toiminnallisuudet on toteutettu luokissa GameService, Deck, Hand ja Card ja niiden metodeja ajetaan
käyttäjän painamien nappien mukaisesti. Myös käyttöliittymän ulkonäkö vaihtelee pelin vaiheiden mukaan. Käytössä on
reagoiva tapahtumankäsittelijä. Ajetun metodin tulokset (pelaajan saama kortti, korttien summa) palautetaan
käyttöliittymään pelaajan näkyviin ja käyttöliittymän komponentit reagoivat suunnitellulla tavalla.

Pääasiallinen rajapinta käyttäjälle on siis VenttiUi, mutta halutessaan katsoa pelin sääntöjä, käyttäjä pääsee nappia
painamalla siirtymään toiseen näkymään jossa on pelin säännöt. Sieltä pääsee takaisin pelinäkymään jälleen napin
painalluksella. Halutessaan katsoa pelituloksia, pelaaja siirtyy toiseen näkymään.

Kuvataan joitain päätoiminnallisuuksia sekvenssikaavion avulla. Kaaviossa on esitetty GameServicen ja Deckin luominen, 
kortin nostaminen pakasta käteen sekä kädessä olevien korttien summan laskeminen.

<img src="https://github.com/marykristina4/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/venttigame_sekvenssikaavio.png" width="560">
Kuva sekvenssikaaviosta

## Tietojen pysyväistallennus

Tiedot pelituloksista tallennetaan tiedostoon pelaajan niin halutessa. Tässä hyödynnetään dao-mallia. Pakkaksessa 
venttigame.dao oleva luokka FileGameResultDao hoitaa pelitulosten tallentamisen. Tämä luokka on rajapinnan
GameResultDao takana eli niitä ei käytetä suoraan vaan rajapinnan kautta. Sovelluksen juureen sijoitettu
konfiguraatiotiedosto config.properties määrittelee tallennukseen käytettävän tiedoston nimen.

Sovellus tallettaa pelitulokset seuraavassa formaatissa:

pelaajan_nimi;pelitulos

eli ensin pelaajan valitsema nimi ja puolipisteellä erotettuna pelitulos. Mahdollisia pelituloksia ovat Voitto, Häviö
ja tasapeli.

Kun peli on päättynyt, pelaaja voi halutessaan tallentaa pelituloksen käyttöliittymän toiminnallisuutta käyttäen.
Pelaaja saa valita pelaajanimen, jolla tulos tallennetaan käyttäen tapahtumankäsittelijää.

Seuraavassa kaaviossa on esitetty pelituloksen GameResult luominen ja tallentaminen sekä pelitulosten hakeminen
tiedostosta niiden esittämiseksi käyttöliittymässä:

<img src="https://github.com/marykristina4/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/venttigame_sekvenssikaavio_dao.PNG" width="560">
Kuva sekvenssikaaviosta


Dao-luokkien testauksessa käytetään keskusmuistiin tallentavia toteutuksia.
 

## Huomioita ohjelmasta / kehitysehdotuksia / heikkouksia

Moninpeliä ei ole vielä toteutettu, sen tekemiseksi tulee myös käyttöliittymää uudelleensuunnitella.
Käyttöliittymän kaikki toiminnallisuus on samassa luokassa ja suurin osa tapahtuu metodissa start(), ja jo tässä
versiossa se on rajoilla pitäisikö jakoa useampaan osaan tehdä: ainakin jos pelaajia halutaan enemmän ja pelin
toteutusta laajentaa, on jakoa tehtävä.

Testauksen monipuolisuutta voisi kasvattaa: toki peli itsessään on aika yksinkertainen eikä siinä mielessä siinä
olekaan kovin monimutkaista logiikkaa. Voisi pohtia myös kuuluisiko myös Hand-luokka paremmin luokan GameService
taakse niin että gameService olisi ainoa jonka käyttöliittymä kohtaa.
