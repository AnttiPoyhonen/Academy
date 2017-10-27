

(function() {
    function foo(param) {
        if (param === undefined) {
            param = "<määrittelemätön>";
        }
        console.log("kutsuit foota parametrilla: " + param);
    }
    foo("terve");
    foo(1);
    foo(1 === 2);
    foo(1, 2, 3);
    var muu = foo();
    console.log(muu);

})();





// var taulu = [];
// for (var i = 0; i < 5; i++) {
//     taulu.push("Numero: " + i.toString())
// }
// console.log(taulu);
//
// for(var nro in taulu) {
//     console.log(nro);
// }

