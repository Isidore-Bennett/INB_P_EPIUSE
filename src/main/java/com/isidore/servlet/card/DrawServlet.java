package com.isidore.servlet.card;

import com.isidore.constant.MethodType;
import com.isidore.service.CardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.isidore.constant.MethodType.GET;
import static com.isidore.util.Util.objectToJson;
import static com.isidore.util.Util.setHeaders;

public class DrawServlet extends HttpServlet {
    private final CardService cardService;

    public DrawServlet() {
        cardService = CardService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        setHeaders(response, GET);
        response.getWriter().write(objectToJson(cardService.draw()));
    }
}
