const model = require('../model');

let users = [
  {
    id: 1,
    name: 'alice'
  },
  {
    id: 2,
    name: 'bek'
  },
  {
    id: 3,
    name: 'chris'
  }
]

exports.index = (req, res) => {
	// res.json(users);	
	model.User.findAll()
	.then(users => res.json(users));	
};

exports.show = (req, res) => {
	const id =parseInt(req.params.id, 10);
	model.User.findOne({
    	where: {
    	  id: id
    	}
  	}).then(user => {
    
    	if (!user) {
      	return res.status(404).json({error: 'No User'});
    	}

	    return res.json(user);
	});

		// get id
	// const id = parseInt(req.params.id,10);
		// id can't found (null)
	// if(!id) {
	// 	return res.status(400).json({error:'Invalid id'}); // errcode 400으로 json 형식의 invalid id 라는 에러 메시지 반환
	// }

		// find id
	// const user = users.filter(user => user.id === id).pop(); // 없는 아이디를 검색할 경우 undefined가 들어가게 됨.
		// there is no user
	// if(!user) {
	// 	return res.status(404).json({error:'No User'}); // errcode 404으로 json 형식의 No User 라는 에러 메시지 반환	
	// }

		// response value
	// res.json(user); // json 형식으로 user 값 반환.
};

exports.destroy = (req, res) => {
		// want delete id
	const id =parseInt(req.params.id, 10);
	if(!id) {
		return res.status(400).json({error:'Invalid id'});
	}
		// use databases
	model.User.destroy({
		where: {
			id: id
		}
	}).then(count => {
		if(!count) { // 없을 때
			return res.status(404).json({error:'No User'});
		}	
		res.status(204).send();
	})

		// find index
	// const userIdx = users.findIndex(user => user.id === id);
	// if(userIdx === -1) {
	// 	return res.status(404).json({error: "No User"});
	// }

		// remove
	// users.splice(userIdx, 1)  // userIdx를 포함해서 몇개를 지울 것인가.

	// res.status(204).send();
};

exports.create = (req,res) => {
	// name
	let name = req.body.name || false;
	name = name.toString().trim();
	if(!name) {
		res.status(400).json({error: 'Invalid name'});
	}

	model.User.create({
		name: name
	}).then(user => {
		res.status(201).json(user);		
	});

		// // id
	// const id = users.reduce((maxId, user) => {
	// 	return user.id > maxId ? user.id : maxId;
	// }, 0) + 1;

		// // new user

	// const user = {
	// 	id: id,
	// 	name: name
	// };
	// // push

	// users.push(user);
	// res.status(201).json(user);
};