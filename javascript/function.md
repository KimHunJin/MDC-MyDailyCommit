**JavaScript Function**
===================


><h3><b>Function?</b></h3>
>
>- 임의 횟수에 걸쳐 호출되거나 실행될 수 있는 자바스크립트 코드 블록  
>- built-in function : 내장함수 (eval(), parseInt(), ...)
>- custom function : 사용자 정의 함수
>- function은 항상 반환값이 있다.

---------

> **return?** 
>
>- 함수는 항상 리턴 값이 있다.
>- return을 선언해주지 않은 함수는 undefined를 반환한다.

함수는 이상한 놈이라 전달인자(아규먼트)가 매개변수보다 많으면 무시하고
적으면 undefiend 값이 할당

----

> **중첩함수**
>
> - function 안에 function이 있는 함수
> - 함수의 최상위 레벨에서만 정의 가능
> - if문, while문 안에서 사용 불가

-----

>**함수 리터널?**
>
>- 익명함수에 사용
 ```var f = function(x) { return x*x; };```
>- 한 번 쓰고 버려지는 함수일 때 유용 (일회용 함수)

-----

>**함수 명명 규칙(Naming Convention) **
>
>- 동사 or 동사로 시작하는 구절
>- 소문자 시작
>- 단어와 단어 사이 구분은 _ 혹은 대문자
>- 내부적으로 사용 or 숨겨진 함수는 _로 시작

-----

>**가변길이 전달인자**
>
>- Arguments 객체 : 함수에 전달된 전달인자를 이름이 아닌 숫자로 사용할 수 있는 방법 제공
>- arguments : Arguments객체를 참조하는 프로퍼티
>- 함수 전달인자가 3개 이상일 경우 순서를 기억하기가 힘들다.
>- 그래서 객체 프로퍼티를 전달인자로 사용한다.
```

function easycopy(args) {
arraycopy(args.from,
	args.from_start 11 0, !/ 기본값이 제공됨을 확인하라 .
	args.to,
	args.to_st art 11 0,
	args .length) ;
}
var a [1 ,2,3,4];
var b = new Array(4);
easycopy({from:a, tO:b, length:4});

```
> 일회용 함수를 만드는 것이 아니라면 전달인자의 데이터타입을 검사하는 코드를 추가하는 것이 좋음.
> 
```
// 배열(또는 배열과 유사한 객체) a가 가진 원소들의 합을 반환한다.
// 원소들은 모두가 반드시 숫자여야 한다. null, undefined 원소들은 무시한다.
function sum(a) {
	if ((a instanceof Array) || // 만약 배열이거나
		(a && typeof a == "object" && "length" in a)) { //또는 배열과 유사한 객체라면
		var total = 0j
		for(var i = 0; i < a.length; i++) {
			var element a[i];
			if (!element) continue; // 모든 null, undefined 원소를 무시한다.
			if (typeof element == "number") total += element;
			else throw new Error("sum(): 모든 배 열 원소는 반드시 숫자여야 함.");
		}
		return total;
	}
	else throw new Error("sum(): 전달인자는 반드시 배열이어야 함.");
}
```

----

>**함수의 데이터**
>
>- 뭔놈의 자바스크립트는 변수에 함수를 담는것도 되고
>- 함수에 함수를 담아서 함수를 호출하는 것도 되고
>- 그냥 이래저래 신기하네
```
// 간단한 함수들을 몇 개 정의한다.
function add(x,y) { return x + y; }
function subtract(x,y) { return x - y; }
function multiply(x,y) { return x * y; }
function divide(x,y) { return x / y; }

// 여기에 정의한 함수는 위의 연산자 함수 중 하나를 전달인자로 받아서
// 두 개의 피연산자와 함께 호출한다.
function operate(operator, operand1, operand2)
{
	return operaor(operand1, operand2);
}

// (2+3) + (4*5) 같은 수식을 계산하기 위해선 다음과 같이 함수로 호출한다.
var i = operate(add, operate(add, 2, 3), operate(multiply, 4, 5));

// 예를 위하여 위에서 정의한 간단한 함수들을 함수 리터럴을 사용하여
// 다시 정의한다. 함수리터럴들은 객체 리터럴의 안에 두라.
var operators = {
	add :	 	function(x,y) { return x+y; },
	subtract : 	function(x,y) { return x-y; },
	multiply :	function(x,y) { return x*y; },
	divide :	function(x,y) { return x/y; },
	pow :		Math.pow	// 이미 정의되어 있는 함수도 사용할 수 있다.
};

// 이 함수는 연산자 함수의 이름을 전달인자로 받아서 작동한다.
// 객체 안에서 연산자 함수를 검색한 후에, 주어진 피연산자들과 함께 호출한다.
// 연산자 함수를 호출하는 구문을 주의하여 보라.
function operate2(op_name, operand1, operand2)
{
	if(typeof operators[op_name] == "function")
		return operators[op_name](operand1, operand2);
	else throw "unknown operator";
}

// ("hello" + " " + "world") 같은 표현식의 값을 계산하기 위하여
// 다음과 같은 방법으로 함수를 호출할 수 있다.
var j = operate2("add", "hello", operate2("add", " ", "world"));
// 이미 정의된 함수 Math.pow() 함수를 사용하는 예는 다음과 같다.
var k = operate2("pow" 10, 2);
```

----------
>**메서드로서의 함수**
>
>- 객체 o, 메서드 m, 함수 f
 ```o.m = f;```
>- this는 메서드 안에서의 객체를 가리킴

```
var calculator = {
	operand1: 1,
	operand2: 1,
	compute: function() {
		this.result = this.operand1 + this.operand2;
	}
};
calculator.compute();
print(calculator.result);
```
>출력 결과 : 2
>- 여기서의 this는 calculator를 가리킴

----

>**클로저 (Closer)**
>유효범위에서 생기는 이슈
>주로 중첩된 함수를 만들면서 생기는 이슈로 많이 고려해야 함.
>자세한 것은... 다음번에 ^^ (함수의 범위로 다루기엔 너무 광범위..)

----

>**출처**
자바스크립트 완벽가이드 JavaScript The Definitive Guide 5/E
