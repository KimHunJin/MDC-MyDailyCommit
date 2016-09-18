import java.util.HashMap;
import java.util.Map;

/**
 * Created by HunJin on 2016-09-18.
 */
public class LambdaExpressionSecondDay {
    public static void main(String[] args) {

        Map<Integer, Integer> items = new HashMap<>();

        LambdaExpressionSecondDay lambdaExpressionSecondDay = new LambdaExpressionSecondDay();

        lambdaExpressionSecondDay.numberOperationPractice();
        lambdaExpressionSecondDay.stringOperationPractice();

        lambdaExpressionSecondDay.makingRandomNumber(items);

        lambdaExpressionSecondDay.forEachPractice(items);

    }

    /**
     * 숫자 연산과 관련된 람다 표현식
     */
    void numberOperationPractice() {
        MathOperation add = (a,b) -> a+b;

        MathOperation minus = (int a,int b) -> a-b;

        MathOperation multipli = (a, b) -> {return a*b;};

        System.out.println("10 + 5 = " + operate(10,5,add));
        System.out.println("10 - 5 = " + operate(10,5,minus));
        System.out.println("10 * 5 = " + operate(10,5,multipli));

    }

    /**
     * 문자 연산과 관련된 람다 표현식
     */
    void stringOperationPractice() {

        StringOperation changeWord = (String a) -> a.substring(0,3) + "...";
        System.out.println("change word abcdefghijklmnopqrstuvwxyz = " + changeWord("abcdefghijklmnopqrstuvwxyz",changeWord));

        GreetingService greetingService = message -> System.out.println("Hello " + message);
        GreetingService greetingService2 = (message) -> System.out.println("Hello " + message);

        greetingService.sayMessage("mos");
        greetingService2.sayMessage("hunjin");
    }

    /**
     * forEach 사용법
     * @param items
     */
    void forEachPractice(Map<Integer, Integer> items) {
        GreetingService greetingService = message -> System.out.println("Oh! " + message);
        items.forEach((k,v)->{
            System.out.println("Key : " + k + " Value : " + v);
            if(v.equals(3)) {
                greetingService.sayMessage(k+"");
            }
        });
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface StringOperation {
        String operation(String a);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a,b);
    }

    private String changeWord(String a, StringOperation stringOperation) {
        return stringOperation.operation(a);
    }

    private void makingRandomNumber(Map<Integer, Integer> map) {
        for(int i=0;i<10;i++) {
            map.put(i,(int)(Math.random()*10)+1);
        }
    }
}