// init var for element ID and insert HTML
var div2 = document.getElementById("2");
if (div2 !== null) div2.innerHTML = "<p><i>Hello world </i>div KAKSI</p>";

// add .innerHTML w/out var
if (document.getElementById("pvm") !== null) document.getElementById("pvm").innerHTML = "<p>" + "Date(): " + new Date();


// date and time to locale w/ var
var pvm = document.getElementById("pvm");
var d = new Date();

if (pvm !== null) pvm.innerHTML += "<p>" + "Local date: " + new Date().toLocaleDateString();

// hours of time, add 0 if time < 10
var h = d.getHours();
if (h < 10) {
    h = "0" + h;
}

// same but with ? (ternary) conditional operator
var min = d.getMinutes();
min = (min < 10) ? "0" + min : min;

var sec = d.getSeconds();
sec = (sec < 10) ? "0" + sec : sec;

if (pvm !== null) pvm.innerHTML += "<p>" + "Local time: " + h + ":" + min + ":" + sec;


// calculating difference between dates
// daysBetween -function
Date.daysBetween = function (d1, d2) {
    
    // one day in ms
    var dayms = 1000 * 60 * 60 * 24;
    
    // conversion of d1 and d2 to ms
    var d1ms = d1.getTime();
    var d2ms = d2.getTime();
    
    // difference in ms
    var diffms = d2ms - d1ms;
    
    // conversion to days & return
    // rounded to full days with .floor
    return Math.floor(diffms / dayms);
}

var valmistuminen = new Date(2017, 11, 15);

var paiviavalmistumiseen = Date.daysBetween(d, valmistuminen);

if (pvm !== null) pvm.innerHTML += "<p>" + "Päiviä Academystä valmistumiseen: " + paiviavalmistumiseen;


// adding an onClick piilota to all h2
var h2s = document.getElementsByTagName("h2");

for (var i = 0; i < h2s.length; i++) {
    h2s[i].setAttribute("onClick", "piilota(this);");
}

// hiding all elements after h2 before the next h2
function piilota (obj) {
            
    if (obj.nextElementSibling.tagName !== "H2") {
        
        var next = obj.nextElementSibling;
    
        do {

            // if not hidden, hide; else show block
            if (!(next.style.display === "none")) {
                next.style.display = "none";
            } else {
                next.style.display = "block";
            }

            next = next.nextElementSibling;
            
        } while (next.tagName !== "H2");
    }
}