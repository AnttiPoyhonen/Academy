use kurssi;

/*

SELECT vanhempi.nimi AS vanhemman_nimi,
 lapsi.nimi AS lapsen_nimi 
FROM henkilo vanhempi, henkilo lapsi 
JOIN lapset 
WHERE lapset.vanhempiid=vanhempi.id 
AND lapset.lapsiid=lapsi.id;
*/


-- Myös henkilöt joilla ei lapsia
select toka.vanhempi, henkilo.nimi 
from henkilo 
right join 
(
	select v.nimi as vanhempi, l.lapsiid as lapsi 
	from henkilo v 
	left join lapset l on v.id=l.vanhempiid
) as toka
on henkilo.id=toka.lapsi
;

