package com;

import com.DB.DB;
import com.model.Bank;
import com.model.Person;
import com.model.StateTreasuryBill;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/showSTBServlet")
public class ShowSTBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Bank bank = DB.selectBank(1);
        ArrayList<StateTreasuryBill> stateTreasuryBills = DB.getStateTreasuryBillClientId(Integer.parseInt(req.getParameter("clientId")));
        req.setAttribute("list", stateTreasuryBills);
        String url = "/ShowSTB.jsp";
        RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher(url);
        dispatcher1.forward(req,resp);
    }
}
