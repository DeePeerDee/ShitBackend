import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.concurrent.Executors;

public class Main {

    static class TestJsonHttpHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            OutputStream os = exchange.getResponseBody();

            if (!Arrays.asList("/", "/json").contains(exchange.getRequestURI().getPath())) {
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

//            String response = "{\"message\":\"<img src='x' onerror=\\\"alert('XSS Attack!')\\\">\"}";
            String response = "{\"message\":\"Hello JSON!\"}";
            exchange.sendResponseHeaders(200, response.length());
            os.write(response.getBytes());
            os.close();
        }
    }

    static class TestXmlHttpHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            OutputStream os = exchange.getResponseBody();

            exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET");
            exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "http://localhost:5501");
            exchange.getResponseHeaders().set("Content-Type", "application/xml; charset=utf-8");
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

            String response = "<Response><Message>Hello XML!</Message></Response>";
            exchange.sendResponseHeaders(200, response.length());
            os.write(response.getBytes());
            os.close();
        }
    }

    static class TestHtmlHttpHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            OutputStream os = exchange.getResponseBody();

            exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET");
            exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "http://localhost:5501");
            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=utf-8");
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

            String response = "<h1>Hello HTML!</h1>";
            exchange.sendResponseHeaders(200, response.length());
            os.write(response.getBytes());
            os.close();
        }
    }

    static class TestJavascriptHttpHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            OutputStream os = exchange.getResponseBody();

            exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET");
            exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "http://localhost:5501");
            exchange.getResponseHeaders().set("Content-Type", "test/javascript; charset=utf-8");
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

            String response = "console.log(\"Hello Javascript!\");";
            exchange.sendResponseHeaders(200, response.length());
            os.write(response.getBytes());
            os.close();
        }
    }

    static class TestPdfHttpHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            OutputStream os = exchange.getResponseBody();

            exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET");
            exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "http://localhost:5501");
            exchange.getResponseHeaders().set("Accept-Encoding", "gzip, deflate, br");
            exchange.getResponseHeaders().set("Content-Type", "application/pdf");
//            exchange.getResponseHeaders().set("Content-Encoding", "gzip, deflate, br");
            exchange.getResponseHeaders().set("Cache-Control", "no-cache, no-store");
            exchange.getResponseHeaders().set("Connection", "keep-alive");
            exchange.getResponseHeaders().set("Keep-Alive", "timeout=10, max=1");
            exchange.getResponseHeaders().set("Content-Language", "en-US");
            exchange.getResponseHeaders().set("Access-Control-Allow-Credentials", "true");
            exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Accept, Content-Type");
            exchange.getResponseHeaders().set("Age", "0");
            exchange.getResponseHeaders().set("Date", ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.RFC_1123_DATE_TIME));
            exchange.getResponseHeaders().set("X-Content-Type-Options", "nosniff");
            exchange.getResponseHeaders().set("Content-Security-Policy", "default-src 'none'; script-src 'self'; style-src 'self'; img-src 'self'; connect-src 'self' http://localhost:8085; frame-src http://localhost:8085; font-src 'self'; object-src 'none';");

            String response = """
                    %PDF-2.0
                    1 0 obj
                    << /Type /Catalog
                       /Pages 2 0 R
                    >>
                    endobj
                    2 0 obj
                    << /Type /Pages
                       /Kids [3 0 R]
                       /Count 1
                    >>
                    endobj
                    3 0 obj
                    << /Type /Page
                       /Parent 2 0 R
                       /MediaBox [0 0 612 792]
                       /Contents 4 0 R
                       /Resources <<
                         /Font <<
                           /F1 5 0 R
                         >>
                       >>
                    >>
                    endobj
                    4 0 obj
                    << /Length 44 >>
                    stream
                    BT
                    /F1 12 Tf
                    25 750 Td
                    (Hello PDF!) Tj
                    ET
                    endstream
                    endobj
                    5 0 obj
                    << /Type /Font
                       /Subtype /Type1
                       /BaseFont /Courier New
                    >>
                    endobj
                    xref
                    0 6
                    0000000000 65535 f\s
                    0000000010 00000 n\s
                    0000000060 00000 n\s
                    0000000111 00000 n\s
                    0000000222 00000 n\s
                    0000000290 00000 n\s
                    trailer
                    << /Size 6
                       /Root 1 0 R
                    >>
                    startxref
                    360
                    %%EOF""";
            exchange.sendResponseHeaders(200, response.length());
            os.write(response.getBytes());
            os.close();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Testing App Initialized...");
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8085), 0);
        server.createContext("/", new TestJsonHttpHandler());
        server.createContext("/json", new TestJsonHttpHandler());
        server.createContext("/xml", new TestXmlHttpHandler());
        server.createContext("/html", new TestHtmlHttpHandler());
        server.createContext("/javascript", new TestJavascriptHttpHandler());
        server.createContext("/pdf", new TestPdfHttpHandler());
        server.setExecutor(Executors.newSingleThreadExecutor());
        server.start();
        System.out.println("Server Started...");
    }
}