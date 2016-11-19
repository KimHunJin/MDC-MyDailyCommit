package simple_project;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by HunJin on 2016-11-06.
 */
public class MultiChatServer {
    private final static int PORT_NUMBER = 8000;
    private ServerSocket listener;

    MultiChatServer() throws IOException {
        listener = new ServerSocket(PORT_NUMBER);
        System.out.println("Listening on port " + PORT_NUMBER);
    }

    void runServer() {
        try {
            while (true) {
                Socket socket = listener.accept();
                System.out.println("accepted connection");
                Connection con = new Connection(socket);
                synchronized (ClientsList.list) {
                    ClientsList.list.add(con);
                    con.start();
                    if(ClientsList.list.size() == 1) {
                        con.send("첫번째 고객님 환영합니다.");
                    } else {
                        con.send(ClientsList.list.size() + "번째 호갱님 안녕^^");
                    }
                }
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("ChatServer Starting");
            new MultiChatServer().runServer();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
