package notes.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by HunJin on 2017-04-24.
 */
public class MiniHttpServer {
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8000), 0);
        httpServer.createContext("/echo", new Handler());
        httpServer.start();
    }
}
