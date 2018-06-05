package sehyun.subject;

/**
 * Created by HunJin on 2016-10-11.
 */
public class sdfsadf {

    static int classVariable; // 클래스 변수
    String globalVariable; // 전역 변수 (글로벌 변수)

    /**
     * 메인 메서드 (클래스 메서드)
     * @param args
     */
    public static void main(String[] args) {
        int locarValiable = 10; // 지역변수 (로컬 변수)
    }

    /**
     * 리턴값이 없는 메서드
     */
    void noReturn() {
        int locarlValiable = 5; // 지역변수 (로컬변수)
    }

    /**
     * 리턴값이 정수형인 메서드
     * @return
     */
    int intReturn() {
        int locarlValiable = 5; // 지역변수 (로컬변수)
        return locarlValiable;
    }

    /**
     * 리턴값이 문자열인 메서드
     * @return
     */
    String stringReturn() {
        int locarlValiable = 5; // 지역변수 (로컬변수)
        return locarlValiable+"";
    }
}
