function allowDrop(ev) {
    ev.preventDefault();
}

function drop(ev) {
    
    ev.preventDefault();
    
    var files = ev.dataTransfer.files;
    
    for (var i = 0; i < files.length; i++) {
        
        var file = files[i];
        var reader = new FileReader();
        
        reader.onload = function (e) {
            
            var text = reader.result;
            output(text);
            
        }
        
        var nameheader = document.getElementById("filename");
        nameheader.innerHTML += "" + file.name;
        
        reader.readAsText(file, "utf-8");
    }
}

var out = document.getElementById("code");

function output (text) {
        
    console.dir(text);
    
    emptycode(out);
    
    out.innerHTML += text;
    
    reprettify();
    
}

function reprettify() {
    out.classList.remove("prettyprinted");
    PR.prettyPrint();
}

function emptycode(el) {
    while(el.firstChild) {
        el.removeChild(el.firstChild);
    }
}