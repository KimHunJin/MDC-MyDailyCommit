var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var session = require('express-session');
var fs = require("fs");
 
var server = app.listen(8000, function(){
 console.log("Express server has started on port 8000");
});
 
app.use(bodyParser.json());
app.use(bodyParser.urlencoded());
app.use(session({
 secret: '@#@$MYSIGN#@$#$',
 resave: false,
 saveUninitialized: true
}));
 
 
var router = require('./router/main')(app, fs);