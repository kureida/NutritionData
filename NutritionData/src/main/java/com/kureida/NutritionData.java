package com.kureida;

import com.google.appengine.api.datastore.*;

import java.util.ArrayList;



public class NutritionData {
    DatastoreService dataStore;

    public NutritionData(){
        dataStore = DatastoreServiceFactory.getDatastoreService();
    }

    public void set(String typeofFood, String name, int servingSize, int calories, int fatCalories, int totalFatGrams, int totalFatPercentage, int satFatGrams,
                    int satFatPercentage, int cholesterolMilligrams, int cholesterolPercentage, int sodiumMilligrams, int sodiumPercentage, int totalCarbsGrams,
                    int totalCarbsPercentage, int fiberGrams, int fiberPercentage, int sugarGrams, int proteinGrams){
        Entity e = new Entity(typeofFood, name);
        e.setProperty("servingSize", servingSize);
        e.setProperty("calories", calories);
        e.setProperty("fatCalories", fatCalories);
        e.setProperty("totalFatGrams", totalFatGrams);
        e.setProperty("totalFatPercentage", totalFatPercentage);
        e.setProperty("satFatGrams", satFatGrams);
        e.setProperty("satFatPercentage", satFatPercentage);
        e.setProperty("cholesterolMilligrams", cholesterolMilligrams);
        e.setProperty("cholesterolPercentage", cholesterolPercentage);
        e.setProperty("sodiumPercentage", sodiumPercentage);
        e.setProperty("sodiumMilligrams", sodiumMilligrams);
        e.setProperty("totalCarbsGrams", totalCarbsGrams);
        e.setProperty("totalCarbsPercentage", totalCarbsPercentage);
        e.setProperty("fiberGrams", fiberGrams);
        e.setProperty("fiberPercentage", fiberPercentage);
        e.setProperty("sugarGrams", sugarGrams);
        e.setProperty("proteinGrams", proteinGrams);
        dataStore.put(e);
    }
    public void set(String typeofFood, String name, String servingSize, String calories, String fatCalories, String totalFatGrams, String totalFatPercentage, String satFatGrams,
                    String satFatPercentage, String cholesterolMilligrams, String cholesterolPercentage, String sodiumMilligrams, String sodiumPercentage, String totalCarbsGrams,
                    String totalCarbsPercentage, String fiberGrams, String fiberPercentage, String sugarGrams, String proteinGrams){

        set(typeofFood, name, Integer.parseInt(servingSize), Integer.parseInt(calories), Integer.parseInt(fatCalories), Integer.parseInt(totalFatGrams), Integer.parseInt(totalFatPercentage), Integer.parseInt(satFatGrams),
        Integer.parseInt(satFatPercentage), Integer.parseInt(cholesterolMilligrams), Integer.parseInt(cholesterolPercentage), Integer.parseInt(sodiumMilligrams), Integer.parseInt(sodiumPercentage), Integer.parseInt(totalCarbsGrams),
        Integer.parseInt(totalCarbsPercentage), Integer.parseInt(fiberGrams), Integer.parseInt(fiberPercentage), Integer.parseInt(sugarGrams), Integer.parseInt(proteinGrams));
    }
    private String getList(String typeofFood){
        Query q = new Query(typeofFood);
        PreparedQuery pq = dataStore.prepare(q);
        String list = "";
        for(Entity result : pq.asIterable()){
            list+="\"" + result.getKey().getName()+ "\",";
        }
        return (list.length() > 2) ? list.substring(0, list.length()-1):"";
    }
    public String getAllFood(){
        ArrayList<String> kindList = getKind();
        String food = "";
        for(int i = 0; i < kindList.size(); i++){
            Query q = new Query(kindList.get(i));
            PreparedQuery pq = dataStore.prepare(q);
            String foodKind = "";
            for(Entity result : pq.asIterable()){
                foodKind += "\"" + result.getKey().getName()+ "\",";
            }
            food+= "\"" + kindList.get(i) + "\",";
            if(i == kindList.size()-1){
                food+= (foodKind.length() > 2) ? foodKind.substring(0, foodKind.length()-1): "";
            } else {
                food+= (foodKind.length() > 2) ? foodKind.substring(0, foodKind.length()): "";
            }
        }
        return food;
    }
    private ArrayList<String> getKind(){
        Query query = new Query(Entities.KIND_METADATA_KIND);
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

        Iterable<Entity> entityIterable = datastoreService.prepare(query).asIterable();
        ArrayList<String> kindList = new ArrayList<String>();
        for(Entity entity : entityIterable) {
            kindList.add(entity.getKey().getName());
        }
        return kindList;
    }
    public String getKinds(){
        Query query = new Query(Entities.KIND_METADATA_KIND);
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

        Iterable<Entity> entityIterable = datastoreService.prepare(query).asIterable();
        String kindList = "";
        for(Entity entity : entityIterable) {
            kindList += "\"" + entity.getKey().getName()+"\",";
        }
        return (kindList.length() > 2 ) ? kindList.substring(0, kindList.length()-1):"";
    }

    public void remove(String key){

    }

}
