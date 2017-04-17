'use strict';

const express = require('express');
const app = express();
const bodyParser = require('body-parser');


app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:true}));
app.use('/users', require('./user'));  // 파일 이름이 index일 경우 index를 써주지 않아도 됨.


app.listen(3000, () => {
  console.log('Example app listening on port 3000!');

  require('./model').sequelize.sync({force: true})
  .then(() => {
  	console.log('Databases sync');
  });
});

module.exports = app;