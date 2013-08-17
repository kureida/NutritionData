package com.kureida;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class PostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        NutritionData nDP = new NutritionData();
        int i = 0;
        do {
            nDP.setFood(req.getParameter("typeofFood" + i), req.getParameter("name" + i), req.getParameter("servingSize" + i).replaceAll("[^\\d]", ""), req.getParameter("calories" + i).replaceAll("[^\\d]", ""), req.getParameter("fatCalories" + i).replaceAll("[^\\d]", ""), req.getParameter("totalFatGrams" + i).replaceAll("[^\\d]", ""), req.getParameter("totalFatPercentage" + i).replaceAll("[^\\d]", ""), req.getParameter("satFatGrams" + i).replaceAll("[^\\d]", ""),
                    req.getParameter("satFatPercentage" + i).replaceAll("[^\\d]", ""), req.getParameter("cholesterolMilligrams" + i).replaceAll("[^\\d]", ""), req.getParameter("cholesterolPercentage" + i).replaceAll("[^\\d]", ""), req.getParameter("sodiumMilligrams" + i).replaceAll("[^\\d]", ""), req.getParameter("sodiumPercentage" + i).replaceAll("[^\\d]", ""), req.getParameter("totalCarbsGrams" + i).replaceAll("[^\\d]", ""),
                    req.getParameter("totalCarbsPercentage" + i).replaceAll("[^\\d]", ""), req.getParameter("fiberGrams" + i).replaceAll("[^\\d]", ""), req.getParameter("fiberPercentage" + i).replaceAll("[^\\d]", ""), req.getParameter("sugarGrams" + i).replaceAll("[^\\d]", ""), req.getParameter("proteinGrams" + i).replaceAll("[^\\d]", ""));
            nDP.setFood("SecretKeyFood", req.getParameter("name" + i), req.getParameter("servingSize" + i).replaceAll("[^\\d]", ""), req.getParameter("calories" + i).replaceAll("[^\\d]", ""), req.getParameter("fatCalories" + i).replaceAll("[^\\d]", ""), req.getParameter("totalFatGrams" + i).replaceAll("[^\\d]", ""), req.getParameter("totalFatPercentage" + i).replaceAll("[^\\d]", ""), req.getParameter("satFatGrams" + i).replaceAll("[^\\d]", ""),
                    req.getParameter("satFatPercentage" + i).replaceAll("[^\\d]", ""), req.getParameter("cholesterolMilligrams" + i).replaceAll("[^\\d]", ""), req.getParameter("cholesterolPercentage" + i).replaceAll("[^\\d]", ""), req.getParameter("sodiumMilligrams" + i).replaceAll("[^\\d]", ""), req.getParameter("sodiumPercentage" + i).replaceAll("[^\\d]", ""), req.getParameter("totalCarbsGrams" + i).replaceAll("[^\\d]", ""),
                    req.getParameter("totalCarbsPercentage" + i).replaceAll("[^\\d]", ""), req.getParameter("fiberGrams" + i).replaceAll("[^\\d]", ""), req.getParameter("fiberPercentage" + i).replaceAll("[^\\d]", ""), req.getParameter("sugarGrams" + i).replaceAll("[^\\d]", ""), req.getParameter("proteinGrams" + i).replaceAll("[^\\d]", ""));
            i += 1;
        } while (req.getParameter("name" + i) != null);

        resp.sendRedirect("");

    }

}
