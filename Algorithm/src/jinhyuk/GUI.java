package jinhyuk;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI {
	GameReset Game;
	//ī�弯��,�̹��� ���� �ҷ�����,GUI ���� 
	public GUI() {
		// TODO Auto-generated constructor stub
		Game=new GameReset();
		Game.randNumber();
		Game.imageFunction();
		Start();
	}
	public void Start() {
		// TODO Auto-generated constructor stub
		JFrame frm=new JFrame("���� �׸� ã��");
		frm.setBounds(120, 120, 600, 300);
		
		JPanel bp=new JPanel();
		bp.setLayout(new GridLayout(2,5,4,4));
		cardButton[] btn=new cardButton[10];
		ActionButtonHandler action=new ActionButtonHandler(btn,this);
		for(int i=0;i<10;i++)
		{
			btn[i]=new cardButton(Integer.toString(i),Game.GetArr(i),Game.GetImage(Game.GetArr(i)),Game.GetImage(0));
			btn[i].addActionListener(action);
			bp.add(btn[i]);
		}
		
		
		frm.add(bp);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public int showPapUp() {
		int result;
		result=JOptionPane.showConfirmDialog(null,
				"����Ͻðڽ��ϱ�?","�������ϴ�.",JOptionPane.YES_NO_OPTION);
		return result;
	}
	public GameReset ReturnGame() {
		return Game;
	}
}
