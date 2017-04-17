

function listen() {
	var http = require('http');
	
	var server = http.createServer();
	
	server.on('request', function (code) {
		console.log('Request On');
	});
	
	server.on('connection', function(code) {
		console.log('Connection On');
	});
	
	server.on('close', function(code) {
		console.log('Close');
	});

	server.listen(8000);
}



function firstWeb() {
	var http = require('http');
	var server = http.createServer(function(request, response) {
		response.writeHead(200,{'Content-Type':'text/html'});
		response.write('<h1>Hell world</h1>');
	});
	
	server.listen(8000, function() {
		console.log('server running');
	});
}

function readHTML() {
	var fs = require('fs');
	var http = require('http');
	
	var server = http.createServer(function(request, response) {
		fs.readFile('index.html', function(error, data) {
			response.writeHead(200, {'Content-Type':'text/html'});
			response.end(data);
		});
	});
	
	server.listen(8000,function() {
		console.log('server running');
	});
}

readHTML();
// firstWeb();