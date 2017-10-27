update henkilo 
set ika = (ika + 1)

where henkilo.nimi in (

	select distinct henkilo.nimi

	from henkilo

	join lapset
	on henkilo.id = lapset.vanhempiID

	where lapset.lapsiID is not null

)