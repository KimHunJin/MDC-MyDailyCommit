function getJson() {
	var http = require('http');
	var url = require('url');
	
	http.createServer(function (request, response) {
		var query = url.parse(request.url, true).query;
		
		response.writeHead(200, {'Content-Type':'text/html'});
		response.write('<h1>'+JSON.stringify(query)+'</h1>');
		response.end();
	}).listen(8000,function() {
		console.log('server running');
	});
}


function postJson() {
	var http = require('http');
	var fs = require('fs');
	
	http.createServer(function (request, response) {
		request.on('data', function(data) {
			response.writeHead(200, {'Content-Type':'text/html'});
			response.write('<h1>'+data+'</h1>');
			response.end();
		});
	}).listen(8000,function() {
		console.log('server running');
	});
}

// postJson();
getJson();