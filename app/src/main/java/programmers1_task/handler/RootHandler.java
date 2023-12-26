package programmers1_task.handler;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class RootHandler implements HttpHandler{

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    String res="""
      {
        "message": "server check"
      }
      """;
    try {
      exchange.getResponseHeaders().add("Content-Type", "application/json");
      exchange.sendResponseHeaders(200, res.getBytes().length);
    } catch (Exception e) {
      res="";
      exchange.getResponseHeaders().add("Content-Type", "application/json");
      exchange.sendResponseHeaders(500, res.getBytes().length);
    } finally {
      OutputStream os = exchange.getResponseBody();
      os.write(res.getBytes());
      os.close();
    }
        
  }

}
