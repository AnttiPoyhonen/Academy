'use strict';

var elementti = document.getElementById("pvm");
var paiva = new Date();

elementti.innerHTML = "<p>" + paiva;
elementti.innerHTML += "<p>" + paiva.toLocaleDateString();
elementti.innerHTML += "<p>" + paiva.toLocaleString("fi-FI");
