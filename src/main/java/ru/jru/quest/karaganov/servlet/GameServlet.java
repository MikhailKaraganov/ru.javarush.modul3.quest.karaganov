package ru.jru.quest.karaganov.servlet;

import lombok.SneakyThrows;

import ru.jru.quest.karaganov.logic.Game;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "GameServlet", urlPatterns = "/gameServlet")
public class GameServlet extends HttpServlet {
    private Game game;

    @Override
    public void init() throws ServletException {
        super.init();
        game = new Game();
    }

    @Override
    @SneakyThrows
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Integer stepID = Integer.parseInt(req.getParameter("stepID"));
        req.setAttribute("step", game.getStepById(stepID));
        getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);

    }
}
