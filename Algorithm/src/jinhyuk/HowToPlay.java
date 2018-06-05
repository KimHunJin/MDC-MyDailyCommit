package jinhyuk;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class HowToPlay {

	JDialog dialogExplain;
	JLabel labelExplainText;

	public HowToPlay() {

		dialogExplain = new JDialog(this.dialogExplain, "게임 방법");
		labelExplainText = new JLabel();
		labelExplainText.setText("같은 그림을 맞추세요!! ");
		labelExplainText.setFont(new Font("GOTHIC", Font.BOLD, 20));
		dialogExplain.setLayout(new GridLayout(3, 1));
		dialogExplain.setBounds(870, 450, 250, 150);
		dialogExplain.add(labelExplainText);
		dialogExplain.setVisible(true);

	}
}
