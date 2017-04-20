1. npm install express -g express-generator@4

2. express kakao && npm install

3. mkdir data

4. cd data

5. vi keyboard.json
{
	"type" : "buttons",
	"buttons" : ["도움말", "시작하기", "만든이"]
}

6. cd ../routes

7. vi kakao.js
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

8. cd ..

9. vi app.js
var fs = require('fs'); // insert the internal module
var kakao = require('./routes/kakao')(app, fs); // insert before exception
