(function () {
    var timer_varoitus;
    var timer_siirtyminen;
    var varoituspopup = document.getElementById('varoitus');

    function alustaAjastimet() {
        var ODOTUSAIKA = 10000;   // Millisekunteja, 10 sekuntia
        console.log("Nollataan ja käynnistetään ajastimet");
        // Piilotetaan varoitusikkuna
        varoituspopup.style.display = 'none';
        // Nollataan ajastimet
        clearTimeout(timer_varoitus);
        clearTimeout(timer_siirtyminen);
        // Käynnistetään ajastimet
        timer_varoitus = setTimeout(naytaVaroitus, ODOTUSAIKA / 2);
        timer_siirtyminen = setTimeout(siirryMuualle, ODOTUSAIKA);
    }

    function naytaVaroitus() {
        console.log("Varoitus laukesi"); // also show in the console
        varoituspopup.style.display = 'block';
    }

    function siirryMuualle() {
        console.log("Ohjataan muualle"); // ei välttämättä juuri näy konsolissa
        window.location.href = 'laskin.html';
    }

    // Asetetaan tapahtumankäsittelijät sekä hiiri- että näppäintapahtumille
    // keydown tunnistaa myös nuoli-näppäimet kaikilla selaimilla, keypress vain joillakin
    document.onkeydown = alustaAjastimet;
    document.onmousemove = alustaAjastimet;

    alustaAjastimet();

})();
