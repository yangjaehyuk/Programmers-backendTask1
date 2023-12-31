/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package programmers1_task;

import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import programmers1_task.handler.RootHandler;
import programmers1_task.handler.SumHandler;

public class App{
    public static void main(String[] args) throws Exception {
        int port = 5678;
        HttpServer server = HttpServer.create(new InetSocketAddress(port),0);
        server.createContext("/", new RootHandler());
        server.createContext("/sum", new SumHandler());
        server.setExecutor(null);
        server.start();
    }
    
    
}
