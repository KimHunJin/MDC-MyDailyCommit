function main() {
	var http = require('http');
	
	http.createServer(function(request, response) {
		response.writeHead(200,{'Content-Type':'text/html'});
		response.end('<h1>hello world man</h1>');
	}).listen(8000,function() {
		console.log('server start');
	});
}

function test() {
	var http = require('http');
	
	http.createServer(function(request, response) {
		response.writeHead(200,{'Content-Type':'text/html'});
		response.write('hello');
		response.write('<br/><h2>hello</h2>');
		response.end('<h1>hello world test</h1>');
	}).listen(8000,function() {
		console.log('server start');
	});
}

function getLog() {
	console.log('dir : ', __dirname);
	console.log('file : ', __filename);
}

function loopMethod() {
	for(var i=1; i<=10;i++) {
		console.log(i);
	}
}

function process() {
	process.argv.forEach(function(item, index) {
		console.log(index + ' : ' + typeof (item) + ' : ' , item);
		
		if(item == '--exit') {
			var exitTime =Number(process.argv[index+1]);
			setTimeout(function() {
				process.exit();
			}, exitTime);
		}
	});
}

function module() {
	var mo = require('./module.js');
	
	console.log('abs(-73) = %d', mo.abs(-273));
	console.log('rad(4) = %d', mo.cicleArea(3));
}

// main();
test();
module();
// process();
// module();
loopMethod();

// main();
// test();
// getLog();

