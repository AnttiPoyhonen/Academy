
-- Varmuuden vuoksi:
use world;

/* *************************************
 * HARJOITUS                           *
 ************************************* */
 
-- Kunkin maanosan suurin kaupunki
-- Kahdessa vaiheessa

-- vaihe 1, kaksi erillistä hakua

/*
-- Osa 1
-- Hae kaikki kaupungit, niiden väkiluku ja mihin maanosaan kaupunki kuuluu
-- Yksinkertainen INNER JOIN
	select country.continent as alue, city.population as popula, city.name as nimi
	from country 
	join city 
	on country.code = city.countrycode
;
*/


-- Osa 2
-- Hae kunkin maanosan väkiluvultaan suurin kaupunki
-- vastauksena vain maanosan nimi ja suurin väkiluku
-- JOIN, GROUP BY ja MAX
/*
	select country.continent as alue, max(city.population) as isoin 
	from country 
	join city 
	on city.countrycode=country.code 
	group by country.continent
;
*/

-- vaihe 2, yhdistetty
-- tuloksena maanosan nimi, kaupungin nimi, ja kaupungin väkiluku
-- from: osan 1 haun tulos
-- join: osan 2 haun tulos
-- on: osan1 väkiluku = osan2 suurin väkiluku AND osan1 maanosa = osan 2 maanosa
/*
select osa2.alue, osa1.nimi, osa2.isoin 
from 
(
	select country.continent as alue, city.population as popula, city.name as nimi
	from country 
	join city 
	on country.code = city.countrycode
) as osa1
join 
(
	select country.continent as alue, max(city.population) as isoin 
	from country 
	join city 
	on city.countrycode=country.code 
	group by country.continent
) as osa2 
on osa2.isoin=osa1.popula and osa2.alue=osa1.alue
order by osa2.alue
;
*/

/* *************************************
 * HARJOITUS                           *
 ************************************* */

-- Tehdään pieni testi, eli yhdistetään - jälleen kerran - maa- ja kaupunki-taulut
-- koita seuraavaa. Lienee selvä, ainakin haun jälkeen, miksi count(*) eikä *
-- select count(*) from city, country;
-- Jos ei ole selvää miksi tuollainen määrä tulee, niin koita seuraavaa
-- select * from city inner join country limit 10;
 
/* *************************************
 * HARJOITUS                           *
 ************************************* */

-- Yhdistä maa- ja kaupunki-tauluja, mutta nyt kaupunkitaulusta tietoa maa-taulun tulosten parantamiseksi
-- Hae kaikkien maiden: nimi, maanosa, alue (region) ja pääkaupungin nimi

-- select co.name, co.continent, co.region, ci.name from country co join city ci on co.capital=ci.id;

-- Saitko yhtä monta tulosta kuin maa-taulussa on rivejä? 
-- Sen luonnollisesti saa vertaamalla kun katsoo tulosjoukon koon ruudulta, mutta tee kysely joka kertoo asian
-- Tulosjoukko: montako riviä maa-taulussa, montako riviä edellisen kohdan kyselyssä, ovatko ne yhtäsuuret. (0=false, 1=true)
-- select eka.lkm, toka.lkm, (eka.lkm = toka.lkm) as `yhtäsuuret` from (select count(*) as lkm from country) as eka, (select count(*) as lkm from country co join city ci on co.capital=ci.id) as toka;
 
/* *************************************
 * HARJOITUS                           *
 ************************************* */

-- Tulosta kaikki valtiot, ja niiden päämiehet (HeadOfState)
-- select name, HeadOfState from country;

-- Montako valtiota on, joilla ei ole päämistä? Kolme pitäisi tulla vastaukseksi
-- select count(*) from country where headofstate is null or headofstate='';
 
-- Tulosta kaikki valtioden päämiehet , ja kuinka monessa maassa he ovat päämiehiä
 
-- select HeadOfState, count(*) as lkm from country group by headofstate order by lkm desc;

-- Tulosta vain ne päämiehet, jotka ovat päämiehiä useammassa kuin kahdessa valtiossa
-- select HeadOfState, count(*) as lkm from country group by headofstate having lkm > 2 order by lkm desc;

/* *************************************
 * HARJOITUS                           *
 ************************************* */

-- Tulosta kaikki maat, joissa suomi on puhuttu kieli ja kuinka monta prosenttia väestöstä puhuu suomea ja onko suomi virallinen kieli kyseisessä maassa
-- select c.name, cl.isofficial, cl.percentage from countrylanguage cl join country c on c.code=cl.countrycode where cl.language='Finnish';

