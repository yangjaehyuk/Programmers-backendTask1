package programmers1_task.handler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import programmers1_task.domain.Member;


public class SumHandler implements HttpHandler{

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    String newPath = "C:\\Users\\user\\Desktop\\programmers1\\data\\input\\user.json";
    File file = new File(newPath);
    ObjectMapper objectMapper = new ObjectMapper();
    Member[] members = objectMapper.readValue(file, Member[].class);
    int total=0;
    for(Member member: members){
      total+=member.getCount();
    }
    String res="""
      {
        "sum": %d
      }
        """.formatted(total);
    try {
      exchange.getResponseHeaders().add("Content-Type", "application/json");
      exchange.sendResponseHeaders(200, res.getBytes().length);
    } catch (Exception e) {
      exchange.getResponseHeaders().add("Content-Type", "application/json");
      exchange.sendResponseHeaders(500, res.getBytes().length);
    } finally {
      OutputStream os = exchange.getResponseBody();
      os.write(res.getBytes());
      os.close();
    }
  }
  
}
