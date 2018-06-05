package jinhyuk;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class MainScreen extends JFrame {

    private JButton gameStartButton = new JButton(new ImageIcon("pic/게임 시작.png"));
    private JButton explainButton = new JButton(new ImageIcon("pic/explain.jpg"));
    private JButton quitButton = new JButton(new ImageIcon("pic/quit.jpg"));
    public Clip clip;

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

    public MainScreen() {

        setTitle("같은 그림 찾기 게임");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(700, 150);

        loadAudio("bgm/피아노.wav");

        JLabel backgroundImage = new JLabel(new ImageIcon("pic/casino.jpg"));

        setContentPane(backgroundImage);

        Container container = this.getContentPane();

        gameStartButton.setBounds(160, 570, 75, 30);
        gameStartButton.setContentAreaFilled(false);
        gameStartButton.setContentAreaFilled(false);
        gameStartButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                new SelectLevel(MainScreen.this);
                clip.stop();
            }
        });

        explainButton.setBounds(260, 570, 75, 30);
        explainButton.setContentAreaFilled(false);
        explainButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                new HowToPlay();
            }
        });

        quitButton.setBounds(360, 570, 75, 30);
        quitButton.setContentAreaFilled(false);
        quitButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
        container.add(gameStartButton);
        container.add(explainButton);
        container.add(quitButton);

        setVisible(true);
    }

}