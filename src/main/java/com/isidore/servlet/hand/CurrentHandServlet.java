package com.isidore.servlet.hand;

import com.isidore.service.HandService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.isidore.constant.MethodType.GET;
import static com.isidore.util.Util.objectToJson;
import static com.isidore.util.Util.setHeaders;

public class CurrentHandServlet extends HttpServlet {
    private final HandService handService;

    public CurrentHandServlet() {
        handService = HandService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        setHeaders(response, GET);
        response.getWriter().write(objectToJson(handService.getCurrentHand()));
    }
}
