package algorithm.arduino;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by HunJin on 2017-06-10.
 */
public class JavaToHttpRequest {

    public static void main(String[] args) {
        try {
            String data = URLEncoder.encode("key1", "UTF-8") +
                    "=" +
                    URLEncoder.encode("value1", "UTF-8");

            data += "&" + URLEncoder.encode("key2", "UTF-8") +
                    "=" + URLEncoder.encode("홍길동", "UTF-8");

            URL url = new URL("http://117.123.102.30:13000/test");
            URLConnection conn = url.openConnection();

            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }
            wr.close();
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
