package com;

import com.DB.DB;
import com.model.Bank;
import com.model.Credit;
import com.model.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/showCreditsServlet")
public class ShowCreditsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Bank bank = DB.selectBank(1);
        ArrayList<Credit> credits = DB.creditList(Integer.parseInt(req.getParameter("clientId")), "on".equals(req.getParameter("kind")));
        req.setAttribute("list", credits);
        String url = "/ShowCredits.jsp";
        RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher(url);
        dispatcher1.forward(req,resp);
    }
}
