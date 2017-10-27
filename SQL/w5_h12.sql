-- SQL scripts, w5 Academy, harjoitus 12, nippuja -- 

/*
 Yhdistä maa- ja kaupunki-tauluja, hakemalla kaupunkitaulusta tietoa maataulun
tulosten parantamiseksi

	1. Hae kaikkien maiden: nimi, maanosa, alue (region) ja pääkaupungin nimi
	
	2. Saitko yhtä monta tulosta kuin country-taulussa on rivejä?
	
	3. Sen luonnollisesti saa vertaamalla, kun katsoo tulosjoukon koon ruudulta,
	mutta tee kysely joka kertoo asian. Tulosjoukko: montako riviä maataulussa,
	montako riviä edellisen kohdan kyselyssä, ovatko ne yhtä suuret.

	(0=false, 1=true). Vinkki: FROM-osaan voi listata useammankin taulun, tai
	tässä tapauksessa alikyselyn yksinkertaisesti pilkulla erottamalla
*/
/*
use world;

select (count(a.name) = count(b.country)) as yhtasuuret
from
(select * from country) as a,
(select name as country, continent, region, capital
from country) as b;

/*
 Hieman tulosjoukon koon huomiointia, kun yhdistellään tietoa tauluista.
Tehdään pieni testi, eli yhdistetään - jälleen kerran - maa- ja kaupunki-taulut

	1. Koita seuraavaa. Lienee selvä, ainakin haun jälkeen, miksi count(*) eikä *
	select count(*) from city, country;
	
	2. Jos ei ole selvää miksi tuollainen määrä tulee, niin koita seuraavaa, ja
	huomaa että vaikka alla on JOIN, niin tulos on vastaava
	select * from city inner join country limit 10;
*/

