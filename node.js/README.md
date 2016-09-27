mkdir server-api
cd server-api
npm init


app.js 만들고
npm start


var : 변수 선언
let : 변수 선언 (var과 같으나, let은 중괄호 기준으로 봄.


const : 바로 값 할당 해야 함 (상수 할당)
	ex) const a = 1;
	   이후 a = 2 해버리면 오류남


npm install express --save


** (ubuntu 같은)node 4점대 일 경우 expree 최 상단에 'use strict'; 추가 **



req.params : 파라미터 정보
req.query : 쿼리 정보
req.body :



res.send() : 일방 포맷 가져오기.
res.json() : json 형식을 가져오겠다.



express 에서 제공하는 params 는 문자열이다.

즉, 정수형을 쓰기 위해서는 parseInt를 사용해야 한다.


body parser

npm i body-parser --save

const bodyParser = require('body-parser');

app.use(bodyParser.json());

app.use(bodyParser.urlencoded({extended:true}));


npm 설치 파일

npm install mocha --save-dev   : unit test를 위한 설정

npm install should --save-dev

npm install supertest --save-dev

npm install sequelize mysql --save