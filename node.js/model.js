const Sequelize = require('sequelize');
const sequelize = new Sequelize('api_server','root','mosquito');

const User = sequelize.define('user', {
	name: Sequelize.STRING
});

module.exports = {
	sequelize: sequelize,
	User: User
}