/*
use world;
-- select count(*) from city, country;
--select * from city inner join country limit 10;

/*
 Käsitellään valtioita ja valtioiden päämiehiä. Tauluna world.country.

	1. Tulosta kaikki valtiot, ja niiden päämiehet (HeadOfState)
	
	2. Montako valtiota on, joilla ei ole päämiestä? Kolme pitäisi tulla vastaukseksi
	
	3. Tulosta kaikki valtioiden päämiehet, ja kuinka monessa maassa he ovat
	päämiehiä
	
	4. Tulosta vain ne päämiehet, jotka ovat päämiehiä useammassa kuin
	kahdessa valtiossa
*/
/*
use world;
-- select name, headofstate from country;
-- select count(*) as no_headofstate from country where headofstate is null or headofstate = "";

/*
select headofstate, count(*) as of_countries#
from country 
where headofstate != null or headofstate != ""
group by headofstate 
order by of_countries# asc;
*/
/* TODO
select a.headofstate, a.of_countries#, (a.of_countries# > 2) as headof_more_than_two
from (
	select headofstate, count(*) as of_countries#
	from country 
	where headofstate != null or headofstate != ""
	group by headofstate
	order by of_countries# asc
) as a
where a.of_countries# > 2;

/*
 Suomen 100-vuotisjuhlien kunniaksi hieman itsenäistymisvuosia (indepyear)
country-taulusta:

	1. Listaa kaikki maat joiden itsenäisyydestä on vähintään 100 vuotta. Älä siis
	kirjoita vuosilukua, vaan laske se nykyisestä vuodesta
	
	2. Listaa kaikki maat, joilla ei löydy itsenäistymisvuotta
	
	3. Listaa kaikki maat, joilla ei löydy itsenäistymisvuotta, mutta lisää vielä
	valtiomuoto ja väkiluku - järjestä väkiluvun mukaan
*/
/*
use world;
-- /*
declare @nyt smallint;
set @nyt = 2017;

select name as country, indepyear as Independence_year
from country
where indepyear >= (@nyt - 100)
order by indepyear desc;
-- /*
select name as country, indepyear as Independence_year
from country
where indepyear is null
order by name asc;
-- /*
select name as country, indepyear as Independence_year, governmentform, population
from country
where indepyear is null
order by population asc;

/*
 Seuraavaksi tutkitaan hieman puhuttuja kieliä. Tässä tauluina countrylanguage
ja country

	1. Tulosta kaikki maat, joissa suomi on puhuttu kieli ja kuinka monta prosenttia
	väestöstä puhuu suomea ja onko suomi virallinen kieli kyseisessä maassa
	*/
	/*
	use world;
	
	select c.name, cl.language, cl.percentage as language_spread, cl.isofficial as Official_language
	from country c
	join countrylanguage cl
	on c.code = cl.countrycode
	where cl.language = 'Finnish'
	order by cl.percentage desc;
	
	/*
	2. Tulosta kaikki maat, joissa suomi tai ruotsi on puhuttu kieli ja kuinka monta
	prosenttia väestöstä puhuu kyseistä kieltä ja onko kieli virallinen kieli
	Esimerkkitulostus:
	
	+----------+---------+------------+------------+
	| language | name | isofficial | percentage |
	+----------+---------+------------+------------+
	| Swedish | Denmark | F | 0.3 |
	| Finnish | Estonia | F | 0.7 |
	| Finnish | Finland | T | 92.7 |
	| Swedish | Finland | T | 5.7 |
	| Swedish | Norway | F | 0.3 |
	| Finnish | Sweden | F | 2.4 |
	| Swedish | Sweden | T | 89.5 |
	+----------+---------+------------+------------+
	*/
	/*
	select c.name, cl.language, cl.percentage as language_spread, cl.isofficial as Official_language
	from country c
	join countrylanguage cl
	on c.code = cl.countrycode
	where cl.language = 'Finnish' or cl.language = 'Swedish'
	order by cl.language asc, cl.percentage desc;
	
	/*
	3. Tulosta nyt vastaava kuin yllä, mutta tee se kaikille pohjoismaiden virallisille
	kielille. Tämä kannattanee tehdä kolmessa vaiheessa:
	
		 Ensin hae pohjoismaat (Nordic Countries)
		
		 Sitten hae kyseisten maiden viralliset kielet, käyttäen edellistä
		kohtaa alikyselynä
		
		 Lopuksi hae kaikki maat joissa puhutaan kyseisiä kieliä käyttämällä
		taas edellistä kyselyä alikyselyinä
	*/
	
	select c.name, cl.language, cl.percentage as language_spread, cl.isofficial as Official_language
	from country c
	
	join countrylanguage cl
	on c.code = cl.countrycode
	
	where cl.language in (
		select language lang
		from countrylanguage
		
		where countrycode in (
			select code
			from country
			where region = 'Nordic Countries')
		and isofficial = true
		
	)
	
	order by cl.language asc, cl.percentage desc;
	
	