-- Tulosta kaikki maat, joissa suomi tai ruotsi on puhuttu kieli ja kuinka monta prosenttia väestöstä puhuu kyseistä kieltä ja onko kieli virallinen kieli
-- select cl.language, c.name, cl.isofficial, cl.percentage from countrylanguage cl join country c on c.code=cl.countrycode where cl.language in ('Finnish', 'Swedish');
/* Esimerkkitulostus
+----------+---------+------------+------------+
| language | name    | isofficial | percentage |
+----------+---------+------------+------------+
| Swedish  | Denmark | F          |        0.3 |
| Finnish  | Estonia | F          |        0.7 |
| Finnish  | Finland | T          |       92.7 |
| Swedish  | Finland | T          |        5.7 |
| Swedish  | Norway  | F          |        0.3 |
| Finnish  | Sweden  | F          |        2.4 |
| Swedish  | Sweden  | T          |       89.5 |
+----------+---------+------------+------------+
*/

-- Tulosta nyt vastaava kuin yllä, mutta tee se kaikille pohjoismaiden virallisille kielille

-- ensin haetaan pohjoismaat
-- select name, code from country where region='Nordic Countries';

-- sitten hae kyseistn maiden viralliset kielet
-- select distinct(language) from countrylanguage where isofficial='T' and countrycode in (select code from country where region='Nordic Countries');

-- lopuksi haetaan kaikki maat joissa puhutaan kyseisiä kieliä käyttämällä edellistä kyselyä alikyselyinä
/*
select cl.language, c.name as country, cl.isofficial, cl.percentage 
from countrylanguage cl 
join country c 
on c.code=cl.countrycode 
where cl.language in (
	select distinct(language) 
	from countrylanguage 
	where isofficial='T' and countrycode in (
		select code 
		from country 
		where region='Nordic Countries'
	)
)
order by language
;
*/


/* *************************************
 * HARJOITUS                           *
 ************************************* */

-- Katsotaan kuinka monta ihmistä puhuu kieliä 

-- Aloitetaan englannilla

-- Hae ensin country-taulusta nimi ja väkiluku, ja countrylanguage-taulusta montako prosenttia kyseisen maan ihmisistä puhuu englantia
/*
select co.name, cl.percentage, co.population 
from country co 
join countrylanguage cl 
on co.code=cl.countrycode 
where cl.language='English'
;
*/

-- Tee sitten muuten sama haku, mutta lisää tulosjoukkoon lasku, joka laskee väkiluvun ja prosenttien perusteella lukumäärä montako ihmistä puhuu englantia
/*
select co.name, cl.percentage, co.population, floor(cl.percentage*co.population /100) as maara 
from country co 
join countrylanguage cl 
on co.code=cl.countrycode 
where cl.language='English'
order by maara desc;
*/

-- Laske nyt englantia äidinkielenään puhuvien kokonaismäärä käyttäen SUM funktiota
/*
select floor(sum(cl.percentage*co.population /100)) as maara 
from country co 
join countrylanguage cl 
on co.code=cl.countrycode 
where cl.language='English';
*/

-- Listaa maailman 10 eniten (äidinkielenä) puhuttua kieltä
-- Äskeisestä osasta saa hyvän tarkistuksen siihen onko ainakin englanti oikein tässä osuudessa
-- Saat 10 ensimmäistä järjestämällä lukumäärän mukaan ja lisäämällä loppuun LIMIT 10
/*
select cl.language, floor(sum(cl.percentage*co.population /100)) as maara 
from country co 
join countrylanguage cl 
on co.code=cl.countrycode
group by cl.language
order by maara desc
limit 10;
*/


/* *************************************
 * HARJOITUS                           *
 ************************************* */

-- Suomen 100-vuotisjuhlien kunniaksi

-- Listaa kaikki maat joiden itsenäisyydestä on vähintään 100 vuotta. Älä siis kirjoita vuosilukua, vaan laske se nykyisestä vuodesta

-- select name, indepyear, year(curdate()) - indepyear as vanha from country where indepyear <= year(curdate()) - 100 order by vanha desc;

-- Listaa kaikki maat, joilla ei löydy itsenäistymisvuotta

-- select name from country where indepyear is null;

-- Listaa kaikki maat, joilla ei löydy itsenäistymisvuotta, mutta lisää vielä valtiomuoto ja väkiluku - järjestä väkiluvun mukaan

-- select name, GovernmentForm, population from country where indepyear is null order by population;

 
 
 
-- ==================================================================================================
-- Listaa GNP keskiarvo maanosittain
