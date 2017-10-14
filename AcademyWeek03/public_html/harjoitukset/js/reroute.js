var varoitusajastin;
var siirtoajastin;

function nollaaAjastimet() {

    clearTimeout(siirto);
    clearTimeout(aikavaroitus);
    document.getElementById("timerwarning").style.display = "none";

    varoitusajastin = setTimeout(aikavaroitus, 2000);
}

// warning before reroute
function aikavaroitus() {
    document.getElementById("timerwarning").style.display = "block";
    siirtoajastin = setTimeout(siirto, 10000)
}

// reroute to index.html
function siirto() {
    location.href = "index.html";
}

nollaaAjastimet();

onmousemove = nollaaAjastimet;
onclick = nollaaAjastimet;
onkeypress = nollaaAjastimet;