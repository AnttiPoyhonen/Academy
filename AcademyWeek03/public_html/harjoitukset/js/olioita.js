function Aforismi(teksti, hlo) {
    
    this.teksti = teksti;
    this.hlo = hlo;
    
    this.getTeksti = function () {
        return this.teksti;
    };
    
    this.getHlo = function () {
        return this.hlo;
    };
    
    this.setTeksti = function (teksti) {
        this.teksti = teksti;
    };
    
    this.setHlo = function (hlo) {
        this.hlo = hlo;
    };
    
    this.toString = function () {
        return '"' + this.teksti + '" - ' + this.hlo;
    };
    
    this.toHtmlString = function () {
        return '<p><i>"' + this.teksti + '"</i> - ' + this.hlo + '</p>';
    }
    
}

var list = document.getElementById("list");
var aforismit = [];

var af1 = new Aforismi("Hei", "Antti");
var af2 = new Aforismi("No moi", "Mirka");
var af3 = new Aforismi("Do not code empty catch-blocks!", "Tommi Teräsvirta");

aforismit.push(af1);
aforismit.push(af2);
aforismit.push(af3);

for (var i = 0; i < aforismit.length; i++) {
    list.innerHTML += "<li>" + aforismit[i].toHtmlString();
}
