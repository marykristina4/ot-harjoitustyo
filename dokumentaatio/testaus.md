# Testausdokumentti

Ohjelmaa on testattu automaattisin testein. Käytössä on JUnit, jolla on toteutettu yksikkö- ja integraatiotestit.
Lisäksi järjestelmää on testannut useampi käyttäjä. Järjestelmätason testit ovat olleen manuaalisia.

## Yksikkö- ja integraatiotestaus

### Yksikkötestit

Yksikkötesteissä on testattu luokkien Card, Hand, Deck, GameResult ja GameService metodien toimintaa. Testiluokat
on nimetty vastaavasti TestCard, TestHand, TestDeck, TestGameResult, TestGameService.

### Dao:jen testaus

Tiedostotallennuksen testaamiseksi on luotu luokka FakeGameResultDao, jolla on jäljilty daon toimintaa, mutta
tämä toteutus on keskusmuistia käyttävä. Luokka FileGameResultDaoTest sisältää varsinaiset testit. Testauksessa on
hyödynnetty JUnitin TemporaryFolder -toiminnallisuutta väliaikaisen tiedoston luomiseksi testauksen ajaksi.

### Integraatiotestit

Integraatiotestit on hoidettu suurimmalta osin GameServiceTest -luokan testeillä, joissa on luotu pelituloksia
ja tallennettu niitä sekä haettu niitä tallennuksesta.

### Testauskattavuus

Testikattavuutta voidaan tarkastella testikattavuusraportti komennolla mvn test jacoco:jacoco.
On huomioitava, että käyttöliittymä eli VenttiUi on jätetty raportista sivuun. Raportista havaitaan, että rivikattavuus on 92% ja haaraumakattavuus 91%.
Lukuja voidaan pitää tarpeeksi hyvinä tämän kaltaisen sovelluksen testaamiseen. Alla viimeisin tilanne testikattavuudesta:

<img src="https://github.com/marykristina4/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/testikattavuus.PNG" width="500">
Kuva testikattavuudesta


## Järjestelmätestaus

Järjestelmää on sovelluksen tekijän lisäksi testannut koodikatselmoinnissa määrätty henkilö sekä sovelluksen tekijän
lapset. Mahdollisia bugeja on korjattu niiden tullessa ilmi. Erillistä dokumentaatiota bugeista ja niiden korjauksista
ei ole luotu.

### Asennus ja konfigurointi

Oletetaan, että sovellusta käytetään käyttöohjeen mukaisesti. Sovelluksen toimintaa on testattu tallennukseen
käytettävän tiedoston ollessa valmiina, kuten myös niin, että sovellus on sen luonut.

### Toiminnallisuus

Pelin kaikkia toiminnallisuuksia on testattu. Käyttöliittymä huolehtii suurilta osin siitä, että käyttö tapahtuu
suunnitellulla tavalla. Koska pelitulosten tallentaminen ei ole niin tarkkaa, voi niitä tallentaa millä nimellä vaan,
eikä käyttäjää autentikoida. Jos nimen kohdalla ei syötä mitään ja painaa tallennusnappia, tulos näkyy pelaajalle
"null" eikä häiritse sovelluksen toimintaa millään tavalla.


## Sovellukseen jääneet laatuongelmat

Virheilmoituksia ei sovellusksesta lähetetä, vaan käyttöliittymä huolehtii ettei virhetilanteita pääsisi syntymään.
Oletettavasti saattaa kuitenkin olla, että on olemassa virhetilanteita, joita ei ole ajateltu. Näitä havaittaessa,
olisi hyvä luoda repositorioon uusi Issue: [Issues]("https://github.com/marykristina4/ot-harjoitustyo/issues")

Kun pelituloksia alkaa kertyä enemmän, niistä on vaikea vetää johtopäätöksiä.
Olisi hyvä, että tulokset saisi numeerisina arvoina (montako voittoa jne.) eikä vain listana.
