package algorithm.omok;

/**
 * Created by HunJin on 2017-06-13.
 * <p>
 * 참고 코드
 * http://message0412.tistory.com/entry/%EC%9E%90%EB%B0%94-%EC%98%A4%EB%AA%A9%EA%B2%8C%EC%9E%84-%EB%A7%8C%EB%93%A4%EA%B8%B0
 **/

/**
 * 참고 코드
 * http://message0412.tistory.com/entry/%EC%9E%90%EB%B0%94-%EC%98%A4%EB%AA%A9%EA%B2%8C%EC%9E%84-%EB%A7%8C%EB%93%A4%EA%B8%B0
 *
 *
 **/

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventHandler extends MouseAdapter {
    private Map map;
    private MapSize ms;
    private DrawBoard d;
    private GUI main;
    private Gravity gr;

    public MouseEventHandler(Map m, MapSize ms, DrawBoard d, GUI main, Gravity gr) {
        map = m;
        this.ms = ms;
        this.d = d;
        this.main = main;
        this.gr = gr;
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        super.mousePressed(arg0);

        int x = (int) Math.round(arg0.getX() / (double) ms.getCell()) - 1; // 범위 내의 좌표 구하기
        int y = (int) Math.round(arg0.getY() / (double) ms.getCell()) - 2;
        if (x < 0 || x > 19 || y < 0 || y > 19) {
            return;
        }
        if (map.getXY(y, x) == map.getWhite()) {
            return;
        }
        System.out.println("MouseEventHandler class " + x + "와" + y);
        System.out.println(x + " " + y);

        gr.XYset(x, y);  //Gravity.java로 눌린 좌표값 전송
        map.setMap(y, x);
        d.repaint();
        if (map.winCheck(x, y) || (gr.win == 1)) {
            if (gr.win == 1) {
                main.showPopUp("백돌이 승리하였습니다.");
            } else if (map.getCheck() == true) {
                main.showPopUp("흑돌이 승리하였습니다.");
            }
        }
    }


}

