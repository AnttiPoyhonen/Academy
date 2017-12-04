const baseeurl = 'api/';

export function fetchall(callback) {
    fetch(baseeurl+'sanonnat', {accept: 'application/json'})
        .then(function(response) {
            response.json().then(function(json) {
                if (response.status >= 500)
                    callback(json, response.status);
                else
                    callback(json);
            });
        });
}

export function fetchone(id, callback) {
    fetch(baseeurl+'sanonnat/'+id, {accept: 'application/json'})
        .then(function(response) {
            response.json().then(function(json) {
                if (response.status >= 500)
                    callback(json, response.status);
                else
                    callback(json);
            });
        });
}

// palauttaa promisen, eikä kutsu callbackiä
export function deletequote(id/*, callback*/) {
    return fetch(baseeurl+'sanonnat/'+id, {method: 'DELETE'})
        .then(function(response){
            //callback();
        })
}

export function createquote(quote, callback) {
    fetch(baseeurl+'sanonnat/',  {
        method: 'POST',
        headers: {'Content-Type': 'application/json' },
        body: JSON.stringify(quote)
    })
        .then((function(response) {
            callback();
        }));
}

export function updatequote(quote, callback) {
    fetch(baseeurl+'sanonnat/'+quote.id,  {
        method: 'PUT',
        headers: {'Content-Type': 'application/json' },
        body: JSON.stringify(quote)
    })
        .then((function(response) {
            callback();
        }));
}

export function resetdata(callback) {
    fetch(baseeurl+'reset', {method: 'GET'})
        .then(function(response) {
            response.json().then(function(json) {
                //console.log("Service client:");
                //console.log(json);
                if (!callback) return;
                if (response.status !== 201)
                    callback(json, response.status);
                else
                    callback(json);
            });
        });
}

export function deleteall(callback) {
    return fetch(baseeurl+'sanonnat', {method: 'DELETE'})
        .then(function(response){
            if (callback)
                callback();
        })
}
