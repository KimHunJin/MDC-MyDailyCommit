package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by HunJin on 2016-12-12.
 */
public class DayTimeClient {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Socket theSocket;
        String host;
        InputStream is;
        BufferedReader reader;
        if(args.length > 0) {
            host = args[0];
        } else {
            host = "localhost";
        }

        try {
            theSocket = new Socket(host, 13);
            is = theSocket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is));
            String theTime = reader.readLine();
            System.out.println("호스트의 시간은 " + theTime + "이다.");
        } catch(UnknownHostException e) {
            System.out.println(args[0] + "호스트를 찾을 수 없습니다.");
        } catch (IOException e) {
            // TODO: handle exception
            System.err.println(e);
        }
    }

}
