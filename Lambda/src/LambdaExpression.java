/**
 * Created by HunJin on 2016-09-16.
 */
public class LambdaExpression {

    public static void main(String[] args) {
	  Runnable lambda = () -> System.out.println(1); // 익명함수
	  lambda.run();

	  new LambdaExpression().print();
	
	}

    /**
	 * using lambda
	 * 객체 생성 유무 판단
	 */
	void print() {
	  Runnable anonClass = new Runnable() {
		@Override
		public void run() {
		  verifyRunnable(this);
		}
	  };

	  anonClass.run(); // 객체 생성 true

	  Runnable lambda = () -> verifyRunnable(this);
	  lambda.run();  // 객체 생성 false
	}

	private void verifyRunnable(Object obj) {
	  System.out.println(obj instanceof Runnable);
	}
}
