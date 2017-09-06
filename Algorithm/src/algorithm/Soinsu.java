package algorithm;

import java.util.Scanner;

/**
 * Created by HunJin on 2017-05-13.
 */
public class Soinsu {
    int inputNum;       // 입력받은 정수
    int sqrtNum;        // 제곱근
    int qNum;           // 몫


    public static void main(String[] args) {
        new Soinsu().execute();
    }

    // 실행
    public void execute() {

        getInputNum();// 정수 입력받기

        boolean isEnd = false;

        while(qNum>1 && isEnd == false) {
            sqrtNum = (int)Math.sqrt(qNum);     // 확인할 수의 제곱근

            for(int i=2; i<=sqrtNum; i++) {     // 확인할 수의 제곱근까지 반복
                if(qNum%i==0) {                 // 소수로 나누어지면
                    System.out.print(i+" x ");
                    qNum /= i;                  // 나눈 몫을 다시 확인할 수로 대입한다.
                    System.out.println(qNum);
                    break;
                }
                if(i==sqrtNum) {                // 끝까지 나누어지는 수가 없을때
                    System.out.println(qNum + " = "+inputNum);      // 마지막까지 남은 수를 출력
                    isEnd = true;

                    break;
                }
            }
        }
    }// end execute()


    // 정수 입력 받는 메서드
    public void getInputNum() {
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.print("정수 입력 : ");
            try {
                inputNum = Integer.parseInt(scan.next());
                if(inputNum<2)
                    throw new Exception();
                else
                    break;
            } catch (Exception e) {
                System.out.println("2이상의 정수만 입력하시오.");
            }
        }
        qNum = inputNum;        // 판별을 할 몫에 입력받은 수 대입
    }//end getInputNum()


}
