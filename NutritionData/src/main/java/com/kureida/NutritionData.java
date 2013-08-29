package com.kureida;

import com.google.appengine.api.datastore.*;

import java.util.ArrayList;


//To Do:
//google datastore queries to retrieve data off of a food (by type or no type)
//add query info to cookie
//read (from javascript) information and display it in accordion skeleton

//extra to do:
//able to move a food from one type/kind (uncatalogued) to another (fruit) in javascript or java
//perhaps another form (servlet) is necessary

//enable an admin to just update one piece of data if only need to update one (fatCalories)
//to do this, need to make the set() not change values to 0 if existing values are in place
//create an if statement
//if statement check if the food exists (by querying for the food name), if it does
//when set() values are neutral "", do not set to 0 but then existing value (foodName.getAttribute(attribute)
//or create a new method

//create better form layout in Javascript for getting ingredients
//use bootstrap .row and .col-*

//extra extra to do:
//get nutrition data from a third-party website that has all the information
//removes the need to manually add nutrition data
public class NutritionData {
    DatastoreService dataStore;

    public NutritionData() {
        dataStore = DatastoreServiceFactory.getDatastoreService();
    }

    //only used for testing purposes
    public void testPost(String name) {
        Entity e;
        if (name.equals(""))
            e = new Entity("test", "the string name came up blank");
        else
            e = new Entity("test", name);

        dataStore.put(e);
    }

