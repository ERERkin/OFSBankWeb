package com;

import com.DB.DB;
import com.model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/boo")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person client = new Person(Integer.parseInt(req.getParameter("clientId")), 1, req.getParameter("name"),
                req.getParameter("address"), Integer.parseInt(req.getParameter("age")), req.getParameter("gender"));
                //Client id:<input type="number" name="clientId"/>
        //    <br/><%--
        //    Bank id:<input type="number" name="bankId"/>
        //    <br/>--%>
        //    Name:<input type="text" name="name"/>
        //    <br/>
        //    Address:<input type="text" name="address"/>
        //    <br/>
        //    Age:<input type="number" name="age"/>
        //    <br/>
        //    Gender:<input type="text" name="gender"/>
        //    <br/>
        //    <input type="submit" name="add client"/>
        DB.addClient(client);
    }
}
