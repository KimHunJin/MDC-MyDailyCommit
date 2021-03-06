package chatting;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by HunJin on 2016-12-12.
 */
public class DayTimeServer {
    public final static int daytimeport = 13;
    public static void main(String[] args) {
        ServerSocket theServer;
        Socket theSocket = null;
        BufferedWriter writer;

        try {
            theServer = new ServerSocket(daytimeport);
            while(true) {
                try {
                    theSocket = theServer.accept();
                    OutputStream os = theSocket.getOutputStream();
                    writer = new BufferedWriter(new OutputStreamWriter(os));
                    Date now = new Date();
                    writer.write(now.toString() + "\r\n");
                    writer.flush();
                    theSocket.close();
                } catch(IOException ie) {
                    System.out.println(ie);
                } finally {
                    try {
                        if(theSocket != null) theSocket.close();
                    } catch(IOException ie) {
                        System.out.println(ie);
                    }
                }
            }
        } catch(IOException ie) {
            System.out.println(ie);
        }
    }
}
