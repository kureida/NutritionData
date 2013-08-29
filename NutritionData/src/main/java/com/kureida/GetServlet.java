package com.kureida;

import com.google.appengine.api.datastore.Entity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class GetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NutritionData nD = new NutritionData();
        ArrayList<Entity> entityArrayList = new ArrayList<Entity>();
        String sSize;
        String typeofWeight;
        int i = 0;
        do {
            String name = req.getParameter("foodName" + i);
            sSize = (req.getParameter("sSize" + i).replaceAll("[^\\d]", "").equals("")) ? "0" : req.getParameter("sSize" + i).replaceAll("[^\\d]","");
            typeofWeight = req.getParameter("typeofWeight" + i);
            String typeofFood = (req.getParameter("typeofFood" + i).equals("None") ? "Food" : req.getParameter("typeofFood" + i)).toLowerCase();
            entityArrayList.add(nD.querySpecificFood(name, typeofFood));
            i++;
        } while (req.getParameter("typeofWeight" + i) != null);
        if (!entityArrayList.isEmpty()) {
            int j = 0;
            Entity item;
            while ((item = entityArrayList.get(j)) != null) {
                String iName = item.getKey().getName();
                double servingSize = Double.parseDouble((String) item.getProperty("servingSize"));
                double proportionateFactor = (Double.parseDouble(sSize) * (typeofWeight.equals("grams") ? 1 : 28.3495))/servingSize; //ounces are assumed to be 28.3495 grams or grams to be .035274 ounces
                double calories = Double.parseDouble((String) item.getProperty("calories"))*proportionateFactor;
                double fatCalories = Double.parseDouble((String) item.getProperty("fatCalories"))*proportionateFactor;
                double totalFatGrams = Double.parseDouble((String) item.getProperty("totalFatGrams"))*proportionateFactor;
                double totalFatPercentage = Double.parseDouble((String) item.getProperty("totalFatPercentage"))*proportionateFactor;
                double satFatGrams = Double.parseDouble((String) item.getProperty("satFatGrams"))*proportionateFactor;
                double satFatPercentage = Double.parseDouble((String) item.getProperty("satFatPercentage"))*proportionateFactor;
                double cholesterolMilligrams = Double.parseDouble((String) item.getProperty("cholesterolMilligrams"))*proportionateFactor;
                double cholesterolPercentage = Double.parseDouble((String) item.getProperty("cholesterolPercentage"))*proportionateFactor;
                double sodiumPercentage = Double.parseDouble((String) item.getProperty("sodiumPercentage"))*proportionateFactor;
                double sodiumMilligrams = Double.parseDouble((String) item.getProperty("sodiumMilligrams"))*proportionateFactor;
                double totalCarbsGrams = Double.parseDouble((String) item.getProperty("totalCarbsGrams"))*proportionateFactor;
                double totalCarbsPercentage = Double.parseDouble((String) item.getProperty("totalCarbsPercentage"))*proportionateFactor;
                double fiberGrams = Double.parseDouble((String) item.getProperty("fiberGrams"))*proportionateFactor;
                double fiberPercentage = Double.parseDouble((String) item.getProperty("fiberPercentage"))*proportionateFactor;
                double sugarGrams = Double.parseDouble((String) item.getProperty("sugarGrams"))*proportionateFactor;
                double proteinGrams = Double.parseDouble((String) item.getProperty("proteinGrams"))*proportionateFactor;
                //put data into cookie for processing
                //when exporting data, use sSize, typeofWeight from initial params instead of servingSize
            }
        }
        resp.sendRedirect("intro.jsp");
    }
}
