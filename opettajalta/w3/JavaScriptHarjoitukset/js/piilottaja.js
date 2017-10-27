
function piilota(event) {
    var h2elem = event.target;
    var divelem = h2elem.nextElementSibling;

    if (divelem.style.display === "none") {
        divelem.style.display = "block";
    } else {
        divelem.style.display = "none";
    }
}

function asetakasittelijat() {
    var kaikki = document.getElementsByTagName("h2");
    for(var i = 0 ; i < kaikki.length ; ++i) {
        kaikki[i].onclick = piilota;
    }
}
asetakasittelijat();
