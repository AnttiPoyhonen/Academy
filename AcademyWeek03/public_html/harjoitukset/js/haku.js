var list = document.getElementById("list");

// create a XMLHttpRequest obj to report acquired data (to console.dir or to show it)
var req = new XMLHttpRequest();
req.onreadystatechange = function() {
    
    // if really ready and everything finished (== 4)
    if (req.readyState === 4) {
        
        // JSON from XHR
        var jsonObj = JSON.parse(req.responseText);
        
        // report acquired data
        console.dir(jsonObj);
        
        // create list items from the JSON
        for (var i = 0; i < jsonObj.length; i++) {
            
            // IF only want to print each associative array to new list items
            // list.innerHTML += "<li>" + JSON.stringify(jsonObj[i]);
            
            //*
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
            
            /*
            for (var ) {
                
                console.log(j);
                
                // create text node from each item of the rows in json
                var itemtext = document.createTextNode(String.join(jsonObj[i][j] + ": " + jsonObj[i].jsonObj[i][j]);
                li.appendChild(itemtext);
                
                if (j < jsonObj[i].length - 1) {
                    var mid = document.createTextNode(", ");
                    li.appendChild(mid);
                }
            }
            
            /*
            for (var item in jsonObj[i]) {
                var itemtext = document.createTextNode(item + ": " + jsonObj[i][item] + ", ");
                li.appendChild(itemtext);
            }
            */
                             
        }
    }
}

function emptylist() {
    while(list.firstChild) {
        list.removeChild(list.firstChild);
    }
}

function search() {
    
    // empty the old list
    emptylist();
    
    // launch the request
    // true = asynch (ajax)
    req.open("GET", "http://localhost:3000/api/personnel", true);
    
    // set send-data to null if there is nothing to send to server
    req.send(null);
}