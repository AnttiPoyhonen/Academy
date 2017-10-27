-- keskimaaraisia kielia
-- use world;

-- Versio 1, vain keskiarvo:
/*
select avg(kielet.lkm)
from (
	select countrycode, count(language) as lkm
	from countrylanguage
	group by language
	) as kielet
;
*/

/*
select cl.countrycode as koodi, count(cl.language) as kielilkm, keskiarvo.ka as katulos
from countrylanguage cl
join
(
	select avg(kielet.lkm) as ka
	from (
		select countrycode, count(language) as lkm
		from countrylanguage
		group by language
		) as kielet
) as keskiarvo
group by cl.countrycode
having kielilkm > keskiarvo;
*/

-- Yhdistetään keskiarvon lasku ja tulostus
select countrycode, count(language) as kielilkm
from countrylanguage cl
join
(
	select avg(kielet.lkm) as ka
	from (
		select countrycode, count(language) as lkm
		from countrylanguage
		group by language
		) as kielet
) as keskiarvo
group by countrycode, keskiarvo.ka  -- keskiarvo.ka vaaditaan, jotta se on käytettävissä HAVING osassa
having kielilkm > keskiarvo.ka
;



/* Harjoitus 9, viimeinen lisätehtävä */
/*
select c.name, c.lifeexpectancy, c.continent 
from (
	select continent, max(lifeexpectancy) as vanhin 
	from country 
	group by continent
	) as sisa 
join country as c 
on c.continent=sisa.continent and c.lifeexpectancy=sisa.vanhin;
*/
