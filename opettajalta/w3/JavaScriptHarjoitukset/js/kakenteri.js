function luoKalenteri(elementin_id) {
    var kalenterielementti = document.getElementById(elementin_id);
    var kuukaudet = {
        'tammi': 31, 'helmi': 28, 'maalis': 31,
        'huhti': 30, 'touko': 31, 'kesä': 30,
        'heinä': 31, 'elo': 31, 'syys': 30,
        'loka': 31, 'marras': 30, 'joulu': 31
    };
    var viikonpaivat = ['sunnuntai',
        'maanantai',
        'tiistai',
        'keskiviikko',
        'torstai',
        'perjantai',
        'lauantai'];
    var vuodenpaiva = 0;


    for (var kuukausi in kuukaudet) {
        // luo_kuukausielementti_v1(kuukausi);
        luo_kuukausielementti_v2(kuukausi);
    }

    function luo_kuukausielementti_v1(kk) {
        var uusielementti = document.createElement("p");
        var tekstisisalto = kk + "kuu: " + kuukaudet[kk];
        var teksisolmu = document.createTextNode(tekstisisalto);
        uusielementti.appendChild(teksisolmu);
        kalenterielementti.appendChild(uusielementti);
    }


    //<editor-fold desc="Versio 2">
    function luo_kuukausielementti_v2(kk) {
        if (!viikonpaivat) viikonpaivat = ['sunnuntai',
            'maanantai',
            'tiistai',
            'keskiviikko',
            'torstai',
            'perjantai',
            'lauantai'];
        var uusikuukausielementti = document.createElement("div");
        kalenterielementti.appendChild(uusikuukausielementti);

        var kuukausiotsikko = document.createElement('h3');
        kuukausiotsikko.appendChild(document.createTextNode(kk + "kuu"));
        uusikuukausielementti.appendChild(kuukausiotsikko);


        for (var i = 1; i <= kuukaudet[kk]; ++i) {
            var paiva_elementti = document.createElement('p');
            var paiva_str = i + " " + viikonpaivat[vuodenpaiva++ % 7] + " " + (vuodenpaiva % 7);
            paiva_elementti.appendChild(document.createTextNode(paiva_str));
            uusikuukausielementti.appendChild(paiva_elementti);
        }
    }

    //</editor-fold>


}