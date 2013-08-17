package com.kureida;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class GetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NutritionData nD = new NutritionData();
        int i = 0;
        do{
            String name = req.getParameter("foodName"+i);
            String sSize = req.getParameter("sSize"+i);
            String typeofWeight = req.getParameter("typeofWeight"+i).replaceAll("[^\\d]", "");
            String typeofFood = (req.getParameter("typeofFood"+i).equals("None")?"Food":req.getParameter("typeofFood"+i)).toLowerCase();


            i++;
        }while(req.getParameter("typeofWeight"+i)!=null);
        resp.sendRedirect("intro.jsp");
    }
}