/*
 Jatketaan kielillä, katsellaan englantia puhuvia ihmisiä ja yleisimpiä kieliä
maailmassa. Tässä osassa ei tarvita alikyselyitä, JOIN ja WHERE ja ehkä
GROUP BY käytössä. Tehtävässä käytetään tietoa country ja countrylanguage
tauluista.

	1. Aloitetaan englannilla: Hae ensin country-taulusta nimi ja väkiluku, ja
	countrylanguage-taulusta montako prosenttia kyseisen maan ihmisistä
	puhuu englantia. INNER JOIN ja WHERE yksi vaihtoehto toteutukselle.
	*/
	/*
	use world;
	
	select c.name as country, c.population, cl.percentage as English_speaking
	from country c
	
	join countrylanguage cl
	on cl.countrycode = c.code
	
	where cl.language = 'English'
	order by cl.percentage asc;
	
	/*
	2. Tee sitten muuten sama haku, mutta lisää tulosjoukkoon lasku, joka laskee
	väkiluvun ja prosenttien perusteella lukumäärä montako ihmistä puhuu
	englantia. (Eli jos maassa asuu miljoona ihmistä ja heistä 5,2% puhuu
	englantia, niin kyseisessä maassa on 52000 englantia puhuvaa ihmistä)
	*/
	/*
	select c.name as country, c.population, cl.percentage as English_speaking,
		floor(c.population / 100 * cl.percentage) as approx_Eng_speaking_population
	from country c
	
	join countrylanguage cl
	on cl.countrycode = c.code
	
	where cl.language = 'English'
	order by approx_Eng_speaking_population asc;
	
	/*
	3. Laske nyt englantia äidinkielenään puhuvien kokonaismäärä käyttäen SUM
	funktiota - tämä siis eri kysely kuin edellä, luonnollisesti sisältää paljon
	samoja piirteitä.
	*/
	/*
	select floor(c.population / 100 * cl.percentage) as engspeaking, c.name as country
	
	from country c
	join countrylanguage cl
	on cl.countrycode = c.code
		
	where cl.language = 'English'
	order by engspeaking asc;
		
	select sum(numbers.engspeaking) as approx_total_Eng_speaking_population
	from (
	
		select c.name as country, floor(c.population / 100 * cl.percentage) as engspeaking
		
		from country c
		join countrylanguage cl
		on cl.countrycode = c.code
			
		where cl.language = 'English'
		order by engspeaking asc
		
	) as numbers;
		
	/*
	4. Listaa maailman 10 eniten (äidinkielenä) puhuttua kieltä. Äskeisestä osasta
	saa hyvän tarkistuksen siihen onko ainakin englantia puhuvien määrä oikein
	tässä osuudessa. Saat 10 ensimmäistä järjestämällä tuloksen lukumäärän
	mukaan ja lisäämällä loppuun LIMIT 10
	*/	
	/*
	use world;
	
	select lpop.Lang as Lang_name, sum(lpop.Lang_population) as Lang_total_population
	
	from (
		select cl.language as Lang, c.name as Lang_country, floor(c.population / 100 * cl.percentage) as Lang_population
		from countrylanguage cl
		join country c
		on c.code = cl.countrycode
	) as lpop
	
	group by lpop.Lang
	order by Lang_total_population desc
	
	limit 10;
		
	/*
 Hae kunkin maanosan suurin kaupunki, tee taas kahdessa vaiheessa
	
	1. Vaihe 1, kaksi erillistä hakua:
	
		 Hae kaikki kaupungit, niiden väkiluku ja mihin maanosaan kaupunki
		kuuluu - normaali INNER JOIN
		*/
		/*
		use world;
		
		select ci.name as city, ci.population, co.continent
		from city ci
		join country co
		on ci.countrycode = co.code
		order by ci.population asc;
		
		/*
		 Hae kunkin maanosan väkiluvultaan suurin kaupunki, tulosjoukossa
		vain maanosan nimi ja suurin väkiluku, esim. JOIN, GROUP BY ja MAX
		*/
		/*
		select co.continent as cont, max(ci.population) as pop
		from city ci
		join country co
		on ci.countrycode = co.code
		group by co.continent
		order by pop asc;
		
	/*
	2. Vaihe 2, yhdistetä nuo kaksi hakua, esimerkiksi seuraavalla tavalla:
	
		 tuloksena maanosan nimi, kaupungin nimi, ja kaupungin väkiluku
		
		 from: osan 1 haun tulos
		
		 join: osan 2 haun tulos
		
		 on: osan1 väkiluku = osan2 suurin väkiluku AND osan1 maanosa =
		osan 2 maanosa
	*/
/*
use world;

select b.cont as Continent, a.city as Largest_city, a.pop as City_population

from(
	select ci.name as city, ci.population as pop, co.continent as cont
	from city ci
	join country co
	on ci.countrycode = co.code
	order by ci.population asc
) as a

join (
	select co.continent as cont, max(ci.population) as pop
	from city ci
	join country co
	on ci.countrycode = co.code
	group by co.continent
	order by pop asc
) as b

on a.pop = b.pop 
and a.cont = b.cont

order by a.pop asc;

		
/*		
*/
