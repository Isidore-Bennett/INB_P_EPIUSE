package com.isidore.servlet;

import com.isidore.servlet.card.DrawServlet;
import com.isidore.servlet.deck.CurrentDeckServlet;
import com.isidore.servlet.deck.NewDeckServlet;
import com.isidore.servlet.deck.ShuffleServlet;
import com.isidore.servlet.game.GameChangeServlet;
import com.isidore.servlet.game.GameCollectionServlet;
import com.isidore.servlet.hand.CurrentHandServlet;
import com.isidore.servlet.hand.HandStrengthServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServletCollection {

    public static void compileServlets(ServletContextHandler context) {
        context.addServlet(new ServletHolder(new NewDeckServlet()), "/deck/new");
        context.addServlet(new ServletHolder(new ShuffleServlet()), "/deck/shuffle");
        context.addServlet(new ServletHolder(new CurrentDeckServlet()), "/deck/current");
        context.addServlet(new ServletHolder(new DrawServlet()), "/card/draw");
        context.addServlet(new ServletHolder(new HandStrengthServlet()), "/hand/strength");
        context.addServlet(new ServletHolder(new CurrentHandServlet()), "/hand/current");
        context.addServlet(new ServletHolder(new GameChangeServlet()), "/game/change");
        context.addServlet(new ServletHolder(new GameCollectionServlet()), "/game/collection");
    }
}
