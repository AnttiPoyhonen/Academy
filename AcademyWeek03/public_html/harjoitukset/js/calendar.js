var kk = {"January": "31", "February": "28", "March": "31", "April": "30", "May": "31", "June": "30", "July": "31", "August": "31", "September": "30", "October": "31", "November": "30", "December": "31"};

var vko = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"];

function createCalendar(element) {

    var cal = document.getElementById(element);
    
    // add Calendar-h1 and the year input field TODO
    var header = document.createElement("h1");
    cal.appendChild(header);
    
    var headertext = document.createTextNode("Calendar");
    header.appendChild(headertext);
    
    var br = document.createElement("p");
    br.appendChild(document.createTextNode(" "));
    cal.appendChild(br);
    
    /*
    var yearDay = 0;
    
    var year = document.getElementById("year").value;
    
    var date = Date(year, 0, 1);
    console.log(date); 
*/
    for (var s in kk) {

        var p = document.createElement("p");
        var text = document.createTextNode(s + ": " + kk[s]);

        p.appendChild(text);
        cal.appendChild(p); 

        var day = null;
        var dayp = null;
        var text2 = null;

        for (var i = 0; i < kk[s]; i++) {
            day = document.createElement("div");
            dayp = document.createElement("p");
            text2 = document.createTextNode((i + 1) + " - " + vko[yearDay++%7]);
            // find the weekday by looping through 0-6 with yearDay++%7

            dayp.appendChild(text2);
            day.appendChild(dayp);
            cal.appendChild(day);
        }

    }
    
}
