$(function () {    
   
    $('<br>').insertAfter('h1');
    $toc = $('<ol id="contents"></ol>').insertAfter('h1');
    $('<br>').insertAfter('h1');
    
    var ids = 0;
    $h2 = null;
    $h2ul = null;
    
    $("h2, h3").each(function (i) {
        
        // create a running ID and div for toc link
        var id = "tocID" + (++ids);
        $('<div id=' + id + '></div>').insertBefore($(this));
        
        // check which tagNames are checked
        // console.log($(this).get(0).tagName);
        
        // check if h2 or h3
        if ($(this).get(0).tagName === "H2") {
            
            $toc.append('<li><a href="#' + id + '">' + $(this).text() + '<a></li>');
            
            // if h2, assign h2 to $h2 for appending a ul to $h2ul
            $h2 = $toc.children().filter(":last");
            $h2ul = $('<ul></ul>').appendTo($h2);
                        
        } else if ($(this).get(0).tagName === "H3") {
            
            // append to the last assigned h2ul
            $h2ul.append('<li><a href="#' + id + '">' + $(this).text() + '<a></li>');
        }
        
    });
    
});