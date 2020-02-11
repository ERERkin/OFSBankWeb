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

@WebServlet("/addCreditServlet")
public class AddCreditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Bank bank = DB.selectBank(1);
        bank.addCredit(0,Integer.parseInt(req.getParameter("clientId")), Double.parseDouble(req.getParameter("sum")),
                Double.parseDouble(req.getParameter("percent")), Integer.parseInt(req.getParameter("month")), 0,
                "on".equals(req.getParameter("kind")));
        System.out.println("on".equals(req.getParameter("kind")));
        String url = "/index.jsp";
        RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher(url);
        dispatcher1.forward(req,resp);
            //Client ID:<input type="number" name="clientId"/>
        //    <br/>
        //    Sum:<input type="number" name="sum">
        //    <br/>
        //    %:<input type="number" name="percent">
        //    <br/>
        //    Month:<input type="number" name="month">
        //    <br/>
        //    Annuity/Differential<input type="checkbox" name="kind">
        //    <br/>
        //    <input type="submit" name="Add credit">
}
}