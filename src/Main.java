import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;

public class Main {

    static class HttpHandlerImpl implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            OutputStream os = exchange.getResponseBody();

            if (!"/".equals(exchange.getRequestURI().getPath())) {
                exchange.sendResponseHeaders(404, -1);
                os.close();
                return;
            }

            exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET");
            exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "http://localhost:5501");
            exchange.getResponseHeaders().set("Content-Type", "application/json; charset=utf-8");
            exchange.getResponseHeaders().set("Cache-Control", "no-cache, no-store");
            exchange.getResponseHeaders().set("Connection", "keep-alive");
            exchange.getResponseHeaders().set("Keep-Alive", "timeout=10, max=1");
            exchange.getResponseHeaders().set("Content-Language", "en-US");
            exchange.getResponseHeaders().set("Access-Control-Allow-Credentials", "true");
            exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Accept, Content-Type");
            exchange.getResponseHeaders().set("Age", "0");
            exchange.getResponseHeaders().set("Date", ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.RFC_1123_DATE_TIME));
            exchange.getResponseHeaders().set("X-Content-Type-Options", "nosniff");
            exchange.getResponseHeaders().set("X-Frame-Options", "DENY");
            exchange.getResponseHeaders().set("Content-Security-Policy", "default-src 'none'; script-src 'self'; style-src 'self'; img-src 'self'; connect-src 'self'; font-src 'self'; object-src 'none'; frame-ancestors 'none';");

            String response = "{\"message\":\"<img src='x' onerror=\\\"alert('XSS Attack!')\\\">\"}";
//            String response = "{\"message\":\"Hello!\"}";
            exchange.sendResponseHeaders(200, response.length());
            os.write(response.getBytes());
            os.close();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Testing App Initialized...");
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8085), 0);
        server.createContext("/", new HttpHandlerImpl());
        server.setExecutor(Executors.newSingleThreadExecutor());
        server.start();
        System.out.println("Server Started...");
    }
}