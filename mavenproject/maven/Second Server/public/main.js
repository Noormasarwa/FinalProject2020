function myFunction() {


}

var password = document.getElementById("password");
var form = document.getElementById("authform");
var sub = document.getElementById("authenticatee");
var y = document.getElementById("responsee");
var realtimepass;

const xhr =new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4){
            if(xhr.status ===200){
                realtimepass = xhr.responseText;
            }
            if(xhr.status === 404){
                console.log('File Not Found');
            }
        }
    };

xhr.open('get','response.txt',true);
xhr.send();


form.addEventListener('submit', function(event) {
 event.preventDefault();
    if(!realtimepass){
        event.preventDefault();
        y.innerHTML = "There is no request to authenticate";

        setTimeout(function(){window.location.reload();}, 1500);


    }else if(!password.value){
            y.innerHTML = "error you dint enter your password";
        }
        else if(password.value === realtimepass){
            var x= "completed";
            y.innerHTML = x;
            password.disabled =true;
            sub.disabled =true;

        }
        else{

            y.innerHTML ="password Invalid pasword try again";
        }


});

xhr.close;
