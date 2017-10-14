var list = document.getElementById("trains");

// create a XMLHttpRequest obj to report acquired data (to console.dir or to show it)
var req = new XMLHttpRequest();

req.onreadystatechange = function() {
    
    if (req.readyState < 4) {
        console.log(req.readyState);
    }
    // if really ready and everything finished (== 4)
    if (req.readyState === 4) {
        
        // JSON from XHR
        var junat = JSON.parse(req.responseText);
        
        // report acquired data
        console.dir(junat);
        
        // create list items from the JSON
        for (var i = 0; i < junat.length; i++) {
            
            // IF only want to print each associative array item to new list items
            // list.innerHTML += "<li>" + JSON.stringify(jsonObj[i]);
            
            var juna = "Juna: " + junat[i].trainType + junat[i].trainNumber;
            
            var leaves = Date(junat[i].timeTableRows[0].scheduledTime);
            
            juna += "<br>" + "Lähtöaika HKI: " + leaves + "<br><br>"; 
            
            
            list.innerHTML += "<li>" + juna;
            
            /*
            // append list item to list
            var li = document.createElement("li");
            list.appendChild(li);

            // loop through items in json to add associative items
            var rowObj = jsonObj[i];
            var proptexts = [];

            for (var property in rowObj) {
                var proptext = property + ": " + rowObj[property];
                proptexts.push(proptext);
            }
            li.appendChild(document.createTextNode(proptexts.join(" - ")));
            */
                      
        }
    }
}

function emptylist() {
    while(list.firstChild) {
        list.removeChild(list.firstChild);
    }
}

function haejunat() {
    
    // empty the old list
    emptylist();
    
    // launch the request
    // true = asynch (ajax)
    req.open("GET", "https://rata.digitraffic.fi/api/v1/live-trains/station/HKI/LH", true);
    
    // set send-data to null if there is nothing to send to server
    req.send(null);
}