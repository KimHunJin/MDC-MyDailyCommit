1. npm install express -g express-generator@4

1. express kakao && npm install

1. mkdir data

1. cd data

1. vi keyboard.json
{
	"type" : "buttons",
	"buttons" : ["도움말", "시작하기", "만든이"]
}

1. cd ../routes

1. vi kakao.js

“`
module.exports = function(app, fs) {
	app.get('/keyboard', function(req, res) {
		fs.readFile(__dirname + "/../data/"+"keyboard.json",'utf8', function(err, data) {
			console.log(data);
			res.end(data);
		});
	});

	app.post('/message', function(req, res) {
		var result = { };
		
		var messageObject = new Object();
		var resultObject = new Object();
		
		var text = "";
		
		if(req.body.content == "안녕") {
			text = "나도 안녕";
		} else if(req.body.content == "만든이") {
			text = "Developed by Mosquito";
		} else if(req.body.content == "시작하기") {
			text = "아무말 입력";
		} else {
			text = "뭔소리여";
		}
		
		messageObject.text = text;
		resultObject.message = messageObject;
		var resultJson = JSON.stringify(resultObject);
		res.send(resultJson);
	});
};
“`

1. cd ..

1. vi app.js

“`
var fs = require('fs'); // insert the internal module
var kakao = require('./routes/kakao')(app, fs); // insert before exception
“`