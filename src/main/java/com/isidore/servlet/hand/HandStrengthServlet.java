package com.isidore.servlet.hand;

import com.isidore.model.Card;
import com.isidore.service.HandService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.isidore.constant.MethodType.POST;
import static com.isidore.util.Util.jsonToObject;
import static com.isidore.util.Util.objectToJson;
import static com.isidore.util.Util.setHeaders;

public class HandStrengthServlet extends HttpServlet {
    private final HandService handService;

    public HandStrengthServlet() {
        handService = HandService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException {
        setHeaders(response, POST);
        response.getWriter().write(objectToJson(handService.getStrength(jsonToObject(req.getReader(), Card.class))));
    }
}
