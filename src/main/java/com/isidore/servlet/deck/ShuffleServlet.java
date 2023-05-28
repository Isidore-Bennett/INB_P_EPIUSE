package com.isidore.servlet.deck;

import com.isidore.service.DeckService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.isidore.constant.MethodType.GET;
import static com.isidore.util.Util.objectToJson;
import static com.isidore.util.Util.setHeaders;

public class ShuffleServlet extends HttpServlet {
    private final DeckService deckService;

    public ShuffleServlet() {
        deckService = DeckService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        setHeaders(response, GET);
        response.getWriter().write(objectToJson(deckService.newShuffle()));
    }
}
