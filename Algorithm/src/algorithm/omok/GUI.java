package algorithm.omok;

/**
 * Created by HunJin on 2017-06-13.
 */

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 참고 코드
 * http://message0412.tistory.com/entry/%EC%9E%90%EB%B0%94-%EC%98%A4%EB%AA%A9%EA%B2%8C%EC%9E%84-%EB%A7%8C%EB%93%A4%EA%B8%B0
 **/

//@SupperessWarnings("serial")
public class GUI extends JFrame {

    private Container c;
    MapSize size = new MapSize();

    public GUI(String title) {
        c = getContentPane(); //컨텐츠 영역을 얻고 추가
        setBounds(200, 20, 650, 700);
        c.setLayout(null);
        Map map = new Map(size);
        Gravity gr = new Gravity();
        DrawBoard d = new DrawBoard(size, map, gr);
        setContentPane(d);
        addMouseListener(new MouseEventHandler(map, size, d, this, gr));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showPopUp(String message) {
        JOptionPane.showMessageDialog(this, message, "", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}

