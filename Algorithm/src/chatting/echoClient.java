package chatting;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by HunJin on 2016-12-12.
 */
public class echoClient {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Socket theSocket = null;
        String host;
        InputStream is;
        BufferedReader reader, userInput;
        OutputStream os;
        BufferedWriter writer;
        String theLine;

        if(args.length > 0) {
            host = args[0];
        } else {
            host = "localhost";
        }

        try {
            theSocket = new Socket(host,7);
            is = theSocket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is));
            userInput = new BufferedReader(new InputStreamReader(System.in));
            os = theSocket.getOutputStream();
            writer = new BufferedWriter(new OutputStreamWriter(os));
            System.out.println("전송할 문장을 입력하세요.");
            while(true) {
                theLine = userInput.readLine();
                if(theLine.equals("quit")) {
                    break;
                }
                writer.write(theLine + '\r' + '\n');
                writer.flush();
                System.out.println(reader.readLine());
            }

        } catch(UnknownHostException e) {
            System.err.println(args[0] + " 호스트를 찾을 수 없습니다.");
        } catch(IOException e) {
            System.err.println(e);
        } finally {
            try {
                theSocket.close();
            } catch(IOException e) {
                System.out.println(e);
            }
        }

    }
}
