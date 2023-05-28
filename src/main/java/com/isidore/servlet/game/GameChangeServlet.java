package com.isidore.servlet.game;

import com.isidore.constant.Game;
import com.isidore.service.GameService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.MimeTypes;

import java.io.IOException;
import java.util.stream.Collectors;

import static com.isidore.constant.MethodType.POST;
import static com.isidore.util.Util.setHeaders;

public class GameChangeServlet extends HttpServlet {
    private final GameService gameService;

    public GameChangeServlet() {
        gameService = GameService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException {
        setHeaders(response, POST, MimeTypes.Type.TEXT_PLAIN);
        gameService.setCurrentGame(Game.getGame(req.getReader().lines().collect(Collectors.joining(System.lineSeparator()))));
        response.getWriter().write(gameService.getCurrentGame().value);
    }
}
