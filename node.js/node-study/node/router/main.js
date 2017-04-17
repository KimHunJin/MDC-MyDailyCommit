module.exports = function(app, fs) {
	app.get('/keyboard', function(req, res) {
		fs.readFile(__dirname +  "/../data/"+"keyboard.json",'utf8', function(err, data) {
			console.log(data);
			res.end(data);
		});
	});
	
	
	app.post('/message', function(req, res) {
		var result = { };
		// if(!req.body["user_key"] || !req.boyd["type"] || !req.body["content"]) {
		// 	result["success"] = 0;
		// 	result["error"] = "invalid request";
		// 	res.json(result);
		// 	return;
		// }
		
		// console.log(req.body["content"]);
		
		var messageObject = new Object();
		var resultObject = new Object();
		
		var text = "";
		
		
		if(req.body["content"]=="안녕") {
			text = "나도 안녕";
		} else if(req.body["content"]=="만든이") {
			text = "Developed by Mosquito";
		} else if(req.body["content" == "시작하기"]) {
			text = "아무말이나 입력해주세요";
		} else {
			text = "무슨 소리 하시는건가요?";
		}
		
		messageObject.text = text;
		
		resultObject.message = messageObject;
		
		var resultJson = JSON.stringify(resultObject);
		
		res.send(resultJson);
		
		
		// if(req.body["content"] == "도움말" || req.body["content"]=="시작하기"||req.body["content"]=="만든이") {
		// 	fs.readFile(__dirname + "/../data/message.json", 'utf8', function(err, data) {
		// 		var messages = JSON.parse(data);
		// 		if(req.body["content"] == "도움말") {
		// 			messages["message"] = {"text" : " 메시지"};
		// 		} else if (req.body["content"] == "시자하기") {
		// 			messages["message"] = {"text" : "시작"};
		// 		} else {
		// 			messages["message"] = {"text" : "개발"};
		// 		}
		// 		fs.writeFile(__dirname + "/../data/message.json", JSON.stringify(messages, null, '\t'), "utf8", function(err, data) {
					
		// 		});
		// 		fs.readFile(__dirname + "/../data/message.json", 'utf8', function(err, data) {
		// 			console.log("request_user_key : " + req.body["user_key"]);
		// 			console.log("request type : keyboard - " + req.body["content"]);
		// 			res.end(data);
		// 			return;
		// 		});
		// 	});
		// }
	});
};