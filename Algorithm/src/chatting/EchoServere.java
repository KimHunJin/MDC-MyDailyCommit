package chatting;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by HunJin on 2016-12-12.
 */
public class EchoServere {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        ServerSocket theServer;
        Socket theSocket = null;
        InputStream is;
        BufferedReader reader;
        OutputStream os;
        BufferedWriter writer;
        String theLine;

        try {
            theServer = new ServerSocket(7);
            theSocket = theServer.accept();
            is = theSocket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is));
            os = theSocket.getOutputStream();
            writer = new BufferedWriter(new OutputStreamWriter(os));
            while((theLine = reader.readLine()) != null) {
                System.out.println(theLine);
                writer.write(theLine + '\r' + '\n');
                writer.flush();
            }
        } catch(UnknownHostException e) {
            System.err.println(e);
        } catch(IOException e) {
            System.err.println(e);
        } finally {
            if(theSocket != null) {
                try {
                    theSocket.close();
                } catch(IOException e) {
                    System.out.println(e);
                }
            }
        }

    }
}
