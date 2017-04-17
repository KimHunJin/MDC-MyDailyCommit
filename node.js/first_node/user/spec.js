const should = require('should'); // assert : node에서 제공하는 기본 라이브러리
const request = require('supertest');
const app = require('../express');


describe('GET /users', () => { // 보통 API 이름으로 적어준다.
	//...
	it('should return 200 status code and return array with 3 length', () => {
		//...
		request(app)
			.get('/users')
			.expect(200)
			.end((err, res) => {
				if(err) throw err;
				res.body.should.be.an.instanceOf(Array);
				res.body.should.have.length(3);
				done();
			})
	}); // 이 테스트는 어떤 식인지에 대한 서술식 설명
});

describe('GET /users/:id', () => {
	it('should return user object', done => {
		request(app)
		.get('/users/1')
		.expect(200)
		.end((err, res) => {
			if(err) throw err;
			res.body.should.have.property('id',1);
			res.body.should.have.property('name','alice');
          	done();
		});
	});

	it('should return 400 status code with string id', done => {
    request(app)
        .get('/users/abc')
        .expect(400)
        .end((err, res) => {
          if (err) throw err;
          res.body.should.have.property('error');
          done();
        });
    });

    it('should return 404 status code with no id', done => {
    request(app)
        .get('/users/4')
        .expect(404)
        .end((err, res) => {
          if (err) throw err;
          res.body.should.have.property('error');
          done();
        });
    });
});

describe('POST /users', () => {
	it('should return new user object', done=> {
		request(app)
		.post('/users')
		.expect(201)
		.send({name: 'daniel'})
		.end((err, res) => {
			if(err) throw err;
			res.body.should.have.properties('id', 'name');
			done();
		});
	});
});

describe('DELETE /users/:id', () => {
	it('should return 204 status code', done => {
		request(app)
		.delete('/users/1')
		.expect(204)
		.end((err, res) => {
			if(err) throw err;
			res.body.should.have.properties('error');
			done();
		});
	});

	it('should return 404',done => {
		request(app)
		.delete('/users/abc')
		.expect(400)
		.end((err, res) => {
			if (err) throw err;
			res.body.should.have.property('error');
			done();
		});
	});
});