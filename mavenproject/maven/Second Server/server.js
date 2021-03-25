var express = require('express');
var path = require('path');
var app = express();


app.use(express.static(path.join(__dirname, "public")));

app.get("/", function(req, res){
  res.status(200).sendFile(__dirname, "public", "index.html");

});
app.get("/home", function(req, res){
  res.send("hi");
});


app.listen(3030, function(){
  console.log("We are listining to port 3030");
});
