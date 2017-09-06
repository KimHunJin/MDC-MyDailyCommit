var mysql = require('mysql');
var http = require('http');
var express = require('express');
var bodyParser = require('body-parser');

var client = mysql.createConnection({
	host: '117.123.102.30',
	port: '3306',
	user: 'mos',
	password: 'mosquito',
	database: 'RailoTalk'
});

client.connect(function(err) {
	if (err) {
		console.error('mysql connect error');
		console.error(err);
		throw err;
	}
});

var app = express();
app.use(bodyParser.urlencoded({
	extended: false
}));


app.get('/',function(req,res) {
	var value = { };
	client.query('select * from `RailoInfo`', function(error, result, field) {
		if(error) {
			value['err'] = 500;
			// console.error(error);
			// throw(error);
		} else {
			value['err'] = 200;
			value['result'] = result;
		}
		res.json(value);
	});
});

app.get('/railo/:number',function(req, res) {
	var value = { };
	client.query('select count(*) as count from `RailoInfo` where `railo_number` = ?',[req.params.number], function(error, result, field) {
		if(error) {
			value['err'] = 500;
			console.log(error);
		} else {
			value['err'] = 200;
			value['number'] = result[0].count;
		}
		res.json(value);
	});
});

app.get('/room/:number',function(req, res) {
	var value = { };
	client.query('select `has_room` from `UserInfo` where `kakao_id` = ?', [req.params.number], function(error, result, field) {
		if(error) {
			value['err'] = 500;
			console.error(error);
		} else {
			if(result[0].has_room == '0') {
				value['err'] = 404;
			} else {
				value['err'] = 200;
				value['room'] = result[0].has_room;
			}
			res.json(value);
		}
	});
});

app.post('/insert', function(req,res) {
	
	var body = req.body;
	
	var value = { };
	
	// console.log('body'+body.name);
	// console.log('body'+body.image);
	// console.log('body'+body.same);
	// console.log('body'+body.other);
	// console.log('body'+body.say);
	client.query('insert into `UserInfo`(kakao_id, kakao_name, kakao_thumbnail_image, gender, same_gender, other_gender, say) ' +
				 'select ?,?,?,?,?,?,? from dual where not exists (select `kakao_id` from `UserInfo` where `kakao_id` = ?)',
				 [body.id,body.name,body.image,body.gender,body.same,body.other,body.say,body.id], 
				 function(error, result, field) {
			if(error) {
				console.error(error);
				throw error;
			} else {
				value['err'] = 200;
			}
		res.json(value);
	});
});


app.get('/user/:number', function(req, res) {
	var value = { };
	var body = req.body;
	client.query('select count(*) as count from `UserInfo` where kakao_id = ?', 
				[req.params.number],
				function(error, result, field) {
		if (error) {
			console.error(error);
			throw error;
		} else {
			var count = result[0].count;
			if(count > 0) {
				value['result'] = true;
			} else {
				value['result'] = false;
			}
			res.json(value);
		}
	});
});


app.post('/update', function(req, res) {
	var body = req.body;

	var value = { };
	
	client.query('update `UserInfo` set has_room = ? where kakao_id = ?',
					[body.room,body.id],
					function(error, result, field) {
			if(error) {
				console.error(error);
				throw error;
			} else {
				value['err'] = 200;
			}
	});
	res.json(value);
});

app.post('/update/deleteRoom', function(req, res) {
	var body = req.body;
	var value = { };
	client.query('update `UserInfo` set has_room = 0 where kakao_id = ?',
				 [body.id],
				 function(error, result, field) {
		if(error) {
			console.error(error);
			throw error;
		} else {
			value['err'] = 200;
		}
		res.json(value);
	});
});

app.post('/update/userinfo', function(req, res) {
	var body = req.body;
	var id = body.id;
	var gender = body.gender;
	var say = body.say;
	
	client.query('update `UserInfo` set gender = ?, say = ? where kakao_id = ?',
				[gender,say,id],
				function(error, result, field) {
			if(error) {
				console.error(error);
				throw error;
			}
	});
});


app.listen(8000,function() {
	console.log('server running');
});



// var server = http.createServer(function (resquest, response) {
	
// 	response.writeHead(200, {'Content-Type':'application/json'});
// 	response.end(JSON.stringify(results));
	
// });

// server.listen(8000, function() {
// 	console.log('server start');
// });