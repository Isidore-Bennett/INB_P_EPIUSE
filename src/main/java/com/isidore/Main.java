package com.isidore;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import static com.isidore.servlet.ServletCollection.compileServlets;

public class Main {
    private static Integer PORT = 12345;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");

        Server server = new Server(PORT);
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");

        compileServlets(context);

        server.setHandler(context);

        server.start();
        System.out.println("Server started on point: " + PORT.toString());
        server.join();
    }
}