    public void setFood(String typeofFood, String name, int servingSize, int calories, int fatCalories, int totalFatGrams, int totalFatPercentage, int satFatGrams,
                        int satFatPercentage, int cholesterolMilligrams, int cholesterolPercentage, int sodiumMilligrams, int sodiumPercentage, int totalCarbsGrams,
                        int totalCarbsPercentage, int fiberGrams, int fiberPercentage, int sugarGrams, int proteinGrams) {
        if (name.equals("1234smash"))
            return;
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

    public void setFood(String typeofFood, String name, String servingSize, String calories, String fatCalories, String totalFatGrams, String totalFatPercentage, String satFatGrams,
                        String satFatPercentage, String cholesterolMilligrams, String cholesterolPercentage, String sodiumMilligrams, String sodiumPercentage, String totalCarbsGrams,
                        String totalCarbsPercentage, String fiberGrams, String fiberPercentage, String sugarGrams, String proteinGrams) {

        setFood((typeofFood.equals("Leave blank if unknown") ? "uncatalogued" : typeofFood).toLowerCase(), (name.equals("Name")) ? "1234smash" : name, Integer.parseInt((servingSize.equals("")) ? "0" : servingSize), Integer.parseInt((calories.equals("")) ? "0" : calories), Integer.parseInt((fatCalories.equals("")) ? "0" : fatCalories), Integer.parseInt((totalFatGrams.equals("")) ? "0" : totalFatGrams), Integer.parseInt((totalFatPercentage.equals("")) ? "0" : totalFatPercentage), Integer.parseInt((satFatGrams.equals("")) ? "0" : satFatGrams),
                Integer.parseInt((satFatPercentage.equals("")) ? "0" : satFatPercentage), Integer.parseInt((cholesterolMilligrams.equals("")) ? "0" : cholesterolMilligrams), Integer.parseInt((cholesterolPercentage.equals("")) ? "0" : cholesterolPercentage), Integer.parseInt((sodiumMilligrams.equals("")) ? "0" : sodiumMilligrams), Integer.parseInt((sodiumPercentage.equals("")) ? "0" : sodiumPercentage), Integer.parseInt((totalCarbsGrams.equals("")) ? "0" : totalCarbsGrams),
                Integer.parseInt((totalCarbsPercentage.equals("")) ? "0" : totalCarbsPercentage), Integer.parseInt((fiberGrams.equals("")) ? "0" : fiberGrams), Integer.parseInt((fiberPercentage.equals("")) ? "0" : fiberPercentage), Integer.parseInt((sugarGrams.equals("")) ? "0" : sugarGrams), Integer.parseInt((proteinGrams.equals("")) ? "0" : proteinGrams));
    }

    private String getList(String typeofFood) {
        Query q = new Query(typeofFood);
        PreparedQuery pq = dataStore.prepare(q);
        String list = "";
        for (Entity result : pq.asIterable()) {
            list += "\"" + result.getKey().getName() + "\",";
        }
        return (list.length() > 2) ? list.substring(0, list.length() - 1) : "";
    }

    public String getAllFood() {
        ArrayList<String> kindList = getKind();
        String food = "";
        for (int i = 0; i < kindList.size(); i++) {
            Query q = new Query(kindList.get(i));
            PreparedQuery pq = dataStore.prepare(q);
            String foodKind = "";
            for (Entity result : pq.asIterable()) {
                foodKind += "\"" + result.getKey().getName() + "\",";
            }
            food += "\"" + kindList.get(i) + "\",";
            if (i == kindList.size() - 1) {
                food += (foodKind.length() > 2) ? foodKind.substring(0, foodKind.length() - 1) : "";
            } else {
                food += (foodKind.length() > 2) ? foodKind.substring(0, foodKind.length()) : "";
            }
        }
        return food;
    }

    //obsolete as datastore statistics now work for java, used to get Entity metadata
    private ArrayList<String> getKind() {
        Query query = new Query(Entities.KIND_METADATA_KIND);
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

        Iterable<Entity> entityIterable = datastoreService.prepare(query).asIterable();
        ArrayList<String> kindList = new ArrayList<String>();
        for (Entity entity : entityIterable) {
            //This line is to be commented out to see google defined queries
            if (!entity.getKey().getName().contains("_") && !entity.getKey().getName().equals("SecretKeyFood".toLowerCase()))
                kindList.add(entity.getKey().getName());

        }
        return kindList;
    }

    //obsolete as datastore statistics now work for java, used to get Entity metadata
    public String getKinds() {
        Query query = new Query(Entities.KIND_METADATA_KIND);
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

        Iterable<Entity> entityIterable = datastoreService.prepare(query).asIterable();
        String kindList = "";
        for (Entity entity : entityIterable) {
            //This line is to be commented out to see google defined queries
            if (!entity.getKey().getName().contains("_") && !entity.getKey().getName().equals("SecretKeyFood".toLowerCase()))
                kindList += "\"" + entity.getKey().getName() + "\",";
        }
        return (kindList.length() > 2) ? kindList.substring(0, kindList.length() - 1) : "";
    }

    private ArrayList<String> getSimpleKind() {
        Query query = new Query("__Stat_Kind__");
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

        Iterable<Entity> entityIterable = datastoreService.prepare(query).asIterable();
        ArrayList<String> kindList = new ArrayList<String>();
        for (Entity entity : entityIterable) {
            //if(!entity.getKey().getName().contains("_"))
            kindList.add(entity.getKey().getName());

        }
        return kindList;
    }

    public String getSimpleKinds() {
        Query query = new Query("__Stat_Kind__");
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

        Iterable<Entity> entityIterable = datastoreService.prepare(query).asIterable();
        String kindList = "";
        for (Entity entity : entityIterable) {
            //if(!entity.getKey().getName().contains("_"))
            kindList += "\"" + entity.getKey().getName() + "\",";
        }
        return (kindList.length() > 2) ? kindList.substring(0, kindList.length() - 1) : "";
    }

    public void remove(String key) {

    }

    //returns the first entity with the key of the query
       public Entity querySpecificFood(String name, String typeofFood) {
        String queryKey = (typeofFood.equals("None")) ? "SecretKeyFood".toLowerCase() : typeofFood;
        Query query = new Query(queryKey);
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        Iterable<Entity> entityIterable = datastoreService.prepare(query).asIterable();

        for (Entity entity : entityIterable) {
            if (entity.getKey().getName().equals(name)) {
                return entity;
            }
        }
        return null;
    }
}
