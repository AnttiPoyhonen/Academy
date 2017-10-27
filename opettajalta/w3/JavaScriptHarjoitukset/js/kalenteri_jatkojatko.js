
function alusta_sivu() {
    document.getElementById("form.vuosi").value = new Date().getFullYear();
    document.getElementById("form.button").onclick = paivita_sivu;
    var tanaan = new Date();
    tp = tanaan.getDate();
    tk = tanaan.getMonth();
    tv = tanaan.getFullYear();
}

function paivita_sivu() {
    var vuosi = parseInt(document.getElementById("form.vuosi").value);
    var kalenteri = document.getElementById("kalenteri");
    // tyhjennä mahdollinen vanha kalenteri pois
    while(kalenteri.firstChild)
        kalenteri.removeChild(kalenteri.firstChild);
    luoKalenteri("kalenteri", vuosi);
    // päivitä otsikko
    document.getElementById("otsikkovuosi").innerText = vuosi;
    return false; // formin takia
}

var kieli = "fi";
var tp, tk, tv;

function luoKalenteri(elementin_id, vuosi) {
    if (elementin_id === undefined) elementin_id = "kalenteri";
    if (vuosi === undefined) vuosi = new Date().getFullYear();

    var kalenterielementti = document.getElementById(elementin_id);

    var kuukaudet = kuukausitaulu(kieli);
    var viikonpaivat = viikopaivataulu(kieli);

    for (var i= 0 ; i < kuukaudet.length ; ++i) {
        luo_kuukausielementti(i);
    }
    // laskee montako päivää kuussa on, parametrina kuukauden numero
    function paivia_kuukaudessa(kuukausi) {
        // seuraavan kuukauden nollas päivä: sama kuin tämän kuukauden
        // viimeinen päivä
        var paivia = new Date(vuosi, kuukausi+1, 0).getDate();
        return paivia;
    }

    function luo_kuukausielementti(kk) {
        var uusikuukausielementti = document.createElement("div");
        uusikuukausielementti.className = "kuukausidiv";
        kalenterielementti.appendChild(uusikuukausielementti);

        var kuukausiotsikko = document.createElement('h3');
        kuukausiotsikko.appendChild(document.createTextNode(kuukaudet[kk]));
        uusikuukausielementti.appendChild(kuukausiotsikko);

        var nykyinen_kuukausipaiva = new Date(vuosi, kk, 1).getDay();
        var paivia = paivia_kuukaudessa(kk);

        for (var i = 1; i <= paivia; ++i) {
            var paivaelementti = document.createElement('p');
            var viikonpaivaindeksi = nykyinen_kuukausipaiva++ % 7;
            var paiva_str = i + " " + viikonpaivat[viikonpaivaindeksi];
            paivaelementti.appendChild(document.createTextNode(paiva_str));
            if (viikonpaivaindeksi === 0 || viikonpaivaindeksi === 6) {
                paivaelementti.className = "vkonloppu";
            }
            if (tp === i && tk === kk && tv === vuosi) {
                //paivaelementti.class = (paivaelementti.className ? paivaelementti + " " : "") + "tanaan";
                paivaelementti.id = "kalenteri_tanaan";
            }
            uusikuukausielementti.appendChild(paivaelementti);
        }
    }

    function viikopaivataulu(kieli) {
        var tuetut_kielet = ['fi', 'en', 'sv', 'de'];
        var kielitaulut = [
            ['sunnuntai', 'maanantai', "tiistai", 'keskiviikko', 'torstai', 'perjantai', 'lauantai'],
            ['Sunday','Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
            ['söndag', 'måndag', 'tisdag', 'onsdag', 'torsdag', 'fredag', 'lördag'],
            ["Sonntag","Montag","Dienstag","Mittwoch","Donnerstag","Freitag","Samstag"]
        ] ;
        var kieli_indeksi = tuetut_kielet.indexOf(kieli);
        if(kieli_indeksi < 0) kieli_indeksi = 0;
        return kielitaulut[kieli_indeksi];
    }
    function kuukausitaulu(kieli) {
        var tuetut_kielet = ['fi', 'en', 'sv', 'de'];
        var kielitaulut = [
            [ 'tammikuu', 'helmikuu', 'maaliskuu', 'huhtikuu', 'toukokuu', 'kesäkuu', 'heinäkuu', 'elokuu', 'syyskuu',
                'lokakuu', 'marraskuu', 'joulukuu'],
            ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
            [ 'januari', 'februari', 'mars', 'april', 'maj', 'juni', 'juli', 'augusti', 'september', 'oktober', 'november', 'december'],
            ["Januar","Februar","März","April","Mai","Juni","Juli","August","September","Oktober","November","Dezember"]
        ] ;
        var kieli_indeksi = tuetut_kielet.indexOf(kieli);
        if(kieli_indeksi < 0) kieli_indeksi = 0;
        return kielitaulut[kieli_indeksi];
    }
}

function paivita_kieli() {
    var valittukieli = document.getElementById("form.kieli").value;
    kieli = valittukieli;
    paivita_sivu();
}