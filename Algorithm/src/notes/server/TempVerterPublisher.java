package notes.server;

import javax.xml.ws.Endpoint;

/**
 * Created by HunJin on 2017-04-24.
 */
public class TempVerterPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9901/TempVerter", new TempVerterImpl());
    }
}
