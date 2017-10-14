// create and insert a nav element as firstchild of body
var body = document.body;
var nav = document.createElement("nav");
var content = document.getElementById("content");

content.style.cssText = "margin-top: 120px; margin-left: 5%; margin-right: 5%;";

// insert nav.css stylesheet to page
var head = document.head;
head.innerHTML += '<link rel="stylesheet" href="css/nav.css">';

// insert nav before current firstChild
if (body.firstChild === null) {
    body.appendChild(nav);
} else {
    body.insertBefore(nav, body.firstChild);
}

nav.style.position = "fixed 0 0";

// insert all links
nav.innerHTML += "<span>" + "Navigation: ";


/*
<div class="dropdown">
  <button class="dropbtn">Dropdown</button>
  <div class="dropdown-content">
    <a href="#">Link 1</a>
    <a href="#">Link 2</a>
    <a href="#">Link 3</a>
  </div>
</div> */


// HTML links

nav.innerHTML += '<div class="dropdown" id="navHTML">';
var navHTML = document.getElementById("navHTML");

navHTML.innerHTML += '<button class="dropbtn" id="buttonHTML">' + "HTML";

navHTML.innerHTML += '<div class="dropdown-content" id="dropdownHTML">';
var dropdownHTML = document.getElementById("dropdownHTML");

dropdownHTML.innerHTML += '<a href="index.html">' + "Home";
dropdownHTML.innerHTML += '<a href="listat.html">' + "Listat";
dropdownHTML.innerHTML += '<a href="hinnasto.html">' + "Hinnasto";
dropdownHTML.innerHTML += '<a href="tarjouspyynto.html">' + "Tender Request";


// CSS links

nav.innerHTML += '<div class="dropdown" id="navCSS">';
var navCSS = document.getElementById("navCSS");

navCSS.innerHTML += '<button class="dropbtn" id="buttonCSS">' + "CSS";

navCSS.innerHTML += '<div class="dropdown-content" id="dropdownCSS">';
var dropdownCSS = document.getElementById("dropdownCSS");

dropdownCSS.innerHTML += '<a href="tyylitjakuvat.html">' + "Tyylit ja kuvat";
dropdownCSS.innerHTML += '<a href="tekstityylit.html">' + "Tekstityylit";


// JS links

nav.innerHTML += '<div class="dropdown" id="navJS">';
var navJS = document.getElementById("navJS");

navJS.innerHTML += '<button class="dropbtn" id="buttonJS">' + "JS";

navJS.innerHTML += '<div class="dropdown-content" id="dropdownJS">';
var dropdownJS = document.getElementById("dropdownJS");

dropdownJS.innerHTML += '<a href="JSHarjoitukset.html">' + "JS Harjoitukset";
dropdownJS.innerHTML += '<a href="reroute.html">' + "Rerouting";
dropdownJS.innerHTML += '<a href="kalenteri.html">' + "Kalenteri";
dropdownJS.innerHTML += '<a href="hakulomake.html">' + "Hakulomake";
dropdownJS.innerHTML += '<a href="junat.html">' + "junat";
dropdownJS.innerHTML += '<a href="dragndrop.html">' + "Drag 'n' Drop";
dropdownJS.innerHTML += '<a href="olioita.html">' + "JS Olioita";


// JQuery links

nav.innerHTML += '<div class="dropdown" id="navJQ">';
var navJQ = document.getElementById("navJQ");

navJQ.innerHTML += '<button class="dropbtn" id="buttonJQ">' + "JQ";

navJQ.innerHTML += '<div class="dropdown-content" id="dropdownJQ">';
var dropdownJQ = document.getElementById("dropdownJQ");

dropdownJQ.innerHTML += '<a href="JQuery1.html">' + "JQuery 1";
dropdownJQ.innerHTML += '<a href="JQuery2.html" id="JQ2link">' + "JQuery 2";
dropdownJQ.innerHTML += '<a href="ajaximg.html">' + "AJAX Images";
dropdownJQ.innerHTML += '<a href="contents.html">' + "Table of Contents";
