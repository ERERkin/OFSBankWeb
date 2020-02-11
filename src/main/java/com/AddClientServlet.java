package com;

import com.DB.DB;
import com.model.Bank;
import com.model.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addClientServlet")
public class AddClientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*Person client = new Person(Integer.parseInt(req.getParameter("clientId")), 1, req.getParameter("name"),
                req.getParameter("address"), Integer.parseInt(req.getParameter("age")), req.getParameter("gender"));*/
        Bank bank = DB.selectBank(1);
        bank.addBorrower(Integer.parseInt(req.getParameter("clientId")), 1, req.getParameter("name"),
                req.getParameter("address"), Integer.parseInt(req.getParameter("age")), req.getParameter("gender"));
        String url = "/index.jsp";
        RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher(url);
        dispatcher1.forward(req,resp);
        //DB.addClient(client);
    }
}
