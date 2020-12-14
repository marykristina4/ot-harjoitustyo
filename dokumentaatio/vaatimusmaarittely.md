# Vaatimusmäärittely

Tässä dokumentissa kuvataan sovelluksen toiminnallisuus

## Sovelluksen tarkoitus

Sovellus on peli nimeltä Ventti, jota yksi pelaaja voi pelata kerrallaan tietokonetta tai muuta vastustajaa vastaan.
Sovelluksen toiminta mukailee korttipeliä Ventti, joka on suomalainen vastine BlackJackille. Pelaaja pystyy
pelaamisen jälkeen kirjoittaa nimensä ja tallentaa pelituloksen.

## Käyttäjät

Sovelluksella on vain peruskäyttäjiä, eli pelaajia, jotka voivat omalla nimellään kirjautua ja tallentaa
pelituloksiaan. 


## Käyttöliittymäluonnos

Kun pelaaja käynnistää pelin, hänelle aukeaa pelinäkymä. Pelinäkymässä pelaaja pystyy pelaamaan venttiä ja hän voi
tallentaa pelituloksensa haluamallaan nimellä. Halutessaan pelaaja voi ajaa raportin, josta näkee aiempia pelituloksia. 
Sovelluksessa on myös toiminnallisuus, josta voi tarkastella haluamansa pelaajan pelituloksia. Halutessaan tarkistaa
pelin säännöt, pelaaja voi siirtyä sopivalla napilla näkymään, jossa säännöt esitetään.

## Perusversion tarjoama toiminnallisuus

Perusversiossa toimii yksinpeli, niin että pelaaja voi pelata tietokonetta vastaan. Jos pelaajia on kaksi, toinen
heistä voi olla tietokone/vastustaja. Peli aloitetaan jakamalla aloituskortit. Tämän jälkeen pelaaja saa päättää
kortti kerrallaan ottaako hän vielä uuden kortin. Jos pelaaja ottaa kortin niin että korttien arvojen summa menee yli
21:n, tietokone voittaa. Jos pelaaja saavuttaa tilanteen, jossa hänen korttiensa summa on tasan 21, hän voittaa
suoraan. Jos pelaaja ei enää ota uutta korttia niin että hänen korttiensa summa on alle 21, on tietokoneen/vastustajan
vuoro. Tietokone/vastustaja ottaa aina uuden kortin jos sen korttien summa on alle pelaajan korttien summan. Siis,
jos tietokone/vastustaja saa summan joka on 21, se voittaa. Jos tietokone/vastustaja saa summan joka on suurempi kuin
pelaajalla, mutta kuitenkin alle 21, se voittaa. Tietokone/vastustaja häviää jos sen korttien summa on yli 21. Peli
voi päättyä myös tasapeliin. Kun peli on pelattu loppuun, voi nappia "Aloita uusi peli" painamalla aloittaa uuden
pelin. Tämä on pelaajan kannalta paljon mukavampaa kun että joutuisi joka kerta sulkemaan ohjelman ja ajamaan
sen uudestaan.


## Jatkokehitysideoita	

Jatkossa voisi pelistä tehdä myös moninpeliversion, jossa tietokonetta ja/tai vastaan voi olla samaan aikaan pelaamassa
useampi pelaaja. Lisäksi olisi kiva tehdä peliturnausksia, joissa pelaaja voi päättää pelien määrän ja jonkinlaisen
logiikan mukaan tietyllä prosenttiosuudella voittoja saa erilaisia tasoja/palkintoja. Turnauksen tulokset voitaisiin
tallentaa erilliseen tiedostoon.

Perusversion graaginen käyttöliittymä on melko alkeellinen ulkonäön kannalta, sitä voi jatkokehittää.
kehittää hienompaan suuntaan. Ainakin, kun pelituloksia kertyy enemmän, niiden selaaminen listanäkymästä on hankalaa
eikä kokonaiskuvaa menestyksestä pysty muodostamaan.




