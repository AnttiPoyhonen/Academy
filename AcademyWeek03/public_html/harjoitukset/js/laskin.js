// laskin.js, sisältäen yleisimmät laskin-funktiot, joita voidaan käyttää sivulla esim. formeissa. Kaikissa parametreina kaksi lukua (haetaan ID:n perusteella) "#luku1" ja "#luku2"; output kenttään "#tulos".

// add
function add() {
    
    var luku1 = parseInt(document.getElementById("luku1").value);
    var luku2 = parseInt(document.getElementById("luku2").value);
    
    console.log("add: " + luku1 + " " + luku2);
    
    var tulos = luku1 + luku2;
    
    document.getElementById("tulos").value = tulos;  
}

// subtract
function subtract() {
    
    var luku1 = parseInt(document.getElementById("luku1").value);
    var luku2 = parseInt(document.getElementById("luku2").value);
    
    console.log("subtract: " + luku1 + " " + luku2);
    
    var tulos = luku1 - luku2;
    
    document.getElementById("tulos").value = tulos;
}

// times
function times() {
    
    var luku1 = parseInt(document.getElementById("luku1").value);
    var luku2 = parseInt(document.getElementById("luku2").value);
    
    console.log("times: " + luku1 + " " + luku2);
    
    var tulos = luku1 * luku2;
    
    document.getElementById("tulos").value = tulos;  
}


// divide
function divide() {
    
    var luku1 = parseInt(document.getElementById("luku1").value);
    var luku2 = parseInt(document.getElementById("luku2").value);
    
    console.log("divide: " + luku1 + " " + luku2);
    
    var tulos = 0;
    
    if (luku2 === 0) {
        tulos = "Divider cannot be 0!"
    } else {
        tulos = luku1 / luku2;
    }
    
    document.getElementById("tulos").value = tulos;     
}


// exponent
function topowerof() {
    
    var luku1 = parseInt(document.getElementById("luku1").value);
    var luku2 = parseInt(document.getElementById("luku2").value);
    
    console.log("topowerof: " + luku1 + " " + luku2);
    
    var tulos = 0;
    
    if (luku2 == 0) {
        tulos = 1;
    } else if (luku2 == 1) {
        tulos = luku1;
    } else {
        tulos = luku1;
        for (var i = 2; i <= luku2; i++) {
            tulos = tulos * luku1;
        }
    }
    
    document.getElementById("tulos").value = tulos;  
}