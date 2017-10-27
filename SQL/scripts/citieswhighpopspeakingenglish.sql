select a.name as city, b.language, a.population

from city a 

join countrylanguage b
on a.countrycode = b.countrycode

where a.population > 500000
AND b.language = 'English'
AND b.IsOfficial = true

order by a.population desc; 