package simple_project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by HunJin on 2016-11-06.
 */
public class Connection extends Thread {
    private volatile BufferedReader br;
    private volatile PrintWriter pw;
    private String clientName;

    Connection(Socket s) throws IOException {
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        pw = new PrintWriter(s.getOutputStream(),true);
    }

    @Override
    public void run() {
        String line;
        try {
            clientName = br.readLine();
            sendClientsList();
            while ((line = br.readLine()) != null) {
                broadcast(clientName+" : " + line);
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            System.out.println(clientName + " : finished");
            synchronized (ClientsList.list) {
                ClientsList.list.remove(this);
                broadcast ("now " + ClientsList.list.size() + " users");
                sendClientsList();
            }
        }
    }

    private void broadcast(String message) {
        System.out.println("broadcasting " + message);
        synchronized (ClientsList.list) {
            for(Connection c : ClientsList.list) {
                c.send(message);
            }
        }
    }

    void send(String message) {
        pw.println(message);
    }

    private void sendClientsList() {
        StringBuilder sb = new StringBuilder();
        synchronized (ClientsList.list) {
            for(Connection c : ClientsList.list) {
                sb.append(c.clientName);
                sb.append(" ");
            }
            broadcast("!" + sb.toString());
        }
    }
}
