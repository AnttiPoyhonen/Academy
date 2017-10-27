-- SQL scripts, w5 Academy, harjoitus 9 -- 

/*

1. Hae kaupungeista kaupungin nimi ja populaatio sille kaupungille, jolla on suurin
asukasluku. Käytä alikyselyä ja siellä MAX-funktiota etsimään suurin populaatio,
käytä alikyselyn tulosta ehtona varsinaisessa kyselyssä ja vertaa että
populaatio=<alikyselyn tulos>
*/
/*
use world;

--

select name as city, population
from city
where population=(
	select max(population)
	from city
);

/*
2. Hae countrylanguage taulusta maat joissa puhutaan keskimääräistä useampaa
kieltä.
*/
/*
use world;

--

select country.name, count(cl.language) as kielilkm
from countrylanguage cl

join (
	select avg(kielet.lkm) as ka
	from(
		select countrycode, count(language) as lkm
		from countrylanguage
		group by language
	) as kielet
) as keskiarvo

join country
on cl.countrycode = country.code

group by countrycode, keskiarvo.ka

having kielilkm > keskiarvo.ka

order by kielilkm asc;

--

select avg(kielet.lkm) as language_average
from(
	select countrycode, count(language) as lkm
	from countrylanguage
	group by language
) as kielet;

/*
3. Hae kaikki yli 500.000 asukasta omaavat kaupungit, jotka ovat maassa, jossa
puhutaan englantia
*/
/*
use world;

--

select a.name as a, a.population, b.name as country, c.language

from city a

join country b
on a.countrycode = b.code

join countrylanguage c
on c.countrycode = b.code

where c.language = 'English'
and b.continent = 'Europe'
and a.population > 500000

order by a.population asc;

/*
Lisätehtävät

 Käytä edellisen harjoituksen Henkilö/lapset tauluja: Vanhenna kaikkia henkilöitä
joilla on lapsia
*/
/*
use kurssi;

--

select distinct parent.nimi as parent, parent.ika as PREV_age
from henkilo parent

join lapset id
on id.vanhempiID = parent.id;

-- BEFORE

update henkilo
set ika = ika + 1

where id in 
(
	select distinct vanhempiID
	from lapset
);

-- AFTER

select distinct parent.nimi as parent, parent.ika as NEW_age
from henkilo parent

join lapset id
on id.vanhempiID = parent.id;

/*
 Haastetta hieman enemmän, vaatii pari alikyselyä: Tulosta kunkin maanosan
korkeimman elinajan odotuksen omaava maa, ja sen elinajan odotus,
esimerkiksi:
		
+---------------+----------------+---------------+
| name | lifeexpectancy | continent |
+---------------+----------------+---------------+
| Andorra | 83.5 | Europe |
| Australia | 79.8 | Oceania |
| Canada | 79.4 | North America |
| French Guiana | 76.1 | South America |
| Macao | 81.6 | Asia |
| Saint Helena | 76.8 | Africa |
+---------------+----------------+---------------+
*/
/*
use world;

select max(lifeexpectancy) as max, continent
from country
group by continent;

--

select name as country, lifeexpectancy, continent

from country

where lifeexpectancy in (
	select max(lifeexpectancy)
	from country
	group by continent
)

group by continent

order by lifeexpectancy asc;

/*
*/