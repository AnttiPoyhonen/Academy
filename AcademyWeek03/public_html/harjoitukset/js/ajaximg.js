$(function(){    
   
    var input = "";
    
    // on click
    $("#search").on("click", search); 
    
    
    // search function
    function search () {
                
        input = $("#searchtag").val();
        
        if (input === "") {
            input = "cat";
            alert('Empty search, looking for "cat" instead.');
        }
                
        // JSON GET, taking input
        $.getJSON('http://api.flickr.com/services/feeds/photos_public.gne?jsoncallback=?',
        {
            tags: input,
            tagmode: "any",
            format: "json"
        }).done(function(data) { 
            clearsearch();
            addimgs(data);
        });
        
    };
    
    
    // loop through the data json and add imgs as list items
    function addimgs (json) {
        
        $('<p style="display: inline; margin-left: 10px; font-weight: bold;">Looking for: ' + ' "' + input + '"</p>').insertAfter($("#search"));
        
        var items = json.items;
        $img = $("#images");
                
        for (var i = 0; i < items.length; i++) {
            
            // console.log(items[i]);
            
            var src = '<img src="' + items[i].media.m + '">';
            var capt = items[i].description;
            
            // console.log(src + " - " + capt);
            
            // add and access the added figure
            $img.append('<figure style="float: left; border: 1px solid black; padding: 5px; margin: 5px 1%; width: 22%; min-width: 240px; overflow-wrap: break-word;"></figure>');
            $fig = $img.children().last();
            
            // add a figcaption and an img w/ src 
            $fig.append('<figcaption>' + capt + '</figcaption>');
            
            // separate src; figcaption includes an img tag!
            // $fig.append(src);
                        
        }
        
    }
    
    function clearsearch () {
        $("#search").next("p").remove();
        $("#images").children().remove();
    }
    
});
