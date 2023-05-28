package com.isidore.servlet.game;

import com.isidore.constant.Game;
import com.isidore.service.GameService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.MimeTypes;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.isidore.constant.MethodType.GET;
import static com.isidore.constant.MethodType.POST;
import static com.isidore.util.Util.setHeaders;

public class GameCollectionServlet extends HttpServlet {
    private final GameService gameService;

    public GameCollectionServlet() {
        gameService = GameService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        setHeaders(response, GET);
        gameService.setCurrentGame(Game.getGame(req.getReader().lines().collect(Collectors.joining(System.lineSeparator()))));
        response.getWriter().write(Arrays.stream(gameService.getGameCollection()).map(game -> game.value).collect(Collectors.joining(",")));
    }
}
