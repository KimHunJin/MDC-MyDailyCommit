package jinhyuk;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class CardPuzzle extends JFrame {

    int level;


    File path = new File(""); // 게임 경로 찾기
    int cardrandom[]; // 카드 랜덤번호가 들어갈 배열
    public Clip clip;

    // 패널 1 메뉴부분
    JPanel panel1;
    int score = 0;
    JLabel labelScore; // 패널1의 점수
    int sec = 0;
    JLabel labelTimer; // 시간초를 보여줄 패널 1의 라벨
    Timer timerSec = new Timer(); // 패널1에 보여줄 라벨의 타이머 초기화
    JButton buttonStart; // 게임 시작 버튼
    JButton buttonPauseOrResume; //일시 정지
    JButton buttonQuit;  // 종료

    // 패널 2 게임구현부분
    JPanel panel2;
    ImageIcon imageBack; // 뒷면 이미지 저장할 아이콘
    ImageIcon imageIcon[];// 앞면 이미지 저장할 20개 아이콘들
    int startCheck; // 새게임버튼 안누르고 그림 누를경우엔 0, 새게임 누르고 패누를땐 1
    JButton buttonImage[]; // 이미지들을 올려둘 버튼 20개
    Timer timerMix = new Timer(); // 패를 섞을때 속도 조절위한 타이머 초기화
    Timer timerHide = new Timer(); // 패를 뒤집기전에 패를 몇초간 보여줄지 타이머
    Timer timerCardCheck = new Timer(); // 패 2개를 뒤집고나서 틀렸을 경우 몇초간 보여줄지 타이머
    JButton buttonConfirmedCheck; // 2개 패 찾기를 성공한것을 누른건지 확인하기위한버튼
    JButton buttonSelectedFirst; // 처음 선택된 버튼
    JButton buttonSelectedSecond; // 두번째 선택된 버튼
    int selectedTwoCardCheck; // 버튼이 몇번 눌렸는지 체크하기
    int firstCardNumber; // 첫번째 눌린 버튼에서 배열의 카드번호 저장하기위해
    int secondCardNumber; // 두번째 눌린 버튼에서 배열의 카드번호 저장하기위해
    int selectedImageNumber; // 몇번째 버튼인지 확인하기 위한 눌려진 버튼의 번호 저장
    ImageIcon selectedImage; // 눌려진 이미지 보여주기위해

    // 결과 팝업창
    JDialog dialogResult;
    JLabel labelResultText;
    JLabel labelResultScore;
    JButton buttonResultOK;
    JButton buttonResultQuit;
    int cardPuzzleScore = 0;

    boolean isPause = false; // pause 와 resume을 쓰기위해

    public void loadAudio(String pathName) {
        try {
            clip = AudioSystem.getClip(); // 비어있는 오디오 클립 만들기
            File audioFile = new File(pathName); // 오디오 파일의 경로명
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile); // 오디오 파일로부터
            clip.open(audioStream); // 재생할 오디오 스트림 열기
            clip.loop(10);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CardPuzzle(int level) { // 초기 생성자

        super("같은 그림 찾기 게임");

        this.level = level;

        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        cardrandom = new int[level];
        imageIcon = new ImageIcon[level];
        buttonImage = new JButton[level];

        panel1 = new JPanel1();
        panel2 = new JPanel2();

        setBackground(Color.WHITE);
        startCheck = 0;

        buttonResultOK = new JButton("다시하기");
        buttonResultOK.setFont(new Font("GOTHIC", Font.BOLD, 15));
        buttonResultOK.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                dialogResult.dispose();
                buttonResultOK.addActionListener(new MyActionListenerNewGame());
            }
        });

        buttonResultQuit = new JButton("게임종료");
        buttonResultQuit.setFont(new Font("GOTHIC", Font.BOLD, 15));
        buttonResultQuit.addMouseListener(new MyMouseListenerQuit());

        dialogResult = new JDialog(this, "게임 결과");
        dialogResult.setLayout(new GridLayout(3, 1));
        dialogResult.setBounds(400, 300, 250, 150);
        dialogResult.add(labelResultText);
        dialogResult.add(labelResultScore);
        dialogResult.add(buttonResultOK);
        dialogResult.add(buttonResultQuit);
        dialogResult.setLocation(850, 450);

        add(panel1);
        add(panel2);

        setSize(850, 700);
        setVisible(true);
        setLocation(600, 150);
        loadAudio("bgm/카드맞추기.wav");
    }

    class JPanel1 extends JPanel { // 버튼, 라벨패널

        public JPanel1() {

            setBackground(Color.WHITE);
            setLayout(null);
            Container c = getContentPane();
            //   setLayout(new GridLayout(1, 3, 30, 5)); // 패널 레이아웃 설정

            buttonStart = new JButton("New Game!!");
            buttonStart.setBounds(650, 400, 130, 50);
            buttonPauseOrResume = new JButton("Pause/Resume");
            buttonPauseOrResume.setBounds(650, 460, 130, 50);
            buttonQuit = new JButton("Quit");
            buttonQuit.setBounds(650, 520, 130, 50);

            labelTimer = new JLabel(sec + "초");
            labelTimer.setBounds(675, 100, 90, 30);
            labelTimer.setFont(new Font("GOTHIC", Font.BOLD, 20));
            labelTimer.setOpaque(true);
            labelTimer.setHorizontalAlignment(NORMAL);

            labelScore = new JLabel("점수 : " + score + "점 ");
            labelScore.setBounds(670, 230, 100, 30);
            labelScore.setFont(new Font("GOTHIC", Font.BOLD, 15));
            labelScore.setHorizontalAlignment(NORMAL);

            labelResultText = new JLabel();
            labelResultText.setHorizontalAlignment(NORMAL);
            labelResultScore = new JLabel();
            labelResultScore.setHorizontalAlignment(NORMAL);

            c.add(labelScore);
            c.add(buttonStart);
            c.add(buttonPauseOrResume);
            c.add(buttonQuit);
            c.add(labelTimer);

            buttonStart.addActionListener(new MyActionListenerNewGame());
            buttonPauseOrResume.addMouseListener(new MyMouseListenerPauseOrResume());
            buttonQuit.addMouseListener(new MyMouseListenerQuit());

        }
    }
    // 패널1

    class JPanel2 extends JPanel { // 게임 구현 패널

        public JPanel2() {

            Container container = getContentPane();
            container.setLayout(null);
            setBackground(Color.WHITE);

            mixNumber(); // 패 섞기
            setImage(); // 이미지 받아오기
            setButtonFirstImage(); // 버튼에 이미지 씌우기
            setButtonName(); // 버튼에 각각 이름 붙이기

            for (int i = 0; i < level; i++) {
                buttonImage[i].addMouseListener(new jjacMouseListener());
            }

            int row = level > 16 ? 5 : 4; // 삼항 연산자 ( level이 10보다 크면 5, 작으면 4)

            int x = 10; // 기본 x 위치
            int y = 30; // 기본 y 위치
            int w = 0;  // 가로 증가
            int h = 0;  // 세로 증가
            for (int i = 0; i < level; i++) {
                if (i % row == 0 && i > 0) {
                    w = 0;
                    h++;
                }
                buttonImage[i].setBounds(x + (120 * w), y + (140 * h), 110, 130);
                w++;

            }

            for (int i = 0; i < level; i++) {
                container.add(buttonImage[i]);
            }
        }
    }
    // 패널2


    class MyActionListenerNewGame implements ActionListener { // 게임 시작버튼
        @Override
        public void actionPerformed(ActionEvent e) {

            setButtonName();
            startCheck = 1;
            sec = 0;
            score = 0;
            labelTimer.setText("  " + sec + " 초"); // 라벨 0으로 초기화
            labelScore.setText("점수 :  " + score + "점 "); // 라벨 0으로 초기화

            timerMix.cancel();
            timerMix = new Timer(); // 타이머 객체 초기화
            timerHide.cancel();
            timerHide = new Timer(); // 타이머 객체 초기화
            timerSec.cancel(); // 타이머 객체 없애기
            timerSec = new Timer(); // 타이머 객체 초기화

            timerMix.scheduleAtFixedRate(new TimerTask() { // 패 섞는 모션
                int i = 0;

                public void run() {
                    mixNumber();
                    setImage();
                    setButtonResetImage();
                    i = i + 1;
                    if (i == level)
                        timerMix.cancel(); // 20번 섞었으면 타이머 종료시키기
                }
            }, 0, 50); // 0초후 실행해서 0.005초간격으로 섞기

            timerHide.scheduleAtFixedRate(new TimerTask() { // 3초 보여준 후 뒤집는 모션
                public void run() {
                    hideButtonImage();
                    timerHide.cancel();
                }
            }, 3000, 1000); // 3초후 실행

            timerSec.scheduleAtFixedRate(new TimerTask() { // 게임시작후 시간초

                public void run() {

                    if (isPause) {
                        return;
                    }

                    labelTimer.setText("  " + sec + " 초");
                    sec = sec + 1;
                    if (sec == 101) {
                        dialogResult2();
                        timerSec.cancel();
                    }

                }
            }, 3000, 1000); // 3초후 1초 간격으로 시간을 세줌

        }
    }
    // 게임 시작버튼

    private class MyMouseListenerPauseOrResume extends MouseAdapter { // 일시정지 버튼

        public void mousePressed(MouseEvent e) {
            isPause = !isPause;
        }
    }

    private class MyMouseListenerQuit extends MouseAdapter { // 종료버튼

        public void mousePressed(MouseEvent e) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.exit(0);
        }
    }

    private class jjacMouseListener implements MouseListener { // 두개 카드 확인 및 결과 표시
        public void mouseClicked(java.awt.event.MouseEvent e) {
        }

        public void mouseEntered(java.awt.event.MouseEvent e) {
        }

        public void mouseExited(java.awt.event.MouseEvent e) {
        }

        public void mousePressed(java.awt.event.MouseEvent e) {
            buttonConfirmedCheck = ((JButton) e.getSource());
            if (buttonConfirmedCheck.getName() == "checked") { // 눌린 버튼이 checked이면 성공한버튼 눌린거면 실행안하기
                selectedTwoCardCheck = 0; // 성공한 패를 눌렀으므로 카운트 다시 0으로

            } else if (startCheck == 1 && (selectedTwoCardCheck == 0 || selectedTwoCardCheck == 1)) {
                // 카드가 뒤집어 졌을때만 실행하기위해

                selectedTwoCardCheck += 1; // 카드 선택 될때마다 카운트 + 1

                // 첫번째 눌린 카드 번호
                if (selectedTwoCardCheck == 1) {

                    buttonSelectedFirst = ((JButton) e.getSource()); // 첫번째 눌린 버튼객체 가져오기
                    selectedImageNumber = Integer.parseInt(buttonSelectedFirst.getName()) - 1; // 이름이 string 이므로 int로 변환
                    selectedImage = new ImageIcon(path + "pic/card/" + cardrandom[selectedImageNumber] + ".jpg");
                    buttonSelectedFirst.setIcon(selectedImage); // 버튼 눌려진 이미지 보여주기

                    firstCardNumber = cardrandom[selectedImageNumber]; // 카드 번호가 10이하면 그냥 저장
                    if (cardrandom[selectedImageNumber] > 10) // 카드 번호가 10보다 크면 -10
                        firstCardNumber = cardrandom[selectedImageNumber] - 10;
                } // 첫번째 눌린 카드 번호

                // 두번째 눌린 카드 번호
                if (buttonConfirmedCheck.getName() == buttonSelectedFirst.getName()) { // 두번째 클릭이 처음클릭한 카드를 또 선택했으면 카운트0
                    selectedTwoCardCheck = 1;
                } else if (selectedTwoCardCheck == 2) {
                    buttonSelectedSecond = ((JButton) e.getSource()); // 첫번째 눌린 버튼객체 가져오기
                    selectedImageNumber = Integer.parseInt(buttonSelectedSecond.getName()) - 1; // 이름이 string 이므로 int로 변환
                    selectedImage = new ImageIcon(path + "pic/card/" + cardrandom[selectedImageNumber] + ".jpg");
                    buttonSelectedSecond.setIcon(selectedImage); // 버튼 눌려진 이미지 보여주기

                    secondCardNumber = cardrandom[selectedImageNumber]; // 카드 번호가 10이하면 그냥 저장
                    if (cardrandom[selectedImageNumber] > 10) // 카드 번호가 10보다 크면 -10
                        secondCardNumber = cardrandom[selectedImageNumber] - 10;

                    if (firstCardNumber == secondCardNumber) { // 첫번째 두번째 선택된 카드 비교
                        selectedTwoCardCheck = 0; // 카드 2선택되면 다시 초기화
                        buttonSelectedFirst.setName("checked"); // 성공이므로 버튼 이름 50으로 해서 선택못하게 하기
                        buttonSelectedSecond.setName("checked"); // 성공이므로 버튼 이름 50으로 해서 선택못하게 하기

                        int end = 0; // 패 몇개 맞췄는지 확인하기
                        for (int i = 0; i < level; i++) { // 패 몇개 맞췄는지 확인하기
                            if ((buttonImage[i].getName()).equals("checked")) {
                                end = end + 1;
                                if (end == level) { // 20개 전부 맞았는지 체크

                                    timerSec.cancel(); // 타이머 정지
                                    labelTimer.setText("  " + sec + " 초");

                                    cardPuzzleScore = 100 - sec;
                                    labelScore.setText("점수 :  " + cardPuzzleScore + " 점");

                                    dialogResult();
                                    break;
                                }
                            }
                        }

                    } else {
                        timerCardCheck = new Timer();
                        timerCardCheck.scheduleAtFixedRate(new TimerTask() { // 첫번째 두번째 카드비교후 틀리면 몇초보여주기

                            public void run() {
                                selectedTwoCardCheck = 0; // 카드 2선택되면 다시 초기화 , 카드가 뒷면보일때까지 다른것 선택못하게하기
                                buttonSelectedFirst.setIcon(imageBack); // 틀렸으므로 첫번째 카드 다시 뒤집기
                                buttonSelectedSecond.setIcon(imageBack); // 틀렸으므로 두번째 카드 다시 뒤집기
                                timerCardCheck.cancel(); // 뒤집고 타이머 종료
                            }
                        }, 300, 1); // 0.3초후 카드 뒷면 보이게 하기.
                    }
                } // 두번째 눌린 카드 번호
            }

        }

        public void mouseReleased(java.awt.event.MouseEvent e) {
        }
    }
    // 두개 카드 확인 및 결과 표시

    // EventHandlerResultOK

    public void mixNumber() { // 카드 섞기


        // 카드가 매핑되게 세팅 (1 = 11, 2 = 12)
        int match = level / 2;
        for (int i = 0; i < level / 2; i++) {
            cardrandom[i] = i + 1;
            cardrandom[match] = i + 11;
            match++;
        }

        int i = 0;
        int rand1 = 0;
        int rand2 = 0;

        // 충분히 섞는다.
        while (true) {
            rand1 = (int) (Math.random() * level);
            rand2 = (int) (Math.random() * level);
            if (rand1 == rand2) {
                continue;
            }

            int tmp = cardrandom[rand1];
            cardrandom[rand1] = cardrandom[rand2];
            cardrandom[rand2] = tmp;

            i++;

            // 충분히 섞는다
            if (i > 30) {
                break;
            }
        }
    }

    public void setImage() { // 이미지객체에 그림 가져오기

        imageBack = new ImageIcon(path + "pic/card/0.jpg");
        for (int i = 0; i < level; i++) {
            imageIcon[i] = new ImageIcon(path + "pic/card/" + cardrandom[i] + ".jpg");
        }
    }

    public void setButtonFirstImage() { // 버튼 설정 및 처음 가져온 그림 보여주기

        for (int i = 0; i < level; i++) {
            buttonImage[i] = new JButton(imageIcon[i]);
            buttonImage[i].setBackground(Color.WHITE); // 배경색

        }
    }

    public void setButtonResetImage() { // 버튼에 리셋된 이미지 재설정하기

        for (int i = 0; i < level; i++) {
            buttonImage[i].setIcon(imageIcon[i]);
        }
    }

    public void setButtonName() { // 버튼에 이름주기

        for (int i = 0; i < level; i++) {
            buttonImage[i].setName(Integer.toString(i + 1));
        }
    }

    public void hideButtonImage() { // 버튼 그림 뒷면 보이기

        for (int i = 0; i < level; i++) {
            buttonImage[i].setIcon(imageBack);
        }
    }

    void dialogResult() { // 다이얼로그 보여주기

        labelResultText.setText("축하합니다 !!");
        labelResultScore.setText("점수 :  " + cardPuzzleScore + " 점 획득");
        dialogResult.setVisible(true);

    }

    void dialogResult2() {
        labelResultText.setText("아쉽습니다 ..");
        labelResultScore.setText("점수 :  " + "0" + " 점 획득");
        dialogResult.setVisible(true);
    }

}
