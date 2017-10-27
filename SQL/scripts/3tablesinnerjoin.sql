SELECT
a.name as city, 
a.population as citypop, 
a.district, 
b.name as country, 
b.population as countrypop, 
c.language as lang

FROM 
city a 

JOIN 
country b 
ON a.countrycode = b.code 

JOIN
countrylanguage c
ON a.countrycode = c.countrycode

where 
a.countrycode='FIN' 
AND
c.language in (
	select language from countrylanguage where Percentage=(
		select max(Percentage) from countrylanguage where countrycode='FIN'
	)
) 

order by a.population asc

;