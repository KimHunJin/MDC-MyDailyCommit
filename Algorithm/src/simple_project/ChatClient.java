package simple_project;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by HunJin on 2016-11-06.
 */
public class ChatClient implements ActionListener{
    final static String SERVER_ADDR = "localhost";
    final static int SERVER_PORT = 8000;
    static Socket socket;
    static volatile BufferedReader br;
    static PrintWriter pw;

    JButton btnSend, btnConnect, btnQuit;
    JTextArea txtInput, txtOutput, txtUsers;
    JTextField txtUserName;

    JPanel createGUI() {
        JPanel pnlLayout = new JPanel();
        pnlLayout.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlLayout.setLayout(new BorderLayout());
        JPanel pnlLeft = new JPanel();
        pnlLeft.setLayout(new BorderLayout());
        txtUserName = new JTextField(30);
        pnlLeft.add(txtUserName, BorderLayout.NORTH);
        txtInput = new JTextArea(5, 30);
        txtInput.setEnabled(false);
        pnlLeft.add(new JScrollPane(txtInput), BorderLayout.CENTER);
        txtOutput = new JTextArea(10, 30);
        txtOutput.setFocusable(false);
        pnlLeft.add(new JScrollPane(txtOutput), BorderLayout.SOUTH);
        pnlLayout.add(pnlLeft, BorderLayout.WEST);
        JPanel pnlRight = new JPanel();
        pnlRight.setLayout(new BorderLayout());
        txtUsers = new JTextArea(10, 10);
        txtUsers.setFocusable(false);
        Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        txtUsers.setBorder(border);
        pnlRight.add(txtUsers, BorderLayout.NORTH);
        JPanel pnlButtons = new JPanel();
        pnlButtons.setLayout(new GridLayout(3, 1));
        btnConnect = new JButton("Connect");
        btnConnect.addActionListener(this);
        pnlButtons.add(btnConnect);
        btnSend = new JButton("Send");
        btnSend.addActionListener(this);
        btnSend.setEnabled(false);
        pnlButtons.add(btnSend);
        btnQuit = new JButton("Quit");
        btnQuit.addActionListener(this);
        pnlButtons.add(btnQuit);
        pnlRight.add(pnlButtons, BorderLayout.SOUTH);
        pnlLayout.add(pnlRight, BorderLayout.EAST);
        return pnlLayout;
    }


    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame("ChatClient");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setContentPane(new ChatClient().createGUI());
                f.pack();
                f.setResizable(false);
                f.setVisible(true);
            }
        };
        EventQueue.invokeLater(r);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if(obj == btnConnect) {
            txtUserName.setFocusable(false);
            String userName = txtUserName.getText().toString().trim();
            try {
                socket = new Socket(SERVER_ADDR, SERVER_PORT);
                btnConnect.setEnabled(false);
                InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                br = new BufferedReader(isr);
                pw = new PrintWriter(socket.getOutputStream(), true);
                txtOutput.append(br.readLine() + "\n");
                pw.println((!userName.equals("")) ? userName : "unknown");
                txtInput.setEnabled(true);
                btnSend.setEnabled(true);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String line;
                        try {
                            while ((line = br.readLine()) != null) {
                                if (line.charAt(0) != '!') {
                                    txtOutput.append(line + "\n");
                                    continue;
                                }
                                txtUsers.setText("");
                                String[] users;
                                users = line.substring(1).split(" ");
                                for (String user : users) {
                                    txtUsers.append(user);
                                    txtUsers.append("\n");
                                }
                            }
                        } catch (IOException ie) {
                            ie.printStackTrace();
                            return;
                        }
                    }
                }).start();
            } catch (Exception e1) {
                txtOutput.append("unalbe to connect to server");
            }

        }
        if(obj == btnSend) {
            pw.println(txtInput.getText().toString());
            txtInput.setText("");
        }
        if(obj == btnQuit) {
            try {
                if (socket != null) {
                    socket.close();
                }

            } catch (IOException ie) {

            }
            System.exit(0);
        }
    }
}
