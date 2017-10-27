select distinct henkilo.nimi, henkilo.ika

from henkilo

join lapset
on henkilo.id = lapset.vanhempiID

where lapset.lapsiID is not null