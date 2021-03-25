function myFunction() {


}


var forme = document.getElementById("formcreq");
var ya = document.getElementById("creqresponse");
var sub2 = document.getElementById("authenticate");
var txt;


xhr.onreadystatechange = function() {
        if(xhr.readyState === 4){
            if(xhr.status ===200){
                txt = xhr.responseText;
            }
            if(xhr.status === 404){
                console.log('File Not Found');
            }
        }
    };

xhr.open('get','creq.txt',true);
xhr.send();



forme.addEventListener('submit', function(event) {
 event.preventDefault();
    if(!txt){
        event.preventDefault();
          alert(txt);

    }else
    {
      sub2.disabled = true;
      event.preventDefault();
      ya.innerHTML = txt;
    }

});

xhr.close;
