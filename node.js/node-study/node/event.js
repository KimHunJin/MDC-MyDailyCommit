process.on('exit', function(code) {
	console.log('bye');
});

// process.on('uncaughtException', function(error) {
// 	console.log('error');
// });

var onUncaughtException = function(error) {
	console.log('exception');
	
	process.removeListener('uncaughtException', onUncaughtException);
	
};

function error_test() {
	
	var count = 0;
	var test = function() {
		count = count + 1;
		if(count > 3) {
			return;
		}
		
		setTimeout(test, 2000);
		error.error.error();
	};

	setTimeout(test,2000);
}


function uncaughtexception() {
	
	process.on('uncaughtException',onUncaughtException);
	
	var test =  function() {
		setTimeout(test,2000);
		error.error.error();
	};	
	
	setTimeout(test,2000);
}

function forceEvent() {
	process.on('exit', function(code) {
		console.log('bye');
	});
	
	process.exit();
	
	process.emit('exit');
	process.emit('exit');
	process.emit('exit');
	process.emit('exit');
	
	console.log('running');
}


function customEventListener() {
	var custom = new process.EventEmitter();
	
	custom.on('tick',function(code) {
		console.log('running event');
	});
	
	custom.emit('tick');
}

function timerEvent() {
	var rint = require('./rint');
	rint.timer.on('tick', function(code) {
		console.log('event running');
	});
}


timerEvent();